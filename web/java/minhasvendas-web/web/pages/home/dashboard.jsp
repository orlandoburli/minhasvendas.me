<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="pt_BR"/>

<div class="row">
	<div class="col-md-12">
		<h3 class="page-title">
			Seja bem vindo, ${usuario.razaoSocial}
		</h3>
	</div>
</div>

<div class="row">
	<div class="col-md-12">
		<ul class="page-breadcrumb breadcrumb">
			<li>
				<i class="fa fa-money"></i>
				<a href="javascript:;">Financeiro</a>
			</li>
		</ul>
	</div>
</div>

<div class="row">
	<div class="col-md-4">
		<div class="dashboard-stat green-seagreen">
			<div class="visual">
				<i class="fa fa-dollar"></i>
			</div>
			<div class="details">
				<div class="number">
					 
					 <fmt:formatNumber value="${valorReceber}" type="currency"/>
				</div>
				<div class="desc">
					 Em ${quantidadeReceber} Contas a Receber
				</div>
			</div>
			<a class="more" href="entradaconsulta.action">
				Ver mais <i class="m-icon-swapright m-icon-white"></i>
			</a>
		</div>
	</div>
	
	<div class="col-md-4">
		<div class="dashboard-stat red-pink">
			<div class="visual">
				<i class="fa fa-dollar"></i>
			</div>
			<div class="details">
				<div class="number">
					 
					 <fmt:formatNumber value="${valorPagar}" type="currency"/>
				</div>
				<div class="desc">
					 Em ${quantidadePagar} Contas a Pagar
				</div>
			</div>
			<a class="more" href="entradaconsulta.action">
				Ver mais <i class="m-icon-swapright m-icon-white"></i>
			</a>
		</div>
	</div>
</div>


<div class="row">
	<div class="col-md-12">
		<ul class="page-breadcrumb breadcrumb">
			<li>
				<i class="fa fa-cubes"></i>
				<a href="javascript:;">Estoque</a>
			</li>
		</ul>
	</div>
</div>

<div class="row">
	<div class="col-md-4">
		<div class="dashboard-stat blue-madison">
			<div class="visual">
				<i class="fa fa-cubes"></i>
			</div>
			<div class="details">
				<div class="number">
					 ${novasEntradas}
				</div>
				<div class="desc">
					 Novas Entradas de Mercadoria
				</div>
			</div>
			<a class="more" href="entradaconsulta.action">
				Ver mais <i class="m-icon-swapright m-icon-white"></i>
			</a>
		</div>
	</div>
	
	<div class="col-md-4">
		<div class="dashboard-stat blue-ebonyclay">
			<div class="visual">
				<i class="fa fa-exchange"></i>				
			</div>
			<div class="details">
				<div class="number">
					 ${novasTransferencias}
				</div>
				<div class="desc">
					 Novas Transferências 
				</div>
			</div>
			<a class="more" href="#">
				Ver mais <i class="m-icon-swapright m-icon-white"></i>
			</a>
		</div>
	</div>
	
	<div class="col-md-4">
		<div class="dashboard-stat blue-hoki">
			<div class="visual">
				<i class="fa fa-mail-reply-all"></i>				
			</div>
			<div class="details">
				<div class="number">
					 ${novasDevolucoes}
				</div>
				<div class="desc">
					 Novas Devoluções
				</div>
			</div>
			<a class="more" href="#">
				Ver mais <i class="m-icon-swapright m-icon-white"></i>
			</a>
		</div>
	</div>
	
</div>

<script type="text/javascript">
$("a").click(function(e) {
	var dataLink = $(this).attr("href");
	
	if (dataLink != null && dataLink != '' && dataLink != 'javascript:;') {
		e.preventDefault();
		loadDataLink(dataLink, this);
	}
});
</script>