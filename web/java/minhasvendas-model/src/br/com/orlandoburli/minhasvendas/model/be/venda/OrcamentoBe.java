package br.com.orlandoburli.minhasvendas.model.be.venda;

import java.math.BigDecimal;
import java.util.List;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.dao.venda.OrcamentoDao;
import br.com.orlandoburli.minhasvendas.model.vo.venda.ItemOrcamentoVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.OrcamentoVo;

public class OrcamentoBe extends BaseBe<OrcamentoVo, OrcamentoDao> {

	public OrcamentoBe(DAOManager manager) {
		super(manager);
	}

	@Override
	public void doBeforeSave(OrcamentoVo vo) throws BeException {
		super.doBeforeSave(vo);

		calcularTotal(vo);
	}

	public void calcularTotal(OrcamentoVo vo) {
		if (vo == null) {
			return;
		}

		// Calcula total
		vo.setValorItens(BigDecimal.ZERO);
		vo.setValorDescontos(BigDecimal.ZERO);
		vo.setValorTotal(BigDecimal.ZERO);

		if (vo.getValorFrete() == null) {
			vo.setValorFrete(BigDecimal.ZERO);
		}

		for (ItemOrcamentoVo item : vo.getItens()) {
			vo.setValorItens(vo.getValorItens().add(item.getValorUnitario().multiply(item.getQuantidade())));
			vo.setValorDescontos(vo.getValorDescontos().add(item.getValorDesconto()));
		}

		vo.setValorTotal(vo.getValorItens().subtract(vo.getValorDescontos()).add(vo.getValorFrete()));
	}

	@Override
	public void doBeforeDelete(OrcamentoVo vo) throws BeException {
		super.doBeforeDelete(vo);

		// Apagar todos os itens
		ItemOrcamentoBe itemBe = new ItemOrcamentoBe(getManager());
		List<ItemOrcamentoVo> list = itemBe.getList(vo);

		for (ItemOrcamentoVo itemOrcamentoVo : list) {
			itemBe.remove(itemOrcamentoVo);
		}
	}

	@Override
	public void doAfterSave(OrcamentoVo vo) throws BeException {
		super.doAfterSave(vo);

		ItemOrcamentoBe itemBe = new ItemOrcamentoBe(getManager());

		for (ItemOrcamentoVo item : vo.getItens()) {
			item.setIdOrcamento(vo.getIdOrcamento());
			itemBe.save(item);
		}
	}
}