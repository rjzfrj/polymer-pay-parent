package com.zyzf.pay.reconciliation.service;

import java.util.List;
import java.util.Map;

import com.zyzf.pay.common.core.page.PageBean;
import com.zyzf.pay.common.core.page.PageParam;
import com.zyzf.pay.reconciliation.entity.RpAccountCheckMistake;

/**
 * 对账差错接口 .
 *
 */
public interface RpAccountCheckMistakeService {

	/**
	 * 保存
	 */
	void saveData(RpAccountCheckMistake rpAccountCheckMistake);

	/**
	 * 更新
	 */
	void updateData(RpAccountCheckMistake rpAccountCheckMistake);

	/**
	 * 根据id获取数据
	 * 
	 * @param id
	 * @return
	 */
	RpAccountCheckMistake getDataById(String id);

	/**
	 * 获取分页数据
	 * 
	 * @param pageParam
	 * @return
	 */
	PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);

	/**
	 * 批量保存差错记录
	 * 
	 * @param mistakeList
	 */
	void saveListDate(List<RpAccountCheckMistake> mistakeList);

}