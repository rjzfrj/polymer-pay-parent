package com.zyzf.pay.account.entity;

import java.io.Serializable;

import com.zyzf.pay.common.core.entity.BaseEntity;
import com.zyzf.pay.common.core.enums.PublicEnum;

/**
 * 结算附件表
 * ：
 * 
 */
public class RpSettRecordAnnex extends BaseEntity implements Serializable {

	/** 是否删除 **/
	private String isDelete = PublicEnum.NO.name();

	/** 附件名称 **/
	private String annexName;

	/** 附件地址 **/
	private String annexAddress;

	/** 结算id **/
	private String settlementId;

	private static final long serialVersionUID = 1L;

	public RpSettRecordAnnex() {
		super();
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete == null ? null : isDelete.trim();
	}

	public String getAnnexName() {
		return annexName;
	}

	public void setAnnexName(String annexName) {
		this.annexName = annexName == null ? null : annexName.trim();
	}

	public String getAnnexAddress() {
		return annexAddress;
	}

	public void setAnnexAddress(String annexAddress) {
		this.annexAddress = annexAddress == null ? null : annexAddress.trim();
	}

	public String getSettlementId() {
		return settlementId;
	}

	public void setSettlementId(String settlementId) {
		this.settlementId = settlementId;
	}
}