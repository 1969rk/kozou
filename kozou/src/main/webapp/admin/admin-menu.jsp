<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>

<h3>管理者メニュー</h3>

<h4>新規ユーザーの追加</h4>
<form action="RegistUser.action" method="post">
	<label for="name">Name</label>
	<input type="text" id="name" name="userName" required><br>
	<label for="loginId">Login ID</label>
	<input type="text" id="loginId" name="loginId" required><br>
	<p>（半角アルファベット大文字、小文字、数字を含め、8-16文字で設定してください。</p>
	<label for="password">Password</label>
	<input type="password" id="password" name="password" required><br>
	<input type="submit" value="submit">
</form>

<input type="button" value="logout" onClick="location.href='ALogout.action'">

<%@ include file="../footer.html" %>