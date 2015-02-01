<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="../../header-title.jsp"%>

<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="portlet box box-solid box-primary">
			
				<div class="box-header">
					 <h3 class="box-title">${subtitulo}</h3>
				</div>
				
				<div class="box-body">
					<div class="row">
						<div class="col-md-1 text-right">
							<label class="control-label text-right">Pesquisar por: </label>
						</div>
						
						<div class="col-sm-2">
							<select id="ParametroPesquisa" class="form-control input-circle">
								<option value="nome">Nome</option>
							</select>
						</div>
				
						<div class="col-sm-3">
							<input id="PesquisarPor" type="text" autofocus="autofocus" autocomplete="off" class="form-control input-circle" tabindex="3" />
						</div>
						
						<div class="col-sm-2">
							<select id="somenteAtivos" class="form-control input-circle">
								<option value="S">Somente ativos</option>
								<option value="N">Somente inativos</option>
								<option value="">Todos</option>
							</select>
						</div>
	
						<div class="col-sm-2 ">
							<button tabindex="4" title="Clique para pesquisar [Atalho: ENTER]" class="BotaoPesquisar btn btn-default"><i class="fa fa-search"></i> Pesquisar</button>
						</div>
					</div>
					
					<div class="table-scrollable">
						<div class="portlet">
							<div class="portlet-body">
								<div class="DataGridConsulta" data-page="localestoqueconsulta.grid.action" data-page-size="8" data-detail-page="localestoquecadastro.action"></div>
							</div>
						</div>
					</div>
					
					<%@include file="../../botoes-consulta.jsp"%>
				</div>
			</div>
		</div>
	</div>
</section>