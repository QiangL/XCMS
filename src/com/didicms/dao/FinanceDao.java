package com.didicms.dao;

import java.math.BigDecimal;
import java.util.List;

import com.didicms.entry.Finance;

public interface FinanceDao {
	public boolean insert(Finance finance);
	public List<Finance> getAllByCompanyId(int companyId,int count);
	public boolean remit(int financeId);
	public boolean confirm(int financeId);
	public List<Finance> getAll(int count);
	public Finance getById(int id);
	public int getFinancePage();
	public int getFinancePageByCompanyId(int companyId);
	
	public int getHistoryFinancePage();
	public int getHistoryFinancePageByCompanyId(int companyId);
	
	public List<Finance> getHistoryAll(int count);
	public List<Finance> getHistoryAllByCompanyId(int companyId,int count);
	
	public boolean motifyAmount(int financeId,BigDecimal amount);

	

}
