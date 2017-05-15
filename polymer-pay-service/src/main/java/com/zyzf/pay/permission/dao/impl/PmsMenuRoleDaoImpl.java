package com.zyzf.pay.permission.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyzf.pay.permission.dao.PmsMenuRoleDao;
import com.zyzf.pay.permission.entity.PmsMenuRole;

/**
 * 菜单角色
 *
 * ：
 * 
 * 
 */
@Repository("pmsRoleMenuDao")
public class PmsMenuRoleDaoImpl extends PermissionBaseDaoImpl<PmsMenuRole> implements PmsMenuRoleDao {

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
	public List<PmsMenuRole> listByRoleId(Long roleId) {
		return super.getSqlSession().selectList(getStatement("listByRoleId"), roleId);
	}
}