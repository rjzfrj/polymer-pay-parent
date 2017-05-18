package com.zyzf.pay.permission.service;

import com.zyzf.pay.common.core.page.PageBean;
import com.zyzf.pay.common.core.page.PageParam;
import com.zyzf.pay.permission.entity.ZyppOperatorLog;

/**
 * 操作员日志service接口
 *
 * 
 * 
 */
public interface ZyppOperatorLogService {

	/**
	 * 创建ZyppOperatorLog
	 */
	void saveData(ZyppOperatorLog ZyppOperatorLog);

	/**
	 * 修改ZyppOperatorLog
	 */
	void updateData(ZyppOperatorLog ZyppOperatorLog);

	/**
	 * 根据id获取数据ZyppOperatorLog
	 * 
	 * @param id
	 * @return
	 */
	ZyppOperatorLog getDataById(Long id);

	/**
	 * 分页查询ZyppOperatorLog
	 * 
	 * @param pageParam
	 * @param ActivityVo
	 *            ZyppOperatorLog
	 * @return
	 */
	PageBean listPage(PageParam pageParam, ZyppOperatorLog ZyppOperatorLog);

}
