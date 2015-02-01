package br.com.orlandoburli.minhasvendas.model.dao.venda;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.vo.venda.OrcamentoVo;

public class OrcamentoDao extends BaseCadastroDao<OrcamentoVo> {

	public OrcamentoDao(DAOManager manager) {
		super(manager);
	}
}