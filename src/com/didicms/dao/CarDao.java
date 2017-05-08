package com.didicms.dao;

import java.util.List;

import com.didicms.entry.Car;

public interface CarDao {
	public Car getById(String id);

	public List<Car> getByCompanyId(int companyId,int count);

	public boolean insert(Car car);

	public boolean delete(String id);

	public boolean update(Car car);
	public int getNumber(int companyId);



}
