package com.zyzf.pay.permission.dao;

import java.util.List;

import com.zyzf.pay.permission.entity.ZyppOperatorRole;

/**
 * 操作员与角色dao
 *
 * ：
 * 
 * 
 */
public interface ZyppOperatorRoleDao extends PermissionBaseDao<ZyppOperatorRole> {

	/**
	 * 根据操作员ID查找该操作员关联的角色.
	 * 
	 * @param operatorId
	 *            .
	 * @return list .
	 */
	List<ZyppOperatorRole> listByOperatorId(Long operatorId);

	/**
	 * 根据角色ID查找该操作员关联的操作员.
	 * 
	 * @param roleId
	 * @return
	 */
	List<ZyppOperatorRole> listByRoleId(Long roleId);

	/**
	 * 根据操作员ID删除与角色的关联记录.
	 * 
	 * @param operatorId
	 *            .
	 */
	void deleteByOperatorId(Long operatorId);

	/**
	 * 根据角色ID删除操作员与角色的关联关系.
	 * 
	 * @param roleId
	 *            .
	 */
	void deleteByRoleId(Long roleId);

	/**
	 * 根据角色ID和操作员ID删除关联数据(用于更新操作员的角色).
	 * 
	 * @param roleId
	 *            角色ID.
	 * @param operatorId
	 *            操作员ID.
	 */
	void deleteByRoleIdAndOperatorId(Long roleId, Long operatorId);

}
