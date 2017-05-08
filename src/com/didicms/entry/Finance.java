package com.didicms.entry;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Finance {
	public Finance() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompany() {
		return companyId;
	}

	public void setCompany(int companyId) {
		this.companyId = companyId;
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
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyPublicAccount() {
		return companyPublicAccount;
	}

	public void setCompanyPublicAccount(String companyPublicAccount) {
		this.companyPublicAccount = companyPublicAccount;
	}

	private int id;
	private int companyId;
	private BigDecimal amount;
	private FinanceStatus status;
	private Date date;
	private String opratorId;
	private String companyName;
	private String companyPublicAccount;
}
