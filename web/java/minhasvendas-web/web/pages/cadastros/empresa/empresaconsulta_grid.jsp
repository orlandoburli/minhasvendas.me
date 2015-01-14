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
			<td>Código</td>
			<td>Razão Social</td>
			<td>Fantasia</td>
			<td>Email</td>
			<td>Tipo</td>
			<td>Senha</td>
			<td>Data de Cadastro</td>
			<td>Email confirmado</td>
			<td>hash</td>
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


				data-id="idEmpresa=${ vo.idEmpresa}">
			<td>${ vo.idEmpresa }</td>
			<td>${ vo.razaoSocial }</td>
			<td>${ vo.fantasia }</td>
			<td>${ vo.email }</td>
			<td>${ vo.tipoDesc }</td>
			<td>${ vo.senha }</td>
			<td>${ vo.dataCadastro }</td>
			<td>${ vo.flagEmailConfirmadoDesc }</td>
			<td>${ vo.hash }</td>
			</tr>
		</c:forEach>
	</tbody>

</table>


