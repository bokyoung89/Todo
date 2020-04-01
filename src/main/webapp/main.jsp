<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.project.todo.dto.TodoDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODO 리스트</title>
<% String path = request.getContextPath(); %>
<link rel="stylesheet" type="text/css" href="<%=path%>/main.css"/>
</head>
<body>
	<p class="title">나의 해야할 일들</p>
	<p class="new"><a href="<%=path %>/form">새로운 TODO 등록</a></p>
	<div class="flex-container">
		<div class="list" id="TODO">
			<p>TODO</p>
			<c:forEach var="item" items="${todo}">
				<c:if test="${item.getType() == 'TODO'}">
					<p>
						<span class="item-title">${item.getTitle()}</span></br>
						<fmt:parseDate value="${item.getRegDate()}" var="parsedDate" pattern="yyyy-MM-dd HH:mm:ss.S"/>
							등록날짜: <fmt:formatDate value="${parsedDate}" pattern="yyyy. MM. dd"/>,
							${item.getName()},
							우선순위 ${item.getSequence()}
						<span class="button">-></span>
					</p>
				</c:if>
			</c:forEach>
		</div>
		<div class="list" id="DOING">
			<p>DOING</p>
			<c:forEach var="item" items="${todo}">
				<c:if test="${item.getType() == 'DOING'}">
					<p>
						<span class="item-title">${item.getTitle()}</span></br>
						<fmt:parseDate value="${item.getRegDate()}" var="parsedDate" pattern="yyyy-MM-dd HH:mm:ss.S"/>
							등록날짜: <fmt:formatDate value="${parsedDate}" pattern="yyyy. MM. dd"/>,
							${item.getName()},
							우선순위 ${item.getSequence()}
						<span class="button">-></span>
					</p>
				</c:if>
			</c:forEach>
		</div>
		<div class="list" id="DONE">
			<p>DONE</p>
			<c:forEach var="item" items="${todo}">
				<c:if test="${item.getType() == 'DONE'}">
					<p>
						<span class="item-title">${item.getTitle()}</span></br>
						<fmt:parseDate value="${item.getRegDate()}" var="parsedDate" pattern="yyyy-MM-dd HH:mm:ss.S"/>
							등록날짜: <fmt:formatDate value="${parsedDate}" pattern="yyyy. MM. dd"/>,
							${item.getName()},
							우선순위 ${item.getSequence()}
						<span class="button">-></span>
					</p>
				</c:if>
			</c:forEach>
		</div>
	</div>
<script type="text/javascript" src="<%=path%>/main.js"></script>
</body>
</html>