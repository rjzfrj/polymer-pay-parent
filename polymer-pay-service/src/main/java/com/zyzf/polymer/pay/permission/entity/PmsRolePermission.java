package com.zyzf.polymer.pay.permission.entity;

import com.zyzf.polymer.pay.common.core.entity.BaseEntity;

/**
 * 权限管理-角色权限关联表..
 *
 * 
 */
public class PmsRolePermission extends BaseEntity {

	private static final long serialVersionUID = -9012707031072904356L;
	private Long roleId; // 角色ID
	private Long permissionId;// 权限ID

	/**
	 * 角色ID
	 * 
	 * @return
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * 角色ID
	 * 
	 * @return
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * 权限ID
	 * 
	 * @return
	 */
	public Long getPermissionId() {
		return permissionId;
	}

	/**
	 * 权限ID
	 * 
	 * @return
	 */
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public PmsRolePermission() {
		super();
	}

}
