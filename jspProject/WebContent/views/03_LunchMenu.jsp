<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
	

	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP test3</title>
</head>
<body>
	<h1>include 테스트</h1>
	<h2>내일 이맘때 식사는 무엇으로 할까요?</h2>
	<%--<span style="color: hotpink;"><%=today%></span> --%> 
	<%@
	 include file="common/today.jsp"
	 %>
</body>
</html>