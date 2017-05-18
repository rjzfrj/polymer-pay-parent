package com.zyzf.pay.permission.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zyzf.pay.common.core.enums.PublicStatusEnum;
import com.zyzf.pay.common.core.page.PageBean;
import com.zyzf.pay.common.core.page.PageParam;
import com.zyzf.pay.permission.dao.ZyppOperatorDao;
import com.zyzf.pay.permission.dao.ZyppOperatorRoleDao;
import com.zyzf.pay.permission.entity.ZyppOperator;
import com.zyzf.pay.permission.entity.ZyppOperatorRole;
import com.zyzf.pay.permission.service.ZyppOperatorService;

/**
 * 操作员service接口实现
 *
 */
@Service("ZyppOperatorService")
public class ZyppOperatorServiceImpl implements ZyppOperatorService {
	@Autowired
	private ZyppOperatorDao ZyppOperatorDao;

	@Autowired
	private ZyppOperatorRoleDao ZyppOperatorRoleDao;

	/**
	 * 创建ZyppOperator
	 */
	public void saveData(ZyppOperator ZyppOperator) {
		ZyppOperatorDao.insert(ZyppOperator);
	}

	/**
	 * 修改ZyppOperator
	 */
	public void updateData(ZyppOperator ZyppOperator) {
		ZyppOperatorDao.update(ZyppOperator);
	}

	/**
	 * 根据id获取数据ZyppOperator
	 * 
	 * @param id
	 * @return
	 */
	public ZyppOperator getDataById(Long id) {
		return ZyppOperatorDao.getById(id);

	}

	/**
	 * 分页查询ZyppOperator
	 * 
	 * @param pageParam
	 * @param ActivityVo
	 *            ZyppOperator
	 * @return
	 */
	public PageBean listPage(PageParam pageParam, ZyppOperator ZyppOperator) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("loginName", ZyppOperator.getLoginName()); // 操作员登录名（精确查询）
		paramMap.put("realName", ZyppOperator.getRealName()); // 操作员姓名（模糊查询）
		paramMap.put("status", ZyppOperator.getStatus()); // 状态

		return ZyppOperatorDao.listPage(pageParam, paramMap);
	}

	/**
	 * 根据ID删除一个操作员，同时删除与该操作员关联的角色关联信息. type="1"的超级管理员不能删除.
	 * 
	 * @param id
	 *            操作员ID.
	 */
	public void deleteOperatorById(Long operatorId) {
		ZyppOperator ZyppOperator = ZyppOperatorDao.getById(operatorId);
		if (ZyppOperator != null) {
			if ("admin".equals(ZyppOperator.getType())) {
				throw new RuntimeException("【" + ZyppOperator.getLoginName() + "】为超级管理员，不能删除！");
			}
			ZyppOperatorDao.delete(operatorId);
			// 删除原来的角色与操作员关联
			ZyppOperatorRoleDao.deleteByOperatorId(operatorId);
		}
	}

	/**
	 * 更新操作员信息.
	 * 
	 * @param operator
	 */
	public void update(ZyppOperator operator) {
		ZyppOperatorDao.update(operator);

	}

	/**
	 * 根据操作员ID更新操作员密码.
	 * 
	 * @param operatorId
	 * @param newPwd
	 *            (已进行SHA1加密)
	 */
	public void updateOperatorPwd(Long operatorId, String newPwd) {
		ZyppOperator ZyppOperator = ZyppOperatorDao.getById(operatorId);
		ZyppOperator.setLoginPwd(newPwd);
		ZyppOperatorDao.update(ZyppOperator);
	}

	/**
	 * 根据登录名取得操作员对象
	 */
	public ZyppOperator findOperatorByLoginName(String loginName) {
		return ZyppOperatorDao.findByLoginName(loginName);
	}

	/**
	 * 保存操作員信息及其关联的角色.
	 * 
	 * @param ZyppOperator
	 *            .
	 * @param roleOperatorStr
	 *            .
	 */

	@Transactional
	public void saveOperator(ZyppOperator ZyppOperator, String roleOperatorStr) {
		// 保存操作员信息
		ZyppOperatorDao.insert(ZyppOperator);
		// 保存角色关联信息
		if (StringUtils.isNotBlank(roleOperatorStr) && roleOperatorStr.length() > 0) {
			saveOrUpdateOperatorRole(ZyppOperator, roleOperatorStr);
		}
	}

	/**
	 * 保存用户和角色之间的关联关系
	 */
	private void saveOrUpdateOperatorRole(ZyppOperator ZyppOperator, String roleIdsStr) {
		// 删除原来的角色与操作员关联
		List<ZyppOperatorRole> listZyppOperatorRoles = ZyppOperatorRoleDao.listByOperatorId(ZyppOperator.getId());
		Map<Long, ZyppOperatorRole> delMap = new HashMap<Long, ZyppOperatorRole>();
		for (ZyppOperatorRole ZyppOperatorRole : listZyppOperatorRoles) {
			delMap.put(ZyppOperatorRole.getRoleId(), ZyppOperatorRole);
		}
		if (StringUtils.isNotBlank(roleIdsStr)) {
			// 创建新的关联
			String[] roleIds = roleIdsStr.split(",");
			for (int i = 0; i < roleIds.length; i++) {
				long roleId = Long.parseLong(roleIds[i]);
				if (delMap.get(roleId) == null) {
					ZyppOperatorRole ZyppOperatorRole = new ZyppOperatorRole();
					ZyppOperatorRole.setOperatorId(ZyppOperator.getId());
					ZyppOperatorRole.setRoleId(roleId);
					ZyppOperatorRole.setCreater(ZyppOperator.getCreater());
					ZyppOperatorRole.setCreateTime(new Date());
					ZyppOperatorRole.setStatus(PublicStatusEnum.ACTIVE.name());
					ZyppOperatorRoleDao.insert(ZyppOperatorRole);
				} else {
					delMap.remove(roleId);
				}
			}
		}

		Iterator<Long> iterator = delMap.keySet().iterator();
		while (iterator.hasNext()) {
			long roleId = iterator.next();
			ZyppOperatorRoleDao.deleteByRoleIdAndOperatorId(roleId, ZyppOperator.getId());
		}
	}

	/**
	 * 修改操作員信息及其关联的角色.
	 * 
	 * @param ZyppOperator
	 *            .
	 * @param roleOperatorStr
	 *            .
	 */
	public void updateOperator(ZyppOperator ZyppOperator, String roleOperatorStr) {
		ZyppOperatorDao.update(ZyppOperator);
		// 更新角色信息
		this.saveOrUpdateOperatorRole(ZyppOperator, roleOperatorStr);
	}

}
