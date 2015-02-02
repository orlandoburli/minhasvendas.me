package br.com.orlandoburli.minhasvendas.model.be.estoque;

import java.math.BigDecimal;
import java.util.List;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.ItemEntradaDao;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.EntradaVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.ItemEntradaVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.ProdutoVo;

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

	@Override
	public void doBeforeSave(ItemEntradaVo vo) throws BeException {
		super.doBeforeSave(vo);

		ProdutoVo produto = new ProdutoBe(getManager()).get(vo.getIdProduto());
		vo.setProduto(produto);

		if (vo.getValorDesconto() == null) {
			vo.setValorDesconto(BigDecimal.ZERO);
		}

		vo.setValorTotal(vo.getQuantidade().multiply(vo.getValorUnitario()).subtract(vo.getValorDesconto()));
	}
}