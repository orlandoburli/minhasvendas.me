package br.com.orlandoburli.minhasvendas.web.actions.home;

import java.util.List;

import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.web.BaseAction;
import br.com.orlandoburli.framework.core.web.filters.OutjectSession;
import br.com.orlandoburli.minhasvendas.model.be.acesso.MenuBe;
import br.com.orlandoburli.minhasvendas.model.vo.acesso.MenuVo;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;

public class HomeAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	@OutjectSession("menus")
	private List<MenuVo> menus;

	private EmpresaVo usuario;

	public void execute() {

		DAOManager manager = DAOManager.getInstance();

		try {
			menus = new MenuBe(manager).getMenus();
		} catch (ListException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}

		getRequest().setAttribute("empresa", getUsuario());

		forward("web/pages/home/home.jsp");
	}

	public List<MenuVo> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuVo> menus) {
		this.menus = menus;
	}

	public EmpresaVo getUsuario() {
		return usuario;
	}

	public void setUsuario(EmpresaVo usuario) {
		this.usuario = usuario;
	}
}
