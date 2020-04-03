<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새로운 TODO 등록</title>
</head>
<body>
<% String path = request.getContextPath(); %>
<link rel="stylesheet" type="text/css" href="<%=path%>/todoForm.css"/>
</body>
<h2>할일 등록</h2>
<form action="<%=path%>/add" method="post">
	<label for="title">어떤 일인가요?</label><br/>
		<input type="text" name="title" placeholder="swift 공부하기(24자까지)" maxlength="24"><br/>
	<label for="name">누가 할 일인가요?</label><br/>
		<input type="text" name="name" placeholder="홍길동"></br>
	<label for="sequence">우선순위를 선택하세요</label></br>
		<span><input type="radio" name="sequence" value="1순위">1순위</span>
		<span><input type="radio" name="sequence" value="2순위">2순위 </span>
		<span><input type="radio" name="sequence" value="3순위">3순위</span>
	<div class="bottom">
		<input class="buttons" type="button" value="< 이전" onclick="history.back();"/>
		<input class="buttons" type="submit" name="submit" value="제출">
		<input class="buttons" type="reset" value="내용지우기">
	</div>
</form>
</html>