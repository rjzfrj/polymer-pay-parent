package com.zyzf.pay.account.dao;

import java.util.List;
import java.util.Map;

import com.zyzf.pay.account.entity.RpAccountHistory;
import com.zyzf.pay.account.vo.DailyCollectAccountHistoryVo;
import com.zyzf.pay.common.core.dao.BaseDao;

/**
 * 账户历史dao
 * ：
 * 
 */
public interface RpAccountHistoryDao  extends BaseDao<RpAccountHistory> {
	List<RpAccountHistory> listPageByParams(Map<String, Object> params);
	
	List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo(Map<String, Object> params);

	/** 更新账户风险预存期外的账户历史记录记为结算完成 **/
	void updateCompleteSettTo100(Map<String, Object> params);
}