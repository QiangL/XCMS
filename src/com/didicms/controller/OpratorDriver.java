package com.didicms.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.didicms.dao.DriverService;
import com.didicms.entry.Driver;
import com.didicms.entry.DriverGrade;
import com.didicms.entry.Exam;
import com.didicms.entry.Msg;

@Controller
@RequestMapping("/oprator")
public class OpratorDriver {
	@Autowired
	private DriverService driverServive;

	@RequestMapping(value="/opratorDriver",method = RequestMethod.GET)
	public String view(HttpSession session) {
		int notExamDriverPN=driverServive.getNotExamNubmer();
		int driverPN=driverServive.getNumber();
		session.setAttribute(SessionKey.OpratorNotExamDriverPageNum, notExamDriverPN);
		session.setAttribute(SessionKey.OpratorDriverPageNum, driverPN);
		return URL.OpratorDriver;
	}

	@RequestMapping(value = "/examDriver", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
	String examDriver(String driverId) {
		Msg msg=new Msg();
		if(driverServive.exam(driverId)){
			msg.code=1;
			msg.msg="";
		}else{
			msg.code=-1;
			msg.msg="";
		}
		return JSON.toJSONString(msg);
	}
	@RequestMapping(value = "/showNotExamDriver", method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	String showNotExamDriver(int count) {
		return JSON.toJSONString(driverServive.getAllNotExam(count));
	}

	@RequestMapping(value = "/showDriver", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String showDriver(int count) {
		List<Driver> list = driverServive.getAll(count);
		return JSON.toJSONString(list);
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
