package com.zyzf.polymer.pay.permission.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import com.zyzf.polymer.pay.common.core.page.PageBean;
import com.zyzf.polymer.pay.common.core.page.PageParam;

/**
 * 权限点数据访问层基础支撑接口
 * 
 * ：
 * 
 * 
 */
public interface PermissionBaseDao<T> {

	/**
	 * 函数功能说明 ：单条插入数据. 
	 * 
	 * @参数：@param entity
	 * @参数：@return
	 * @return：int
	 * @throws
	 */
	int insert(T entity);

	/**
	 * 函数功能说明 ： 批量插入数据. 
	 * 
	 * @参数：@param list
	 * @参数：@return
	 * @return：int
	 * @throws
	 */
	int insert(List<T> list);

	/**
	 * 函数功能说明 ：根据id单条更新数据.
	 * 
	 * @参数：@param entity
	 * @参数：@return
	 * @return：int
	 * @throws
	 */
	int update(T entity);

	 /**
	  * 说明：更具主键id修改 其他字段不为空的才会被修改
	 * @param entity
	 * @return：int
	 */
	int updateByPrimaryKeySelective(T entity);
	/**
	 * 函数功能说明 ： 根据id批量更新数据. 
	 * 
	 * @参数：@param list
	 * @参数：@return
	 * @return：int
	 * @throws
	 */
	int update(List<T> list);

	/**
	 * 函数功能说明 ： 根据column批量更新数据.
	 * 
	 * @参数：@param paramMap
	 * @参数：@return
	 * @return：int
	 * @throws
	 */
	int update(Map<String, Object> paramMap);


	/**
	 * 函数功能说明 ： 根据id查询数据.
	 * 
	 * @参数：@param id
	 * @参数：@return
	 * @return：T
	 * @throws
	 */
	T getById(Long id);

	/**
	 * 函数功能说明 ： 根据column查询数据.
	 * 
	 * @参数：@param paramMap
	 * @参数：@return
	 * @return：T
	 * @throws
	 */
	public T getByColumn(Map<String, Object> paramMap);

	/**
	 * 根据条件查询 listBy: <br/>
	 * 
	 * @param paramMap
	 * @return 返回实体
	 */
	public T getBy(Map<String, Object> paramMap);

	/**
	 * 根据条件查询列表数据.
	 */
	public List<T> listBy(Map<String, Object> paramMap);

	/**
	 * 函数功能说明 ： 根据column查询列表数据.
	 * 
	 * @参数：@param paramMap
	 * @参数：@return
	 * @return：List<T>
	 * @throws
	 */
	public List<T> listByColumn(Map<String, Object> paramMap);

	/**
	 * 函数功能说明 ： 根据column查询记录数. 
	 * 
	 * @参数：@param paramMap
	 * @参数：@return
	 * @return：Long
	 * @throws
	 */
	Long getCountByColumn(Map<String, Object> paramMap);

	/**
	 * 函数功能说明 ： 根据id删除数据.
	 * 
	 * @参数：@param id
	 * @参数：@return
	 * @return：int
	 * @throws
	 */
	int delete(Long id);

	/**
	 * 函数功能说明 ： 根据id批量删除数据.
	 * 
	 * @参数：@param list
	 * @参数：@return
	 * @return：int
	 * @throws
	 */
	int delete(List<T> list);

	/**
	 * 函数功能说明 ： 根据column批量删除数据. 
	 * 
	 * @参数：@param paramMap
	 * @参数：@return
	 * @return：int
	 * @throws
	 */
	int delete(Map<String, Object> paramMap);

	/**
	 * 函数功能说明 ： 分页查询数据 .
	 * 
	 * @参数：@param pageParam
	 * @参数：@param paramMap
	 * @参数：@return
	 * @return：PageBean
	 * @throws
	 */
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);

	public SqlSessionTemplate getSessionTemplate();

	public SqlSession getSqlSession();
}
