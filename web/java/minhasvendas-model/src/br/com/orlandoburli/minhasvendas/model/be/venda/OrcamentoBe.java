package br.com.orlandoburli.minhasvendas.model.be.venda;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.dao.venda.OrcamentoDao;
import br.com.orlandoburli.minhasvendas.model.vo.venda.OrcamentoVo;

public class OrcamentoBe extends BaseBe<OrcamentoVo, OrcamentoDao> {

	public OrcamentoBe(DAOManager manager) {
		super(manager);
	}
}