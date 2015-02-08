package br.com.orlandoburli.minhasvendas.model.be.venda;

import java.util.ArrayList;
import java.util.List;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.vo.JsonItemVo;
import br.com.orlandoburli.minhasvendas.model.dao.venda.ClienteDao;
import br.com.orlandoburli.minhasvendas.model.dicionario.vendas.Cliente;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.ClienteVo;

public class ClienteBe extends BaseBe<ClienteVo, ClienteDao> {

	public ClienteBe(DAOManager manager) {
		super(manager);
	}

	public List<ClienteVo> getListAtivos(EmpresaVo empresa, String query) throws ListException {
		ClienteVo filter = new ClienteVo();
		filter.setIdEmpresa(empresa.getIdEmpresa());

		StringBuilder where = new StringBuilder();
		where.append(Cliente.TABELA_CLIENTE + "." + Cliente.Colunas.NOME + " ILIKE '%" + query + "%'");

		return getList(filter, where.toString(), Cliente.TABELA_CLIENTE + "." + Cliente.Colunas.NOME);
	}

	public List<JsonItemVo> toJsonItemListCustom(List<ClienteVo> source) {
		List<JsonItemVo> list = new ArrayList<JsonItemVo>(source.size());

		for (ClienteVo c : source) {
			JsonItemVo item = new JsonItemVo();
			item.setId(c.getIdCliente().toString());
			item.setLabel(c.getNome());
			item.setValue(c.getNome());

			list.add(item);
		}

		return list;
	}

	public ClienteVo cadastroRapido(String nome, EmpresaVo empresa) throws BeException {
		ClienteVo cliente = new ClienteVo();
		cliente.setIdEmpresa(empresa.getIdEmpresa());
		cliente.setNome(nome);

		save(cliente);

		return cliente;
	}
}