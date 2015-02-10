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
					<div class="portlet-body form FormularioCadastro FormularioGeral" data-page-consulta="orcamentoconsulta.action" data-page-operacao="${operacao}" data-page-cadastro="orcamentocadastro.action">
						<form class="form-horizontal" action="#" role="form">
							<div class="form-body FormularioDadosCadastro">
								<input id="idOrcamento" type="hidden" value="${ vo.idOrcamento }" />
								<input id="idEmpresa" type="hidden" value="${ vo.idEmpresa }" />
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Cliente</label>
									<div class="col-sm-7">
										<input id="idCliente" type="hidden" autofocus="autofocus" class="form-control select2" value="${ vo.idCliente }" data-remote-source="orcamentocadastro.clientes.action" data-cadastro-rapido="clientecadastro.rapido.action"/>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Data Orçamento</label>
									<div class="col-sm-3">
										<input id="dataOrcamento" type="text" class="form-control input-circle" value="<fmt:formatDate value="${ vo.dataOrcamento.time }" pattern="dd/MM/yyyy"/>" data-field-type="date" />
									</div>
									
									<label class="col-sm-1 control-label text-right">Data Validade</label>
									<div class="col-sm-3">
										<input id="dataValidade" type="text" class="form-control input-circle" value="<fmt:formatDate value="${ vo.dataValidade.time }" pattern="dd/MM/yyyy"/>" data-field-type="date"/>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Vendedor</label>
									<div class="col-sm-7">
										<input id="idVendedor" type="hidden" class="form-control select2" value="${ vo.idVendedor }" data-remote-source="orcamentocadastro.vendedores.action" data-cadastro-rapido="vendedorcadastro.rapido.action"/>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Valor do Frete</label>
									<div class="col-sm-2">
										<div class="input-group">
											<input id="valorFrete" class="form-control input-circle text-right" data-field-type="number" data-field-precision="2" value="${vo.valorFrete}"/>
											<span class="input-group-addon">R$</span>
										</div>
									</div>
									<label class="col-sm-2 control-label text-right">Valor dos Itens</label>
									<div class="col-sm-2">
										<div class="input-group">
											<input id="valorItens" disabled="disabled" class="form-control input-circle text-right" data-field-type="number" data-field-precision="2" value="${vo.valorItens}"/>
											<span class="input-group-addon">R$</span>
										</div>
									</div>
								</div>
								
								<div class="form-group">
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
								
								<div class="box box-success init-collapsed">
	                                <div class="box-header">
	                                    <h3 class="box-title"><i class="fa fa-file-text-o"></i>&nbsp;&nbsp;&nbsp; Observações</h3>
	                                    <div class="box-tools pull-right">
	                                        <button type="button" class="btn btn-default btn-sm" data-widget="collapse"><i class="fa fa-plus"></i></button>
	                                    </div>
	                                </div><!-- /.box-header -->
	                                <div class="box-body">
	                                    <div class="row">
											<div class="form-group">
												<label class="col-sm-2 control-label text-right">Observações</label>
												<div class="col-sm-7">
													<textarea id="observacoes" class="form-control" rows="3" placeholder="">${vo.observacoes}</textarea>
												</div>
											</div>
	                                    </div><!-- /.row -->
	                                </div><!-- /.box-body -->
	                            </div>
	                            
	                            <!-- ITENS -->
								
								<div class="box">
									<div class="box-body">
										<div class="box-header">
											<h3 class="box-title"><i class="fa fa-cube"></i><span>&nbsp;&nbsp;&nbsp;&nbsp;Itens</span></h3>
										</div>
										
										<div class="box-body">
											<div class="row">
												<div class="col-xs-4">
													<label class="control-label text-right">Produto</label>
												</div>
												
												<div class="col-xs-1">
													<label class="control-label col-md-12 text-right">Qtd.</label>
												</div>
												
												<div class="col-xs-2">
													<label class="control-label col-md-12 text-right">Valor Unitário</label>
												</div>
												
												<div class="col-xs-2">
													<label class="control-label col-md-12 text-right">Valor Desconto</label>
												</div>
												
												<div class="col-xs-2 text-right">
													<label class="control-label col-md-12 text-right">Valor Total</label>
												</div>
												
												<div class="col-xs-1">
													&nbsp;
												</div>
												
											</div>
											
											<div class="row FormItens">
												<div class="col-xs-4">
													<input type="hidden" id="idProduto" class="form-control select2" data-remote-source="orcamentocadastro.produtos.action" data-cadastro-rapido="produtocadastro.rapido.action"/>
												</div>
												
												<div class="col-xs-1">
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
														<input id="valorDesconto" class="form-control input-circle text-right" data-field-type="number" data-field-precision="2" data-skip-enter="true" />
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
														<i class="fa fa-plus-circle"></i>
													</button>
												</div>
											</div>
											
											<div class="row">
												<div class="table-scrollable col-xs-12">
													<div class="box" style="margin-top: 20px;">
														<div class="box-body">
															<div class="DataGridConsulta" data-page="orcamentocadastro.grid.action" data-page-size="8" data-detail-page="orcamentocadastro.action"></div>
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
		function funcaoRefresh() {
			getVoSessao(function(retorno) {
				$(".FormularioDadosCadastro").find("#valorItens").val(retorno.objeto.valorItens);
				$(".FormularioDadosCadastro").find("#valorDescontos").val(retorno.objeto.valorDescontos);
				$(".FormularioDadosCadastro").find("#valorTotal").val(retorno.objeto.valorTotal);
				
				formataInput($(".FormularioDadosCadastro").find("#valorItens"));
				formataInput($(".FormularioDadosCadastro").find("#valorDescontos"));
				formataInput($(".FormularioDadosCadastro").find("#valorTotal")); 
			});
		}
		
		loadJs("web/js/item.js", function() {
			ItemHandler.init(funcaoRefresh);
			
			// Ao alterar o frete, também recalcula o total.
			$(".FormularioDadosCadastro").find("#valorFrete").on("blur", funcaoRefresh);
		});
	});
</script>
