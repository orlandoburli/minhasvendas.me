<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="pt_BR" />

<style type="text/css">
table thead td:nth-child(1) {
}
table thead td:nth-child(2) {
}
table thead td:nth-child(3) {
}
table thead td:nth-child(5) {
}
table thead td:nth-child(1), table thead td:nth-child(2), table thead td:nth-child(4){
	
}
table tbody tr td:nth-child(1), table tbody tr td:nth-child(2), table tbody tr td:nth-child(4) {
	
}
</style>

<table data-page-count="${pageCount}" class="table">
	<thead>
		<tr>
			<td>Cliente</td>
			<td>Data Orçamento</td>
			<td>Vendedor</td>
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
			<td><fmt:formatDate value="${vo.dataOrcamento.time}" pattern="dd/MM/yyyy" /></td>
			<td>${ vo.vendedor.nome }</td>
			<td><fmt:formatNumber value="${vo.valorTotal }" type="currency" /></td>
			</tr>
		</c:forEach>
	</tbody>

</table>


