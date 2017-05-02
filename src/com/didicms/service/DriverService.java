package com.didicms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.didicms.dao.DriverDao;
import com.didicms.entry.Driver;

@Service
public class DriverService {
	@Autowired
	private DriverDao driverDao;
	
	public boolean update(Driver driver){
		if(driverDao.update(driver)) return true;
		return false;
	}
	public boolean exam(Driver driver){
		if(driverDao.exam(driver)) return true;
		return false;
	}

}
