package com.didicms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.didicms.entry.Driver;

@Service
public interface DriverService extends DriverDao {
	public List<Driver> getAll(int count);
	public boolean exam(String id);
	public List<Driver> getAllNotExam(int count);
}
