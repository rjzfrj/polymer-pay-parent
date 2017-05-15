package com.zyzf.pay.account.service;

import com.zyzf.pay.account.entity.RpAccount;
import com.zyzf.pay.common.core.page.PageBean;
import com.zyzf.pay.common.core.page.PageParam;

/**
 *  账户service接口
 * ：
 * 
 */
public interface RpAccountService{
	
	/**
	 * 保存
	 */
	void saveData(RpAccount rpAccount);

	/**
	 * 更新
	 */
	void updateData(RpAccount rpAccount);

	/**
	 * 根据id获取数据
	 * 
	 * @param id
	 * @return
	 */
	RpAccount getDataById(String id);
	

	/**
	 * 获取分页数据
	 * 
	 * @param pageParam
	 * @return
	 */
	PageBean listPage(PageParam pageParam, RpAccount rpAccount);
	
	/**
	 * 根据userNo获取数据
	 * 
	 * @param userNo
	 * @return
	 */
	RpAccount getDataByUserNo(String userNo);
	
}