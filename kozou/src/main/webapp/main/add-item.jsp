<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<h3>商品情報を確認し、修正あるいは空欄を追加してください。</h3>
<form action="AddItem.action">
    <p>JAN code: <input type="text" name="janCode" value="${product.janCode}" required></p>
    <p>商品名: <input type="text" name="productName" value="${product.productName}" required></p>
    <p>容量: <input type="text" name="amount" value="${product.amount}"></p>
    <p>(数字のみを入力してください。単位をここに入力しないでください。)</p>
    <p>単位: <input type="text" name="unit" value="${product.unit}"></p> 
    <p>(ml, L, g, kgのように入力してください)</p>
    <p>メーカー: <input type="text" name="manufacturer" value="${product.manufacturer}"></p>
    <p>分類: <input type="text" name="genre" value="${product.genre}" required></p>
    <input type="hidden" name="userId" value="${userId}">
    <input type="submit" value="submit">
</form>
<c:if test="${empty product}">
	<p>${error}</p>
</c:if> 
<a href="menu.jsp">戻る</a>

<%@ include file="../footer.html" %>

