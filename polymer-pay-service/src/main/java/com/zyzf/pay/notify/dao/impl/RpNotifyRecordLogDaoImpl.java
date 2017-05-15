package com.zyzf.pay.notify.dao.impl;

import com.zyzf.pay.common.core.dao.impl.BaseDaoImpl;
import com.zyzf.pay.notify.dao.RpNotifyRecordLogDao;
import com.zyzf.pay.notify.entity.RpNotifyRecordLog;

import org.springframework.stereotype.Repository;

/**
 * @功能说明:
 * 
 * @创建时间: 16/6/2  下午2:32
 * @公司名称: ()
 * @版本:V1.0
 */
@Repository("rpNotifyRecordLogDao")
public class RpNotifyRecordLogDaoImpl extends BaseDaoImpl<RpNotifyRecordLog> implements RpNotifyRecordLogDao {
    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insertSelective(RpNotifyRecordLog record) {
        return 0;
    }

    @Override
    public RpNotifyRecordLog selectByPrimaryKey(String id) {
        return null;
    }


    @Override
    public int updateByPrimaryKey(RpNotifyRecordLog record) {
        return 0;
    }
}
