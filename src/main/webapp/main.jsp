<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.project.todo.dto.TodoDto"%>
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
<%
	List<TodoDto> todos = new ArrayList<>();
	List<TodoDto> doings = new ArrayList<>();
	List<TodoDto> dones	= new ArrayList<>();
	List<String> test = new ArrayList<>();
	request.setAttribute("todos", todos);
	request.setAttribute("doings", doings);
	request.setAttribute("dones", dones);
%>
	<c:forEach items="${requestScope.todo}" var="item" >
		<c:if test="${item.getTitle() == 'TODO'}">
			${todos.add(item)} todos<br>
		</c:if>
		<c:if test="${item.getTitle() == 'DOING'}">
			${doings.add(item)} doings<br>
		</c:if>
		<c:if test="${item.getTitle() == 'DONE'}">
			${dones.add(item)} dones<br>
		</c:if>
	</c:forEach>
	<p class="title">나의 해야할 일들</p>
	<p class="new"><a href="<%=path%>/form">새로운 TODO 등록</a></p>
	<div class="flex-container">
		<div class="list" id="TODO">
			<p>TODO</p>
			<c:forEach var="item" items="${todos}">
				<p>${item}</p>
			</c:forEach>
		</div>
		<div class="list" id="DOING">
			<p>DOING</p>
			<c:forEach var="item" items="${doings}">
				<p>${item}</p>
			</c:forEach>
		</div>
		<div class="list" id="DONE">
			<p>DONE</p>
			<c:forEach var="item" items="${dones}">
				<p>${item}</p>
				<p>${item.getName() }${item.getName() }${item.getName() }</p>
			</c:forEach>
		</div>
	</div>
<script type="text/javascript" src="<%=path%>/main.js"></script>
</body>
</html>