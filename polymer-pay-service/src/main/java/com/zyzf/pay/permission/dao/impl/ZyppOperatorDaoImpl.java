package com.zyzf.pay.permission.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyzf.pay.permission.dao.ZyppOperatorDao;
import com.zyzf.pay.permission.entity.ZyppOperator;

/**
 * 权限操作员dao实现
 *
 * ：
 * 
 * 
 */
@Repository
public class ZyppOperatorDaoImpl extends PermissionBaseDaoImpl<ZyppOperator> implements ZyppOperatorDao {

	/**
	 * 根据操作员登录名获取操作员信息.
	 * 
	 * @param loginName
	 *            .
	 * @return operator .
	 */

	public ZyppOperator findByLoginName(String loginName) {
		return super.getSqlSession().selectOne(getStatement("findByLoginName"), loginName);
	}

	@Override
	public List<ZyppOperator> listByRoleId(Long roleId) {
		return super.getSqlSession().selectList(getStatement("listByRoleId"), roleId);
	}

}
