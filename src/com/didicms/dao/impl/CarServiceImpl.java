package com.didicms.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.didicms.dao.CarService;
import com.didicms.entry.Car;

@Component
public class CarServiceImpl implements CarService {
	@Autowired
	JdbcTemplate jdbc;

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

	@Override
	public int getNotExamNubmer() {
		String sql="select count(*) from car  where car_exam=0";
		return jdbc.queryForObject(sql, Integer.class);
	}

	@Override
	public int getNumber() {
		String sql="select count(*) from car";
		return jdbc.queryForObject(sql, Integer.class);
	}

}
