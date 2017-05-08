package com.didicms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.didicms.dao.DriverDao;
import com.didicms.entry.Driver;
import com.didicms.entry.Msg;

@Controller
@RequestMapping(value = "/account")
public class AccountDriver {
	@Autowired
	private DriverDao driverDao;
	
	@RequestMapping(value="driver",method=RequestMethod.GET)
	public String viewDriver(HttpSession session){
		return URL.AccountDriver;
	}
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
	@ResponseBody
	public String deleteDriver(String driverId) {
		Msg msg=new Msg();
		if (driverDao.delete(driverId)) {
			msg.code=1;
		}else{
			msg.code=-1;
		}
		return JSON.toJSONString(msg);
	}

}
