<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.project.todo.dto.TodoDto"%>
<%@page import="kr.or.project.todo.dao.TodoDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% String path = request.getContextPath(); %>
<link rel="stylesheet" type="text/css" href="<%=path%>/main.css"/>
</head>
<body>
<h1>나의 해야할 일들</h1>
${requestScope.todo[0]} <br>
${requestScope.todo[1]} <br>

<%--
<%
 	List<TodoDto> list = (List<TodoDto>)request.getAttribute("todo");
%>

<%=list%>
 --%>
 <script type="text/javascript" src=<%=path%>/main.js></script>
</body>
</html>