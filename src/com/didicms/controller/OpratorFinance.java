package com.didicms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.didicms.dao.FinanceDao;
import com.didicms.entry.Finance;

@Controller
@RequestMapping("/opratorFinance")
public class OpratorFinance {
	@Autowired
	private FinanceDao financeDao;

	@RequestMapping(method = RequestMethod.GET)
	public String view() {
		return URL.OpratorFinance;
	}

	@RequestMapping(value = "/finance", method = RequestMethod.POST)
	public String remit(Finance finance) {
		if (financeDao.insert(finance)) {
			return URL.OpratorFinance;
		}
		return URL.error;
	}

}
