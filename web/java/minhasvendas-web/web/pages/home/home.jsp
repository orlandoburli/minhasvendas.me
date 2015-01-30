<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="product" content="Minhas Vendas.me">
    <meta name="description" content="Minhas Vendas - Sistema de Gestão de Vendas para micro e pequenas empresas">
    <meta name="author" content="Orlando Burli Junior, Gustavo Santos Arruda">

	<%@include file="../header-includes.jsp" %>	    

    <script src="web/js/minhasvendas.js"></script>
        
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${tituloApp}</title>
	
</head>
<body class="skin-blue">
	<header class="header">
		<%@include file="header.jsp" %>
	</header>
	
<!-- 	<div class="container page-content">
		<div class="page-content-body" data-load="dashboard.action">
		</div>
	</div>
	
	<footer class="footer" data-load="footer.action"></footer> -->
	
	<div class="wrapper row-offcanvas row-offcanvas-left">
		<%@include file="sidebar.jsp" %>
		
		<!-- Right side column. Contains the navbar and content of the page -->
        <aside class="right-side page-content-body" data-load="dashboard.action">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    Blank page
                    <small>it all starts here</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li><a href="#">Examples</a></li>
                    <li class="active">Blank page</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content" >

            </section><!-- /.content -->
        </aside><!-- /.right-side -->
	</div>
</body>
</html>