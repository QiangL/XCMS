package com.didicms.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.didicms.entry.Driver;

@Service
public interface DriverService extends DriverDao {
	public boolean insertReal(Driver driver);
	public List<Driver> getAll(int count);
	public boolean examAdd(String id);
	public boolean examDel(String id);
	public List<Driver> getAllNotExamAdd(int count);
	public List<Driver> getAllNotExamDel(int count);
	public int getNotExamAddNubmer();
	public int getNotExamDelNubmer();
	public int getAllDriverNumber();
	public boolean deleteReal(String id);
}
