package com.zyzf.pay.permission.dao;

import java.util.List;

import com.zyzf.pay.permission.entity.ZyppOperator;

/**
 * 操作员dao
 *
 * ：
 * 
 * 
 */
public interface ZyppOperatorDao extends PermissionBaseDao<ZyppOperator> {

	/**
	 * 根据操作员登录名获取操作员信息.
	 * 
	 * @param loginName
	 *            .
	 * @return operator .
	 */
	ZyppOperator findByLoginName(String loginName);

	/**
	 * 根据角色ID找到操作员列表.
	 * 
	 * @param roleId
	 * @return
	 */
	List<ZyppOperator> listByRoleId(Long roleId);
}
