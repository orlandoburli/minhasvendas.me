package br.com.orlandoburli.minhasvendas.model.dao.estoque;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.ItemEntradaVo;

public class ItemEntradaDao extends BaseCadastroDao<ItemEntradaVo> {

	public ItemEntradaDao(DAOManager manager) {
		super(manager);
	}
}