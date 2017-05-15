package com.zyzf.pay.notify.dao;


import com.zyzf.pay.common.core.dao.BaseDao;
import com.zyzf.pay.notify.entity.RpNotifyRecordLog;


/**
 * @功能说明:
 * 
 * @创建时间: 16/6/2  上午11:20
 * @公司名称: ()
 * @版本:V1.0
 */
public interface RpNotifyRecordLogDao  extends BaseDao<RpNotifyRecordLog> {


    int deleteByPrimaryKey(String id);

    int insertSelective(RpNotifyRecordLog record);

    RpNotifyRecordLog selectByPrimaryKey(String id);


    int updateByPrimaryKey(RpNotifyRecordLog record);
}