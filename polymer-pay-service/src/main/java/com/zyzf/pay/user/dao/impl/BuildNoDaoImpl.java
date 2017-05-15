package com.zyzf.pay.user.dao.impl;

import org.springframework.stereotype.Repository;

import com.zyzf.pay.common.core.dao.impl.BaseDaoImpl;
import com.zyzf.pay.user.dao.BuildNoDao;
import com.zyzf.pay.user.entity.SeqBuild;

/**
 *  生成编号dao实现类
 */
@Repository
public class BuildNoDaoImpl   extends BaseDaoImpl<SeqBuild> implements BuildNoDao {

    @Override
    public String getSeqNextValue(SeqBuild seqBuild) {
        return super.getSqlSession().selectOne(getStatement("getSeqNextValue"),seqBuild);
    }
}
