<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style type="text/css">
/* table thead td:nth-child(1) {
	width: 60px;
}

table thead td:nth-child(1) {
	text-align: right;
}

table tbody tr td:nth-child(1) {
	text-align: right;
} */
</style>


<table data-page-count="${pageCount}" class="table">
	<thead>
		<tr>
			<td>Nome</td>
			<td>Data de nascimento</td>
			<td>Fone</td>
			<td>Cidade</td>
			<td>UF</td>
			<td>Categoria</td>
		</tr>
	</thead>

	<tfoot>
		<tr>
			<td colspan="4">P&aacute;gina ${pageNumber} de ${pageCount}</td>
		</tr>
	</tfoot>
	
	<tbody>
		<c:forEach items="${listSource}" var="vo">
			<tr data-id="idCliente=${ vo.idCliente}">
			<td>${ vo.nome }</td>
			<td><fmt:formatDate value="${ vo.dataNascimento.time }" pattern="dd/MM/yyyy"/> </td>
			<td>${ vo.fone1 }</td>
			<td>${ vo.cidade }</td>
			<td>${ vo.uf }</td>
			<td>${ vo.categoria.nome }</td>
			</tr>
		</c:forEach>
	</tbody>

</table>


