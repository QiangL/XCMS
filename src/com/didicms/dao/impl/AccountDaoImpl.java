package com.didicms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.didicms.dao.AccountDao;
import com.didicms.entry.Account;
@Component
public class AccountDaoImpl implements AccountDao{

	@Override
	public Account getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAllByCompanyId(int companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

}
