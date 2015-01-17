package br.com.orlandoburli.minhasvendas.model.be.estoque;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.ItemEntradaDao;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.ItemEntradaVo;

public class ItemEntradaBe extends BaseBe<ItemEntradaVo, ItemEntradaDao> {

	public ItemEntradaBe(DAOManager manager) {
		super(manager);
	}
}