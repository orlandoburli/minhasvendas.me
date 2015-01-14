package br.com.orlandoburli.minhasvendas.web.actions.acesso;

import javax.servlet.http.Cookie;

import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;
import br.com.orlandoburli.framework.core.utils.Utils;
import br.com.orlandoburli.framework.core.web.BaseAction;
import br.com.orlandoburli.framework.core.web.filters.OutjectSession;
import br.com.orlandoburli.framework.core.web.retorno.RetornoAction;
import br.com.orlandoburli.minhasvendas.model.be.cadastros.EmpresaBe;
import br.com.orlandoburli.minhasvendas.model.be.cadastros.LoginInvalidoException;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;

public class LoginAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private static final String LOGIN_COOKIES = "login_cookie";

	private String email;
	private String senha;

	private Integer lembrarSenha;

	@OutjectSession(Constants.Session.SESSION_USUARIO)
	private EmpresaVo usuario;

	@OutjectSession("tituloApp")
	private String tituloApp;

	public void execute() {
		setTituloApp("Minhas Vendas - Sistema de Gestão para autônomos, micro e pequenas empresas");

		// Se o cookie do email estiver salvo, retorna.
		if (getRequest() != null && getRequest().getCookies() != null) {
			for (Cookie cookie : getRequest().getCookies()) {
				if (cookie.getName().equalsIgnoreCase(LoginAction.LOGIN_COOKIES)) {
					getRequest().setAttribute(LoginAction.LOGIN_COOKIES, cookie.getValue());
				}
			}
		}

		forward("web/pages/acesso/login.jsp");
	}

	public void login() {
		DAOManager manager = DAOManager.getInstance();
		try {

			EmpresaVo empresa = new EmpresaBe(manager).login(email, senha);
			setUsuario(empresa);

			Log.debug("Empresa logada! " + empresa.getRazaoSocial());

			this.write(Utils.voToJson(new RetornoAction(true, "LOGIN_OK", "")));

			// Lembrar senha
			if (getLembrarSenha() != null && getLembrarSenha() == 1) {
				Cookie cookie = new Cookie(LoginAction.LOGIN_COOKIES, email);
				getResponse().addCookie(cookie);
			}

		} catch (LoginInvalidoException e) {
			this.write(Utils.voToJson(new RetornoAction(false, e.getMessage(), "login")));
		} catch (ListException e) {
			this.write(Utils.voToJson(new RetornoAction(false, e.getMessage(), "login")));
		} finally {
			manager.commit();
		}
	}

	public void load() {
		this.write(Utils.voToJson(new RetornoAction(true, "LOAD_OK", "")));
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getLembrarSenha() {
		return lembrarSenha;
	}

	public void setLembrarSenha(Integer lembrarSenha) {
		this.lembrarSenha = lembrarSenha;
	}

	public String getTituloApp() {
		return tituloApp;
	}

	public void setTituloApp(String tituloApp) {
		this.tituloApp = tituloApp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EmpresaVo getUsuario() {
		return usuario;
	}

	public void setUsuario(EmpresaVo usuario) {
		this.usuario = usuario;
	}
}
