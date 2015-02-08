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
					<div class="portlet-body form FormularioCadastro FormularioGeral" data-page-consulta="fornecedorconsulta.action" data-page-operacao="${operacao}" data-page-cadastro="fornecedorcadastro.action">
						<form class="form-horizontal" action="#" role="form">
							<div class="form-body">
								
								<input id="idFornecedor" type="hidden" value="${ vo.idFornecedor }" />
								<input id="idEmpresa" type="hidden" value="${ vo.idFornecedor }" />
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Nome</label>
									<div class="col-sm-7">
										<input id="nome" type="text"  autofocus="autofocus" class="form-control input-circle" value="${ vo.nome }" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Razão Social</label>
									<div class="col-sm-7">
										<input id="razaoSocial" type="text"   class="form-control input-circle" value="${ vo.razaoSocial }" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Cpf / Cnpj</label>
									<div class="col-sm-3">
										<input id="cpfCnpj" type="text"   class="form-control input-circle" value="${ vo.cpfCnpj }" data-field-type="cpfcnpj"/>
									</div>
									
									<label class="col-sm-1 control-label text-right">Fone 1</label>
									<div class="col-sm-3">
										<input id="fone01" type="text"   class="form-control input-circle" value="${ vo.fone01 }" data-field-type="fone"/>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Fone 2</label>
									<div class="col-sm-3">
										<input id="fone02" type="text"   class="form-control input-circle" value="${ vo.fone02 }" data-field-type="fone"/>
									</div>
									
									<label class="col-sm-1 control-label text-right">Fone 3</label>
									<div class="col-sm-3">
										<input id="fone03" type="text"   class="form-control input-circle" value="${ vo.fone03 }" data-field-type="fone"/>
									</div>
								</div>
								
								<div class="box box-success init-collapsed">
	                                <div class="box-header">
	                                    <h3 class="box-title"><i class="fa fa-file-text-o"></i>&nbsp;&nbsp;&nbsp; Observações</h3>
	                                    <div class="box-tools pull-right">
	                                        <button type="button" class="btn btn-default btn-sm" data-widget="collapse"><i class="fa fa-plus"></i></button>
	                                    </div>
	                                </div>
	                                <div class="box-body">
	                                    <div class="row">
											<div class="form-group">
												<label class="col-sm-2 control-label text-right">Observações</label>
												<div class="col-sm-7">
													<textarea id="observacoes" class="form-control" rows="8" placeholder="">${vo.observacoes}</textarea>
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