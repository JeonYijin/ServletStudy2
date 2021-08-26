<%@page import="com.ae.ae1.bankbook.BankbookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Select Page</h1>
	<% 
		//session
		//application
		//page
		String num = request.getParameter("BOOK_NUM");
		Object obj = request.getAttribute("dto");
		BankbookDTO bankbookDTO = (BankbookDTO)obj;
	%>
 
	<h3>num : <%= num %></h3>
	<h3>Name : <%= bankbookDTO.getBook_name() %></h3>
	
</body>
</html>