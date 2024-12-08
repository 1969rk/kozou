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
        <p>容量: ${product.capacity} ${product.unit}</p>
        <p>メーカー: ${product.manufacturer}</p>
        <p>分類: ${product.genre}</p>
    </c:if>
    </c:if 
    <a href="index.jsp">戻る</a>
</body>
</html>


