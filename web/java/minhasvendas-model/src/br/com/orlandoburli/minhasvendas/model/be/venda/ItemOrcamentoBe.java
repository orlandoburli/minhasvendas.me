package br.com.orlandoburli.minhasvendas.model.be.venda;

import java.math.BigDecimal;
import java.util.List;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.be.estoque.ProdutoBe;
import br.com.orlandoburli.minhasvendas.model.dao.venda.ItemOrcamentoDao;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.ProdutoVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.ItemOrcamentoVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.OrcamentoVo;

public class ItemOrcamentoBe extends BaseBe<ItemOrcamentoVo, ItemOrcamentoDao> {

	public ItemOrcamentoBe(DAOManager manager) {
		super(manager);
	}

	public List<ItemOrcamentoVo> getList(OrcamentoVo vo) throws ListException {
		ItemOrcamentoVo filter = new ItemOrcamentoVo();
		filter.setIdOrcamento(vo.getIdOrcamento());

		return getList(filter);
	}

	public void remove(List<ItemOrcamentoVo> list) throws BeException {
		for (ItemOrcamentoVo item : list) {
			remove(item);
		}
	}

	@Override
	public void doBeforeSave(ItemOrcamentoVo vo) throws BeException {
		super.doBeforeSave(vo);

		ProdutoVo produto = new ProdutoBe(getManager()).get(vo.getIdProduto());
		vo.setProduto(produto);

		if (vo.getValorDesconto() == null) {
			vo.setValorDesconto(BigDecimal.ZERO);
		}

		vo.setValorTotal(vo.getQuantidade().multiply(vo.getValorUnitario()).subtract(vo.getValorDesconto()));
	}
}