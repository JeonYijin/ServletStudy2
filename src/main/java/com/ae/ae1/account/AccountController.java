package com.ae.ae1.account;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountController {
	
	private AccountDAO accountDAO;
	
	public AccountController() {
		accountDAO = new AccountDAO();
	}
	
	public void start(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Account Controller 실행");
		
		String path = "";
		
		String uri = request.getRequestURI();
		int index = uri.lastIndexOf("/");
		path = uri.substring(index+1);
		
		if(path.equals("accountList.do")) {
			System.out.println("계좌 전체조회");
			ArrayList<AccountDTO> ar = accountDAO.getList();
			for(AccountDTO accountDTO : ar) {
				System.out.println(accountDTO.getAccount_num());
				System.out.println(accountDTO.getAccount_date());
				System.out.println(accountDTO.getAccount_balance());
				System.out.println("--------------");
			}
			 request.setAttribute("list", ar);
			 RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/account/accountList.jsp");
			 try {
				view.forward(request, response);
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(path.equals("accountInsert.do")) {
			System.out.println("계좌 개설");
		}else if(path.equals("accountSelect")){
			System.out.println("계좌 상세 조회");
		}else {
			System.out.println("그외 나머지");
		}
		
	}
}
