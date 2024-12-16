<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>

<h3>商品情報を検索</h3>
<form action="Scrape.action" method="post">
    <div class="sInput">
	    <label for="janCode">JANコード</label>
	    <input class="box" id="janCode" type="text" name="janCode" oninput="numberOnly(this)" required>
    </div>
    <input type="hidden" name="userId" value="${userId}">
    <input class="button" type="submit" value="検索">
</form>

<a href="menu.jsp">戻る</a>

<script type="text/javascript">
	function numberOnly(v) {
		return v.replace(/[０-９]/g, (s) => String.fromCharCode(s.charCodeAt(0) - 65248));
	}
</script>

<%@ include file="../footer.html" %>
