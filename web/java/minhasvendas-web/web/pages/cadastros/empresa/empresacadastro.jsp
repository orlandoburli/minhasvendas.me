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
			
			<div class="portlet-body form FormularioCadastro FormularioGeral" data-page-consulta="empresaconsulta.action" data-page-operacao="${operacao}" data-page-cadastro="empresacadastro.action">
				<form class="form-horizontal" action="#" role="form">
					<div class="form-body">
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Código</label>
							<div class="col-sm-7">
								<input id="idEmpresa" type="text" disabled="disabled"  class="form-control input-circle" value="${ vo.idEmpresa }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Razão Social</label>
							<div class="col-sm-7">
								<input id="razaoSocial" type="text"  autofocus="autofocus" class="form-control input-circle" value="${ vo.razaoSocial }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Fantasia</label>
							<div class="col-sm-7">
								<input id="fantasia" type="text"   class="form-control input-circle" value="${ vo.fantasia }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Email</label>
							<div class="col-sm-7">
								<input id="email" type="text"   class="form-control input-circle" value="${ vo.email }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Tipo</label>
							<div class="col-sm-7">
								<select id="tipo" class="form-control input-circle">
									<option <c:if test="${ vo.tipo == 'F'}">selected="selected"</c:if> value="F">Física</option>
									<option <c:if test="${ vo.tipo == 'J'}">selected="selected"</c:if> value="J">Jurídica</option>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Senha</label>
							<div class="col-sm-7">
								<input id="senha" type="text"   class="form-control input-circle" value="${ vo.senha }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Data de Cadastro</label>
							<div class="col-sm-7">
								<input id="dataCadastro" type="text"   class="form-control input-circle" value="${ vo.dataCadastro }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Email confirmado</label>
							<div class="col-sm-7">
								<select id="flagEmailConfirmado" class="form-control input-circle">
									<option <c:if test="${ vo.flagEmailConfirmado == 'S'}">selected="selected"</c:if> value="S">Sim</option>
									<option <c:if test="${ vo.flagEmailConfirmado == 'N'}">selected="selected"</c:if> value="N">Não</option>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">hash</label>
							<div class="col-sm-7">
								<input id="hash" type="text"   class="form-control input-circle" value="${ vo.hash }" />
							</div>
						</div>
						
						<%@include file="../../botoes-cadastro.jsp"%>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>