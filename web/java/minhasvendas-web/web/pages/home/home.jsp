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
	
	<div class="wrapper row-offcanvas row-offcanvas-left">
		<%@include file="sidebar.jsp" %>
		
        <aside class="right-side page-content-body" data-load="dashboard.action">
			
        </aside>
        
        <footer class="footer" data-load="footer.action"></footer>
	</div>
</body>
</html>