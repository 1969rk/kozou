<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>商品情報</title>
</head>
<body>
    <h1>商品情報</h1>
    <c:if test="${not empty product}">
        <p>JAN code: ${product.janCode}</p>
        <p>商品名: ${product.name}</p>
        <p>メーカー: ${product.manufacturer}</p>
        <p>ジャンル: ${product.genre}</p>
    </c:if>
    <c:if test="${empty product}">
        <p>商品情報を取得できませんでした。</p>
    </c:if>
    <a href="scrapeInput.jsp">戻る</a>
</body>
</html>


