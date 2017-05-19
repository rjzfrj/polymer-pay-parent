package com.zyzf.polymer.pay.permission.entity;

/**
 * 
 * 权限管理- 操作员角色关联表 
 *
 * ：
 * 
 * 
 */
public class PmsOperatorRole extends PermissionBaseEntity {

	private static final long serialVersionUID = 174356028197753020L;
	private Long roleId;// 角色ID
	private Long operatorId;// /操作员ID

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
	 * 操作员ID
	 * 
	 * @return
	 */
	public Long getOperatorId() {
		return operatorId;
	}

	/**
	 * 操作员ID
	 * 
	 * @return
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public PmsOperatorRole() {

	}

}
