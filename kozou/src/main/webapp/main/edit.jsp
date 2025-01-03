<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>

<h3>情報を確認してください。</h3>
<p class="caution">このページで修正できます。</p>

<form action="UpdateItem.action" method="post">
    <div class="addItem">
	    <label for="janCode">JANコード</label>
	    <input class="box" id="janCode" type="text" name="janCode" value="${product.janCode}" readonly>
	    <label for="name">商品名</label>
	    <input class="box" id="name" type="text" name="productName" value="${product.productName}" required>
	    <label for="amount">容量(数字のみ)</label>
		<input class="box" id="amount" type="text" name="amount" value="${product.amount}">
	    <label for="unit">単位(ml, kgなど)</label>
	    <input class="box" id="unit" type="text" name="unit" value="${product.unit}">
	    <label for="brand">メーカー</label>
	    <input class="box" id="brand" type="text" name="manufacturer" value="${product.manufacturer}">
	    <label for="genre">分類</label>
	    <input class="box" id="genre"type="text" name="genre" value="${product.genre}" required>
    </div>
    <input type="hidden" name="userId" value="${userId}">
    <input class="button" type="submit" value="更新">
</form>

<a href="menu.jsp">戻る</a>

<%@ include file="../footer.html" %>

