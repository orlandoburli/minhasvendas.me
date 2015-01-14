package br.com.orlandoburli.minhasvendas.model.be.estoque;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.ProdutoDao;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.ProdutoVo;

public class ProdutoBe extends BaseBe<ProdutoVo, ProdutoDao> {

	public ProdutoBe(DAOManager manager) {
		super(manager);
	}
}