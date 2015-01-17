package br.com.orlandoburli.minhasvendas.model.dao.estoque;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.LocalEstoqueVo;

public class LocalEstoqueDao extends BaseCadastroDao<LocalEstoqueVo> {

	public LocalEstoqueDao(DAOManager manager) {
		super(manager);
	}
}