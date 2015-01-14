package br.com.orlandoburli.minhasvendas.web.servlets;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Utils;
import br.com.orlandoburli.framework.core.web.BaseAction;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.framework.core.web.filters.AutorizathionFilter;
import br.com.orlandoburli.framework.core.web.filters.InjectionFilter;
import br.com.orlandoburli.minhasvendas.web.servlets.filters.NomeMenuFilter;

@WebServlet(value = "*.action", loadOnStartup = 1)
public class MainControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Locale.setDefault(new Locale("pt", "BR"));

		String URL = req.getRequestURI();
		URL = URL.substring(URL.lastIndexOf("/") + 1);
		URL = URL.substring(0, URL.lastIndexOf("."));

		String facadeName = null;
		String methodName = null;

		facadeName = URL.indexOf(".") >= 0 ? URL.substring(0, URL.indexOf(".")) : URL;
		methodName = URL.indexOf(".") >= 0 ? URL.substring(URL.indexOf(".") + 1) : "execute";

		String className = null;

		try {
			String appdir = req.getServletContext().getRealPath("") + File.separator;

			className = Utils.getFacadeName(appdir, facadeName + "Action" + Utils.DOT_CLASS, getServletContext());

			if (className == null) {
				Log.warning("Classe [" + facadeName + "] nao encontrada (null)");
				return;
			}

			Log.debug("className: " + className);

			Class<?> klass = Class.forName(className);
			Object facade = null;

			try {
				Constructor constructor = klass.getConstructor(new Class[] { HttpServletRequest.class, HttpServletResponse.class, ServletContext.class, String.class });
				facade = constructor.newInstance(new Object[] { req, resp, getServletContext(), methodName });
			} catch (NoSuchMethodException ex) { // Se nao tem o construtor com
				// 4 parametros, tenta o
				// padrao
				facade = klass.newInstance();
			}

			if (facade instanceof BaseAction) { // Injeta os atributos request,
				// response e servletcontext
				((BaseAction) facade).setRequest(req);
				((BaseAction) facade).setResponse(resp);
				((BaseAction) facade).setContext(getServletContext());
				((BaseAction) facade).setMethodName(methodName);
			}

			// Seta o nome do metodo no request
			req.setAttribute("methodname", methodName);

			// Execucao dos filtros
			// Filtro para injecao de dependencias
			InjectionFilter ifilter = new InjectionFilter();
			ifilter.setContext(getServletContext());
			ifilter.setRequest(req);
			ifilter.setResponse(resp);

			resp.setCharacterEncoding("UTF-8");

			if (!ifilter.doFilter(facade)) {
				return;
			}

			// Filtro de autorizacao / autenticacao
			AutorizathionFilter afilter = new AutorizathionFilter();
			afilter.setContext(getServletContext());
			afilter.setRequest(req);
			afilter.setResponse(resp);

			if (!afilter.doFilter(facade)) {
				resp.sendRedirect("login.action");
				return;
			}

			// // Filtro de injecao de nomes na tela
			NomeMenuFilter nomeFilter = new NomeMenuFilter();

			nomeFilter.setContext(getServletContext());
			nomeFilter.setRequest(req);
			nomeFilter.setResponse(resp);

			if (!nomeFilter.doFilter(facade)) {
				resp.sendRedirect("login.action");
				return;
			}

			// Invocacao dos metodos
			Log.debug("Invocando metodo " + methodName + " do facade " + facadeName);

			Method method = klass.getMethod(methodName, new Class<?>[] {});
			method.invoke(facade, new Object[] {});

			if (facade instanceof BaseAction) { // Processamento de Outjection
				((BaseAction) facade).dispatch();
			}

			// Fecha o DaoManager, se for consulta ou cadastro
			if (facade instanceof BaseCadastroAction) {
				((BaseCadastroAction) facade).getManager().commit();
			} else if (facade instanceof BaseConsultaAction) {
				((BaseConsultaAction) facade).getManager().commit();
			}

		} catch (ClassNotFoundException e) {
			Log.warning("Classe [" + facadeName + "] nao encontrada!");
		} catch (InstantiationException e) {
			Log.critical(e);
		} catch (IllegalAccessException e) {
			Log.critical(e);
		} catch (SecurityException e) {
			Log.critical(e);
		} catch (NoSuchMethodException e) {
			Log.warning("Metodo [" + methodName + "] nao existe em [" + className + "]");
		} catch (IllegalArgumentException e) {
			Log.critical(e);
		} catch (InvocationTargetException e) {
			Log.critical(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}