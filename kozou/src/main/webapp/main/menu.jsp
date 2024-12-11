<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<h3>${user.userName}さんの調味料・日用品在庫状況</h3>

<form action="TransferSearch.action" method="post">
	<input type='hidden' name="userId" value="${user.userId}"> 
	<input type="submit" value="商品検索&追加">
</form>

<table>
	<thead>
		<tr>
			<th scope="col">カテゴリー</th>
			<th scope="col">数量</th>
			<th scope="col"></th>
		</tr>
	</thead>
	<c:forEach var="gc" items="${genreCount}">
		<tr>
			<td>${gc.genre}</td>
			<td>${gc.stockCount}</td>
			<td>
				<form action="TransferList.action" method="post">
					<input type="hidden" name="userId" value="${user.userId}">
					<input type="hidden" name="genreId" value="${gc.genreId}">
					<input type="hidden" name="genre" value="${gc.genre}">
					<input type="submit" value="商品確認&削除">
				</form>
			</td>
		</tr>
	</c:forEach>
</table>

<input type="button" value="logout" onClick="location.href='Logout.action'">

<%@ include file="../footer.html" %>
