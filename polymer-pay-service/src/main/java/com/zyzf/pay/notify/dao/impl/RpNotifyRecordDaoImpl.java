package com.zyzf.pay.notify.dao.impl;

import com.zyzf.pay.common.core.dao.impl.BaseDaoImpl;
import com.zyzf.pay.notify.dao.RpNotifyRecordDao;
import com.zyzf.pay.notify.entity.RpNotifyRecord;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @功能说明:
 * 
 * @创建时间: 16/6/2  下午2:31
 * @公司名称: ()
 * @版本:V1.0
 */
@Repository("rpNotifyRecordDao")
public class RpNotifyRecordDaoImpl extends BaseDaoImpl<RpNotifyRecord> implements RpNotifyRecordDao {


    @Override
    public RpNotifyRecord getNotifyByMerchantNoAndMerchantOrderNoAndNotifyType(String merchantNo, String merchantOrderNo, String notifyType) {
        Map<String , Object> paramMap = new HashMap<String , Object>();
        paramMap.put("merchantNo",merchantNo);
        paramMap.put("merchantOrderNo",merchantOrderNo);
        paramMap.put("notifyType",notifyType);

        return super.getBy(paramMap);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insertSelective(RpNotifyRecord record) {
        return 0;
    }

    @Override
    public RpNotifyRecord selectByPrimaryKey(String id) {
        return null;
    }


    @Override
    public int updateByPrimaryKey(RpNotifyRecord record) {
        return 0;
    }

}
