package com.didicms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.didicms.dao.DriverDao;
import com.didicms.entry.Driver;
import com.didicms.service.DriverService;

@Controller
@RequestMapping("/opratorDriver")
public class OpratorDriver {
	@Autowired
	private DriverDao driverDao;
	@Autowired
	private DriverService driverServive;
	
	@RequestMapping(method=RequestMethod.GET)
	public String view(){
		return URL.OpratorDriver;
	}
	
	@RequestMapping(value="/addDriver",method=RequestMethod.POST)
	public String addDriver(HttpServletRequest request,Driver driver){
		if(driverDao.insert(driver)){
			return URL.OpratorDriver;
		}
		return URL.error;
	}
	@RequestMapping(value="/updateDriver",method=RequestMethod.POST)
	public String updateDriver(Driver driver){
		if(driverDao.update(driver)){
			return URL.OpratorDriver;
		}
		return URL.error;
	}
	@RequestMapping(value="/deleteDriver",method=RequestMethod.POST)
	public String deleteDriver(String driverId){
		if(driverDao.delete(driverId)){
			return URL.OpratorDriver;
		}
		return URL.error;
	}
	@RequestMapping String examDriver(Driver Driver){
		if(driverServive.exam(Driver)){
			return URL.OpratorDriver;
		}
		return URL.error;
	}

}
