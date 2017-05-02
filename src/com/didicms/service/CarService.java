package com.didicms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.didicms.dao.CarDao;
import com.didicms.entry.Car;

@Service
public class CarService {
	@Autowired
	private CarDao carDao;
	
	public boolean update(Car car){
		if(carDao.update(car)) return true;
		return false;
	}
	public boolean exam(Car car){
		if(carDao.exam(car)) return true;
		return false;
	}

}
