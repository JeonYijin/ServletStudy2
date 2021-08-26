package com.ae.ae1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ae.ae1.account.AccountController;
import com.ae.ae1.bankbook.BankBookController;
import com.ae.ae1.member.MemberController;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberController memberController;
	private BankBookController bankbookController; 
	private AccountController accountController;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
        memberController = new MemberController();
        bankbookController = new BankBookController();
        accountController = new AccountController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig sc = getServletConfig(); // 내장객체 가지고 오는 메서드
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		context = getServletContext(); //session에서 안꺼내고 바로 꺼내기도 가능
		
		System.out.println("Front Controller 실행");
		String uri = request.getRequestURI();
		System.out.println(uri);
		//String [] uris =uri.split("/");
		
		int statIndex = request.getContextPath().length();
		int lastIndex =uri.lastIndexOf("/");
		
		String path = uri.substring(statIndex+1, lastIndex);
		
		//System.out.println(uris[2]);
		
		//String path = uris[2];
		System.out.println("path: "+ path);
		if(path.equals("member")) {
			try {
				memberController.start(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(path.equals("bankbook")) {
			bankbookController.start(request, response);
		}else if(path.equals("account")) {
			accountController.start(request, response);
		}else {
			System.out.println("없는 url");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
