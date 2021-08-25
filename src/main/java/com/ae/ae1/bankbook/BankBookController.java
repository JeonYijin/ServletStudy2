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
		
		/**     ----------------List---------------    */
		
		if(path.equals("bankbookList.do")) {
			System.out.println("상품조회");
			ArrayList<BankbookDTO> ar = bankbookDAO.getList();
			//for(초기식;조건식;증감식)
			//for(모은 타입명 변수명:컬렉션 참조변수명)
			for(BankbookDTO bankbookDTO :ar) {
				System.out.println(bankbookDTO.getBook_num());
				System.out.println(bankbookDTO.getBook_rate());
				System.out.println("----------------");
			}
			request.setAttribute("ar", ar);
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookList.jsp");
			try {
				view.forward(request, response);
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/**     ----------------insert---------------    */
			
		}else if(path.equals("bankbookInsert.do")) {
			System.out.println("상품등록");
			
			String method = request.getMethod();
			System.out.println("Method : " + method);
			
			if(method.equals("POST")) {
				//파라미터값 출력
				String name = request.getParameter("book_name");
				System.out.println(name);
				String rate = request.getParameter("book_rate");
				System.out.println(rate);
				String sale = request.getParameter("book_sale");
				System.out.println(sale);
				int result=0;
				BankbookDTO bankbookDTO = new BankbookDTO();
				bankbookDTO.setBook_name(name);
				bankbookDTO.setBook_rate(Double.parseDouble(rate));
				bankbookDTO.setBook_sale(Integer.parseInt(sale));
				result = bankbookDAO.setInsert(bankbookDTO);

//				result = bankbookDAO.setInsert(request);
				System.out.println(result);
//				ArrayList<BankbookDTO> ar = bankbookDAO.getList();
//				request.setAttribute("ar", ar);
//				RequestDispatcher view = request.getRequestDispatcher("../index.jsp");
//				try {
//					view.forward(request, response);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
				//}
			try {
				response.sendRedirect("./bankbookList.do");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else {
				RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookInsert.jsp");
				try {
					view.forward(request, response);
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
			/**     ----------------insert2---------------    */
		
			
			/**     ----------------select---------------    */	
		}else if(path.equals("bankbookSelect.do")) {
			System.out.println("상품상세조회");
			String num = request.getParameter("BOOK_NUM");
			long num2 = Long.parseLong(num);			
			BankbookDTO bankbookDTO = new BankbookDTO();
			bankbookDTO.setBook_num(num2);
			bankbookDTO = bankbookDAO.getSelect(bankbookDTO);
			System.out.println(bankbookDTO.getBook_name());
			request.setAttribute("dto", bankbookDTO);
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
