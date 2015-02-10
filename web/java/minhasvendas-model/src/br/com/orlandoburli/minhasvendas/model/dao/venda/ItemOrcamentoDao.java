package br.com.orlandoburli.minhasvendas.model.dao.venda;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.vo.venda.ItemOrcamentoVo;

public class ItemOrcamentoDao extends BaseCadastroDao<ItemOrcamentoVo> {

	public ItemOrcamentoDao(DAOManager manager) {
		super(manager);
	}
}