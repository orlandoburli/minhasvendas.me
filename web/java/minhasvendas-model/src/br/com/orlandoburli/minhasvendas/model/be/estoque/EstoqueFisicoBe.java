package br.com.orlandoburli.minhasvendas.model.be.estoque;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.EstoqueFisicoDao;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.EstoqueFisicoVo;

public class EstoqueFisicoBe extends BaseBe<EstoqueFisicoVo, EstoqueFisicoDao> {

	public EstoqueFisicoBe(DAOManager manager) {
		super(manager);
	}
}