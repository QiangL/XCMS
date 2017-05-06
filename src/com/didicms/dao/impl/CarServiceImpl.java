package com.didicms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.didicms.dao.CarService;
import com.didicms.entry.Car;

@Component
public class CarServiceImpl implements CarService {

	@Override
	public Car getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> getByCompanyId(int companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Car car) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Car car) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Car> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exam(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Car> getAllNotExam() {
		// TODO Auto-generated method stub
		return null;
	}

}
