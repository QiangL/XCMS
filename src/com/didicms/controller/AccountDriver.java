package com.didicms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.didicms.dao.DriverDao;
import com.didicms.dao.DriverService;
import com.didicms.entry.Driver;

@Controller
public class AccountDriver {
	@Autowired
	private DriverDao driverDao;


	@RequestMapping(value = "/addDriver", method = RequestMethod.POST)
	public String addDriver(HttpServletRequest request, Driver driver) {
		if (driverDao.insert(driver)) {
			return URL.AccountDriver;
		}
		return URL.error;
	}

	@RequestMapping(value = "/updatedriver", method = RequestMethod.POST)
	public String updateDriver(Driver driver) {
		if (driverDao.update(driver)) {
			return URL.AccountDriver;
		}
		return URL.error;
	}

	@RequestMapping(value = "/deletedriver", method = RequestMethod.POST)
	public String deleteDriver(String driverId) {
		if (driverDao.delete(driverId)) {
			return URL.AccountDriver;
		}
		return URL.error;
	}

}
