<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 테스트4</title>
</head>
<body>
	<h1>서블릿통신하기</h1>
	<h3>오늘의 메뉴
		<%@ include file="common/today.jsp"%></h3>
		<form action="/jsp/menuOrder.do" method="get">
			<select name="menuSelect">
				<option value="텐동">텐동</option>
				<option value="피자">피자</option>
				<option value="햄버거">햄버거</option>
				<option value="커리">커리</option>
				<option value="양꼬치">양꼬치</option>
			</select>
			<button type="submit">선택완료</button>
		</form>
</body>
</html>