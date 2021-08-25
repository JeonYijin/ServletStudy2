<%@page import="com.ae.ae1.account.AccountDTO"%>
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
	<h1>Account List Page</h1>
	
	<table>
		<tr>
		<th>계좌번호</th><th>개설일</th><th>잔고</th>
		</tr>
		
	<%
		Object obj = request.getAttribute("list");	
		ArrayList<AccountDTO> ar= (ArrayList<AccountDTO>)obj;
		for(AccountDTO dto:ar){
	%>
		<tr>
			<td><%=dto.getAccount_num() %></td>
			<td><%=dto.getAccount_date() %></td>
			<td><%=dto.getAccount_balance() %></td>
		</tr>
	
	
	<%} %>
	
	</table>
	
</body>
</html>