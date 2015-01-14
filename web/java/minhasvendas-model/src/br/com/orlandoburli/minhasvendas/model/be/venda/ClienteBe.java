package br.com.orlandoburli.minhasvendas.model.be.venda;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.dao.venda.ClienteDao;
import br.com.orlandoburli.minhasvendas.model.vo.venda.ClienteVo;

public class ClienteBe extends BaseBe<ClienteVo, ClienteDao> {

	public ClienteBe(DAOManager manager) {
		super(manager);
	}
}