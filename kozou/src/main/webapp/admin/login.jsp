<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>

<h2>家庭用在庫管理システム</h2>
<h1>new 小 蔵</h1>
<h3>管理者ページ</h3>

<form action="ALogin.action" method="post">
	<div class="boxes">
		<label for="loginId">ID</label>
		<input class="box" id="loginId" type="text" name="loginId">
		<label for="password">password</label>
		<input class="box" id="password" type="password" name="password">
	</div>
	<input class="submit" type="submit" value="login">
</form>

<a href="../index.jsp">Topへ</a>

<%@ include file="../footer.html" %>