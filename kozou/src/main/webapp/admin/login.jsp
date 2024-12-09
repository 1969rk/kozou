<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>

<h2>家庭用在庫管理システム</h2>
<h1>new 小 蔵</h1>
<h3>管理者ページ</h3>

<form action="ALogin.action" method="post">
	<p>user ID<input type="text" name="loginId"></p>
	<p>password<input type="password" name="password"></p>
	<input type="submit" value="login">
</form>

<a href="../index.jsp">Topへ</a>

<%@ include file="../footer.html" %>