package br.com.orlandoburli.minhasvendas.model.be.estoque;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.FornecedorDao;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.FornecedorVo;

public class FornecedorBe extends BaseBe<FornecedorVo, FornecedorDao> {

	public FornecedorBe(DAOManager manager) {
		super(manager);
	}
}