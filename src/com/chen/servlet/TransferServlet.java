package com.chen.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chen.pojo.Account;
import com.chen.service.AccountService;
import com.chen.service.impl.AccountServiceImpl;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet{
	private AccountService accService = new AccountServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		req.setCharacterEncoding("UTF-8");
		Account accOut = new Account();
		accOut.setAccNo(req.getParameter("accOutAccNo"));
		accOut.setPassword(Integer.parseInt(req.getParameter("accOutPassword")));
		accOut.setBalance(Double.parseDouble(req.getParameter("accOutBalance")));
		Account accIn = new Account();
		accIn.setAccNo(req.getParameter("accInAccNo"));
		accIn.setName(req.getParameter("accInName"));
		int index = accService.transfer(accIn, accOut);
		if(index==AccountService.SUCCESS){
			resp.sendRedirect("/bank-exer/show");
		}else{
			HttpSession session = req.getSession();
			session.setAttribute("code", index);
			resp.sendRedirect("/bank-exer/error/error.jsp");
		}
		
	}

}
