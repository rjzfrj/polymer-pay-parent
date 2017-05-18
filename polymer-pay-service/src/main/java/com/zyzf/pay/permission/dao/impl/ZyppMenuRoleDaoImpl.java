package com.zyzf.pay.permission.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyzf.pay.permission.dao.ZyppMenuRoleDao;
import com.zyzf.pay.permission.entity.ZyppMenuRole;

/**
 * 菜单角色
 *
 * ：
 * 
 * 
 */
@Repository("ZyppRoleMenuDao")
public class ZyppMenuRoleDaoImpl extends PermissionBaseDaoImpl<ZyppMenuRole> implements ZyppMenuRoleDao {

	@Override
	public void deleteByRoleId(Long roleId) {
		super.getSqlSession().delete(getStatement("deleteByRoleId"), roleId);
	}

	/**
	 * 根据角色ID统计关联到此角色的菜单数.
	 * 
	 * @param roleId
	 *            角色ID.
	 * @return count.
	 */
	@Override
	public List<ZyppMenuRole> listByRoleId(Long roleId) {
		return super.getSqlSession().selectList(getStatement("listByRoleId"), roleId);
	}
}