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
public class DriverController {
	@Autowired
	private DriverDao driverDao;


	

}
