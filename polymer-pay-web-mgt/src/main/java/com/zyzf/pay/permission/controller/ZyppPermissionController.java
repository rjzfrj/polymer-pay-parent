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

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zyzf.pay.common.core.dwz.DwzAjax;
import com.zyzf.pay.common.core.enums.PublicStatusEnum;
import com.zyzf.pay.common.core.page.PageBean;
import com.zyzf.pay.common.core.page.PageParam;
import com.zyzf.pay.controller.common.BaseController;
import com.zyzf.pay.permission.entity.ZyppPermission;
import com.zyzf.pay.permission.entity.ZyppRole;
import com.zyzf.pay.permission.service.ZyppPermissionService;
import com.zyzf.pay.permission.service.ZyppRoleService;
import com.zyzf.pay.permission.utils.ValidateUtils;

/**
 * 权限管理模块的Permission类，包括权限点管理、角色管理、操作员管理.<br/>
 *
 * ：
 * 
 * 
 */
@Controller
@RequestMapping("/Zypp/permission")
public class ZyppPermissionController extends BaseController {

	@Autowired
	private ZyppPermissionService ZyppPermissionService;
	@Autowired
	private ZyppRoleService ZyppRoleService;

	private static Log log = LogFactory.getLog(ZyppPermissionController.class);

