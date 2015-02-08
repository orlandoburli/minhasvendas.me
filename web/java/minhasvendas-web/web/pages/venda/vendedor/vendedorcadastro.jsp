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
					<div class="portlet-body form FormularioCadastro FormularioGeral" data-page-consulta="vendedorconsulta.action" data-page-operacao="${operacao}" data-page-cadastro="vendedorcadastro.action">
						<form class="form-horizontal" action="#" role="form">
							<div class="form-body">
								<input id="idVendedor" type="hidden" value="${ vo.idVendedor }" />
								<input id="idEmpresa" type="hidden" value="${ vo.idEmpresa }" />
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Nome</label>
									<div class="col-sm-7">
										<input id="nome" type="text"  autofocus="autofocus" class="form-control input-circle" value="${ vo.nome }" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Categoria</label>
									<div class="col-sm-7">
										<select id="idCategoriaVendedor" class="form-control input-circle">
											<option>[SELECIONE A CATEGORIA DO VENDEDOR]</option>
											<c:forEach items="${categorias}" var="categoria">
												<option <c:if test="${ vo.idCategoriaVendedor == categoria.idCategoriaVendedor}">selected="selected"</c:if> value="${categoria.idCategoriaVendedor}">${categoria.nome}</option>	
											</c:forEach>
										</select>
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
	</div>
</section>