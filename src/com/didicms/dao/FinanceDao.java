package com.didicms.dao;

import java.util.List;

import com.didicms.entry.Finance;

public interface FinanceDao {
	public boolean insert(Finance finance);
	public List<Finance> getAllByCompanyId(int cmpanyId,int count);
	public boolean remit(int financeId);
	public boolean confirm(int financeId);
	public List<Finance> getAll(int count);
	public Finance getById(int id);
	public int getFinancePage();

	

}
