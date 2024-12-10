<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<h1>商品情報</h1>
<form action="AddItem.action">
    <p>JAN code: <input type="text" name="janCode" value="${product.janCode}"></p>
    <p>商品名: <input type="text" name="productName" value="${product.productName}"></p>
    <p>容量: <input type="text" name="amount" value="${product.amount}">${product.unit}</p>
    <input type="hidden" name="unit" value="${product.unit}"> 
    <p>メーカー: <input type="text" name="manufacturer" value="${product.manufacturer}"></p>
    <p>分類: <input type="text" name="genre" value="${product.genre}"></p>
    <input type="hidden" name="userId" value="${userId}">
    <input type="submit" value="submit">
</form>
<c:if test="${empty product}">
	<p>商品情報の一部あるいはすべてを入手できませんでした。</p>
</c:if> 
<a href="menu.jsp">戻る</a>

<%@ include file="../footer.html" %>

