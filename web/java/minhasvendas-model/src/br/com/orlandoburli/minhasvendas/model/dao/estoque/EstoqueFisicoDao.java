package br.com.orlandoburli.minhasvendas.model.dao.estoque;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.EstoqueFisicoVo;

public class EstoqueFisicoDao extends BaseCadastroDao<EstoqueFisicoVo> {

	public EstoqueFisicoDao(DAOManager manager) {
		super(manager);
	}
}