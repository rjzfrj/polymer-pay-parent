package com.zyzf.pay.user.dao;

import com.zyzf.pay.common.core.dao.BaseDao;
import com.zyzf.pay.user.entity.RpUserPayConfig;

/**
 * 用户支付配置dao
 */
public interface RpUserPayConfigDao  extends BaseDao<RpUserPayConfig> {

    /**
     * 根据用户编号获取用户支付信息
     * @param userNo
     * @return
     */
    RpUserPayConfig getByUserNo(String userNo, String auditStatus);

}