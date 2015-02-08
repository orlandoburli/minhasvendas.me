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
							<div class="form-body">
								
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
									<label class="col-sm-2 control-label text-right">Valor Itens</label>
									<div class="col-sm-3">
										<input id="valorItens" type="text" disabled="disabled"  class="form-control input-circle" value="${ vo.valorItens }" data-field-type="number" data-field-precision="2"/>
									</div>
									
									<label class="col-sm-1 control-label text-right">Valor Desconto</label>
									<div class="col-sm-3">
										<input id="valorDesconto" type="text" disabled="disabled"  class="form-control input-circle" value="${ vo.valorDesconto }" data-field-type="number" data-field-precision="2"/>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Valor Total</label>
									<div class="col-sm-3">
										<input id="valorTotal" type="text" disabled="disabled" class="form-control input-circle" value="${ vo.valorTotal }" data-field-type="number" data-field-precision="2"/>
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
								
								<%@include file="../../botoes-cadastro.jsp"%>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>