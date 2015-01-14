<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style type="text/css">
table thead td:nth-child(2) {
	width: 100px;
}

table thead td:nth-child(2) {
	text-align: right;
}

table tbody tr td:nth-child(2) {
	text-align: right;
}
</style>


<table data-page-count="${pageCount}" class="table">
	<thead>
		<tr>
			<td>Nome</td>
			<td>Ativo</td>
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


				data-id="idCategoria=${ vo.idCategoria}">
			<td>${ vo.nome }</td>
			<td>${ vo.ativoDesc }</td>
			</tr>
		</c:forEach>
	</tbody>

</table>


