package br.com.orlandoburli.minhasvendas.web.actions.home;

import br.com.orlandoburli.framework.core.web.BaseAction;

public class HeaderAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	public void execute() {
		forward("web/pages/home/header.jsp");
	}
}
