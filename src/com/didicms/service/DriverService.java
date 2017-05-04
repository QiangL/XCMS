package com.didicms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.didicms.dao.DriverDao;
import com.didicms.entry.Driver;

@Service
public interface DriverService extends DriverDao {
	public List<Driver> getAll();
}
