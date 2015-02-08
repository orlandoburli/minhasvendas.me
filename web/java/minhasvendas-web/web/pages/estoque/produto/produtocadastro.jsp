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
					<div class="portlet-body form FormularioCadastro FormularioGeral" data-page-consulta="produtoconsulta.action" data-page-operacao="${operacao}" data-page-cadastro="produtocadastro.action">
						<form class="form-horizontal" action="#" role="form">
							<div class="form-body">
								<input id="idProduto" type="hidden" value="${ vo.idProduto }" />
								<input id="idEmpresa" type="hidden" value="${ vo.idEmpresa }" />
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Código do Produto</label>
									<div class="col-sm-7">
										<input id="codigoProduto" type="text" autofocus="autofocus" class="form-control input-circle" value="${ vo.codigoProduto }" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Nome</label>
									<div class="col-sm-7">
										<input id="nome" type="text" class="form-control input-circle" value="${ vo.nome }" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Valor de venda</label>
									<div class="col-sm-7">
										<input id="valorVenda" type="text" class="form-control input-circle" value="${ vo.valorVenda }" data-field-type="number" data-field-precision="2"/>
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
								
								<div class="form-group">
									<label class="col-sm-2 control-label text-right">Categoria</label>
									<div class="col-sm-7">
										<select id="idCategoriaProduto" class="form-control input-circle">
											<option>[NENHUMA CATEGORIA SELECIONADA]</option>
											<c:forEach items="${categorias }" var="categoria">
												<option <c:if test="${ vo.idCategoriaProduto == categoria.idCategoria}">selected="selected"</c:if> value="${categoria.idCategoria }">${categoria.nome}</option>
											</c:forEach>
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