<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<style type="text/css">
table thead td:nth-child(2) {
	width: 100px;
}

table thead td:nth-child(3) {
	
}

table thead td:nth-child(2), table thead td:nth-child(3) {
	text-align: right;
}

table tbody tr td:nth-child(2), table tbody tr td:nth-child(3) {
	text-align: right;
}
</style>

<fmt:setLocale value="pt_BR"/>
<table data-page-count="${pageCount}" class="table">
	<thead>
		<tr>
			<td>Produto</td>
			<td>Quantidade</td>
			<td>Valor de Compra</td>
			<td></td>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${vo.itens}" var="item" varStatus="loop">
			<tr data-id="idItemEntrada=${ item.idItemEntrada}" data-index="${loop.index}">
				<td>${ item.produto.nome }</td>
				<td> 
					<input id="quantidade${loop.index}" class="form-control input-circle text-right item-quantidade"  value="${item.quantidade}" data-field-type="number" data-field-precision="0" /> 
				</td>
				<td>
					<div class="input-icon right">
						<i class="fa fa-usd"></i>
						<input id="valorCompra${loop.index}" class="form-control input-circle text-right item-valor-compra" data-field-type="number" data-field-precision="2" value="${item.valorCompra }" />
					</div>
				</td>
				<td>
					<button class="btn btn-danger BotaoRemoverItem tooltips" type="button" data-index="${loop.index}" title="Clique para remover este item" tabindex="-1">
						<i class="fa fa-trash-o"></i>
					</button>
				</td>
			</tr>
		</c:forEach>
	</tbody>

</table>
