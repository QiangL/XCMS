package com.didicms.controller;

import com.didicms.dao.CarDao;
import com.didicms.entry.Car;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/accountCar")
public class AccountCar {
	@Autowired
	private CarDao carDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String view(){
		return URL.AccountCar;
	}
	@RequestMapping(value="/addCar",method=RequestMethod.POST)
	public String addCar(HttpServletRequest request,Car car){
		if(carDao.insert(car)){
			return URL.AccountCar;
		}
		return URL.error;
	}
	@RequestMapping(value="/updateCar",method=RequestMethod.POST)
	public String updateCar(Car car){
		if(carDao.update(car)){
			return URL.AccountCar;
		}
		return URL.error;
	}
	@RequestMapping(value="/deleteCar",method=RequestMethod.POST)
	public String deleteCar(int carId){
		if(carDao.delete(carId)){
			return URL.AccountCar;
		}
		return URL.error;
	}
}
