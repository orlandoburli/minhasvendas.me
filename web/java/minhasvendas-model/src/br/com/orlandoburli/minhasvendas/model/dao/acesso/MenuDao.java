package br.com.orlandoburli.minhasvendas.model.dao.acesso;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.vo.acesso.MenuVo;

public class MenuDao extends BaseCadastroDao<MenuVo> {

	public MenuDao(DAOManager manager) {
		super(manager);
	}

}
