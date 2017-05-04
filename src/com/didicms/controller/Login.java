package com.didicms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class Login {
	private static final String ACCOUNT = "ACCOUNT";
	private static final String OPRATOR = "OPRATOR";

	@Autowired
	private OpratorDao opratorDao;
	@Autowired
	private AccountDao accountDao;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String view() {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		if (ACCOUNT.equalsIgnoreCase(request.getParameter("role"))) {
			session.setAttribute("role", ACCOUNT);
			// if(accountLogin(request,session)){
			return "account";
			// }
		} else if (OPRATOR.equalsIgnoreCase(request.getParameter("role"))) {
			session.setAttribute("role", OPRATOR);
			// if(opratorLogin(request,session)){
			return "oprator";
			// }
		}
		return URL.error;
	}

	private boolean opratorLogin(HttpServletRequest request, HttpSession session) {
		Oprator oprator = opratorDao.getById(request.getParameter("id"));
		if (oprator.getPassword().equals(PwdEncoding.encoding(request.getParameter("password")))) {
			session.setAttribute("user", oprator.getId());
			return true;
		}
		return false;

	}

	private boolean accountLogin(HttpServletRequest request, HttpSession session) {
		Account account = accountDao.getById(request.getParameter("id"));
		if (account.getPassword().equals(PwdEncoding.encoding(request.getParameter("password")))) {
			session.setAttribute("user", account.getId());
			return true;
		}
		return false;
	}

}
