package com.didicms.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.didicms.entry.Driver;
import com.didicms.entry.DriverGrade;
import com.didicms.entry.Exam;
import com.didicms.service.DriverService;

@Controller
@RequestMapping("/opratorDriver")
public class OpratorDriver {
	@Autowired
	private DriverService driverServive;

	@RequestMapping(method = RequestMethod.GET)
	public String view() {
		return URL.OpratorDriver;
	}

	@RequestMapping(value = "/addDriver", method = RequestMethod.POST)
	public String addDriver(HttpServletRequest request, Driver driver) {
		if (driverServive.insert(driver)) {
			return URL.OpratorDriver;
		}
		return URL.error;
	}

	@RequestMapping(value = "/updateDriver", method = RequestMethod.POST)
	public String updateDriver(Driver driver) {
		if (driverServive.update(driver)) {
			return URL.OpratorDriver;
		}
		return URL.error;
	}

	@RequestMapping(value = "/deleteDriver", method = RequestMethod.POST)
	public String deleteDriver(String driverId) {
		if (driverServive.delete(driverId)) {
			return URL.OpratorDriver;
		}
		return URL.error;
	}

	@RequestMapping(value = "/examDriver", method = RequestMethod.POST)
	String examDriver(String driverId) {
		if (driverServive.exam(driverServive.getById(driverId))) {
			return URL.OpratorDriver;
		}
		return URL.error;
	}

	@RequestMapping(value = "/showDriver", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String showDriver() {
		List<Driver> list = driverServive.getAll();
		String s = JSON.toJSONString(list);
		System.out.println(s);
		return s;
	}
	
	@RequestMapping(value = "/showDriver1", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String test() {
		Driver d = new Driver();
		d.setId("this'a test");
		d.setName("空联顺");
		d.setAge(25);
		d.setGrade(DriverGrade.A);
		d.setBadReview(2.2);
		d.setBindCarId(1001);
		d.setGender("男");
		d.setIsExam(Exam.Examed);
		d.setNumber("12121212");
		return JSON.toJSONString(d);
	}
	@RequestMapping(value = "/showDriver2", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String test2() {
		List<Driver> list=new LinkedList<>();
		Driver d = new Driver();
		d.setId("this'a test");
		d.setName("空联顺");
		d.setAge(25);
		d.setGrade(DriverGrade.A);
		d.setBadReview(2.2);
		d.setBindCarId(1001);
		d.setGender("男");
		d.setIsExam(Exam.Examed);
		d.setNumber("12121212");
		list.add(d);
		d=new Driver();
		list.add(d);
		return JSON.toJSONString(list);
	}

}
