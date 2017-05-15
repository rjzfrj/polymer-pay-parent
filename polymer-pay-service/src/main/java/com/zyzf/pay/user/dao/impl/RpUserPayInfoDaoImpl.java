package com.zyzf.pay.user.dao.impl;

import org.springframework.stereotype.Repository;

import com.zyzf.pay.common.core.dao.impl.BaseDaoImpl;
import com.zyzf.pay.user.dao.RpUserPayInfoDao;
import com.zyzf.pay.user.entity.RpUserPayInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户第三方支付信息dao实现类
 * 
 */
@Repository
public class RpUserPayInfoDaoImpl  extends BaseDaoImpl<RpUserPayInfo> implements RpUserPayInfoDao{
    /**
     * 通过商户编号获取商户第三方支付信息
     *
     * @param userNo
     * @param payWayCode
     * @return
     */
    @Override
    public RpUserPayInfo getByUserNo(String userNo, String payWayCode) {
        Map<String , Object> paramMap = new HashMap<String , Object>();
        paramMap.put("userNo",userNo);
        paramMap.put("payWayCode",payWayCode);
        return super.getBy(paramMap);
    }
}