/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.57
 * Generated at: 2015-01-14 21:50:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.web.pages.acesso;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/web/pages/acesso/../header-includes.jsp", Long.valueOf(1421265271000L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"pt-BR\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta name=\"product\" content=\"Minhas Vendas.me\">\n");
      out.write("    <meta name=\"description\" content=\"Minhas Vendas - Sistema de Gestão de Vendas para micro e pequenas empresas\">\n");
      out.write("    <meta name=\"author\" content=\"Orlando Burli Junior, Gustavo Santos Arruda\">\n");
      out.write("    \n");
      out.write("\t");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/minhasvendas-assets/bootstrap/3.3.1/css/bootstrap.min.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/minhasvendas-assets/bootstrap/3.3.1/css/bootstrap-theme.min.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/minhasvendas-assets/bootstrap/3.3.1/css/sticky-footer-navbar.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/minhasvendas-assets/bootstrap/3.3.1/css/jasny-bootstrap.min.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/minhasvendas-assets/bootstrap/3.3.1/css/components.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/minhasvendas-assets/bootstrap/3.3.1/css/minhasvendas.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/minhasvendas-assets/font-awesome/css/font-awesome.min.css\" />\n");
      out.write("\n");
      out.write("<script src=\"/minhasvendas-assets/bootstrap/3.3.1/js/jquery-2.1.1.min.js\"></script>\n");
      out.write("<script src=\"/minhasvendas-assets/bootstrap/3.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"/minhasvendas-assets/bootstrap/3.3.1/js/jquery-bs3Alert.min.js\"></script>\n");
      out.write("<script src=\"/minhasvendas-assets/bootstrap/3.3.1/js/jasny-bootstrap.min.js\"></script>\n");
      out.write("<script src=\"/minhasvendas-assets/bootstrap/3.3.1/js/jquery.bootstrap-growl.min.js\"></script>\n");
      out.write("<script src=\"/minhasvendas-assets/bootstrap/3.3.1/js/jquery.blockUI.js\"></script>\n");
      out.write("<script src=\"/minhasvendas-assets/bootstrap/3.3.1/js/jquery.price_format.2.0.min.js\"></script>\n");
      out.write("<script src=\"/minhasvendas-assets/bootstrap/3.3.1/js/jquery.mask.min.js\"></script>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/web/js/geral.js\"></script>\n");
      out.write("\n");
      out.write("\t\n");
      out.write("\t<script src=\"web/js/login.js\"></script>\n");
      out.write("    \n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t<title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tituloApp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</title>\n");
      out.write("\t\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\" style=\"width: 400px; margin-top: 100px;\">\n");
      out.write("\n");
      out.write("        <h1>\n");
      out.write("            <i class=\"glyphicon glyphicon-user\"></i> Login <small> Minhas Vendas</small>\n");
      out.write("        </h1>\n");
      out.write("\n");
      out.write("        <div class=\"panel panel-primary\">\n");
      out.write("\n");
      out.write("            <div class=\"panel-heading\">\n");
      out.write("                <h3 class=\"panel-title\">Informe os dados para acesso</h3>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"panel-body\">\n");
      out.write("\n");
      out.write("                <label>Email</label> \n");
      out.write("                <input id=\"email\" type=\"email\" placeholder=\"Informe o seu email\" autofocus=\"autofocus\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${login_cookie}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"form-control\" /> \n");
      out.write("                \n");
      out.write("                <label>Senha</label> \n");
      out.write("                <input id=\"senha\" type=\"password\" placeholder=\"Informe a sua senha\" class=\"form-control\" autocomplete=\"off\" /> \n");
      out.write("                \n");
      out.write("                <label> \n");
      out.write("                \t<input id=\"lembrarSenha\" type=\"checkbox\" value=\"1\" /> Lembrar login\n");
      out.write("                </label>\n");
      out.write("\n");
      out.write("                <button id=\"entrar\" class=\"btn btn-lg btn-primary btn-block\">\n");
      out.write("                    Entrar <i class=\"icon-enter-2 on-right on-left\"></i>\n");
      out.write("                </button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
