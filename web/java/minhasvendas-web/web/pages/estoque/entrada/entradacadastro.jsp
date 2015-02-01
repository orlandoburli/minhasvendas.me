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
							<div class="form-body">
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
									<div class="col-sm-3">
										<input id="dataEmissaoDocumento" type="text" class="form-control input-circle" value="<fmt:formatDate value="${ vo.dataEmissaoDocumento.time }" pattern="dd/MM/yyyy"/>" data-field-type="date" />
									</div>
									<label class="col-sm-1 control-label text-right">Status</label>
									
									<input id="status" type="hidden" value="${vo.status }">
									
									<div class="col-sm-3">
										<input id="statusDesc" type="text" disabled="disabled" class="form-control input-circle" value="${ vo.statusDesc }" />	
									</div>
								</div>
								
								<div>
									<div class="portlet">
										<div class="portlet-title">
											<div class="caption">
												<i class="fa "></i>Itens
											</div>
										</div>
										<div class="portlet-body">
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label text-right">Produto</label>
															<input id="idProduto" class="form-control input-circle autocomplete" data-remote-source="entradacadastro.produtos.action"/>
														</div>
													</div>
													
													<div class="col-md-2">
														<div class="form-group">
															<label class="control-label col-md-12 text-right">Qtd.</label>
															<input id="quantidade" class="form-control input-circle text-right" data-field-type="number" data-field-precision="0" />
														</div>
													</div>
													
													<div class="col-md-2">
														<div class="form-group">
															<label class="control-label col-md-12 text-right">Valor de Compra</label>
															<input id="valorCompra" class="form-control input-circle text-right" data-field-type="number" data-field-precision="2" />
														</div>
													</div>
													
													<div class="col-md-2">
														<div class="form-group">
															<label class="control-label col-md-12 text-right">&nbsp;</label>
															<button type="button" class="BotaoAdicionarItem btn  btn-primary tooltips" title="Novo Registro (Ctrl + N)">
																<i class="fa fa-plus-circle"></i> Adicionar Item
															</button>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								
								<div class="table-scrollable">
									<div class="portlet">
										<div class="portlet-body">
											<div class="DataGridConsulta" data-page="entradacadastro.grid.action" data-page-size="8" data-detail-page="entradacadastro.action"></div>
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
	
	<script type="text/javascript">
	
		function limparCamposItem() {
			$("#idProduto").val("");
			$("#quantidade").val("1");
			$("#valorCompra").val("");
		}
		
		if (browser.mozilla) {
			$("#valorCompra").keypress(keySalvar);
		} else {
			$("#valorCompra").keydown(keySalvar);
		}
	
		function keySalvar(event) {
			if (event.keyCode == 13) {
				adicionarItem();
			}
		}
		
		function adicionarItem() {
			// Se tiver alguma requisicao rolando, nao executa.
			if ($.active > 0) {
				return;
			}
			
			var params = {
				idProduto : $("#idProduto").attr("data-value"),
				quantidade : $("#quantidade").val(),
				valorCompra : $("#valorCompra").val()
			};
			
			$.ajax({
				url : 'entradacadastro.adicionaritem.action',
				type : 'POST',
				data : params,
				beforeSend : function(data) { },
				success : function(data) {
	
					var retorno = $.parseJSON(data);
	
					if (retorno.sucesso) {
						mensagemInfo(retorno.mensagem);
						limparCamposItem();
						loadDataGrid(setRemoverItem);
						$("#idProduto").focus();
					} else {
						mensagemErro(retorno.mensagem);
						$("#" + retorno.fieldFocus).focus();
					}
				},
				error : function(erro) {
					console.log("Erro no load ajax! " + erro);
				}
			});
		}
		
		function alterarItem(campo) {
			// Se tiver alguma requisicao rolando, nao executa.
			if ($.active > 0) {
				return;
			}
			
			var _quantidade = "";
			var _valorCompra = "";
			
			// Verifica qual campo está sendo atualizado
			if (campo.hasClass("item-quantidade")) {
				_quantidade = campo.val();
				_valorCompra = campo.closest("tr").find(".item-valor-compra").val();
			} else if (campo.hasClass("item-valor-compra")) {
				_quantidade = campo.closest("tr").find(".item-quantidade").val();
				_valorCompra = campo.val(); 
			}
			
			var params = {
				index : $(campo).closest("tr").attr("data-index"),
				quantidade : _quantidade,
				valorCompra : _valorCompra
			};
			
			$.ajax({
				url : 'entradacadastro.editaritem.action',
				type : 'POST',
				data : params,
				beforeSend : function(data) { },
				success : function(data) {
	
					var retorno = $.parseJSON(data);
	
					if (retorno.sucesso) {
						// Se deu certo, nao precisa avisar nada...
						/* mensagemInfo(retorno.mensagem); */
					} else {
						mensagemErro(retorno.mensagem);
						$("#" + retorno.fieldFocus).focus();
					}
				},
				error : function(erro) {
					console.log("Erro no load ajax! " + erro);
				}
			});
		}
		
		function removerItem(indexParam) {
			
			if (!confirm("Confirma exclusão deste item?")) {
				return;
			}
			
			// Se tiver alguma requisicao rolando, nao executa.
			if ($.active > 0) {
				return;
			}
			
			var params = {
				index : indexParam
			};
			
			$.ajax({
				url : 'entradacadastro.removeritem.action',
				type : 'POST',
				data : params,
				beforeSend : function(data) { },
				success : function(data) {
					
					var retorno = $.parseJSON(data);
					
					if (retorno.sucesso) {
						mensagemInfo(retorno.mensagem);
						limparCamposItem();
						loadDataGrid(setRemoverItem);
						$("#idProduto").focus();
					} else {
						mensagemErro(retorno.mensagem);
						$("#" + retorno.fieldFocus).focus();
					}
				},
				error : function(erro) {
					console.log("Erro no load ajax! " + erro);
				}
			});
		}
		
		$(".BotaoAdicionarItem").click(function() {
			adicionarItem();
		});
		
		
		function setRemoverItem() {
			$(".BotaoRemoverItem").click(function() {
				removerItem($(this).attr("data-index"));
			});
			
			$(".item-quantidade,.item-valor-compra").blur(function() {
				alterarItem($(this));
			});
		}
		
		$(document).ready(function() {
			loadJs("web/js/item.js");
			
			setTimeout(function() {
				limparCamposItem();
				loadDataGrid(setRemoverItem);
			}, 1000);
		});
		
	
	</script>
</section>