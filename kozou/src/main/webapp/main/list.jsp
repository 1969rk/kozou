<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<h3>${genre}の在庫状況です。</h3>

<table>
	<thead>
		<tr>
			<th scope="col">商品名</th>
			<th scope="col">登録日</th>
			<th scope="col"></th>
		</tr>
	<c:forEach var="item" items="${stock}">
		<tr>
			<td>${item.productName}</td>
			<td>${fn:substring(item.addTime, 0, 10)}</td>
			<td>
				<form action="RemoveItem.action">
					<input type="hidden" name="stockId" value="${item.stockId}">
					<input type="hidden" name="userId" value="${userId}">
					<input type="submit" value="削除">
				</form>
			</td>
		</tr>
	</c:forEach>
</table>

<form action="UpdateData.action">
	<input type="hidden" name="userId" value="${userId}">
	<input class="button" type="submit" value="戻る">
</form>

<%@ include file="../footer.html" %>

