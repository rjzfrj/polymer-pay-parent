package com.zyzf.pay.reconciliation.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 根据对账单解析出来的实体vo，用户与平台的交易记录对账.
 *
 */
public class ReconciliationEntityVo {

	/** 对账批次号 **/
	private String accountCheckBatchNo;

	/** 账单日期 **/
	private Date billDate;

	/** 银行类型 WEIXIN ALIPAY **/
	private String bankType;

	/** 下单时间 **/
	private Date orderTime;

	/** 银行交易时间 **/
	private Date bankTradeTime;

	/** 银行订单号 **/
	private String bankOrderNo;

	/** 银行流水号 **/
	private String bankTrxNo;

	/** 银行交易状态 **/
	private String bankTradeStatus;

	/** 银行交易金额 **/
	private BigDecimal bankAmount;

	/** 银行退款金额 **/
	private BigDecimal bankRefundAmount;

	/** 银行手续费 **/
	private BigDecimal bankFee;

	public String getAccountCheckBatchNo() {
		return accountCheckBatchNo;
	}

	public void setAccountCheckBatchNo(String accountCheckBatchNo) {
		this.accountCheckBatchNo = accountCheckBatchNo;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getBankTradeTime() {
		return bankTradeTime;
	}

	public void setBankTradeTime(Date bankTradeTime) {
		this.bankTradeTime = bankTradeTime;
	}

	public String getBankOrderNo() {
		return bankOrderNo;
	}

	public void setBankOrderNo(String bankOrderNo) {
		this.bankOrderNo = bankOrderNo;
	}

	public String getBankTrxNo() {
		return bankTrxNo;
	}

	public void setBankTrxNo(String bankTrxNo) {
		this.bankTrxNo = bankTrxNo;
	}

	public String getBankTradeStatus() {
		return bankTradeStatus;
	}

	public void setBankTradeStatus(String bankTradeStatus) {
		this.bankTradeStatus = bankTradeStatus;
	}

	public BigDecimal getBankAmount() {
		return bankAmount;
	}

	public void setBankAmount(BigDecimal bankAmount) {
		this.bankAmount = bankAmount;
	}

	public BigDecimal getBankRefundAmount() {
		return bankRefundAmount;
	}

	public void setBankRefundAmount(BigDecimal bankRefundAmount) {
		this.bankRefundAmount = bankRefundAmount;
	}

	public BigDecimal getBankFee() {
		return bankFee;
	}

	public void setBankFee(BigDecimal bankFee) {
		this.bankFee = bankFee;
	}

}
