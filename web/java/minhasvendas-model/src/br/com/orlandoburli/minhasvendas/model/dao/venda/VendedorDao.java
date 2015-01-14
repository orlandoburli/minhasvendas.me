package br.com.orlandoburli.minhasvendas.model.dao.venda;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.vo.venda.VendedorVo;

public class VendedorDao extends BaseCadastroDao<VendedorVo> {

	public VendedorDao(DAOManager manager) {
		super(manager);
	}
}