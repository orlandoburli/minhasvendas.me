package br.com.orlandoburli.minhasvendas.model.dao.estoque;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.CategoriaProdutoVo;

public class CategoriaProdutoDao extends BaseCadastroDao<CategoriaProdutoVo> {

	public CategoriaProdutoDao(DAOManager manager) {
		super(manager);
	}
}