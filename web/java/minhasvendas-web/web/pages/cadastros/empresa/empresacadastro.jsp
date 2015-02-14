<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="titulo" value="Empresa"/>
<c:set var="subtitulo" value="Dados da Empresa"/>
<c:set var="subMenu" value="Geral"/>
<c:set var="menuAtivo" value="Empresa"/>

<%@include file="../../header-title.jsp"%>

<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="portlet box box-solid box-primary">
			
				<div class="box-header">
					<h3 class="box-title">Dados da Empresa</h3>
				</div>
				
				<div class="box-body">
					<div class="portlet-body form FormularioCadastro FormularioGeral" data-page-consulta="dashboard.action" data-page-operacao="${operacao}" data-page-cadastro="empresacadastro.action">
						<form class="form-horizontal" action="#" role="form">
							<div class="form-body">
							
								<input id="idEmpresa" type="hidden" disabled="disabled"  class="form-control input-circle" value="${ vo.idEmpresa }" />
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Razão Social</label>
									<div class="col-sm-3">
										<input id="razaoSocial" type="text"  autofocus="autofocus" class="form-control input-circle" value="${ vo.razaoSocial }" />
									</div>
									<label class="col-sm-1 control-label text-right">Fantasia</label>
									<div class="col-sm-3">
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
									<div class="col-sm-3">
										<select id="tipo" class="form-control input-circle">
											<option <c:if test="${ vo.tipo == 'F'}">selected="selected"</c:if> value="F">Física</option>
											<option <c:if test="${ vo.tipo == 'J'}">selected="selected"</c:if> value="J">Jurídica</option>
										</select>
									</div>
									<label class="col-sm-2 control-label text-right">Data de Cadastro</label>
									<div class="col-sm-2">
										<input type="text" disabled="disabled" class="form-control input-circle" value="<fmt:formatDate value="${ vo.dataCadastro.time }" pattern="dd/MM/yyyy hh:mm:ss"/>" data-field-type="date" />
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