	/**
	 * 分页列出Zypp权限，也可根据权限获权限名称进行查询.
	 * 
	 * @return ZyppPermissionList or operateError.
	 */
	@RequiresPermissions("Zypp:permission:view")
	@RequestMapping("/list")
	public String listZyppPermission(HttpServletRequest req, PageParam pageParam, ZyppPermission ZyppPermission, Model model) {
		try {
			PageBean pageBean = ZyppPermissionService.listPage(pageParam, ZyppPermission);
			model.addAttribute(pageBean);
			model.addAttribute("pageParam", pageParam);
			return "Zypp/ZyppPermissionList";
		} catch (Exception e) {
			log.error("== listZyppPermission exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 进入添加Zypp权限页面 .
	 * 
	 * @return addZyppPermissionUI .
	 */
	@RequiresPermissions("Zypp:permission:add")
	@RequestMapping("/addUI")
	public String addZyppPermissionUI() {
		return "Zypp/ZyppPermissionAdd";
	}

	/**
	 * 将权限信息保存到数据库中
	 * 
	 * @return operateSuccess or operateError.
	 */
	@RequiresPermissions("Zypp:permission:add")
	@RequestMapping("/add")
	public String addZyppPermission(HttpServletRequest req, ZyppPermission ZyppPermission, Model model, DwzAjax dwz) {
		try {

			// 表单数据校验
			String validateMsg = validateZyppPermission(ZyppPermission);
			if (StringUtils.isNotBlank(validateMsg)) {
				return operateError(validateMsg, model); // 返回错误信息
			}

			String permissionName = ZyppPermission.getPermissionName().trim();
			String permission = ZyppPermission.getPermission();
			// 检查权限名称是否已存在
			ZyppPermission checkName = ZyppPermissionService.getByPermissionName(permissionName);
			if (checkName != null) {
				return operateError("权限名称【" + permissionName + "】已存在", model);
			}
			// 检查权限是否已存在
			ZyppPermission checkPermission = ZyppPermissionService.getByPermission(permission);
			if (checkPermission != null) {
				return operateError("权限【" + permission + "】已存在", model);
			}
			ZyppPermission.setStatus(PublicStatusEnum.ACTIVE.name());
			ZyppPermission.setCreater(getZyppOperator().getLoginName());
			ZyppPermission.setCreateTime(new Date());
			ZyppPermissionService.saveData(ZyppPermission);

			return operateSuccess(model, dwz); // 返回operateSuccess视图,并提示“操作成功”
		} catch (Exception e) {
			log.error("== addZyppPermission exception:", e);
			return operateError("保存失败", model);
		}
	}

	/**
	 * 校验Zypp权限信息.
	 * 
	 * @param ZyppPermission
	 *            .
	 * @return msg .
	 */
	private String validateZyppPermission(ZyppPermission ZyppPermission) {
		String msg = ""; // 用于存放校验提示信息的变量
		String permissionName = ZyppPermission.getPermissionName(); // 权限名称
		String permission = ZyppPermission.getPermission(); // 权限标识
		String desc = ZyppPermission.getRemark(); // 权限描述
		// 权限名称 permissionName
		msg += ValidateUtils.lengthValidate("权限名称", permissionName, true, 3, 90);
		// 权限标识 permission
		msg += ValidateUtils.lengthValidate("权限标识", permission, true, 3, 100);
		// 描述 desc
		msg += ValidateUtils.lengthValidate("描述", desc, true, 3, 60);
		return msg;
	}

	/**
	 * 转到权限修改页面 .
	 * 
	 * @return editZyppPermissionUI or operateError .
	 */
	@RequiresPermissions("Zypp:permission:edit")
	@RequestMapping("/editUI")
	public String editZyppPermissionUI(HttpServletRequest req, Long id, Model model) {
		try {
			ZyppPermission ZyppPermission = ZyppPermissionService.getDataById(id);
			model.addAttribute("ZyppPermission", ZyppPermission);
			return "Zypp/ZyppPermissionEdit";
		} catch (Exception e) {
			log.error("== editZyppPermissionUI exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 保存修改后的权限信息
	 * 
	 * @return operateSuccess or operateError .
	 */
	@RequiresPermissions("Zypp:permission:edit")
	@RequestMapping("/edit")
	public String editZyppPermission(HttpServletRequest req, ZyppPermission permission, Model model, DwzAjax dwz) {
		try {
			Long id = permission.getId();
			ZyppPermission ZyppPermission = ZyppPermissionService.getDataById(id);
			if (ZyppPermission == null) {
				return operateError("无法获取要修改的数据", model);
			} else {

				String permissionName = permission.getPermissionName();
				String remark = permission.getRemark();

				ZyppPermission.setPermissionName(permissionName);
				ZyppPermission.setRemark(remark);

				// 表单数据校验
				String validateMsg = validateZyppPermission(ZyppPermission);
				if (StringUtils.isNotBlank(validateMsg)) {
					return operateError(validateMsg, model); // 返回错误信息
				}

				// 检查权限名称是否已存在
				ZyppPermission checkName = ZyppPermissionService.getByPermissionNameNotEqId(permissionName, id);
				if (checkName != null) {
					return operateError("权限名称【" + permissionName + "】已存在", model);
				}

				ZyppPermissionService.updateData(ZyppPermission);

				return operateSuccess(model, dwz);
			}
		} catch (Exception e) {
			log.error("== editZyppPermission exception:", e);
			return operateError("修改失败", model);
		}
	}

	/**
	 * 删除一条权限记录
	 * 
	 * @return operateSuccess or operateError .
	 */
	@RequiresPermissions("Zypp:permission:delete")
	@RequestMapping("/delete")
	public String deleteZyppPermission(HttpServletRequest req, Long permissionId, Model model, DwzAjax dwz) {
		try {
			ZyppPermission permission = ZyppPermissionService.getDataById(permissionId);
			if (permission == null) {
				return operateError("无法获取要删除的数据", model);
			}
			// 判断此权限是否关联有角色，要先解除与角色的关联后才能删除该权限
			List<ZyppRole> roleList = ZyppRoleService.listByPermissionId(permissionId);
			if (roleList != null && !roleList.isEmpty()) {
				return operateError("权限【" + permission.getPermission() + "】关联了【" + roleList.size() + "】个角色，要解除所有关联后才能删除。其中一个角色名为:" + roleList.get(0).getRoleName(), model);
			}
			ZyppPermissionService.delete(permissionId);
			return operateSuccess(model, dwz); // 返回operateSuccess视图,并提示“操作成功”
		} catch (Exception e) {
			log.error("== deleteZyppPermission exception:", e);
			return operateError("删除限权异常", model);
		}
	}
}
