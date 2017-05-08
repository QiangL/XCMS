package com.didicms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.didicms.dao.AccountDao;
import com.didicms.entry.Account;
import com.didicms.entry.Company;
import com.didicms.entry.Msg;

@Controller
@RequestMapping("/oprator")
public class OpratorAccount {
	@Autowired
	AccountDao accountDao;
	
	@RequestMapping(value="/account",method = RequestMethod.GET)
	public String view() {
		return URL.OpratorAccount;
	}

	@RequestMapping(value = "/updateAccount", method = RequestMethod.POST)
	public String updateCompany(Account account) {
		if (accountDao.update(account)) {
			return "redirect:/oprator/account";
		}
		return URL.error;
	}
	@RequestMapping(value = "/addAccount", method = RequestMethod.POST)
	public String addCompany(Account account) {
		if (accountDao.insert(account)) {
			return "redirect:/oprator/account";
		}
		return URL.error;
	}
	@RequestMapping(value = "/deleteAccount", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String deleteCompany(String accountId) {
		Msg msg=new Msg();
		if(accountDao.delete(accountId)){
			msg.code=1;
		}else{
			msg.code=-1;
		}
		return JSON.toJSONString(msg);
	}
	
	
	@RequestMapping(value = "/showAccount", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String showCompany(int count) {
		List<Account> list = accountDao.getAll(count);
		return JSON.toJSONString(list);
	}
	@RequestMapping(value = "/accountPageNum", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String OpratorCompanyPageNum(){
		return JSON.toJSONString(accountDao.getNumber());
	}


}
