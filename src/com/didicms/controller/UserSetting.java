package com.didicms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.didicms.dao.AccountDao;
import com.didicms.dao.OpratorDao;
import com.didicms.entry.Account;
import com.didicms.entry.Oprator;
import com.didicms.util.PwdEncoding;

@Controller
@RequestMapping("/oprator/user")
public class UserSetting {
	@Autowired
	private OpratorDao opratorDao;
	@Autowired
	private AccountDao accountDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String view(){
		return URL.UserSetting;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String update(HttpSession session,HttpServletRequest request){
		String role=(String) session.getAttribute("role");
		if("oprator".equalsIgnoreCase(role) && opratorUpdate(request, session)){
			return "redirect:oprator/driver";
		}
		return URL.error;
	}
	private boolean opratorUpdate(HttpServletRequest request, HttpSession session) {
		Oprator oprator = opratorDao.getById(request.getParameter("id"));
		String userId=(String) session.getAttribute("user");
		if(!oprator.getId().equals(userId)) return false;
		String pwd=PwdEncoding.encoding(request.getParameter("password"));
		oprator.setPassword(pwd);
		if (opratorDao.update(oprator)) {
			return true;
		}
		return false;

	}

	private boolean accountUpdate(HttpServletRequest request, HttpSession session) {
		Account account = accountDao.getById(request.getParameter("id"));
		String userId=(String) session.getAttribute("user");
		if(!account.getId().equals(userId)) return false;
		String pwd=PwdEncoding.encoding(request.getParameter("password"));
		account.setPassword(pwd);
		if (accountDao.update(account)) {
			return true;
		}
		return false;
	}
	
	
	

}
