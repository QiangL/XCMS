package com.didicms.dao;

import java.util.List;

import com.didicms.entry.Driver;

public interface DriverDao {
	public Driver getById(String id);

	public List<Driver> getAllByCompanyId(int companyId);

	public boolean update(Driver driver);

	public boolean insert(Driver driver);

	public boolean delete(String id);


}
