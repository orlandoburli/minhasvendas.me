<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="pt_BR" />
<style type="text/css">
table thead td:nth-child(1) {
	width: 100px;
}

table thead td:nth-child(1), table thead td:nth-child(3) {
	text-align: right;
}

table tbody tr td:nth-child(1), table tbody tr td:nth-child(3) {
	text-align: right;
}
</style>

<table data-page-count="${pageCount}" class="table">
	<thead>
		<tr>
			<td>Código do Produto</td>
			<td>Nome</td>
			<td>Valor de venda</td>
			<td>Categoria</td>
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
			
			<tr data-id="idProduto=${ vo.idProduto}">
			<td>${ vo.codigoProduto }</td>
			<td>${ vo.nome }</td>
			<td>
				<fmt:formatNumber value="${vo.valorVenda }" type="currency" />
			</td>
			<td>${ vo.categoria.nome}</td>
			<td>${ vo.ativoDesc }</td>
			</tr>
		</c:forEach>
	</tbody>

</table>


