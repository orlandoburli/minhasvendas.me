package br.com.orlandoburli.minhasvendas.model.be.estoque;

import java.util.List;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.ItemEntradaDao;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.EntradaVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.ItemEntradaVo;

public class ItemEntradaBe extends BaseBe<ItemEntradaVo, ItemEntradaDao> {

	public ItemEntradaBe(DAOManager manager) {
		super(manager);
	}

	public List<ItemEntradaVo> getList(EntradaVo vo) throws ListException {
		ItemEntradaVo filter = new ItemEntradaVo();
		filter.setIdEntrada(vo.getIdEntrada());

		return getList(filter);
	}

	public void remove(List<ItemEntradaVo> list) throws BeException {
		for (ItemEntradaVo itemEntradaVo : list) {
			remove(itemEntradaVo);
		}
	}
}