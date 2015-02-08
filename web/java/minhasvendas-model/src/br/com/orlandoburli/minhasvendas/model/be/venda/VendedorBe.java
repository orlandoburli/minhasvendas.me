package br.com.orlandoburli.minhasvendas.model.be.venda;

import java.util.ArrayList;
import java.util.List;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.vo.JsonItemVo;
import br.com.orlandoburli.minhasvendas.model.dao.venda.VendedorDao;
import br.com.orlandoburli.minhasvendas.model.dicionario.vendas.Vendedor;
import br.com.orlandoburli.minhasvendas.model.domains.SimNao;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.VendedorVo;

public class VendedorBe extends BaseBe<VendedorVo, VendedorDao> {

	public VendedorBe(DAOManager manager) {
		super(manager);
	}

	public List<VendedorVo> getListAtivos(EmpresaVo empresa, String query) throws ListException {
		VendedorVo filter = new VendedorVo();

		filter.setIdEmpresa(empresa.getIdEmpresa());
		filter.setAtivo(SimNao.SIM);

		StringBuilder where = new StringBuilder();
		where.append(Vendedor.TABELA_VENDEDOR + "." + Vendedor.Colunas.NOME + " ILIKE '%" + query + "%'");

		return getList(filter, where.toString(), Vendedor.TABELA_VENDEDOR + "." + Vendedor.Colunas.NOME);
	}

	public List<JsonItemVo> toJsonItemListCustom(List<VendedorVo> source) {
		List<JsonItemVo> list = new ArrayList<JsonItemVo>(source.size());

		for (VendedorVo p : source) {
			JsonItemVo item = new JsonItemVo();
			item.setId(p.getIdVendedor().toString());

			if (p.getCategoria() != null) {
				item.setLabel(p.getNome() + " " + p.getCategoria().getNome());
			} else {
				item.setLabel(p.getNome());
			}

			item.setValue(p.getNome());

			list.add(item);
		}

		return list;
	}

	public VendedorVo cadastroRapido(String nome, EmpresaVo empresa) throws BeException {
		VendedorVo vendedor = new VendedorVo();
		vendedor.setNome(nome);
		vendedor.setAtivo(SimNao.SIM);
		vendedor.setIdEmpresa(empresa.getIdEmpresa());

		save(vendedor);

		return vendedor;
	}
}