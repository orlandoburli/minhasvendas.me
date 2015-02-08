package br.com.orlandoburli.minhasvendas.model.be.estoque;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.vo.JsonItemVo;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.ProdutoDao;
import br.com.orlandoburli.minhasvendas.model.dicionario.estoque.Produto;
import br.com.orlandoburli.minhasvendas.model.domains.SimNao;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.ProdutoVo;

public class ProdutoBe extends BaseBe<ProdutoVo, ProdutoDao> {

	public ProdutoBe(DAOManager manager) {
		super(manager);
	}

	public List<ProdutoVo> getListAtivos(EmpresaVo empresa, String query) throws ListException {
		ProdutoVo filter = new ProdutoVo();
		filter.setIdEmpresa(empresa.getIdEmpresa());
		filter.setAtivo(SimNao.SIM);

		// filter.setNome("%" + (query == null ? "" : query) + "%");
		query = query == null ? "" : query;

		StringBuilder where = new StringBuilder();

		where.append(Produto.TABELA_PRODUTO + "." + Produto.Colunas.NOME + " ILIKE '%" + query + "%' ");
		where.append(" OR ");
		where.append(Produto.TABELA_PRODUTO + "." + Produto.Colunas.CODIGO_PRODUTO + " ILIKE '%" + query + "%' ");

		return getList(filter, where.toString(), Produto.TABELA_PRODUTO + "." + Produto.Colunas.NOME);
	}

	public List<JsonItemVo> toJsonItemList(List<ProdutoVo> source) {
		return toJsonVo(source, "idProduto", "nome", "nome");
	}

	public List<JsonItemVo> toJsonItemListCustom(List<ProdutoVo> source) {

		List<JsonItemVo> list = new ArrayList<JsonItemVo>(source.size());

		for (ProdutoVo p : source) {
			JsonItemVo item = new JsonItemVo();
			item.setId(p.getIdProduto().toString());

			if (p.getCodigoProduto() != null && !p.getCodigoProduto().trim().equals("")) {
				item.setLabel(p.getCodigoProduto() + " - " + p.getNome());
			} else {
				item.setLabel(p.getNome());
			}

			item.setValue(p.getNome());

			list.add(item);
		}

		return list;
	}

	public ProdutoVo cadastroRapido(String nomeProduto, EmpresaVo empresa) throws BeException {
		ProdutoVo produto = new ProdutoVo();
		produto.setNome(nomeProduto);
		produto.setAtivo(SimNao.SIM);
		produto.setIdEmpresa(empresa.getIdEmpresa());
		produto.setValorVenda(BigDecimal.ZERO);
		save(produto);

		return produto;
	}
}