package com.didicms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.didicms.dao.CompanyDao;
import com.didicms.entry.Company;

@Controller
@RequestMapping("/opratorCompany")
public class OpratorCompany {
	@Autowired
	private CompanyDao companyDao;

	@RequestMapping(method = RequestMethod.GET)
	public String view() {
		return URL.OpratorCompany;
	}

	@RequestMapping(value = "/updateCompany", method = RequestMethod.POST)
	public String updateCompany(Company company) {
		if (companyDao.update(company)) {
			return URL.OpratorCompany;
		}
		return URL.error;
	}

}
