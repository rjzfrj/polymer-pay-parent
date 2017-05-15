package com.zyzf.pay.user.dao;

import com.zyzf.pay.common.core.dao.BaseDao;
import com.zyzf.pay.user.entity.SeqBuild;

/**
 * 生成编号dao
 * 
 */
public interface BuildNoDao extends BaseDao<SeqBuild> {

    public String getSeqNextValue(SeqBuild seqBuild);

}
