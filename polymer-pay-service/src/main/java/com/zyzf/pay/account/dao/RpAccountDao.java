package com.zyzf.pay.account.dao;

import java.util.Map;

import com.zyzf.pay.account.entity.RpAccount;
import com.zyzf.pay.common.core.dao.BaseDao;

/**
 * 账户dao
 * ：
 * 
 */
public interface RpAccountDao  extends BaseDao<RpAccount> {
	RpAccount getByAccountNo(String accountNo);

	RpAccount getByUserNo(Map<String, Object> map);
}