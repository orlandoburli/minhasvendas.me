package br.com.orlandoburli.minhasvendas.model.be.estoque;

import java.util.ArrayList;
import java.util.List;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.vo.JsonItemVo;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.FornecedorDao;
import br.com.orlandoburli.minhasvendas.model.dicionario.estoque.Fornecedor;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.FornecedorVo;

public class FornecedorBe extends BaseBe<FornecedorVo, FornecedorDao> {

	public FornecedorBe(DAOManager manager) {
		super(manager);
	}

	public List<FornecedorVo> getListFornecedores(EmpresaVo usuario, String query) throws ListException {
		StringBuilder where = new StringBuilder();

		FornecedorVo filter = new FornecedorVo();
		filter.setIdEmpresa(usuario.getIdEmpresa());

		where.append(Fornecedor.TABELA_FORNECEDOR + "." + Fornecedor.Colunas.NOME + " ILIKE '%" + query + "%'");
		where.append(" OR ");
		where.append(Fornecedor.TABELA_FORNECEDOR + "." + Fornecedor.Colunas.RAZAO_SOCIAL + " ILIKE '%" + query + "%'");

		return getList(filter, where.toString(), Fornecedor.TABELA_FORNECEDOR + "." + Fornecedor.Colunas.NOME);
	}

	public FornecedorVo cadastroRapido(String nome, EmpresaVo empresa) throws BeException {
		FornecedorVo fornecedor = new FornecedorVo();

		fornecedor.setNome(nome);
		fornecedor.setIdEmpresa(empresa.getIdEmpresa());
		fornecedor.setEmpresa(empresa);

		save(fornecedor);

		return fornecedor;
	}

	public List<JsonItemVo> toJsonItemListCustom(List<FornecedorVo> source) {

		List<JsonItemVo> list = new ArrayList<JsonItemVo>(source.size());

		for (FornecedorVo p : source) {
			JsonItemVo item = new JsonItemVo();
			item.setId(p.getIdFornecedor().toString());
			if (p.getCpfCnpj() != null && !p.getCpfCnpj().trim().equals("")) {
				item.setLabel(p.getNome() + " " + p.getCpfCnpj());
			} else {
				item.setLabel(p.getNome());
			}
			item.setValue(p.getNome());

			list.add(item);
		}

		return list;
	}
}