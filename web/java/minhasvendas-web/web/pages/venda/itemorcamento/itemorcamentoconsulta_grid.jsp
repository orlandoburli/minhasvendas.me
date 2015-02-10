<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="pt_BR"/>
<table data-page-count="${pageCount}" class="table table-striped DataGridItens">
	<thead>
		<tr>
			<td>Produto</td>
			<td class="text-right">Quantidade</td>
			<td class="text-right">Valor Unitário</td>
			<td class="text-right">Valor Desconto</td>
			<td class="text-right">Valor Total</td>
			<td></td>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${vo.itens}" var="item" varStatus="loop">
			<tr data-id="idItemOrcamento=${ item.idItemOrcamento}" data-index="${loop.index}">
				<td class="col-xs-4">${ item.produto.nome }</td>
				<td class="col-xs-1">
					<input id="quantidade" class="form-control input-circle text-right item-quantidade"  value="${item.quantidade}" data-field-type="number" data-field-precision="0" /> 
				</td>
				<td class="col-xs-2">
					<div class="input-group">
						<input id="valorUnitario" class="form-control input-circle text-right item-valor-compra" data-field-type="number" data-field-precision="2" value="${item.valorUnitario }" />
						<span class="input-group-addon">R$</span>
					</div>
				</td>
				<td class="col-xs-2">
					<div class="input-group">
						<input id="valorDesconto" class="form-control input-circle text-right item-valor-compra" data-field-type="number" data-field-precision="2" value="${item.valorDesconto }" />
						<span class="input-group-addon">R$</span>
					</div>
				</td>
				<td class="col-xs-2">
					<div class="input-group">
						<input id="valorTotal" disabled="disabled" class="form-control input-circle text-right item-valor-compra" data-field-type="number" data-field-precision="2" value="${item.valorTotal }" />
						<span class="input-group-addon">R$</span>
					</div>
				</td>
				<td class="col-xs-2">
					<button class="btn btn-danger BotaoRemoverItem tooltips" type="button" data-index="${loop.index}" title="Clique para remover este item" tabindex="-1">
						<i class="fa fa-trash-o"></i>
					</button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
