<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="FormularioBotoes form-actions right row">
	
	<div class="text-left col-md-6">
		<c:if test="${empty hideNavigation}">
		<button class="BotaoNavegacaoPrimeiro btn btn-default btn-icon tooltips" title="Primeiro [Home]">
			<i class="fa fa-angle-double-left"></i>
		</button>
		<button class="BotaoNavegacaoAnterior btn btn-default btn-icon tooltips" title="Anterior [&larr;/PgUp]">
			<i class="fa fa-angle-left"></i>
		</button>
		<button class="BotaoNavegacaoProximo btn btn-default btn-icon tooltips" title="Próximo [&rarr;/PgDown]">
			<i class="fa fa-angle-right"></i>
		</button>
		<button class="BotaoNavegacaoUltimo btn btn-default btn-icon tooltips" title="Último [End]">
			<i class="fa fa-angle-double-right"></i>
		</button>
		</c:if>
	</div>
	
	<div class="text-right col-md-6">
	
		${customButtons}
	
		<c:if test="${empty hideNovo}">
			<button type="button" class="BotaoNovo btn  btn-primary tooltips" title="Novo Registro (Ctrl + N)">
				<i class="fa fa-plus-circle"></i> Novo
			</button>
		</c:if>
	
		<c:if test="${empty hideEditar}">
			<button type="button" class="BotaoEditar btn  btn-success tooltips" title="Editar Registro Selecionado (Ctrl + E)">
				<i class="fa fa-edit"></i> Editar
			</button>
		</c:if>
		
		<c:if test="${empty hideExcluir}">
			<button type="button" class="BotaoExcluir btn  btn-danger tooltips" title="Excluir Registro Selecionado (Ctrl + Del)">
				<i class="fa fa-trash-o"></i> Excluir
			</button>
		</c:if>
	</div>
</div>