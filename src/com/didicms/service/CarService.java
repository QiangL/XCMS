package com.didicms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.didicms.dao.CarDao;
import com.didicms.entry.Car;

@Service
public interface CarService extends CarDao {

	public List<Car> getAll();

}
