package com.didicms.dao;

import java.util.List;

import com.didicms.entry.Account;

public interface AccountDao {
	public Account getById(String id);

	public List<Account> getAllByCompanyId(int companyId,int count);

	public boolean insert(Account account);

	public boolean delete(String id);

	public boolean update(Account account);
	
	public int getNumber();
	
	public List<Account> getAll(int count);

}
