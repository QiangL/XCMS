package com.didicms.dao;

import java.util.List;

import com.didicms.entry.Car;

public interface CarDao {
	public Car getById(int id);

	public List<Car> getByCompanyId(int companyId);

	public boolean insert(Car car);

	public boolean delete(int id);

	public boolean update(Car car);

	public boolean exam(Car car);

}
