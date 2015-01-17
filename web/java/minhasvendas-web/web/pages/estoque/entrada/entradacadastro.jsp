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
								<input id="serie" type="text"   class="form-control input-circle" value="${ vo.serie }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Data de Emissão</label>
							<div class="col-sm-3">
								<input id="dataEmissaoDocumento" type="text" class="form-control input-circle" value="${ vo.dataEmissaoDocumento }" data-field-type="date" />
							</div>
							<label class="col-sm-1 control-label text-right">Status</label>
							
							<input id="status" type="hidden" value="${vo.status }">
							
							<div class="col-sm-3">
								<input id="statusDesc" type="text" disabled="disabled" class="form-control input-circle" value="${ vo.statusDesc }" />	
							</div>
						</div>
						
						<%@include file="../../botoes-cadastro.jsp"%>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>