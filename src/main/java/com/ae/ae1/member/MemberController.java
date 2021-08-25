package com.ae.ae1.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController {
	
	private MemberDAO memberDAO;
	private MemberService memberService;
	
	public MemberController() {
		memberDAO = new MemberDAO();
		memberService = new MemberService();
	}
	
	
	public void start(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberController 실행");
		String path = "";
		String uri = request.getRequestURI();
		String [] uris = uri.split("/");
		
		//System.out.println(uris[3]);
		
		path = uris[3];
		
		if(path.equals("memberLogin.do")) {
			System.out.println("로그인 진행");
			String value = request.getParameter("id");
			String value2= request.getParameter("pw");
			System.out.println(value);
			System.out.println(value2);

			
		}else if(path.equals("memberJoin.do")) {
			System.out.println("회원가입 진행");
			
			String method = request.getMethod();
			System.out.println("method: " + method);
			
			if(method.equals("POST")) {
				int result = memberService.memberJoin(request, response);
				if(result>0) {
					response.sendRedirect("../index.jsp"); //root '/' 만 쳐도 됨
					
				}else {
					response.sendRedirect("./"); // 가입실패하면 다시 회원가입 페이지로
				}
			}else {
				RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/member/memberJoin.jsp");
				
				view.forward(request, response);
				
			}
			
			
			
			
			
			
		}else if(path.equals("memberPage.do")) {
			System.out.println("mypage 진행");
		}else {
			System.out.println("그 외 나머지");
		}
		
	}
	
}
