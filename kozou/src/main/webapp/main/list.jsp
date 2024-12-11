<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<h3>${genre}の在庫状況です。</h3>

<section>
	<c:forEach var="item" items="${stock}">
		<form action="RemoveItem.action">
			<p>${item.productName} / ${fn:substring(item.addTime, 0, 10)} 登録
			<input type="hidden" name="stockId" value="${item.stockId}">
			<input type="hidden" name="userId" value="${userId}">
			<input type="submit" value="削除"></p>
		</form>
	</c:forEach>
</section>

<form action="UpdateData.action">
	<input type="hidden" name="userId" value="${userId}">
	<input type="submit" value="戻る">
</form>

<%@ include file="../footer.html" %>

