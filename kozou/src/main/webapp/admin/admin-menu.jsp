<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>

<h3>管理者メニュー</h3>

<h4>新規ユーザーの追加</h4>

<form action="RegistUser.action" method="get">
	<p>Name<input type="text" name="userName"></p>
	<p>user ID<input type="text" name="loginId"></p>
	<p>password<input type="password" name="password"></p>
	<input type="submit" value="submit">
</form>

<a href="../index.jsp">Topへ</a>

<%@ include file="../footer.html" %>