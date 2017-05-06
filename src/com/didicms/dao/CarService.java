package com.didicms.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.didicms.entry.Car;

@Service
public interface CarService extends CarDao {

	public List<Car> getAll();
	public boolean exam(int id);
	public List<Car> getAllNotExam();
	public int getNotExamNubmer();
	public int getNumber();

}
