package com.zyzf.pay.user.dao;

import com.zyzf.pay.common.core.dao.BaseDao;
import com.zyzf.pay.user.entity.RpUserPayInfo;

/**
 * 用户第三方支付信息dao
 * 
 */
public interface RpUserPayInfoDao  extends BaseDao<RpUserPayInfo> {

    /**
     * 通过商户编号获取商户第三方支付信息
     * @param userNo
     * @param payWayCode
     * @return
     */
    public  RpUserPayInfo getByUserNo(String userNo, String payWayCode);

}