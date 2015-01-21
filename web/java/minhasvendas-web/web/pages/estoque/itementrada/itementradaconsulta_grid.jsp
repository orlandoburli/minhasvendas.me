<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<style type="text/css">
table thead td:nth-child(2) {
	width: 100px;
}

table thead td:nth-child(2), table thead td:nth-child(3) {
	text-align: right;
}

table tbody tr td:nth-child(2), table tbody tr td:nth-child(3) {
	text-align: right;
}
</style>

<fmt:setLocale value="pt_BR"/>
<table data-page-count="${pageCount}" class="table">
	<thead>
		<tr>
			<td>Produto</td>
			<td>Quantidade</td>
			<td>Valor de Compra</td>
		</tr>
	</thead>

	<tfoot>
		<tr>
			<td colspan="4">P&aacute;gina ${pageNumber} de ${pageCount}</td>
		</tr>
	</tfoot>
	
	<tbody>
		<c:forEach items="${vo.itens}" var="item">
			<tr data-id="idItemEntrada=${ item.idItemEntrada}">
			<td>${ item.produto.nome }</td>
			<td><fmt:formatNumber value="${ item.quantidade }" maxFractionDigits="0"/></td>
			<td><fmt:formatNumber value="${ item.valorCompra }" type="currency"/> </td>
			</tr>
		</c:forEach>
	</tbody>

</table>


