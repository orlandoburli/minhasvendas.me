<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style type="text/css">
table thead td:nth-child(1) {
	width: 80px;
}

table thead td:nth-child(2) {
	width: 50px;
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
			<td>Documento</td>
			<td>Série</td>
			<td>Data de Emissão</td>
			<td>Valor Total</td>
			<td>Status</td>
		</tr>
	</thead>

	<tfoot>
		<tr>
			<td colspan="4">P&aacute;gina ${pageNumber} de ${pageCount}</td>
		</tr>
	</tfoot>
	
	<tbody>
		<c:forEach items="${listSource}" var="vo">
			<tr data-id="idEntrada=${ vo.idEntrada}">
			<td>${ vo.numeroDocumento }</td>
			<td>${ vo.serie }</td>
			<td>${ vo.dataEmissaoDocumento }</td>
			<td>${ vo.statusDesc }</td>
			</tr>
		</c:forEach>
	</tbody>

</table>


