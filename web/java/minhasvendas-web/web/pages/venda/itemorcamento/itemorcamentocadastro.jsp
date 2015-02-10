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
					<div class="portlet-body form FormularioCadastro FormularioGeral" data-page-consulta="itemorcamentoconsulta.action" data-page-operacao="${operacao}" data-page-cadastro="itemorcamentocadastro.action">
						<form class="form-horizontal" action="#" role="form">
							<div class="form-body">
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">idItemOrcamento</label>
									<div class="col-sm-7">
										<input id="idItemOrcamento" type="text" disabled="disabled"  class="form-control input-circle" value="${ vo.idItemOrcamento }" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Orçamento</label>
									<div class="col-sm-7">
										<input id="idOrcamento" type="text"  autofocus="autofocus" class="form-control input-circle" value="${ vo.idOrcamento }" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Produto</label>
									<div class="col-sm-7">
										<input id="idProduto" type="text"   class="form-control input-circle" value="${ vo.idProduto }" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Quantidade</label>
									<div class="col-sm-7">
										<input id="quantidade" type="text"   class="form-control input-circle" value="${ vo.quantidade }" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Valor Unitário</label>
									<div class="col-sm-7">
										<input id="valorUnitario" type="text"   class="form-control input-circle" value="${ vo.valorUnitario }" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Valor Desconto</label>
									<div class="col-sm-7">
										<input id="valorDesconto" type="text"   class="form-control input-circle" value="${ vo.valorDesconto }" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">valorTotal</label>
									<div class="col-sm-7">
										<input id="valorTotal" type="text"   class="form-control input-circle" value="${ vo.valorTotal }" />
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