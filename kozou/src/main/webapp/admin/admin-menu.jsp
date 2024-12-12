<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>

<h3>管理者メニュー</h3>

<h4>新規ユーザーの追加</h4>
<form action="RegistUser.action" method="post">
	<div class="aMenu">
		<label for="name">Name</label>
		<input class="box" type="text" id="name" name="userName" required>
		<label for="loginId">Login ID</label>
		<input class="box" type="text" id="loginId" name="loginId" required>
		<label for="password">Password</label>
		<input class="box" type="password" id="password" name="password" required><br>
	</div>
	<p class="caution">パスワードは半角アルファベット大小文字、数字を必ず含めて、8-16文字で設定してください。</p>
	<input class="button" type="submit" value="submit">
	<input class="submit" type="button" value="logout" onClick="location.href='ALogout.action'">
</form>


<%@ include file="../footer.html" %>

