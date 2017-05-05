package com.didicms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.didicms.dao.CarDao;
import com.didicms.dao.CarService;
import com.didicms.entry.Car;

@Controller
@RequestMapping("/opratorCar")
public class OpratorCar {
	@Autowired
	private CarDao carDao;
	@Autowired
	private CarService carServive;

	@RequestMapping(method = RequestMethod.GET)
	public String view() {
		return URL.OpratorCar;
	}

	@RequestMapping
	String examCar(int id) {
		if (carServive.exam(id)) {
			return URL.OpratorCar;
		}
		return URL.error;
	}

}
