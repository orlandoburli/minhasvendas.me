package br.com.orlandoburli.minhasvendas.model.dao.venda;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.vo.venda.CategoriaClienteVo;

public class CategoriaClienteDao extends BaseCadastroDao<CategoriaClienteVo> {

	public CategoriaClienteDao(DAOManager manager) {
		super(manager);
	}
}