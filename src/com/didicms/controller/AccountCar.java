package com.didicms.controller;

import com.alibaba.fastjson.JSON;
import com.didicms.dao.CarDao;
import com.didicms.entry.Car;
import com.didicms.entry.Msg;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/account")
public class AccountCar {
	@Autowired
	private CarDao carDao;
	
	@RequestMapping(value="/car",method=RequestMethod.GET)
	public String view(){
		return URL.AccountCar;
	}
	

	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	public String addCar(HttpServletRequest request, Car car,HttpSession session) {
		car.setCompanyId((Integer)session.getAttribute("companyId"));
		if (carDao.insert(car)) {
			return "redirect:/account/car";
		}
		return URL.error;
	}

	@RequestMapping(value = "/updateCar", method = RequestMethod.POST)
	public String updateCar(Car car,HttpSession session) {
		car.setCompanyId((Integer)session.getAttribute("companyId"));
		if (carDao.update(car)) {
			return "redirect:/account/car";
		}
		return URL.error;
	}

	@RequestMapping(value = "/deleteCar", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String deleteCar(String carId) {
		Msg msg=new Msg();
		if(carDao.delete(carId)){
			msg.code=1;
		}else{
			msg.code=-1;
		}
		return JSON.toJSONString(msg);
	}
	
	@RequestMapping(value = "/showCar", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String showDriver(int count,HttpSession session) {
		Integer companyId=(Integer) session.getAttribute("companyId");
		List<Car> list = carDao.getByCompanyId(companyId, count);
		return JSON.toJSONString(list);
	}
	
	@RequestMapping(value = "/carPageNum", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String OpratorCarPageNum(HttpSession session){
		Integer companyId=(Integer) session.getAttribute("companyId");
		return JSON.toJSONString(carDao.getNumber(companyId));
	}
}
