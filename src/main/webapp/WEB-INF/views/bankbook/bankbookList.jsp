<%@page import="com.ae.ae1.bankbook.BankbookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List Page</h1>
	
	<table>
		<tr>
			<th>일련번호</th><th>제품번호</th><th>이자율</th>
		</tr>
	<% 
		Object obj =request.getAttribute("ar");
		ArrayList<BankbookDTO> ar = (ArrayList<BankbookDTO>)obj;
		for(BankbookDTO dto:ar){
	%>
		<tr>
			<td><%=dto.getBook_num() %></td>
			<td><a href="./bankbookSelect.do?BOOK_NUM=<%=dto.getBook_num() %>"> <%=dto.getBook_name() %></a></td>
			<td><%=dto.getBook_rate() %></td>
		</tr>
	
	<% }%>
	
	</table>
	
	<a href="bankbookInsert.do">WRITE</a>
	
	
	
</body>
</html>