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
			<td>Cliente</td>
			<td>Data Orçamento</td>
			<td>Vendedor</td>
			<td>Valor Itens</td>
			<td>Valor Total</td>
		</tr>
	</thead>

	<tfoot>
		<tr>
			<td colspan="4">P&aacute;gina ${pageNumber} de ${pageCount}</td>
		</tr>
	</tfoot>
	
	<tbody>
		<c:forEach items="${listSource}" var="vo">
			<tr	data-id="idOrcamento=${ vo.idOrcamento}">
			<td>${ vo.cliente.nome }</td>
			<td>${ vo.dataOrcamento }</td>
			<td>${ vo.vendedor.nome }</td>
			<td>${ vo.valorItens }</td>
			<td>${ vo.valorTotal }</td>
			</tr>
		</c:forEach>
	</tbody>

</table>


