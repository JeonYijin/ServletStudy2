package com.ae.ae1.bankbook;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BankBookController {
	
	private BankbookDAO bankbookDAO;
	
	public BankBookController() {
		bankbookDAO = new BankbookDAO();
	}
	public void start(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BankBook Controller 실행");
		
		String path = "";
		
		String uri = request.getRequestURI();
		int index = uri.lastIndexOf("/");
		path = uri.substring(index+1);
		//String [] uris = uri.split("/");
		
		//System.out.println(uris[3]);
		
		//path = uris[3];
		
		if(path.equals("bankbookList.do")) {
			System.out.println("상품조회");
			ArrayList<BankbookDTO> ar = bankbookDAO.getList();
			//for(초기식;조건식;증감식)
			//for(모은 타입명 변수명:컬렉션 참조변수명)
			for(BankbookDTO bankbookDTO :ar) {
				System.out.println(bankbookDTO.getPro_name());
				System.out.println(bankbookDTO.getInterest_rate());
				System.out.println("----------------");
			}
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookList.jsp");
			try {
				view.forward(request, response);
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(path.equals("bankbookInsert.do")) {
			System.out.println("상품등록");
		}else if(path.equals("bankbookSelect.do")) {
			System.out.println("상품상세조회");
			String num = request.getParameter("PRO_NUM");
			int num2 = Integer.parseInt(num);			
			BankbookDTO bankbookDTO = new BankbookDTO();
			bankbookDTO.setPro_num(num2);
			bankbookDTO = bankbookDAO.getSelect(bankbookDTO);
			System.out.println(bankbookDTO.getPro_name());
			
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookSelect.jsp");
			try {
				view.forward(request, response);
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("그 외 나머지");
		}
		
		
		
		
	}
	
}
