package com.zyzf.pay.reconciliation.service;

import java.util.List;

import com.zyzf.pay.reconciliation.entity.RpAccountCheckBatch;
import com.zyzf.pay.reconciliation.entity.RpAccountCheckMistake;
import com.zyzf.pay.reconciliation.entity.RpAccountCheckMistakeScratchPool;

/**
 * 对账数据事务一致性service.
 *
 */
public interface RpAccountCheckTransactionService {

	/**
	 * 保存
	 */
	void saveDatasaveDate(RpAccountCheckBatch batch, List<RpAccountCheckMistake> mistakeList, List<RpAccountCheckMistakeScratchPool> insertScreatchRecordList, List<RpAccountCheckMistakeScratchPool> removeScreatchRecordList);

	/**
	 * 
	 * @param list
	 * @param mistakeList
	 */
	void removeDateFromPool(List<RpAccountCheckMistakeScratchPool> list, List<RpAccountCheckMistake> mistakeList);

	/**
	 * 差错处理
	 * 
	 * @param id
	 *            差错记录id
	 * @param handleType
	 *            差错处理方式
	 * @param handleRemark
	 *            差错备注
	 */
	void handle(String id, String handleType, String handleRemark);

}