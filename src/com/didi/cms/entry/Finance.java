package com.didi.cms.entry;

import java.math.BigDecimal;
import java.util.Date;

public class Finance {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCompany() {
		return company;
	}
	public void setCompany(int company) {
		this.company = company;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public FinanceStatus getStatus() {
		return status;
	}
	public void setStatus(FinanceStatus status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOpratorId() {
		return opratorId;
	}
	public void setOpratorId(String opratorId) {
		this.opratorId = opratorId;
	}
	private int id;
	private int company;
	private BigDecimal amount;
	private FinanceStatus status;
	private Date date;
	private String opratorId;
}
