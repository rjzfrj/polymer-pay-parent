package com.zyzf.pay.permission.service;

import java.util.List;

import com.zyzf.pay.common.core.page.PageBean;
import com.zyzf.pay.common.core.page.PageParam;
import com.zyzf.pay.permission.entity.ZyppPermission;

/**
 * 权限service接口
 *
 * 
 */
public interface ZyppPermissionService {

	/**
	 * 创建ZyppPermission
	 */
	void saveData(ZyppPermission ZyppPermission);

	/**
	 * 修改ZyppPermission
	 */
	void updateData(ZyppPermission ZyppPermission);

	/**
	 * 根据id获取数据ZyppPermission
	 * 
	 * @param id
	 * @return
	 */
	ZyppPermission getDataById(Long id);

	/**
	 * 分页查询ZyppPermission
	 * 
	 * @param pageParam
	 * @param ActivityVo
	 *            ZyppPermission
	 * @return
	 */
	PageBean listPage(PageParam pageParam, ZyppPermission ZyppPermission);

	/**
	 * 检查权限名称是否已存在
	 * 
	 * @param permissionName
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
	 * 删除
	 * 
	 * @param permissionId
	 */
	void delete(Long permissionId);

	/**
	 * 根据角色查找角色对应的功能权限ID集
	 * 
	 * @param roleId
	 * @return
	 */
	String getPermissionIdsByRoleId(Long roleId);
	
	/**
	 * 查询所有的权限
	 */
	List<ZyppPermission> listAll();

}
