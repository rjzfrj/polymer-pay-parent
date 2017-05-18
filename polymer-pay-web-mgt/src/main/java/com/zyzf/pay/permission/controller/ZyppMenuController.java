/*
 * Copyright 2015-2102 zyzf(http://) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zyzf.pay.permission.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zyzf.pay.common.core.dwz.DwzAjax;
import com.zyzf.pay.common.core.enums.PublicEnum;
import com.zyzf.pay.common.core.enums.PublicStatusEnum;
import com.zyzf.pay.controller.common.BaseController;
import com.zyzf.pay.permission.biz.ZyppMenuBiz;
import com.zyzf.pay.permission.entity.ZyppMenu;
import com.zyzf.pay.permission.service.ZyppMenuService;

/**
 * 权限-菜单控制器
 *
 * ：
 * 
 * 
 */
@Controller
@RequestMapping("/Zypp/menu")
public class ZyppMenuController extends BaseController {

	private static final Log log = LogFactory.getLog(ZyppMenuController.class);

	@Autowired
	private ZyppMenuService ZyppMenuService;
	@Autowired
	private ZyppMenuBiz ZyppMenuBiz;

	/**
	 * 列出要管理的菜单.
	 * 
	 * @return ZyppMenuList .
	 */
	@RequiresPermissions("Zypp:menu:view")
	@RequestMapping("/list")
	public String listZyppMenu(HttpServletRequest req, Model model) {
		String editMenuController = "Zypp/menu/editUI";
		String str = ZyppMenuBiz.getTreeMenu(editMenuController);
		model.addAttribute("tree", str);
		return "Zypp/ZyppMenuList";
	}

	/**
	 * 进入新菜单添加页面.
	 * 
	 * @return ZyppMenuAdd .
	 */
	@RequiresPermissions("Zypp:menu:add")
	@RequestMapping("/addUI")
	public String addZyppMenuUI(HttpServletRequest req, ZyppMenu ZyppMenu, Model model, Long pid) {
		if (null != pid) {
			ZyppMenu parentMenu = ZyppMenuService.getById(pid);
			ZyppMenu.setParent(parentMenu);
			model.addAttribute(ZyppMenu);
		}
		return "Zypp/ZyppMenuAdd";
	}

	/**
	 * 保存新增菜单.
	 * 
	 * @return operateSuccess or operateError .
	 */
	@RequiresPermissions("Zypp:menu:add")
	@RequestMapping("/add")
	public String addZyppMenu(HttpServletRequest req, ZyppMenu ZyppMenu, Model model, DwzAjax dwz) {
		try {
			String name = ZyppMenu.getName();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLeaf", "YES");
			map.put("name", name);
			List<ZyppMenu> list = ZyppMenuService.getMenuByNameAndIsLeaf(map);
			if (list.size() > 0) {
				return operateError("同级菜单名称不能重复", model);
			}
			ZyppMenu.setCreater(getZyppOperator().getLoginName());
			ZyppMenu.setStatus(PublicStatusEnum.ACTIVE.name());
			ZyppMenu.setIsLeaf("YES");
			if (null != ZyppMenu.getParent().getId()) {
				ZyppMenu.setLvl(ZyppMenu.getParent().getLvl()+1);
			}else{
				ZyppMenu.setLvl(1L);
				ZyppMenu parent = new ZyppMenu();
				parent.setId(0l);
				ZyppMenu.setParent(parent);
			}
			ZyppMenuService.savaMenu(ZyppMenu);
		} catch (Exception e) {
			// 记录系统操作日志
			log.error("== addZyppMenu exception:", e);
			return operateError("添加菜单出错", model);
		}
		return operateSuccess(model, dwz);
	}

	/**
	 * 进入菜单修改页面.
	 * 
	 * @return
	 */
	@RequiresPermissions("Zypp:menu:edit")
	@RequestMapping("/editUI")
	public String editZyppMenuUI(HttpServletRequest req, Long id, Model model) {
		if (null != id) {
			ZyppMenu ZyppMenu = ZyppMenuService.getById(id);
			model.addAttribute(ZyppMenu);
		}
		return "Zypp/ZyppMenuEdit";
	}

	/**
	 * 保存要修改的菜单.
	 * 
	 * @return
	 */
	@RequiresPermissions("Zypp:menu:edit")
	@RequestMapping("/edit")
	public String editZyppMenu(HttpServletRequest req, ZyppMenu menu, Model model, DwzAjax dwz) {
		try {
			ZyppMenu parentMenu = menu.getParent();
			if (null == parentMenu) {
				parentMenu = new ZyppMenu();
				parentMenu.setId(0L);
			}
			menu.setParent(parentMenu);
			ZyppMenuService.update(menu);
			// 记录系统操作日志
			return operateSuccess(model, dwz);
		} catch (Exception e) {
			// 记录系统操作日志
			log.error("== editZyppMenu exception:", e);
			return operateError("保存菜单出错", model);
		}

	}

	/**
	 * 删除菜单.
	 * 
	 * @return
	 */
	@RequiresPermissions("Zypp:menu:delete")
	@RequestMapping("/delete")
	public String delZyppMenu(HttpServletRequest req, Long menuId, Model model, DwzAjax dwz) {
		try {
			if (menuId == null || menuId == 0) {
				return operateError("无法获取要删除的数据", model);
			}
			ZyppMenu menu = ZyppMenuService.getById(menuId);
			if (menu == null) {
				return operateError("无法获取要删除的数据", model);
			}
			Long parentId = menu.getParent().getId(); // 获取父菜单ID

			// 先判断此菜单下是否有子菜单
			List<ZyppMenu> childMenuList = ZyppMenuService.listByParentId(menuId);
			if (childMenuList != null && !childMenuList.isEmpty()) {
				return operateError("此菜单下关联有【" + childMenuList.size() + "】个子菜单，不能支接删除!", model);
			}

			// 删除掉菜单
			ZyppMenuService.delete(menuId);

			// 删除菜单后，要判断其父菜单是否还有子菜单，如果没有子菜单了就要装其父菜单设为叶子节点
			List<ZyppMenu> childList = ZyppMenuService.listByParentId(parentId);
			if (childList == null || childList.isEmpty()) {
				// 此时要将父菜单设为叶子
				ZyppMenu parent = ZyppMenuService.getById(parentId);
				parent.setIsLeaf(PublicEnum.YES.name());
				ZyppMenuService.update(parent);
			}
			// 记录系统操作日志
			return operateSuccess(model, dwz);
		} catch (Exception e) {
			// 记录系统操作日志
			log.error("== delZyppMenu exception:", e);
			return operateError("删除菜单出错", model);
		}
	}

}
