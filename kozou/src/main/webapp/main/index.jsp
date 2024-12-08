<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>商品情報検索</title>
</head>
<body>
    <h1>JANコードで商品情報を検索</h1>
    <form action="Scrape.action" method="post">
        <label for="janCode">JANコード:</label>
        <input type="text" id="janCode" name="janCode" required>
        <button type="submit">検索</button>
    </form>
</body>
</html>