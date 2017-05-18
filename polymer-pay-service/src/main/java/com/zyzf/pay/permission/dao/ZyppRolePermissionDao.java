package com.zyzf.pay.permission.dao;

import java.util.List;

import com.zyzf.pay.permission.entity.ZyppRolePermission;

/**
 * 角色权限dao
 *
 * ：
 * 
 * 
 */
public interface ZyppRolePermissionDao extends PermissionBaseDao<ZyppRolePermission> {

	/**
	 * 根据角色ID找到角色关联的权限点.
	 * 
	 * @param roleId
	 *            .
	 * @return rolePermissionList .
	 */
	public List<ZyppRolePermission> listByRoleId(final long roleId);

	/**
	 * 根据角色ID字符串获取相应角色-权限关联信息.
	 * 
	 * @param roleIds
	 * @return
	 */
	public List<ZyppRolePermission> listByRoleIds(String roleIdsStr);

	public void deleteByRoleIdAndPermissionId(Long roleId, Long permissionId);
	
	public void deleteByRoleId(Long roleId);
}
