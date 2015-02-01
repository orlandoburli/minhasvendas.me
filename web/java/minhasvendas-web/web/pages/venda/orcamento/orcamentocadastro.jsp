<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../header-title.jsp"%>

<div class="row">
	<div class="col-md-12">
		<div class="portlet box blue-hoki">
		
			<div class="portlet-title">
				<div class="caption">
					<i class="fa "></i>${subtitulo}
				</div>
			</div>
			
			<div class="portlet-body form FormularioCadastro FormularioGeral" data-page-consulta="orcamentoconsulta.action" data-page-operacao="${operacao}" data-page-cadastro="orcamentocadastro.action">
				<form class="form-horizontal" action="#" role="form">
					<div class="form-body">
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">idOrcamento</label>
							<div class="col-sm-7">
								<input id="idOrcamento" type="text" disabled="disabled"  class="form-control input-circle" value="${ vo.idOrcamento }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Empresa</label>
							<div class="col-sm-7">
								<input id="idEmpresa" type="text"  autofocus="autofocus" class="form-control input-circle" value="${ vo.idEmpresa }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Cliente</label>
							<div class="col-sm-7">
								<input id="idCliente" type="text"   class="form-control input-circle" value="${ vo.idCliente }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Data Orçamento</label>
							<div class="col-sm-7">
								<input id="dataOrcamento" type="text"   class="form-control input-circle" value="${ vo.dataOrcamento }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Vendedor</label>
							<div class="col-sm-7">
								<input id="idVendedor" type="text"   class="form-control input-circle" value="${ vo.idVendedor }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Data Validade</label>
							<div class="col-sm-7">
								<input id="dataValidade" type="text"   class="form-control input-circle" value="${ vo.dataValidade }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Valor Itens</label>
							<div class="col-sm-7">
								<input id="valorItens" type="text"   class="form-control input-circle" value="${ vo.valorItens }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Valor Desconto</label>
							<div class="col-sm-7">
								<input id="valorDesconto" type="text"   class="form-control input-circle" value="${ vo.valorDesconto }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Valor Total</label>
							<div class="col-sm-7">
								<input id="valorTotal" type="text"   class="form-control input-circle" value="${ vo.valorTotal }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Observacoes</label>
							<div class="col-sm-7">
								<input id="observacoes" type="text"   class="form-control input-circle" value="${ vo.observacoes }" />
							</div>
						</div>
						
						<%@include file="../../botoes-cadastro.jsp"%>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>