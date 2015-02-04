<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../header-title.jsp"%>

<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="portlet box box-solid box-primary">
			
				<div class="box-header">
					<h3 class="box-title">${subtitulo}</h3>
				</div>
				
				<div class="box-body">
					<div class="portlet-body form FormularioCadastro FormularioGeral" data-page-consulta="entradaconsulta.action" data-page-operacao="${operacao}" data-page-cadastro="entradacadastro.action">
						<form class="form-horizontal" action="#" role="form">
							<div class="form-body FormularioDadosCadastro">
								<input id="idEntrada" type="hidden" value="${ vo.idEntrada }" />
								<input id="idEmpresa" type="hidden" value="${ vo.idEmpresa }" />
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Número Documento</label>
									<div class="col-sm-4">
										<input id="numeroDocumento" type="text" autofocus="autofocus" class="form-control input-circle" value="${ vo.numeroDocumento }" />
									</div>
								
									<label class="col-sm-1 control-label text-right">Série</label>
									<div class="col-sm-2">
										<input id="serie" type="text" class="form-control input-circle" value="${ vo.serie }" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Data de Emissão</label>
									<div class="col-sm-2">
										<input id="dataEmissaoDocumento" type="text" class="form-control input-circle" value="<fmt:formatDate value="${ vo.dataEmissaoDocumento.time }" pattern="dd/MM/yyyy"/>" data-field-type="date" />
									</div>
									<label class="col-sm-1 control-label text-right">Status</label>
									
									<input id="status" type="hidden" value="${vo.status}">
									
									<div class="col-sm-3">
										<input id="statusDesc" type="text" disabled="disabled" class="form-control input-circle" value="${ vo.statusDesc }" />	
									</div>
									<label class="col-sm-2 control-label text-right">Valor do Frete</label>
									<div class="col-sm-2">
										<div class="input-group">
											<input id="valorFrete" class="form-control input-circle text-right" data-field-type="number" data-field-precision="2" value="${vo.valorFrete}"/>
											<span class="input-group-addon">R$</span>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Valor dos Itens</label>
									<div class="col-sm-2">
										<div class="input-group">
											<input id="valorItens" disabled="disabled" class="form-control input-circle text-right" data-field-type="number" data-field-precision="2" value="${vo.valorItens}"/>
											<span class="input-group-addon">R$</span>
										</div>
									</div>
									<label class="col-sm-2 control-label text-right">Valor dos Descontos</label>
									<div class="col-sm-2">
										<div class="input-group">
											<input id="valorDescontos" disabled="disabled" class="form-control input-circle text-right" data-field-type="number" data-field-precision="2" value="${vo.valorDescontos}"/>
											<span class="input-group-addon">R$</span>
										</div>
									</div>
									
									<label class="col-sm-2 control-label text-right">Valor Total</label>
									<div class="col-sm-2">
										<div class="input-group">
											<input id="valorTotal" disabled="disabled" class="form-control input-circle text-right" data-field-type="number" data-field-precision="2" value="${vo.valorTotal}"/>
											<span class="input-group-addon">R$</span>
										</div>
									</div>
									
								</div>
								
								<!-- ITENS -->
								
								<div class="box">
									<div class="box-body">
										<div class="box-header">
											<h3 class="box-title"><i class="fa fa-cube"></i><span>&nbsp;&nbsp;&nbsp;&nbsp;Itens</span></h3>
										</div>
										
										<div class="box-body">
											<div class="row">
												<div class="col-xs-3">
													<label class="control-label text-right">Produto</label>
												</div>
												
												<div class="col-xs-2">
													<label class="control-label col-md-12 text-right">Qtd.</label>
												</div>
												
												<div class="col-xs-2">
													<label class="control-label col-md-12 text-right">Valor Unitário</label>
												</div>
												
												<div class="col-xs-2">
													<label class="control-label col-md-12 text-right">Valor Desconto</label>
												</div>
												
												<div class="col-xs-2">
													<label class="control-label col-md-12 text-right">Valor Total</label>
												</div>
												
											</div>
											
											<div class="row FormItens">
												<div class="col-xs-3">
													<input id="idProduto" class="form-control input-circle autocomplete" data-remote-source="entradacadastro.produtos.action"/>
												</div>
												
												<div class="col-xs-2">
													<input id="quantidade" class="form-control input-circle text-right" data-field-type="number" data-field-precision="0" data-default-value="1" value="1"/>
												</div>
												
												<div class="col-xs-2">
													<div class="input-group">
														<input id="valorUnitario" class="form-control input-circle text-right" data-field-type="number" data-field-precision="2" />
														<span class="input-group-addon">R$</span>
													</div>
												</div>
												
												<div class="col-xs-2">
													<div class="input-group">
														<input id="valorDesconto" class="form-control input-circle text-right" data-field-type="number" data-field-precision="2" />
														<span class="input-group-addon">R$</span>
													</div>
												</div>
												
												<div class="col-xs-2">
													<div class="input-group">
														<input id="valorTotal" disabled="disabled" class="form-control input-circle text-right" data-field-type="number" data-field-precision="2" />
														<span class="input-group-addon">R$</span>
													</div>
												</div>
												
												<div class="col-xs-1">
													<button type="button" class="BotaoAdicionarItem btn btn-primary tooltips" title="Novo Registro (Ctrl + N)">
														<i class="fa fa-plus-circle"></i> Adicionar Item
													</button>
												</div>
											</div>
											
											<div class="row">
												<div class="table-scrollable col-xs-12">
													<div class="box" style="margin-top: 20px;">
														<div class="box-body">
															<div class="DataGridConsulta" data-page="entradacadastro.grid.action" data-page-size="8" data-detail-page="entradacadastro.action"></div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								
								<%@include file="../../botoes-cadastro.jsp"%>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<script type="text/javascript">
	$(document).ready(function() {
		loadJs("web/js/item.js", function() {
			ItemHandler.init(function() {
				if (debug) {
					console.log("Refresh do total... TODO");
				}
				
				getVoSessao(function(retorno) {
					$(".FormularioDadosCadastro").find("#valorItens").val(retorno.objeto.valorItens);
					$(".FormularioDadosCadastro").find("#valorDescontos").val(retorno.objeto.valorDescontos);
					$(".FormularioDadosCadastro").find("#valorTotal").val(retorno.objeto.valorTotal);
					
					formataInput($(".FormularioDadosCadastro").find("#valorItens"));
					formataInput($(".FormularioDadosCadastro").find("#valorDescontos"));
					formataInput($(".FormularioDadosCadastro").find("#valorTotal")); 
				});
				
			});
		});
	});
</script>
