package com.zyzf.pay.permission.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyzf.pay.permission.dao.ZyppOperatorDao;
import com.zyzf.pay.permission.dao.ZyppOperatorRoleDao;
import com.zyzf.pay.permission.dao.ZyppRoleDao;
import com.zyzf.pay.permission.entity.ZyppOperator;
import com.zyzf.pay.permission.entity.ZyppOperatorRole;
import com.zyzf.pay.permission.entity.ZyppRole;
import com.zyzf.pay.permission.service.ZyppOperatorRoleService;

/**
 * 操作员角色service接口实现
 *
 * 
 */
@Service("ZyppOperatorRoleService")
public class ZyppOperatorRoleServiceImpl implements ZyppOperatorRoleService {
	@Autowired
	private ZyppOperatorRoleDao ZyppOperatorRoleDao;

	@Autowired
	private ZyppOperatorDao ZyppOperatorDao;

	@Autowired
	private ZyppRoleDao ZyppRoleDao;

	/**
	 * 根据操作员ID获得该操作员的所有角色id所拼成的String，每个ID用“,”分隔
	 * 
	 * @param operatorId
	 *            操作员ID
	 * @return roleIds
	 */
	public String getRoleIdsByOperatorId(Long operatorId) {
		// 得到操作员和角色列表
		List<ZyppOperatorRole> rpList = ZyppOperatorRoleDao.listByOperatorId(operatorId);
		// 构建StringBuffer来拼字符串
		StringBuffer roleIdsBuf = new StringBuffer("");
		for (ZyppOperatorRole rp : rpList) {
			roleIdsBuf.append(rp.getRoleId()).append(",");
		}
		String roleIds = roleIdsBuf.toString();
		// 截取字符串
		if (StringUtils.isNotBlank(roleIds) && roleIds.length() > 0) {
			roleIds = roleIds.substring(0, roleIds.length() - 1);
		}
		return roleIds;
	}

	/**
	 * 根据操作员id，获取该操作员所有角色的编码集合
	 * 
	 * @param operatorId
	 * @return
	 */
	public Set<String> getRoleCodeByOperatorId(Long operatorId) {
		// 得到操作员和角色列表
		List<ZyppOperatorRole> rpList = ZyppOperatorRoleDao.listByOperatorId(operatorId);
		Set<String> roleCodeSet = new HashSet<String>();

		for (ZyppOperatorRole rp : rpList) {
			Long roleId = rp.getRoleId();
			ZyppRole role = ZyppRoleDao.getById(roleId);
			if (role == null) {
				continue;
			}
			roleCodeSet.add(role.getRoleCode());
		}

		return roleCodeSet;

	}

	/**
	 * 根据角色ID统计有多少个操作员关联到此角色.
	 * 
	 * @param roleId
	 *            .
	 * @return count.
	 */
	public int countOperatorByRoleId(Long roleId) {
		List<ZyppOperatorRole> operatorList = ZyppOperatorRoleDao.listByRoleId(roleId);
		if (operatorList == null || operatorList.isEmpty()) {
			return 0;
		} else {
			return operatorList.size();
		}
	}

	/**
	 * 根据操作员ID获得所有操作员－角色关联列表
	 */
	public List<ZyppOperatorRole> listOperatorRoleByOperatorId(Long operatorId) {
		return ZyppOperatorRoleDao.listByOperatorId(operatorId);
	}

	/**
	 * 保存操作員信息及其关联的角色.
	 * 
	 * @param ZyppOperator
	 *            .
	 * @param OperatorRoleStr
	 *            .
	 */
	public void saveOperator(ZyppOperator ZyppOperator, String OperatorRoleStr) {
		// 保存操作员信息
		ZyppOperatorDao.insert(ZyppOperator);
		// 保存角色关联信息
		if (StringUtils.isNotBlank(OperatorRoleStr) && OperatorRoleStr.length() > 0) {
			saveOrUpdateOperatorRole(ZyppOperator.getId(), OperatorRoleStr);
		}
	}

	/**
	 * 根据角色ID查询用户
	 * 
	 * @param roleId
	 * @return
	 */
	public List<ZyppOperator> listOperatorByRoleId(Long roleId) {
		return ZyppOperatorDao.listByRoleId(roleId);
	}

	/**
	 * 修改操作員信息及其关联的角色.
	 * 
	 * @param ZyppOperator
	 *            .
	 * @param OperatorRoleStr
	 *            .
	 */
	public void updateOperator(ZyppOperator ZyppOperator, String OperatorRoleStr) {
		ZyppOperatorDao.update(ZyppOperator);
		// 更新角色信息
		saveOrUpdateOperatorRole(ZyppOperator.getId(), OperatorRoleStr);
	}

	/**
	 * 保存用户和角色之间的关联关系
	 */
	private void saveOrUpdateOperatorRole(Long operatorId, String roleIdsStr) {
		// 删除原来的角色与操作员关联
		List<ZyppOperatorRole> listZyppOperatorRoles = ZyppOperatorRoleDao.listByOperatorId(operatorId);
		Map<Long, ZyppOperatorRole> delMap = new HashMap<Long, ZyppOperatorRole>();
		for (ZyppOperatorRole ZyppOperatorRole : listZyppOperatorRoles) {
			delMap.put(ZyppOperatorRole.getRoleId(), ZyppOperatorRole);
		}
		if (StringUtils.isNotBlank(roleIdsStr)) {
			// 创建新的关联
			String[] roleIds = roleIdsStr.split(",");
			for (int i = 0; i < roleIds.length; i++) {
				Long roleId = Long.valueOf(roleIds[i]);
				if (delMap.get(roleId) == null) {
					ZyppOperatorRole ZyppOperatorRole = new ZyppOperatorRole();
					ZyppOperatorRole.setOperatorId(operatorId);
					ZyppOperatorRole.setRoleId(roleId);
					ZyppOperatorRoleDao.insert(ZyppOperatorRole);
				} else {
					delMap.remove(roleId);
				}
			}
		}

		Iterator<Long> iterator = delMap.keySet().iterator();
		while (iterator.hasNext()) {
			Long roleId = iterator.next();
			ZyppOperatorRoleDao.deleteByRoleIdAndOperatorId(roleId, operatorId);
		}
	}

}
