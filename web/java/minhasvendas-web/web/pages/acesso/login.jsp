<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="product" content="Minhas Vendas.me">
    <meta name="description" content="Minhas Vendas - Sistema de Gestão de Vendas para micro e pequenas empresas">
    <meta name="author" content="Orlando Burli Junior, Gustavo Santos Arruda">
    
	<%@include file="../header-includes.jsp" %>
	
	<script src="web/js/login.js"></script>
    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${tituloApp}</title>
	
</head>
<body>
    <div class="container" style="width: 400px; margin-top: 100px;">

        <h1>
            <i class="glyphicon glyphicon-user"></i> Login <small> Minhas Vendas</small>
        </h1>

        <div class="panel panel-primary">

            <div class="panel-heading">
                <h3 class="panel-title">Informe os dados para acesso</h3>
            </div>
            <div class="panel-body">

                <label>Email</label> 
                <input id="email" type="email" placeholder="Informe o seu email" autofocus="autofocus" value="${login_cookie}" class="form-control" /> 
                
                <label>Senha</label> 
                <input id="senha" type="password" placeholder="Informe a sua senha" class="form-control" autocomplete="off" /> 
                
                <label> 
                	<input id="lembrarSenha" type="checkbox" value="1" /> Lembrar login
                </label>

                <button id="entrar" class="btn btn-lg btn-primary btn-block">
                    Entrar <i class="icon-enter-2 on-right on-left"></i>
                </button>
            </div>
        </div>
    </div>
</body>
</html>