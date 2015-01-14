package br.com.orlandoburli.minhasvendas.model.dao.estoque;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.ProdutoVo;

public class ProdutoDao extends BaseCadastroDao<ProdutoVo> {

	public ProdutoDao(DAOManager manager) {
		super(manager);
	}
}