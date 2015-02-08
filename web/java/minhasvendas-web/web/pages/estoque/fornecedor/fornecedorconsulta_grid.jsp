<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style type="text/css">
table thead td:nth-child(1) {
}

table thead td:nth-child(1) {
}

table tbody tr td:nth-child(1) {
}
</style>


<table data-page-count="${pageCount}" class="table">
	<thead>
		<tr>
			<td>Nome</td>
			<td>Razão Social</td>
			<td>Cpf / Cnpj</td>
			<td>Fone 1</td>
		</tr>
	</thead>

	<tfoot>
		<tr>
			<td colspan="4">P&aacute;gina ${pageNumber} de ${pageCount}</td>
		</tr>
	</tfoot>
	
	<tbody>
		<c:forEach items="${listSource}" var="vo">
			<tr data-id="idFornecedor=${ vo.idFornecedor}">
			<td>${ vo.nome }</td>
			<td>${ vo.razaoSocial }</td>
			<td>${ vo.cpfCnpj }</td>
			<td>${ vo.fone01 }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
