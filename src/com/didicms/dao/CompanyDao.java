package com.didicms.dao;

import java.util.List;

import com.didicms.entry.Company;

public interface CompanyDao {
	public Company getById(int id);

	public List<Company> getAll(int count);

	public boolean update(Company company);

	public boolean delete(int id);

	public boolean insert(Company company);
	public int getAllNumber();

}
