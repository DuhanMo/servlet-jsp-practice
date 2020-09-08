<%@ page import="com.kh.model.vo.Person" %><%--
  Created by IntelliJ IDEA.
  User: moduhan
  Date: 2020-09-08
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //1. request, session 객체에 저장된 값 변수에 기록
    String classRoom = (String) request.getAttribute("classRoom");
    Person student = (Person) request.getAttribute("student");

    String academy = (String) session.getAttribute("academy");
    Person teacher = (Person) session.getAttribute("teacher");
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h3>1. 기존에 하던 방식대로 스크립트릿을 이용하여 각 객체에 담겨있는 값 뽑아서 화면 출력</h3>
</body>
</html>
