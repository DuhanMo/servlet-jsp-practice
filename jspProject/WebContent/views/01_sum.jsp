<%-- Directive Tag : 지시자 태그  --%>
<%--  사용하려는 페이지의 설정을 명시하는 태그--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- Declaration Tag : 선언자 태그 --%>
<%!//변수와 같이 미리 선언하여 사용할 값들을 등록해서 선언하는 영역
	int num1 = 2;
	int num2 = 15;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 테스트 1</title>
</head>
<body>
	<h1>JSP 테스트 1</h1>
	<%-- Comments Tag : JSP 주석 태그 --%>

	<!-- 일반 HTML 주석 -->
	<%-- JSP 주석은 사용자에게 전달되지 않는다. 즉, 컴파일 시 자바 서블릿의 주석으로 별도 처리된다. --%>

	<%-- Scriptlet Tag : 자바 코드 구현 태그(스크립트 태그) --%>
	<%-- 자바의 소스코드를 입력하는 영역 --%>
	<%
		int total = 0;
		for (int i = 0; i < 11; i++) {
			total += i;
		}
	%>

	<%-- Expression Tag : 표현태그 --%>
	<%-- 자바로 생성된 코드의 값을 출력하는 태그(out.println()으로 묶여서 나온다.) 
        표현태그 안에 작성한 내용을 JSP내부에서 out.println();으로 묶어서 나오기 때문에
        만약 안의 값에서 ';'을 작성하개 되면 out.println(blah~blah~;);의 형태가 되어 에러가 발생하게 된다.
   --%>
	<h4>
		num1과 num2의 합은
		<%=num1 + num2%></h4>
	<h4>
		1부터 10까지의 합은
		<%=total%></h4>
	<h4>
		1부터 10까지의 합은
		<%=total%>
		입니다.
	</h4>
</body>
</html>