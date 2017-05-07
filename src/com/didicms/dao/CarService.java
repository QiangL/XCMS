package com.didicms.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.didicms.entry.Car;
import com.didicms.entry.Driver;

@Service
public interface CarService extends CarDao {
	public boolean insertReal(Car car);
	public List<Car> getAll(int count);
	public boolean examAdd(String id);
	public boolean examDel(String id);
	public List<Car> getAllNotExamAdd(int count);
	public List<Car> getAllNotExamDel(int count);
	public int getNotExamAddNubmer();
	public int getNotExamDelNubmer();
	public int getAllCarNumber();
	public boolean deleteReal(String id);
}
