package com.zyzf.pay.trade.dao;

import com.zyzf.pay.common.core.dao.BaseDao;
import com.zyzf.pay.trade.entity.RpTradePaymentOrder;

/**
 * <b>功能说明:商户支付订单,dao层接口</b>
 */
public interface RpTradePaymentOrderDao  extends BaseDao<RpTradePaymentOrder>{

    /**
     * 根据商户编号及商户订单号获取支付订单信息
     * @param merchantNo
     * @param merchantOrderNo
     * @return
     */
    RpTradePaymentOrder selectByMerchantNoAndMerchantOrderNo(String merchantNo, String merchantOrderNo);

}
