package com.zyzf.polymer.pay.permission.entity;

import com.zyzf.polymer.pay.common.core.entity.BaseEntity;

/**
 * 菜单实体
 *
 * ：
 * 
 * 
 */
public class PmsMenu extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 菜单名称 **/
	private String name;

	/** 菜单地址 **/
	private String url;

	/** 菜单编号（用于显示时排序） **/
	private String num;

	/** 是否为叶子节点 **/
	private String isLeaf;

	/** 菜单层级 **/
	private Long lvl;

	/** 父节点:一级菜单为0 **/
	private PmsMenu parent;

	/** 目标名称（用于DWZUI的NAVTABID） **/
	private String targetName;

	public PmsMenu() {
		super();
	}

	/** 菜单名称 **/
	public String getName() {
		return name;
	}

	/** 菜单名称 **/
	public void setName(String name) {
		this.name = name;
	}

	/** 菜单地址 **/
	public String getUrl() {
		return url;
	}

	/** 菜单地址 **/
	public void setUrl(String url) {
		this.url = url;
	}

	/** 菜单编号（用于显示时排序） **/
	public String getNum() {
		return num;
	}

	/** 菜单编号（用于显示时排序） **/
	public void setNum(String num) {
		this.num = num;
	}

	/** 是否为叶子节点 **/
	public String getIsLeaf() {
		return isLeaf;
	}

	/** 是否为叶子节点 **/
	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	/** 菜单层级 **/
	public Long getLvl() {
		return lvl;
	}

	/** 菜单层级 **/
	public void setLvl(Long lvl) {
		this.lvl = lvl;
	}

	/** 父节点:一级菜单为0 **/
	public PmsMenu getParent() {
		return parent;
	}

	/** 父节点:一级菜单为0 **/
	public void setParent(PmsMenu parent) {
		this.parent = parent;
	}

	/** 目标名称（用于DWZUI的NAVTABID） **/
	public String getTargetName() {
		return targetName;
	}

	/** 目标名称（用于DWZUI的NAVTABID） **/
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

}
