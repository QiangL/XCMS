package com.didicms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.didicms.dao.AccountDao;
import com.didicms.dao.CarDao;
import com.didicms.dao.CompanyDao;
import com.didicms.dao.DriverDao;
import com.didicms.dao.OpratorDao;
import com.didicms.entry.Account;
import com.didicms.entry.Car;
import com.didicms.entry.Company;
import com.didicms.entry.Driver;
import com.didicms.entry.Oprator;
import com.didicms.util.PwdEncoding;

@Controller
public class Login {
	private static final String ACCOUNT = "account";
	private static final String OPRATOR = "oprator";

	@Autowired
	private OpratorDao opratorDao;
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private CarDao carDao;
	@Autowired
	private DriverDao driverDao;
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String view() {
		return "index";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String loginout(HttpSession session) {
		session.removeAttribute("user");
		session.removeAttribute("role");
		session.removeAttribute("oprator");
		session.removeAttribute("account");
		return "redirect:/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		if (ACCOUNT.equalsIgnoreCase(request.getParameter("role"))) {
			if(accountLogin(request,session)){
				return "redirect:account/driver";
			}
		} else if (OPRATOR.equalsIgnoreCase(request.getParameter("role"))) {
			if(opratorLogin(request,session)){
				return "redirect:oprator/driver";
			}
		}
		return URL.LogErr;
	}
	@RequestMapping(value = "/getDriverById", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getDriverById(String driverId){
		List<Driver> list=new ArrayList<>();
		Driver d=driverDao.getById(driverId);
		if(d!=null){
			list.add(d);
		}
		return JSON.toJSONString(list);
	}
	@RequestMapping(value = "/getCarById", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getCarById(String carId){
		List<Car> list=new ArrayList<>();
		Car c=carDao.getById(carId);
		if(c!=null){
			list.add(c);
		}
		return JSON.toJSONString(list);
	}
	

	private boolean opratorLogin(HttpServletRequest request, HttpSession session) {
		Oprator oprator = opratorDao.getById(request.getParameter("id"));
		if(oprator==null) return false;
		if (oprator.getPassword().equals(PwdEncoding.encoding(request.getParameter("password")))) {
			session.setAttribute("role", OPRATOR);
			session.setAttribute("user", oprator.getId());
			session.setAttribute("oprator", oprator);
			return true;
		}
		return false;

	}

	private boolean accountLogin(HttpServletRequest request, HttpSession session) {
		Account account = accountDao.getById(request.getParameter("id"));
		if(account==null) return false;
		if (account.getPassword().equals(PwdEncoding.encoding(request.getParameter("password")))) {
			session.setAttribute("role", ACCOUNT);
			session.setAttribute("user", account.getId());
			session.setAttribute("companyId", account.getCompanyId());
			session.setAttribute("account", account);
			return true;
		}
		return false;
	}

}
