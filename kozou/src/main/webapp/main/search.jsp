<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>

    <h1>JANコードで商品情報を検索</h1>
    <form action="Scrape.action" method="post">
        <p>JANコード: <input type="text" name="janCode"></p>
        <input type="hidden" name="userId" value="${userId}">
        <input type="submit" value="search">
    </form>
</body>

<%@ include file="../footer.html" %>
