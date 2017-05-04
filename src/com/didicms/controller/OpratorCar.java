package com.didicms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.didicms.dao.CarDao;
import com.didicms.entry.Car;
import com.didicms.service.CarService;

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

	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	public String addCar(HttpServletRequest request, Car car) {
		if (carDao.insert(car)) {
			return URL.OpratorCar;
		}
		return URL.error;
	}

	@RequestMapping(value = "/updateCar", method = RequestMethod.POST)
	public String updateCar(Car car) {
		if (carDao.update(car)) {
			return URL.OpratorCar;
		}
		return URL.error;
	}

	@RequestMapping(value = "/deleteCar", method = RequestMethod.POST)
	public String deleteCar(int carId) {
		if (carDao.delete(carId)) {
			return URL.OpratorCar;
		}
		return URL.error;
	}

	@RequestMapping
	String examCar(Car car) {
		if (carServive.exam(car)) {
			return URL.OpratorCar;
		}
		return URL.error;
	}

}
