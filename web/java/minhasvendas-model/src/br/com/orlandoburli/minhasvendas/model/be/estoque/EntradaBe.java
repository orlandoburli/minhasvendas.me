package br.com.orlandoburli.minhasvendas.model.be.estoque;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.EntradaDao;
import br.com.orlandoburli.minhasvendas.model.domains.StatusProcessamento;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.EntradaVo;

public class EntradaBe extends BaseBe<EntradaVo, EntradaDao> {

	public EntradaBe(DAOManager manager) {
		super(manager);
	}

	@Override
	public void doBeforeInsert(EntradaVo vo) throws BeException {
		super.doBeforeInsert(vo);

		vo.setStatus(StatusProcessamento.NAO_PROCESSADO);
	}
}