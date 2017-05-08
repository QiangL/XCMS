package com.didicms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.didicms.dao.FinanceDao;
import com.didicms.entry.Finance;
import com.didicms.entry.Msg;

@Controller
@RequestMapping("/account")
public class AccountFinance {
	@Autowired
	private FinanceDao financeDao;

	@RequestMapping(value="finance",method = RequestMethod.GET)
	public String view() {
		return URL.AccountFinance;
	}


	@RequestMapping(value = "/remitFinance", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String confirmFinance(int financeId) {
		Msg msg=new Msg();
		if(financeDao.remit(financeId)){
			msg.code=1;
		}else{
			msg.code=-1;
		}
		return JSON.toJSONString(msg);
	}
	@RequestMapping(value = "/showFinance", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String showFinance(int count,HttpSession session) {
		Integer companyId=(Integer) session.getAttribute("companyId");
		return JSON.toJSONString(financeDao.getAllByCompanyId(companyId, count));
	}
	@RequestMapping(value = "/financePageNumber", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String financePageNumber(HttpSession session) {
		Integer companyId=(Integer) session.getAttribute("companyId");
		return JSON.toJSONString(financeDao.getFinancePageByCcompanyId(companyId));
	}

}
