package br.com.orlandoburli.minhasvendas.model.be.venda;

import java.util.List;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.dao.venda.CategoriaVendedorDao;
import br.com.orlandoburli.minhasvendas.model.domains.SimNao;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Vendas.CategoriaVendedor;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.CategoriaVendedorVo;

public class CategoriaVendedorBe extends BaseBe<CategoriaVendedorVo, CategoriaVendedorDao> {

	public CategoriaVendedorBe(DAOManager manager) {
		super(manager);
	}

	public List<CategoriaVendedorVo> getListAtivos(EmpresaVo empresa) throws ListException {

		CategoriaVendedorVo filter = new CategoriaVendedorVo();
		filter.setAtivo(SimNao.SIM);
		filter.setIdEmpresa(empresa.getIdEmpresa());

		return getList(filter, null, CategoriaVendedor.TABELA_CATEGORIA_VENDEDOR + "." + CategoriaVendedor.Colunas.PERCENTUAL_COMISSAO);
	}
}