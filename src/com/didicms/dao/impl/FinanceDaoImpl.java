package com.didicms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.didicms.dao.FinanceDao;
import com.didicms.entry.Finance;

@Component
public class FinanceDaoImpl implements FinanceDao {

	@Override
	public boolean insert(Finance finance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Finance> getAllByCompanyId(int cmpanyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Finance finance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Finance getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean confirm(int financeId) {
		// TODO Auto-generated method stub
		return false;
	}

}
