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
import org.springframework.web.bind.annotation.RequestParam;

import com.zyzf.pay.common.core.dwz.DwzAjax;
import com.zyzf.pay.common.core.page.PageBean;
import com.zyzf.pay.common.core.page.PageParam;
import com.zyzf.pay.controller.common.BaseController;
import com.zyzf.pay.permission.biz.ZyppMenuBiz;
import com.zyzf.pay.permission.entity.ZyppOperator;
import com.zyzf.pay.permission.entity.ZyppPermission;
import com.zyzf.pay.permission.entity.ZyppRole;
import com.zyzf.pay.permission.enums.OperatorTypeEnum;
import com.zyzf.pay.permission.service.ZyppMenuRoleService;
import com.zyzf.pay.permission.service.ZyppMenuService;
import com.zyzf.pay.permission.service.ZyppOperatorRoleService;
import com.zyzf.pay.permission.service.ZyppPermissionService;
import com.zyzf.pay.permission.service.ZyppRolePermissionService;
import com.zyzf.pay.permission.service.ZyppRoleService;
import com.zyzf.pay.permission.utils.ValidateUtils;

/**
 * 权限管理模块角色管理、.<br/>
 *
 * ：
 * 
 * 
 */
@Controller
@RequestMapping("/Zypp/role")
public class ZyppRoleController extends BaseController {

	@Autowired
	private ZyppRoleService ZyppRoleService;
	@Autowired
	private ZyppMenuService ZyppMenuService;
	@Autowired
	private ZyppMenuRoleService ZyppMenuRoleService;
	@Autowired
	private ZyppPermissionService ZyppPermissionService;
	@Autowired
	private ZyppRolePermissionService ZyppRolePermissionService;
	@Autowired
	private ZyppOperatorRoleService ZyppOperatorRoleService;

	private static Log log = LogFactory.getLog(ZyppRoleController.class);

