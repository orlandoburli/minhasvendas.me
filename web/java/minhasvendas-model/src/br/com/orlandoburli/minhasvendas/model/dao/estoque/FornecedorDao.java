package br.com.orlandoburli.minhasvendas.model.dao.estoque;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.FornecedorVo;

public class FornecedorDao extends BaseCadastroDao<FornecedorVo> {

	public FornecedorDao(DAOManager manager) {
		super(manager);
	}
}