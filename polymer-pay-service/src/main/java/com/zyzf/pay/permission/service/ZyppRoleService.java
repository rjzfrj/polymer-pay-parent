package com.zyzf.pay.permission.service;

import java.util.List;

import com.zyzf.pay.common.core.page.PageBean;
import com.zyzf.pay.common.core.page.PageParam;
import com.zyzf.pay.permission.entity.ZyppRole;

/**
 * 角色service接口
 *
 */
public interface ZyppRoleService {

	/**
	 * 创建ZyppRole
	 */
	void saveData(ZyppRole ZyppRole);

	/**
	 * 修改ZyppRole
	 */
	void updateData(ZyppRole ZyppRole);

	/**
	 * 根据id获取数据ZyppRole
	 * 
	 * @param id
	 * @return
	 */
	ZyppRole getDataById(Long id);

	/**
	 * 分页查询ZyppRole
	 * 
	 * @param pageParam
	 * @param ActivityVo
	 *            ZyppRole
	 * @return
	 */
	PageBean listPage(PageParam pageParam, ZyppRole ZyppRole);

	/**
	 * 获取所有角色列表，以供添加操作员时选择.
	 * 
	 * @return roleList .
	 */
	public List<ZyppRole> listAllRole();

	/**
	 * 判断此权限是否关联有角色
	 * 
	 * @param permissionId
	 * @return
	 */
	List<ZyppRole> listByPermissionId(Long permissionId);

	/**
	 * 根据角色名或者角色编号查询角色
	 * 
	 * @param roleName
	 * @param roleCode
	 * @return
	 */
	ZyppRole getByRoleNameOrRoleCode(String roleName, String roleCode);

	/**
	 * 删除
	 * 
	 * @param roleId
	 */
	void delete(Long roleId);

}
