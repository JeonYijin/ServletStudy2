<%@page import="com.ae.ae1.bankbook.BankbookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix = "sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="../CSS/list.css" rel="stylesheet" >
	</head>
	<body>
		<h1>BankBook List Page</h1>
		
		
		<table id = "t1">
			<tr >
				<th class = "c1">일련번호</th>
				<th class = "c1">제품번호</th>
				<th class = "c1">이자율</th>
				<th class = "c1">status</th>
			</tr>
			
			<c:forEach items="${list}" var = "dto" varStatus="i">
			<tr>
				<td class = "c1">${dto.book_num}</td>
				<td class = "c1"><a href="./bankbookSelect.do?BOOK_NUM=${dto.book_num}">${dto.book_name}</a></td>
				<td class = "c1">${dto.book_rate}</td>
				<td class = "c1">
					<p>현재 아이템 : ${i.current}</p>
					<p>인덱스 번호 : ${i.index}</p>
					<p>순서 번호 : ${i.count}</p>
					<p>처음  ? : ${i.first}</p>
					<p>마지막 ? : ${i.last}</p>
				</td>
			</tr>
			</c:forEach>
		
		</table>
		
		<div>
			<c:forEach begin="1" end="10" step="1" var="num" varStatus="i">
				<button>${num} : ${i.begin} : ${i.end} : ${i.step}</button>
			</c:forEach>
		</div>
		
		<a href="bankbookInsert.do">WRITE</a>
		
		
		
	</body>
</html>