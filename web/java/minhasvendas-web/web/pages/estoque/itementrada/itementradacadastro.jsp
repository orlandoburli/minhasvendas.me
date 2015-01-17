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
			
			<div class="portlet-body form FormularioCadastro FormularioGeral" data-page-consulta="itementradaconsulta.action" data-page-operacao="${operacao}" data-page-cadastro="itementradacadastro.action">
				<form class="form-horizontal" action="#" role="form">
					<div class="form-body">
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">idItemEntrada</label>
							<div class="col-sm-7">
								<input id="idItemEntrada" type="text" disabled="disabled"  class="form-control input-circle" value="${ vo.idItemEntrada }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">idEntrada</label>
							<div class="col-sm-7">
								<input id="idEntrada" type="text"  autofocus="autofocus" class="form-control input-circle" value="${ vo.idEntrada }" />
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
							<label class="col-sm-2 control-label text-right">Valor de Compra</label>
							<div class="col-sm-7">
								<input id="valorCompra" type="text"   class="form-control input-circle" value="${ vo.valorCompra }" />
							</div>
						</div>
						
						<%@include file="../../botoes-cadastro.jsp"%>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>