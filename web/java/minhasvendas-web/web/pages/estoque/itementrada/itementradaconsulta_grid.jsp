<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style type="text/css">
table thead td:nth-child(1) {
	width: 60px;
}

table thead td:nth-child(1) {
	text-align: right;
}

table tbody tr td:nth-child(1) {
	text-align: right;
}
</style>


<table data-page-count="${pageCount}" class="table">
	<thead>
		<tr>
			<td>idItemEntrada</td>
			<td>idEntrada</td>
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
		<c:forEach items="${listSource}" var="vo">
			<tr


				data-id="idItemEntrada=${ vo.idItemEntrada}">
			<td>${ vo.idItemEntrada }</td>
			<td>${ vo.idEntrada }</td>
			<td>${ vo.idProduto }</td>
			<td>${ vo.quantidade }</td>
			<td>${ vo.valorCompra }</td>
			</tr>
		</c:forEach>
	</tbody>

</table>


