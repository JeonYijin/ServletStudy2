package com.ae.ae1.member;

import javax.servlet.http.HttpServletRequest;

public class MemberController {
	
	public void start(HttpServletRequest request) {
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
		}else if(path.equals("memberPage.do")) {
			System.out.println("mypage 진행");
		}else {
			System.out.println("그 외 나머지");
		}
		
	}
	
}
