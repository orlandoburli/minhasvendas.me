package br.com.orlandoburli.minhasvendas.model.dao.acesso;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.vo.acesso.ObjetoVo;

public class ObjetoDao extends BaseCadastroDao<ObjetoVo> {

	public ObjetoDao(DAOManager manager) {
		super(manager);
	}

}
