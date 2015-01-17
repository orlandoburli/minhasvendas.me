<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

 <nav class="navbar navbar-default navbar-static-top">
  <div class="container-fluid container">

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        
      <c:forEach items="${menus}" var="menu">
	  <c:if test="${menu.subMenus.size() <= 0 }">
		<li>
			<a href="${menu.objeto.url}">${menu.nome}</a>
		</li>
	  </c:if>
		<c:if test="${menu.subMenus.size() > 0 }">
			<li class="dropdown">
	        	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${menu.nome } <span class="caret"></span></a>
	        	<ul class="dropdown-menu" role="menu">
	        		<c:forEach items="${menu.subMenus}" var="submenu">
	        			<c:if test="${submenu.nome == 'SEPARADOR'}">
	        			<li class="divider"></li>
	        			</c:if>
	        			<c:if test="${submenu.nome != 'SEPARADOR'}">
						<li><a href="${submenu.objeto.url}">${submenu.nome} </a></li>
						</c:if>
					</c:forEach>
	        	</ul>
	        </li>
		</c:if>
	  </c:forEach>
      </ul>
        
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Empresa: ${empresa.fantasia}</a></li>
        <li class="divider"></li>
        <li><a href="logoff.action">Sair</a></li>
      </ul>
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>