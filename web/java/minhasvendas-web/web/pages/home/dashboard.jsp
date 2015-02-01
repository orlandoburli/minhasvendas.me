<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="pt_BR"/>

	<section class="content-header">
		<div class="alert alert-warning alert-dismissable">
            <i class="fa fa-warning"></i>
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <b>Alerta!</b> Você ainda não configurou os parâmetros de vendas. Para configurar, <a href="#">clique aqui!</a>
        </div>
	    <h1>
	        Dashboard
	        <small>Painel de Controle</small>
	    </h1>
	</section>
<section class="content">
<div class="row">
    <div class="col-lg-3 col-xs-6">
        <!-- small box -->
        <div class="small-box bg-aqua">
            <div class="inner">
                <h3>
                    ${quantidadeReceber}
                </h3>
                <p>
                    Novas Vendas
                </p>
            </div>
            <div class="icon">
                <i class="ion ion-bag"></i>
            </div>
            <a href="#" class="small-box-footer">
                Mais informações <i class="fa fa-arrow-circle-right"></i>
            </a>
        </div>
    </div><!-- ./col -->
    <div class="col-lg-3 col-xs-6">
        <!-- small box -->
        <div class="small-box bg-green">
            <div class="inner">
                <h3>
                    53<sup style="font-size: 20px">%</sup>
                </h3>
                <p>
                    Aumento Vendas
                </p>
            </div>
            <div class="icon">
                <i class="ion ion-stats-bars"></i>
            </div>
            <a href="#" class="small-box-footer">
                Mais informações <i class="fa fa-arrow-circle-right"></i>
            </a>
        </div>
    </div><!-- ./col -->
    <div class="col-lg-3 col-xs-6">
        <!-- small box -->
        <div class="small-box bg-yellow">
            <div class="inner">
                <h3>
                    44
                </h3>
                <p>
                    Clientes Cadastrados
                </p>
            </div>
            <div class="icon">
                <i class="ion ion-person-add"></i>
            </div>
            <a href="#" class="small-box-footer">
                Mais informações <i class="fa fa-arrow-circle-right"></i>
            </a>
        </div>
    </div><!-- ./col -->
    <div class="col-lg-3 col-xs-6">
        <!-- small box -->
        <div class="small-box bg-red">
            <div class="inner">
                <h3>
                    65
                </h3>
                <p>
                    Acessos ao EVS
                </p>
            </div>
            <div class="icon">
                <i class="ion ion-pie-graph"></i>
            </div>
            <a href="#" class="small-box-footer">
                Mais informações 	<i class="fa fa-arrow-circle-right"></i>
            </a>
        </div>
    </div><!-- ./col -->
</div>

</section>
<script type="text/javascript">
$("a").click(function(e) {
	var dataLink = $(this).attr("href");
	
	if (dataLink != null && dataLink != '' && dataLink != 'javascript:;') {
		e.preventDefault();
		loadDataLink(dataLink, this);
	}
});
</script>