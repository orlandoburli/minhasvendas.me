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
			
			<div class="portlet-body form FormularioCadastro FormularioGeral" data-page-consulta="categoriaprodutoconsulta.action" data-page-operacao="${operacao}" data-page-cadastro="categoriaprodutocadastro.action">
				<form class="form-horizontal" action="#" role="form">
					<div class="form-body">
						<input id="idCategoria" type="hidden" value="${ vo.idCategoria }" />
						<input id="idEmpresa" type="hidden" value="${ vo.idEmpresa }" />
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Nome</label>
							<div class="col-sm-7">
								<input id="nome" type="text"  autofocus="autofocus" class="form-control input-circle" value="${ vo.nome }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Ativo</label>
							<div class="col-sm-7">
								<select id="ativo" class="form-control input-circle">
									<option <c:if test="${ vo.ativo == 'S'}">selected="selected"</c:if> value="S">Sim</option>
									<option <c:if test="${ vo.ativo == 'N'}">selected="selected"</c:if> value="N">Não</option>
								</select>
							</div>
						</div>
						
						<%@include file="../../botoes-cadastro.jsp"%>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>