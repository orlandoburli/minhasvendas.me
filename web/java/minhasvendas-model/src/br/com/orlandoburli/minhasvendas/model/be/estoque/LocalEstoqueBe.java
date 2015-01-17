package br.com.orlandoburli.minhasvendas.model.be.estoque;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.LocalEstoqueDao;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.LocalEstoqueVo;

public class LocalEstoqueBe extends BaseBe<LocalEstoqueVo, LocalEstoqueDao> {

	public LocalEstoqueBe(DAOManager manager) {
		super(manager);
	}
}