package com.zyzf.pay.permission.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyzf.pay.common.core.page.PageBean;
import com.zyzf.pay.common.core.page.PageParam;
import com.zyzf.pay.permission.dao.ZyppOperatorLogDao;
import com.zyzf.pay.permission.entity.ZyppOperatorLog;
import com.zyzf.pay.permission.service.ZyppOperatorLogService;

/**
 * 操作员service接口实现
 *
 * 
 */
@Service("ZyppOperatorLogService")
public class ZyppOperatorLogServiceImpl implements ZyppOperatorLogService {
	@Autowired
	private ZyppOperatorLogDao ZyppOperatorLogDao;

	/**
	 * 创建ZyppOperator
	 */
	public void saveData(ZyppOperatorLog ZyppOperatorLog) {
		ZyppOperatorLogDao.insert(ZyppOperatorLog);
	}

	/**
	 * 修改ZyppOperator
	 */
	public void updateData(ZyppOperatorLog ZyppOperatorLog) {
		ZyppOperatorLogDao.update(ZyppOperatorLog);
	}

	/**
	 * 根据id获取数据ZyppOperator
	 * 
	 * @param id
	 * @return
	 */
	public ZyppOperatorLog getDataById(Long id) {
		return ZyppOperatorLogDao.getById(id);

	}

	/**
	 * 分页查询ZyppOperator
	 * 
	 * @param pageParam
	 * @param ActivityVo
	 *            ZyppOperator
	 * @return
	 */
	public PageBean listPage(PageParam pageParam, ZyppOperatorLog ZyppOperatorLog) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return ZyppOperatorLogDao.listPage(pageParam, paramMap);
	}

}
