<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>

<h3>次の商品を追加しました。</h3>

<div class="confItem">
	<p>分類</p>
	<p>${product.genre}</p>
	<p>商品名
	<p>${product.productName}</p>
</div>
<p class="caution">${message1}</p>

<form action="UpdateData.action" method="post" id="submit">
	<input type="hidden" name="userId" value="${userId}">
	<input class="button" type="submit" value="戻る">
</form>

<script type="text/javascript">
	function autoSubmit() {
		document.getElementById('submit').submit();
	}

	setTimeout(autoSubmit, 5000);

</script>

<%@ include file="../footer.html" %>

