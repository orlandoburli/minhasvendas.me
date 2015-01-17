package br.com.orlandoburli.minhasvendas.model.dao.estoque;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.EntradaVo;

public class EntradaDao extends BaseCadastroDao<EntradaVo> {

	public EntradaDao(DAOManager manager) {
		super(manager);
	}
}