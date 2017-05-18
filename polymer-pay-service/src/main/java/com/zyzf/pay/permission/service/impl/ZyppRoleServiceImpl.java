package com.zyzf.pay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyzf.pay.common.core.page.PageBean;
import com.zyzf.pay.common.core.page.PageParam;
import com.zyzf.pay.permission.dao.ZyppRoleDao;
import com.zyzf.pay.permission.entity.ZyppRole;
import com.zyzf.pay.permission.service.ZyppRoleService;

/**
 * 角色service接口实现
 *
 * ：
 * 
 * 
 */
@Service("ZyppRoleService")
public class ZyppRoleServiceImpl implements ZyppRoleService {
	@Autowired
	private ZyppRoleDao ZyppRoleDao;

	/**
	 * 创建ZyppOperator
	 */
	public void saveData(ZyppRole ZyppRole) {
		ZyppRoleDao.insert(ZyppRole);
	}

	/**
	 * 修改ZyppOperator
	 */
	public void updateData(ZyppRole ZyppRole) {
		ZyppRoleDao.update(ZyppRole);
	}

	/**
	 * 根据id获取数据ZyppOperator
	 * 
	 * @param id
	 * @return
	 */
	public ZyppRole getDataById(Long id) {
		return ZyppRoleDao.getById(id);

	}

	/**
	 * 分页查询ZyppOperator
	 * 
	 * @param pageParam
	 * @param ActivityVo
	 *            ZyppOperator
	 * @return
	 */
	public PageBean listPage(PageParam pageParam, ZyppRole ZyppRole) {
		Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
		paramMap.put("roleName", ZyppRole.getRoleName()); // 角色名称（模糊查询）
		return ZyppRoleDao.listPage(pageParam, paramMap);
	}

	/**
	 * 获取所有角色列表，以供添加操作员时选择.
	 * 
	 * @return roleList .
	 */
	public List<ZyppRole> listAllRole() {
		return ZyppRoleDao.listAll();
	}

	/**
	 * 判断此权限是否关联有角色
	 * 
	 * @param permissionId
	 * @return
	 */
	public List<ZyppRole> listByPermissionId(Long permissionId) {
		return ZyppRoleDao.listByPermissionId(permissionId);
	}

	/**
	 * 根据角色名或者角色编号查询角色
	 * 
	 * @param roleName
	 * @param roleCode
	 * @return
	 */
	public ZyppRole getByRoleNameOrRoleCode(String roleName, String roleCode) {
		return ZyppRoleDao.getByRoleNameOrRoleCode(roleName, roleCode);
	}

	/**
	 * 删除
	 * 
	 * @param roleId
	 */
	public void delete(Long roleId) {
		ZyppRoleDao.delete(roleId);
	}
}
