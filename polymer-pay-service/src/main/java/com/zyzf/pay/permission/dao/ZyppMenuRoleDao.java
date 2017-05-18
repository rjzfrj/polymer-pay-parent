package com.zyzf.pay.permission.dao;

import java.util.List;

import com.zyzf.pay.permission.entity.ZyppMenuRole;

/**
 * 菜单角色关联表
 *
 * ：
 * 
 * 
 */
public interface ZyppMenuRoleDao extends PermissionBaseDao<ZyppMenuRole> {

	/**
	 * 根据角色ID删除菜单与角色的关联记录.
	 * 
	 * @param roleId
	 */
	void deleteByRoleId(Long roleId);

	/**
	 * 根据角色ID统计关联到此角色的菜单数.
	 * 
	 * @param roleId
	 *            角色ID.
	 * @return count.
	 */
	List<ZyppMenuRole> listByRoleId(Long roleId);
}