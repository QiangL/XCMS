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

	@RequestMapping(value="/driver",method = RequestMethod.GET)
	public String view(HttpSession session) {
		/*int notExamDriverAddPN=driverServive.getNotExamAddNubmer();
		int notExamDriverDelPN=driverServive.getNotExamDelNubmer();
		int driverPN=driverServive.getAllDriverNumber();
		session.setAttribute(SessionKey.OpratorNotExamAddDriverPageNum, notExamDriverAddPN);
		session.setAttribute(SessionKey.OpratorNotExamDelDriverPageNum, notExamDriverDelPN);
		session.setAttribute(SessionKey.OpratorDriverPageNum, driverPN);*/
		return URL.OpratorDriver;
	}
	
	@RequestMapping(value = "/addDriver", method = RequestMethod.POST)
	public String addDriver(HttpServletRequest request, Driver driver) {
		if(driver.getGender().equals("male")){
			driver.setGender("男");
		}else{
			driver.setGender("女");
		}
		
		if(driver.getBindCarId().equals("")){
			driver.setBindCarId(null);
		}
		if (driverServive.insertReal(driver)) {
			return "redirect:/oprator/driver";
		}
		return URL.error;
	}

	@RequestMapping(value = "/updateDriver", method = RequestMethod.POST)
	public String updateDriver(Driver driver) {
		if(driver.getGender().equals("male")){
			driver.setGender("男");
		}else{
			driver.setGender("女");
		}
		
		if(driver.getBindCarId().equals("")){
			driver.setBindCarId(null);
		}
		
		if (driverServive.update(driver)) {
			return "redirect:/oprator/driver";
		}
		return URL.error;
	}

	@RequestMapping(value = "/examAddDriver", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
	String examAddDriver(String driverId) {
		Msg msg=new Msg();
		if(driverServive.examAdd(driverId)){
			msg.code=1;
		}else{
			msg.code=-1;
		}
		return JSON.toJSONString(msg);
	}
	@RequestMapping(value = "/examDelDriver", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
	String examDelDriver(String driverId) {
		Msg msg=new Msg();
		if(driverServive.examDel(driverId)){
			msg.code=1;
		}else{
			msg.code=-1;
		}
		return JSON.toJSONString(msg);
	}
	@RequestMapping(value = "/deleteDriver", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
	String deleteDriver(String driverId) {
		Msg msg=new Msg();
		if(driverServive.deleteReal(driverId)){
			msg.code=1;
		}else{
			msg.code=-1;
		}
		return JSON.toJSONString(msg);
	}
	@RequestMapping(value = "/showNotExamAddDriver", method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	String showNotExamAddDriver(int count) {
		return JSON.toJSONString(driverServive.getAllNotExamAdd(count));
	}
	@RequestMapping(value = "/showNotExamDelDriver", method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	String showNotExamDelDriver(int count) {
		return JSON.toJSONString(driverServive.getAllNotExamDel(count));
	}

	@RequestMapping(value = "/showDriver", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String showDriver(int count) {
		List<Driver> list = driverServive.getAll(count);
		return JSON.toJSONString(list);
	}
	
	/* get PageNumber */
	@RequestMapping(value = "/notExamAddDriverPageNum", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String OpratorNotExamAddDriverPageNum(){
		return JSON.toJSONString(driverServive.getNotExamAddNubmer());
	}
	@RequestMapping(value = "/notExamDelDriverPageNum", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String OpratorNotExamDelDriverPageNum(){
		return JSON.toJSONString(driverServive.getNotExamDelNubmer());
	}
	@RequestMapping(value = "/driverPageNum", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String OpratorDriverPageNum(){
		return JSON.toJSONString(driverServive.getAllDriverNumber());
	}
}
