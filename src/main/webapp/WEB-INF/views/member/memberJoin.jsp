<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MemberJoin Page</h1>
	<form action="./memberJoin.do" method ="post">
		ID <input type="text" name="id"> <br>
		PW <input type="text" name="pw"> <br>
		NAME <input type="text" name="name"> <br>
		PHONE <input type="text" name="phone"> <br>
		EMAIL <input type="text" name="email">
	
	<div>
		<input type="submit">
		<button type="reset">리셋</button>
	</div>
	
	
	</form>
	
</body>
</html>