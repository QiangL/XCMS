package com.didicms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.didicms.dao.CompanyDao;
import com.didicms.entry.Company;
import com.didicms.entry.Driver;
import com.didicms.entry.Msg;

@Controller
@RequestMapping("/oprator")
public class OpratorCompany {
	@Autowired
	private CompanyDao companyDao;

	@RequestMapping(value="/company",method = RequestMethod.GET)
	public String view() {
		return URL.OpratorCompany;
	}

	@RequestMapping(value = "/updateCompany", method = RequestMethod.POST)
	public String updateCompany(Company company) {
		if (companyDao.update(company)) {
			return "redirect:/oprator/company";
		}
		return URL.error;
	}
	@RequestMapping(value = "/addCompany", method = RequestMethod.POST)
	public String addCompany(Company company) {
		if (companyDao.insert(company)) {
			return "redirect:/oprator/company";
		}
		return URL.error;
	}
	@RequestMapping(value = "/deleteCompany", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String deleteCompany(int companyId) {
		Msg msg=new Msg();
		if(companyDao.delete(companyId)){
			msg.code=1;
		}else{
			msg.code=-1;
		}
		return JSON.toJSONString(msg);
	}
	
	
	@RequestMapping(value = "/showCompany", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String showCompany(int count) {
		List<Company> list = companyDao.getAll(count);
		return JSON.toJSONString(list);
	}
	@RequestMapping(value = "/companyPageNum", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String OpratorCompanyPageNum(){
		return JSON.toJSONString(companyDao.getAllNumber());
	}

}
