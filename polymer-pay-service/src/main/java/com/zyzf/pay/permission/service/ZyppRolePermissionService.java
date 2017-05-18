package com.zyzf.pay.permission.service;

import java.util.Set;

import com.zyzf.pay.common.core.page.PageBean;
import com.zyzf.pay.common.core.page.PageParam;
import com.zyzf.pay.permission.entity.ZyppRolePermission;

/**
 * 角色权限service接口
 *
 * 
 */
public interface ZyppRolePermissionService {

	/**
	 * 根据操作员ID，获取所有的功能权限集
	 * 
	 * @param operatorId
	 */
	public Set<String> getPermissionsByOperatorId(Long operatorId);

	/**
	 * 创建ZyppRolePermission
	 */
	void saveData(ZyppRolePermission ZyppRolePermission);

	/**
	 * 修改ZyppRolePermission
	 */
	void updateData(ZyppRolePermission ZyppRolePermission);

	/**
	 * 根据id获取数据ZyppRolePermission
	 * 
	 * @param id
	 * @return
	 */
	ZyppRolePermission getDataById(Long id);

	/**
	 * 分页查询ZyppRolePermission
	 * 
	 * @param pageParam
	 * @param ActivityVo
	 *            ZyppRolePermission
	 * @return
	 */
	PageBean listPage(PageParam pageParam, ZyppRolePermission ZyppRolePermission);
	
	/**
	 * 保存角色和权限之间的关联关系
	 */
	void saveRolePermission(Long roleId, String rolePermissionStr);

}
