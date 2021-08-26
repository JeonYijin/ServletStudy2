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
	
	
 
	<h3>num : ${dto.book_num}  </h3>
	<h3>Name : ${requestScope.dto.book_name}</h3>
	<h3>Count : ${requestScope.count}</h3>
	<h3>name : ${name}</h3>
	<h3>SE : ${sessionScope.se}</h3>
	<h3>SE : ${se}</h3>
	
</body>
</html>