	/**
	 * 获取角色列表
	 * 
	 * @return listZyppRole or operateError .
	 */
	@RequiresPermissions("Zypp:role:view")
	@RequestMapping("/list")
	public String listZyppRole(HttpServletRequest req, PageParam pageParam, ZyppRole ZyppRole, Model model) {
		try {
			PageBean pageBean = ZyppRoleService.listPage(pageParam, ZyppRole);
			model.addAttribute(pageBean);
			model.addAttribute("pageParam", pageParam);
			model.addAttribute("ZyppRole", ZyppRole);
			return "Zypp/ZyppRoleList";
		} catch (Exception e) {
			log.error("== listZyppRole exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 转到添加角色页面 .
	 * 
	 * @return addZyppRoleUI or operateError .
	 */
	@RequiresPermissions("Zypp:role:add")
	@RequestMapping("/addUI")
	public String addZyppRoleUI(HttpServletRequest req, Model model) {
		try {
			return "Zypp/ZyppRoleAdd";
		} catch (Exception e) {
			log.error("== addZyppRoleUI get data exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 保存新添加的一个角色 .
	 * 
	 * @return operateSuccess or operateError .
	 */
	@RequiresPermissions("Zypp:role:add")
	@RequestMapping("/add")
	public String addZyppRole(HttpServletRequest req, Model model, @RequestParam("roleCode") String roleCode, @RequestParam("roleName") String roleName, @RequestParam("remark") String remark, DwzAjax dwz) {
		try {
			ZyppRole roleNameCheck = ZyppRoleService.getByRoleNameOrRoleCode(roleName, null);
			if (roleNameCheck != null) {
				return operateError("角色名【" + roleName + "】已存在", model);
			}

			ZyppRole roleCodeCheck = ZyppRoleService.getByRoleNameOrRoleCode(null, roleCode);
			if (roleCodeCheck != null) {
				return operateError("角色编码【" + roleCode + "】已存在", model);
			}

			// 保存基本角色信息
			ZyppRole ZyppRole = new ZyppRole();
			ZyppRole.setRoleCode(roleCode);
			ZyppRole.setRoleName(roleName);
			ZyppRole.setRemark(remark);
			ZyppRole.setCreateTime(new Date());

			// 表单数据校验
			String validateMsg = validateZyppRole(ZyppRole);
			if (StringUtils.isNotBlank(validateMsg)) {
				return operateError(validateMsg, model); // 返回错误信息
			}
			ZyppRoleService.saveData(ZyppRole);
			return operateSuccess(model, dwz);
		} catch (Exception e) {
			log.error("== addZyppRole exception:", e);
			return operateError("保存数据失败", model);
		}
	}

	/**
	 * 校验角色表单数据.
	 * 
	 * @param ZyppRole
	 *            角色信息.
	 * @return msg .
	 */
	private String validateZyppRole(ZyppRole ZyppRole) {
		String msg = ""; // 用于存放校验提示信息的变量
		String roleName = ZyppRole.getRoleName(); // 角色名称
		String desc = ZyppRole.getRemark(); // 描述
		// 角色名称 permissionName
		msg += ValidateUtils.lengthValidate("角色名称", roleName, true, 3, 90);
		// 描述 desc
		msg += ValidateUtils.lengthValidate("描述", desc, true, 3, 300);
		return msg;
	}

	/**
	 * 转到角色修改页面 .
	 * 
	 * @return editZyppRoleUI or operateError .
	 */
	@RequiresPermissions("Zypp:role:edit")
	@RequestMapping("/editUI")
	public String editZyppRoleUI(HttpServletRequest req, Model model, Long roleId) {
		try {
			ZyppRole ZyppRole = ZyppRoleService.getDataById(roleId);
			if (ZyppRole == null) {
				return operateError("获取数据失败", model);
			}

			model.addAttribute(ZyppRole);
			return "/Zypp/ZyppRoleEdit";
		} catch (Exception e) {
			log.error("== editZyppRoleUI exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 保存修改后的角色信息 .
	 * 
	 * @return operateSuccess or operateError .
	 */
	@RequiresPermissions("Zypp:role:edit")
	@RequestMapping("/edit")
	public String editZyppRole(HttpServletRequest req, Model model, ZyppRole role, DwzAjax dwz) {
		try {
			Long id = role.getId();

			ZyppRole ZyppRole = ZyppRoleService.getDataById(id);
			if (ZyppRole == null) {
				return operateError("无法获取要修改的数据", model);
			}

			ZyppRole roleNameCheck = ZyppRoleService.getByRoleNameOrRoleCode(role.getRoleName(), null);
			if (roleNameCheck != null) {
				return operateError("角色名【" + role.getRoleName() + "】已存在", model);
			}

			ZyppRole roleCodeCheck = ZyppRoleService.getByRoleNameOrRoleCode(null, role.getRoleCode());
			if (roleCodeCheck != null) {
				return operateError("角色编码【" + role.getRoleCode() + "】已存在", model);
			}

			ZyppRole.setRoleName(role.getRoleName());
			ZyppRole.setRoleCode(role.getRoleCode());
			ZyppRole.setRemark(role.getRemark());

			// 表单数据校验
			String validateMsg = validateZyppRole(ZyppRole);
			if (StringUtils.isNotBlank(validateMsg)) {
				return operateError(validateMsg, model); // 返回错误信息
			}
			ZyppRoleService.updateData(ZyppRole);
			return operateSuccess(model, dwz);
		} catch (Exception e) {
			log.error("== editZyppRole exception:", e);
			return operateError("保存失败", model);
		}
	}

	/**
	 * 删除一个角色
	 * 
	 * @return operateSuccess or operateError .
	 */
	@RequiresPermissions("Zypp:role:delete")
	@RequestMapping("/delete")
	public String deleteZyppRole(HttpServletRequest req, Model model, Long roleId, DwzAjax dwz) {
		try {

			ZyppRole role = ZyppRoleService.getDataById(roleId);
			if (role == null) {
				return operateError("无法获取要删除的角色", model);
			}
			String msg = "";
			// 判断是否有操作员关联到此角色
			int operatorCount = ZyppOperatorRoleService.countOperatorByRoleId(roleId);
			if (operatorCount > 0) {
				msg += "有【" + operatorCount + "】个操作员关联到此角色，要先解除所有关联后才能删除!";
				return operateError(msg, model);
			}

			ZyppRoleService.delete(roleId);
			return operateSuccess(model, dwz);
		} catch (Exception e) {
			log.error("== deleteZyppRole exception:", e);
			return operateError("删除失败", model);
		}
	}
	
	/**
	 * 分配权限UI
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequiresPermissions("Zypp:role:assignpermission")
	@RequestMapping("/assignPermissionUI")
	public String assignPermissionUI(HttpServletRequest req, Model model, Long roleId) {

		ZyppRole role = ZyppRoleService.getDataById(roleId);
		if (role == null) {
			return operateError("无法获取角色信息", model);
		}
		// 普通操作员没有修改超级管理员角色的权限
		if (OperatorTypeEnum.USER.name().equals(this.getZyppOperator().getType()) && "admin".equals(role.getRoleName())) {
			return operateError("权限不足", model);
		}

		String permissionIds = ZyppPermissionService.getPermissionIdsByRoleId(roleId); // 根据角色查找角色对应的功能权限ID集
		List<ZyppPermission> permissionList = ZyppPermissionService.listAll();
		List<ZyppOperator> operatorList = ZyppOperatorRoleService.listOperatorByRoleId(roleId);

		model.addAttribute("permissionIds", permissionIds);
		model.addAttribute("permissionList", permissionList);
		model.addAttribute("operatorList", operatorList);
		model.addAttribute("role", role);
		return "/Zypp/assignPermissionUI";
	}

	/**
	 * 分配角色权限
	 */
	@RequiresPermissions("Zypp:role:assignpermission")
	@RequestMapping("/assignPermission")
	public String assignPermission(HttpServletRequest req, Model model, @RequestParam("roleId") Long roleId, DwzAjax dwz, @RequestParam("selectVal") String selectVal) {
		try {
			String rolePermissionStr = getRolePermissionStr(selectVal);
			ZyppRolePermissionService.saveRolePermission(roleId, rolePermissionStr);
			return operateSuccess(model, dwz);
		} catch (Exception e) {
			log.error("== assignPermission exception:", e);
			return operateError("保存失败", model);
		}
	}
	
	/**
	 * 分配菜单UI
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/assignMenuUI")
	public String assignMenuUI(HttpServletRequest req, Model model, Long roleId) {
		ZyppRole role = ZyppRoleService.getDataById(roleId);
		if (role == null) {
			return operateError("无法获取角色信息", model);
		}
		// 普通操作员没有修改超级管理员角色的权限
		if (OperatorTypeEnum.USER.name().equals(this.getZyppOperator().getType()) && "admin".equals(role.getRoleName())) {
			return operateError("权限不足", model);
		}

		String menuIds = ZyppMenuService.getMenuIdsByRoleId(roleId); // 根据角色查找角色对应的菜单ID集
		List menuList = ZyppMenuService.getListByParent(null);
		List<ZyppOperator> operatorList = ZyppOperatorRoleService.listOperatorByRoleId(roleId);

		model.addAttribute("menuIds", menuIds);
		model.addAttribute("menuList", menuList);
		model.addAttribute("operatorList", operatorList);
		model.addAttribute("role", role);
		return "/Zypp/assignMenuUI";
	}

	/**
	 * 分配角色菜单
	 */
	@RequestMapping("/assignMenu")
	public String assignMenu(HttpServletRequest req, Model model, @RequestParam("roleId") Long roleId, DwzAjax dwz, @RequestParam("selectVal") String selectVal) {
		try {
			String roleMenuStr = getRolePermissionStr(selectVal);
			ZyppMenuRoleService.saveRoleMenu(roleId, roleMenuStr);
			return operateSuccess(model, dwz);
		} catch (Exception e) {
			log.error("== assignPermission exception:", e);
			return operateError("保存失败", model);
		}
	}

	/**
	 * 得到角色和权限关联的ID字符串
	 * 
	 * @return
	 */
	private String getRolePermissionStr(String selectVal) throws Exception {
		String roleStr = selectVal;
		if (StringUtils.isNotBlank(roleStr) && roleStr.length() > 0) {
			roleStr = roleStr.substring(0, roleStr.length() - 1);
		}
		return roleStr;
	}
}
