<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String menu = (String) request.getAttribute("menu");
	int price = (Integer) request.getAttribute("price");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>주문 내역 확인하세요</h2>
   <p>
         주문 하신 음식 : <%= menu %> <br>
         가격 : <%= price %>원
   </p>
   <h3>이용해주셔서 감사합니다.</h3>
</body>
</html>