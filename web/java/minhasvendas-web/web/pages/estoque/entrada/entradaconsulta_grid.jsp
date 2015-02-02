<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style type="text/css">
table thead td:nth-child(1) {
	width: 60px;
}
table thead td:nth-child(2) {
	width: 40px;
}
table thead td:nth-child(3) {
	width: 120px;
}
table thead td:nth-child(5) {
	width: 120px;
}
table thead td:nth-child(1), table thead td:nth-child(2), table thead td:nth-child(4){
	text-align: right;
}
table tbody tr td:nth-child(1), table tbody tr td:nth-child(2), table tbody tr td:nth-child(4) {
	text-align: right;
}
</style>

<table data-page-count="${pageCount}" class="table">
	<thead>
		<tr>
			<td>Documento</td>
			<td>Série</td>
			<td>Data de Emissão</td>
			<td>Valor Total</td>
			<td>Status</td>
		</tr>
	</thead>

	<tfoot>
		<tr>
			<td colspan="6">P&aacute;gina ${pageNumber} de ${pageCount}</td>
		</tr>
	</tfoot>
	
	<tbody>
		<c:forEach items="${listSource}" var="vo">
			<tr data-id="idEntrada=${ vo.idEntrada}">
			<td>${ vo.numeroDocumento }</td>
			<td>${ vo.serie }</td>
			<td><fmt:formatDate value="${vo.dataEmissaoDocumento.time}" pattern="dd/MM/yyyy" /></td>
			<td></td>
			<td>${ vo.statusDesc }</td>
			</tr>
		</c:forEach>
	</tbody>

</table>


