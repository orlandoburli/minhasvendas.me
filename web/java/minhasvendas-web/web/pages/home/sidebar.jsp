<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

			<!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="/minhasvendas-assets/lte/img/avatar3.png" class="img-circle" alt="User Image" />
                        </div>
                        <div class="pull-left info">
                            <p>Hello, Jane</p>

                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>
                    <!-- search form -->
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Buscar..."/>
                            <span class="input-group-btn">
                                <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                            </span>
                        </div>
                    </form>
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <c:forEach items="${menus}" var="menu">
                        	<c:if test="${menu.subMenus.size() <= 0 }">
								<li>
									<a class="${menu.classe }" href="${menu.objeto.url}">${menu.nome}</a>
								</li>
						  	</c:if>
						  	<c:if test="${menu.subMenus.size() > 0 }">
								<li class="treeview">
						        	<a href="#">
		                                <i class="${menu.classe}"></i>
		                                <span>${menu.nome}</span>
		                                <i class="fa fa-angle-left pull-right"></i>
		                            </a>
						        	
						        	<ul class="treeview-menu">
						        		<c:forEach items="${menu.subMenus}" var="submenu">
			                                <li><a href="${submenu.objeto.url}"><i class="fa fa-angle-double-right"></i> ${submenu.nome}</a></li>
										</c:forEach>
						        	</ul>
						        </li>
							</c:if>
                        </c:forEach>
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>