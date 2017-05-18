/*
 * Copyright 2015-2102 zyzf(http://) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zyzf.pay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyzf.pay.common.core.page.PageBean;
import com.zyzf.pay.common.core.page.PageParam;
import com.zyzf.pay.permission.dao.ZyppPermissionDao;
import com.zyzf.pay.permission.dao.ZyppRolePermissionDao;
import com.zyzf.pay.permission.entity.ZyppPermission;
import com.zyzf.pay.permission.entity.ZyppRolePermission;
import com.zyzf.pay.permission.service.ZyppPermissionService;

/**
 * 权限service接口实现
 *
 */
@Service("ZyppPermissionService")
public class ZyppPermissionServiceImpl implements ZyppPermissionService {
	@Autowired
	private ZyppPermissionDao ZyppPermissionDao;
	@Autowired
	private ZyppRolePermissionDao ZyppRolePermissionDao;

	/**
	 * 创建ZyppOperator
	 */
	public void saveData(ZyppPermission ZyppPermission) {
		ZyppPermissionDao.insert(ZyppPermission);
	}

	/**
	 * 修改ZyppOperator
	 */
	public void updateData(ZyppPermission ZyppPermission) {
		ZyppPermissionDao.update(ZyppPermission);
	}

	/**
	 * 根据id获取数据ZyppOperator
	 * 
	 * @param id
	 * @return
	 */
	public ZyppPermission getDataById(Long id) {
		return ZyppPermissionDao.getById(id);

	}

	/**
	 * 分页查询ZyppOperator
	 * 
	 * @param pageParam
	 * @param ActivityVo
	 *            ZyppOperator
	 * @return
	 */
	public PageBean listPage(PageParam pageParam, ZyppPermission ZyppPermission) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("permissionName", ZyppPermission.getPermissionName()); // 权限名称（模糊查询）
		paramMap.put("permission", ZyppPermission.getPermission()); // 权限（精确查询）
		return ZyppPermissionDao.listPage(pageParam, paramMap);
	}

	/**
	 * 检查权限名称是否已存在
	 * 
	 * @param trim
	 * @return
	 */
	public ZyppPermission getByPermissionName(String permissionName) {
		return ZyppPermissionDao.getByPermissionName(permissionName);
	}

	/**
	 * 检查权限是否已存在
	 * 
	 * @param permission
	 * @return
	 */
	public ZyppPermission getByPermission(String permission) {
		return ZyppPermissionDao.getByPermission(permission);
	}

	/**
	 * 检查权限名称是否已存在(其他id)
	 * 
	 * @param permissionName
	 * @param id
	 * @return
	 */
	public ZyppPermission getByPermissionNameNotEqId(String permissionName, Long id) {
		return ZyppPermissionDao.getByPermissionNameNotEqId(permissionName, id);
	}

	/**
	 * ZyppPermissionDao 删除
	 * 
	 * @param permission
	 */
	public void delete(Long permissionId) {
		ZyppPermissionDao.delete(permissionId);
	}

	/**
	 * 根据角色查找角色对应的功能权限ID集
	 * 
	 * @param roleId
	 * @return
	 */
	public String getPermissionIdsByRoleId(Long roleId) {
		List<ZyppRolePermission> rmList = ZyppRolePermissionDao.listByRoleId(roleId);
		StringBuffer actionIds = new StringBuffer();
		if (rmList != null && !rmList.isEmpty()) {
			for (ZyppRolePermission rm : rmList) {
				actionIds.append(rm.getPermissionId()).append(",");
			}
		}
		return actionIds.toString();
	}

	/**
	 * 查询所有的权限
	 */
	public List<ZyppPermission> listAll() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return ZyppPermissionDao.listBy(paramMap);
	}
}
