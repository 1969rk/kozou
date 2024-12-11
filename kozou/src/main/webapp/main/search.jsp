<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>

<h3>JANコードで商品情報を検索</h3>
<form action="Scrape.action" method="post">
    <p>JANコード: <input type="text" name="janCode" oninput="numberOnly(this)" required></p>
    <input type="hidden" name="userId" value="${userId}">
    <input type="submit" value="search">
</form>

<a href="menu.jsp">戻る</a>

<script type="text/javascript">
	function numberOnly(v) {
		return v.replace(/[０-９]/g, (s) => String.fromCharCode(s.charCodeAt(0) - 65248));
	}
</script>

<%@ include file="../footer.html" %>
