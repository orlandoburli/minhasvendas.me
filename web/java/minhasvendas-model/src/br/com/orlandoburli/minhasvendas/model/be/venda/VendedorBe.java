package br.com.orlandoburli.minhasvendas.model.be.venda;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.dao.venda.VendedorDao;
import br.com.orlandoburli.minhasvendas.model.vo.venda.VendedorVo;

public class VendedorBe extends BaseBe<VendedorVo, VendedorDao> {

	public VendedorBe(DAOManager manager) {
		super(manager);
	}
}