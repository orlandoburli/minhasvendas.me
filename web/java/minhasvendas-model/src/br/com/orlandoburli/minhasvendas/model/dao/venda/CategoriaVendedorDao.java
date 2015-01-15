package br.com.orlandoburli.minhasvendas.model.dao.venda;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.vo.venda.CategoriaVendedorVo;

public class CategoriaVendedorDao extends BaseCadastroDao<CategoriaVendedorVo> {

	public CategoriaVendedorDao(DAOManager manager) {
		super(manager);
	}
}