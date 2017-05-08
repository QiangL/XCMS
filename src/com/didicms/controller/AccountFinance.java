package com.didicms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.didicms.dao.FinanceDao;
import com.didicms.entry.Finance;

@Controller
@RequestMapping("/accountFinance")
public class AccountFinance {
	@Autowired
	private FinanceDao financeDao;

	@RequestMapping(method = RequestMethod.GET)
	public String view() {
		return URL.AccountFinance;
	}


	@RequestMapping(value = "/remitFinance", method = RequestMethod.POST)
	public String confirmFinance(int financeId) {
		if (financeDao.remit(financeId)) {
			return URL.AccountFinance;
		}
		return URL.error;
	}

}
