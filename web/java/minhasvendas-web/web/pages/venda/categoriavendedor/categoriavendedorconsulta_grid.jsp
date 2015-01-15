<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style type="text/css">

</style>

<table data-page-count="${pageCount}" class="table">
	<thead>
		<tr>
			<td>Nome</td>
			<td>Percentual de Comissão</td>
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
			<tr data-id="idCategoriaVendedor=${ vo.idCategoriaVendedor}">
			<td>${ vo.nome }</td>
			<td> <fmt:formatNumber type="number" value="${ vo.percentualComissao }" maxFractionDigits="2" minFractionDigits="2"/> %</td>
			<td>${ vo.ativoDesc }</td>
			</tr>
		</c:forEach>
	</tbody>

</table>


