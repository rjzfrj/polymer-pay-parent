package com.zyzf.pay.reconciliation.service;

import java.util.List;
import java.util.Map;

import com.zyzf.pay.common.core.page.PageBean;
import com.zyzf.pay.common.core.page.PageParam;
import com.zyzf.pay.reconciliation.entity.RpAccountCheckBatch;

/**
 * 对账批次接口 .
 *
 */
public interface RpAccountCheckBatchService {

	/**
	 * 保存
	 */
	void saveData(RpAccountCheckBatch rpAccountCheckBatch);

	/**
	 * 更新
	 */
	void updateData(RpAccountCheckBatch rpAccountCheckBatch);

	/**
	 * 根据id获取数据
	 * 
	 * @param id
	 * @return
	 */
	RpAccountCheckBatch getDataById(String id);

	/**
	 * 获取分页数据
	 * 
	 * @param pageParam
	 * @return
	 */
	PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);

	/**
	 * 根据条件查询实体
	 * 
	 * @param paramMap
	 */
	public List<RpAccountCheckBatch> listBy(Map<String, Object> paramMap);

}