package br.com.orlandoburli.minhasvendas.model.dao.venda;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.vo.venda.ClienteVo;

public class ClienteDao extends BaseCadastroDao<ClienteVo> {

	public ClienteDao(DAOManager manager) {
		super(manager);
	}
}