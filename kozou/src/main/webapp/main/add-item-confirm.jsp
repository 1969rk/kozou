<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<h3>次の商品を追加しました。</h3>
<p>分類: ${product.genre}</p>
<p>商品名: ${product.productName}</p>
<div>
${message1}
${message2}
${message3}
${message4}
</div>

<form action="UpdateData.action" method="post" id="submit">
	<input type="hidden" name="userId" value="${userId}>
	<input type="submit" value="戻る">
</form>

<script type="text/javascript">
	function autoSubmit() {
		document.getElementById('submit').submit();
	}

	setTimeout(autoSubmit, 5000);

</script>

<%@ include file="../footer.html" %>

