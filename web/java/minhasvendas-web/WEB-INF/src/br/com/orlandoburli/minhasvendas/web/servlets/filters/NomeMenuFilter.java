package br.com.orlandoburli.minhasvendas.web.servlets.filters;

import java.util.List;

import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.web.BaseAction;
import br.com.orlandoburli.framework.core.web.filters.BaseFilter;
import br.com.orlandoburli.minhasvendas.model.vo.acesso.MenuVo;

public class NomeMenuFilter extends BaseFilter {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean doFilter(Object facade) throws IllegalArgumentException, IllegalAccessException {

		BaseAction actionFacade = (BaseAction) facade;

		@SuppressWarnings("unchecked")
		List<MenuVo> menus = (List<MenuVo>) getRequest().getSession().getAttribute("menus");

		if (menus != null) {

			String actionName = actionFacade.getActionName() + ".action";

			MenuVo menu = buscaMenuAction(actionName, menus, true);

			if (menu != null) {
				getRequest().setAttribute("titulo", menu.getNome());
				getRequest().setAttribute("subtitulo", menu.getObjeto().getNome());

				if (menu.getMenuPai() != null) {
					getRequest().setAttribute("subMenu", menu.getMenuPai().getNome());
				}
				getRequest().setAttribute("menuAtivo", menu.getNome());
			} else {
				menu = buscaMenuAction(actionName, menus, false);

				if (menu != null) {
					getRequest().setAttribute("titulo", menu.getNome());
					getRequest().setAttribute("subtitulo", menu.getObjetoSecundario().getNome());
					if (menu.getMenuPai() != null) {
						getRequest().setAttribute("subMenu", menu.getMenuPai().getNome());
					}
					getRequest().setAttribute("menuAtivo", menu.getNome());
				}
			}
		} else {
			Log.warning("Lista de menus da sessao está vazio!");
		}
		return true;
	}

	private MenuVo buscaMenuAction(String actionName, List<MenuVo> menus, boolean primario) {

		for (MenuVo m : menus) {

			if (primario) {
				if (m.getObjetoSecundario() != null) {
					// Log.debug("Primário url: " + m.getObjeto().getUrl());
				}
				// Objeto primario
				if (m.getObjeto() != null && m.getObjeto().getUrl() != null && m.getObjeto().getUrl().equalsIgnoreCase(actionName)) {
					return m;
				}
			} else {
				if (m.getObjetoSecundario() != null) {
					// Log.debug("Secundário url: " +
					// m.getObjetoSecundario().getUrl());
				}
				// Objeto secundario
				if (m.getObjetoSecundario() != null && m.getObjetoSecundario().getUrl() != null && m.getObjetoSecundario().getUrl().equalsIgnoreCase(actionName)) {
					return m;
				}
			}

			// Se nao achou, vai nos submenus
			if (m.getSubMenus().size() > 0) {
				MenuVo m2 = buscaMenuAction(actionName, m.getSubMenus(), primario);

				if (m2 != null) {
					return m2;
				}
			}
		}
		return null;
	}

}
