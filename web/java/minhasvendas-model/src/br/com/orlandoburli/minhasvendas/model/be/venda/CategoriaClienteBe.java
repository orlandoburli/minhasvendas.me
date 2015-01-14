package br.com.orlandoburli.minhasvendas.model.be.venda;

import java.util.List;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.dao.venda.CategoriaClienteDao;
import br.com.orlandoburli.minhasvendas.model.domains.SimNao;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Vendas.CategoriaCliente;
import br.com.orlandoburli.minhasvendas.model.vo.venda.CategoriaClienteVo;

public class CategoriaClienteBe extends BaseBe<CategoriaClienteVo, CategoriaClienteDao> {

	public CategoriaClienteBe(DAOManager manager) {
		super(manager);
	}

	public List<CategoriaClienteVo> getListAtivos() throws ListException {
		CategoriaClienteVo filter = new CategoriaClienteVo();
		filter.setAtivo(SimNao.SIM);

		return getList(filter, null, CategoriaCliente.TABELA_CATEGORIA_CLIENTE + "." + CategoriaCliente.Colunas.NOME);

	}
}