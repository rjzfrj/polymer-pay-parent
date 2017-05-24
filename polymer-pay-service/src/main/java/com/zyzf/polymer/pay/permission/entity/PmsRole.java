package com.zyzf.polymer.pay.permission.entity;

import com.zyzf.polymer.pay.common.core.entity.BaseEntity;

/**
 * 权限管理-角色..
 *
 * ：
 * 
 * 
 */
public class PmsRole extends BaseEntity {

	private static final long serialVersionUID = -1850274607153125161L;
	private String roleCode; // 角色编码：例如：admin
	private String roleName; // 角色名称

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	/**
	 * 角色名称
	 * 
	 * @return
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * 角色名称
	 * 
	 * @return
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public PmsRole() {

	}
}
