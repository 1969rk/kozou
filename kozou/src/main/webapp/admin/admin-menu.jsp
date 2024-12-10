<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>

<h3>管理者メニュー</h3>

<h4>新規ユーザーの追加</h4>
<form action="RegistUser.action" method="post">
	<p>Name<input type="text" name="userName" required></p>
	<p>user ID<input type="text" name="loginId" required></p>
	<p>password<input type="password" name="password" required></p>
	<input type="submit" value="submit">
</form>

<input type="button" value="logout" onClick="location.href='ALogout.action'">

<%@ include file="../footer.html" %>