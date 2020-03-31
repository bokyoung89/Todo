<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String path = request.getContextPath(); %>
<link rel="stylesheet" type="text/css" href="<%=path%>/todoForm.css"/>
</body>
<h2>할일 등록</h2>
<form action="<%=path%>/TodoAddServlet">
	<p class="que">어떤 일인가요?</p>
	<input type="text" name="what" placeholder="swift공부하기(24자까지)" maxlength='24'>
	<p class="que">누가 할일인가요?</p>
	<input type="text" name="who" placeholder="홍길동">
	<p class="que">우선순위를 선택하세요</p>
	<span><input type="radio" name="priority" value="1순위">1순위</span>
	<span><input type="radio" name="priority" value="2순위">2순위 </span>
	<span><input type="radio" name="priority" value="3순위">3순위</span>
	<div class="bottom">
		<input class="buttons" type="button" value="< 이전" onclick="history.back();"/>
		<input class="buttons" type="submit" name="submit" value="제출">
		<input class="buttons" type="reset" value="내용지우기">
	</div>
</form>
</html>