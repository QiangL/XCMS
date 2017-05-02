package com.didicms.dao;

import java.util.List;

import com.didicms.entry.Finance;

public interface FinanceDao {
	public boolean insert(Finance finance);
	public List<Finance> getAllByCompanyId(int cmpanyId);
	public boolean update(Finance finance);
	public Finance getById(int id);
	public boolean confirm(int financeId);

}
