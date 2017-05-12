package com.didicms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.didicms.dao.FinanceDao;
import com.didicms.dao.OrderDao;
import com.didicms.entry.Finance;
import com.didicms.entry.Msg;

@Controller
@RequestMapping("/oprator")
public class OpratorFinance {
	@Autowired
	private FinanceDao financeDao;
	@Autowired
	private OrderDao orderDao;

	@RequestMapping(value="/finance",method = RequestMethod.GET)
	public String view() {
		return URL.OpratorFinance;
	}

	@RequestMapping(value = "/rejectFinance", method = RequestMethod.POST)
	@ResponseBody
	public String rejectFinance(int financeId) {
		Msg msg=new Msg();
		if(financeDao.reject(financeId)){
			msg.code=1;
		}else{
			msg.code=-1;
		}
		return JSON.toJSONString(msg);
	}
	
	@RequestMapping(value = "/remitFinance", method = RequestMethod.POST)
	@ResponseBody
	public String remitFinance(int financeId) {
		Msg msg=new Msg();
		if(financeDao.remit(financeId)){
			msg.code=1;
		}else{
			msg.code=-1;
		}
		return JSON.toJSONString(msg);
	}
	
	
	@RequestMapping(value = "/showOrder", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String showOrder(int companyId){
		return JSON.toJSONString(orderDao.getAll(companyId));
	}
	
	
	@RequestMapping(value = "/showFinance", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String showFinance(int count){
		return JSON.toJSONString(financeDao.getAll(count));
	}
	@RequestMapping(value = "/financePageNumber", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String financePageNumber(){
		return JSON.toJSONString(financeDao.getFinancePage());
	}
	
	
	@RequestMapping(value = "/showHistoryFinance", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String showHistoryFinance(int count){
		return JSON.toJSONString(financeDao.getHistoryAll(count));
	}
	@RequestMapping(value = "/historyFinancePageNumber", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String historyFinancePageNumber(){
		return JSON.toJSONString(financeDao.getHistoryFinancePage());
	}
	

}
