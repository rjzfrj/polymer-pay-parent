package com.zyzf.pay.permission.service;

import java.util.List;

import com.zyzf.pay.common.core.page.PageBean;
import com.zyzf.pay.common.core.page.PageParam;
import com.zyzf.pay.permission.entity.ZyppOperator;
import com.zyzf.pay.permission.entity.ZyppOperatorRole;

/**
 * 操作员service接口
 *
 * 
 */
public interface ZyppOperatorService {

	/**
	 * 创建ZyppOperator
	 */
	void saveData(ZyppOperator ZyppOperator);

	/**
	 * 修改ZyppOperator
	 */
	void updateData(ZyppOperator ZyppOperator);

	/**
	 * 根据id获取数据ZyppOperator
	 * 
	 * @param id
	 * @return
	 */
	ZyppOperator getDataById(Long id);

	/**
	 * 根据登录名取得操作员对象
	 */
	public ZyppOperator findOperatorByLoginName(String loginName);

	/**
	 * 分页查询ZyppOperator
	 * 
	 * @param pageParam
	 * @param ActivityVo
	 *            ZyppOperator
	 * @return
	 */
	PageBean listPage(PageParam pageParam, ZyppOperator ZyppOperator);

	/**
	 * 根据ID删除一个操作员，同时删除与该操作员关联的角色关联信息. type="admin"的超级管理员不能删除.
	 * 
	 * @param id
	 *            操作员ID.
	 */
	public void deleteOperatorById(Long operatorId);

	/**
	 * 根据操作员ID更新操作员密码.
	 * 
	 * @param operatorId
	 * @param newPwd
	 *            (已进行SHA1加密)
	 */
	public void updateOperatorPwd(Long operatorId, String newPwd);

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
	void updateOperator(ZyppOperator ZyppOperator, String roleOperatorStr);

}
