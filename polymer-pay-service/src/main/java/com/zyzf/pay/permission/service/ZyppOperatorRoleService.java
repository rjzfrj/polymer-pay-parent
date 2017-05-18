package com.zyzf.pay.permission.service;

import java.util.List;
import java.util.Set;

import com.zyzf.pay.permission.entity.ZyppOperator;
import com.zyzf.pay.permission.entity.ZyppOperatorRole;

/**
 * 操作员角色service接口
 *
 */
public interface ZyppOperatorRoleService {

	/**
	 * 根据操作员ID获得该操作员的所有角色id所拼成的String，每个ID用“,”分隔
	 * 
	 * @param operatorId
	 *            操作员ID
	 * @return roleIds
	 */
	public String getRoleIdsByOperatorId(Long operatorId);

	/**
	 * 根据操作员id，获取该操作员所有角色的编码集合
	 * 
	 * @param operatorId
	 * @return
	 */
	public Set<String> getRoleCodeByOperatorId(Long operatorId);

	/**
	 * 根据角色ID查询用户
	 * 
	 * @param roleId
	 * @return
	 */
	public List<ZyppOperator> listOperatorByRoleId(Long roleId);

	/**
	 * 保存操作員信息及其关联的角色.
	 * 
	 * @param ZyppOperator
	 *            .
	 * @param roleOperatorStr
	 *            .
	 */
	public void saveOperator(ZyppOperator ZyppOperator, String roleOperatorStr);

	/**
	 * 修改操作員信息及其关联的角色.
	 * 
	 * @param ZyppOperator
	 *            .
	 * @param roleOperatorStr
	 *            .
	 */
	public void updateOperator(ZyppOperator ZyppOperator, String roleOperatorStr);

	/**
	 * 根据角色ID统计有多少个操作员关联到此角色.
	 * 
	 * @param roleId
	 *            .
	 * @return count.
	 */
	public int countOperatorByRoleId(Long roleId);

	/**
	 * 根据操作员ID获得所有操作员－角色关联列表
	 */
	public List<ZyppOperatorRole> listOperatorRoleByOperatorId(Long operatorId);
	
	

}
