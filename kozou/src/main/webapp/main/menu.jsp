<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>

<h3>${user.userName}さんの調味料・日用品在庫状況</h3>


<form action="TransferSearch.action" method="post">
	<input type='hidden' name="userId" value="${user.userId}"> 
	<input type="submit" value="add item">
</form>
<form action="TransferTrash.action" method="post">
	<input type='hidden' name="userId" value="${user.userId}"> 
	<input type="submit" value="discard item">
</form>

<input type="button" value="logout" onClick="location.href='Logout.action'">


<a href="../index.jsp">Topへ</a>

<%@ include file="../footer.html" %>
