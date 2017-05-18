package com.zyzf.pay.permission.dao;

import java.util.List;

import com.zyzf.pay.permission.entity.ZyppPermission;

/**
 * 权限点dao
 *
 * ：
 * 
 * 
 */
public interface ZyppPermissionDao extends PermissionBaseDao<ZyppPermission> {
	/**
	 * 根据实体ID集字符串获取对象列表.
	 * 
	 * @param ids
	 * @return
	 */
	List<ZyppPermission> findByIds(String ids);

	/**
	 * 检查权限名称是否已存在
	 * 
	 * @param trim
	 * @return
	 */
	ZyppPermission getByPermissionName(String permissionName);

	/**
	 * 检查权限是否已存在
	 * 
	 * @param permission
	 * @return
	 */
	ZyppPermission getByPermission(String permission);

	/**
	 * 检查权限名称是否已存在(其他id)
	 * 
	 * @param permissionName
	 * @param id
	 * @return
	 */
	ZyppPermission getByPermissionNameNotEqId(String permissionName, Long id);

	/**
	 * 获取叶子菜单下所有的功能权限
	 * 
	 * @param valueOf
	 * @return
	 */
	List<ZyppPermission> listAllByMenuId(Long menuId);

}
