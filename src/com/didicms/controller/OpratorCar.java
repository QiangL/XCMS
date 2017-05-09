package com.didicms.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.didicms.dao.CarService;
import com.didicms.entry.Car;
import com.didicms.entry.Msg;

@Controller
@RequestMapping("/oprator")
public class OpratorCar {
	@Autowired
	private CarService carServive;

	@RequestMapping(value="/car",method = RequestMethod.GET)
	public String view(HttpSession session) {
		/*int notExamDriverAddPN=carServive.getNotExamAddNubmer();
		int notExamDriverDelPN=carServive.getNotExamDelNubmer();
		int driverPN=carServive.getAllCarNumber();
		session.setAttribute(SessionKey.OpratorNotExamAddCarPageNum, notExamDriverAddPN);
		session.setAttribute(SessionKey.OpratorNotExamDelCarPageNum, notExamDriverDelPN);
		session.setAttribute(SessionKey.OpratorCarPageNum, driverPN);*/
		return URL.OpratorCar;
	}
	
	
	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	public String addDriver(HttpServletRequest request, Car car) {
		if (carServive.insertReal(car)) {
			return "redirect:oprator/car";
		}
		return URL.error;
	}

	@RequestMapping(value = "/updateCar", method = RequestMethod.POST)
	public String updateDriver(Car car) {
		if (carServive.update(car)) {
			return "redirect:oprator/car";
		}
		return URL.error;
	}

	@RequestMapping(value = "/examAddCar", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
	String examAddDriver(String carId,int flag) {
		Msg msg=new Msg();
		msg.code=-1;
		if(flag!=-1 && carServive.examAdd(carId)){
			msg.code=1;
		}else if(carServive.deleteReal(carId)){
			msg.code=1;
		}
		return JSON.toJSONString(msg);
	}
	@RequestMapping(value = "/examDelCar", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
	String examDelDriver(String carId,int flag) {
		Msg msg=new Msg();
		msg.code=-1;
		if(flag!=-1 && carServive.examDel(carId)){
			msg.code=1;
		}else if(carServive.examAdd(carId)){
			msg.code=1;
		}
		return JSON.toJSONString(msg);
	}
	@RequestMapping(value = "/deleteCar", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
	String deleteDriver(String carId) {
		Msg msg=new Msg();
		if(carServive.deleteReal(carId)){
			msg.code=1;
		}else{
			msg.code=-1;
		}
		return JSON.toJSONString(msg);
	}
	@RequestMapping(value = "/showNotExamAddCar", method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	String showNotExamAddDriver(int count) {
		return JSON.toJSONString(carServive.getAllNotExamAdd(count));
	}
	@RequestMapping(value = "/showNotExamDelCar", method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	String showNotExamDelDriver(int count) {
		return JSON.toJSONString(carServive.getAllNotExamDel(count));
	}

	@RequestMapping(value = "/showCar", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String showDriver(int count) {
		List<Car> list = carServive.getAll(count);
		return JSON.toJSONString(list);
	}
	/* get PageNumber */
	@RequestMapping(value = "/notExamAddCarPageNum", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String OpratorNotExamAddCarPageNum(){
		return JSON.toJSONString(carServive.getNotExamAddNubmer());
	}
	@RequestMapping(value = "/notExamDelCarPageNum", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String OpratorNotExamDelCarPageNum(){
		return JSON.toJSONString(carServive.getNotExamDelNubmer());
	}
	@RequestMapping(value = "/carPageNum", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String OpratorCarPageNum(){
		return JSON.toJSONString(carServive.getAllCarNumber());
	}

}
