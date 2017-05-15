package com.zyzf.pay.account.service;

import com.zyzf.pay.account.entity.RpAccountHistory;
import com.zyzf.pay.common.core.page.PageBean;
import com.zyzf.pay.common.core.page.PageParam;

/**
 * 账户历史service接口
 * ：
 * 
 */
public interface RpAccountHistoryService{
	
	/**
	 * 保存
	 */
	void saveData(RpAccountHistory rpAccountHistory);

	/**
	 * 更新
	 */
	void updateData(RpAccountHistory rpAccountHistory);

	/**
	 * 根据id获取数据
	 * 
	 * @param id
	 * @return
	 */
	RpAccountHistory getDataById(String id);
	

	/**
	 * 获取分页数据
	 * 
	 * @param pageParam
	 * @return
	 */
	PageBean listPage(PageParam pageParam, RpAccountHistory rpAccountHistory);
	
}