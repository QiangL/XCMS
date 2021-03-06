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
import com.didicms.dao.CarDao;
import com.didicms.dao.DriverDao;
import com.didicms.entry.Driver;
import com.didicms.entry.Msg;

@Controller
@RequestMapping(value = "/account")
public class AccountDriver {
	@Autowired
	private DriverDao driverDao;
	@Autowired
	private CarDao carDao;
	
	@RequestMapping(value="/driver",method=RequestMethod.GET)
	public String viewDriver(HttpSession session){
		return URL.AccountDriver;
	}
	@RequestMapping(value = "/addDriver", method = RequestMethod.POST)
	public String addDriver(HttpServletRequest request, Driver driver,HttpSession session) {
		driver.setBindCarId(carDao.getCarIdByCarNumber(driver.getCarNumber()));
		if(driver.getGender().equals("male")){
			driver.setGender("男");
		}else{
			driver.setGender("女");
		}
		driver.setCompanyId((Integer)session.getAttribute("companyId"));
		/*if(driver.getBindCarId().equals("")){
			driver.setBindCarId(null);
		}*/
		if (driverDao.insert(driver)) {
			return "redirect:/account/driver";
		}
		return URL.error;
	}

	@RequestMapping(value = "/updateDriver", method = RequestMethod.POST)
	public String updateDriver(Driver driver,HttpSession session) {
		driver.setBindCarId(carDao.getCarIdByCarNumber(driver.getCarNumber()));
		if(driver.getGender().equals("male")){
			driver.setGender("男");
		}else{
			driver.setGender("女");
		}
		driver.setCompanyId((Integer)session.getAttribute("companyId"));
		/*if(driver.getBindCarId().equals("")){
			driver.setBindCarId(null);
		}*/
		if (driverDao.update(driver)) {
			return "redirect:/account/driver";
		}
		return URL.error;
	}

	@RequestMapping(value = "/deleteDriver", method = RequestMethod.POST)
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
	@RequestMapping(value = "/showDriver", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String showDriver(int count,HttpSession session) {
		Integer companyId=(Integer) session.getAttribute("companyId");
		List<Driver> list = driverDao.getAllByCompanyId(companyId,count);
		return JSON.toJSONString(list);
	}
	
	@RequestMapping(value = "/driverPageNum", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String OpratorDriverPageNum(HttpSession session){
		Integer companyId=(Integer) session.getAttribute("companyId");
		return JSON.toJSONString(driverDao.getNumber(companyId));
	}

}
