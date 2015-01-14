<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../header-title.jsp"%>

<div class="row">
	
	<div class="col-md-12">
		<div class="portlet box blue-hoki">
		
			<div class="portlet-title">
				<div class="caption">
					<i class="fa "></i>${subtitulo}
				</div>
			</div>
			
			<div class="portlet-body form FormularioCadastro FormularioGeral" data-page-consulta="categoriaconsulta.action" data-page-operacao="${operacao}" data-page-cadastro="categoriacadastro.action">
				
			</div>
		</div>
	</div>
</div>