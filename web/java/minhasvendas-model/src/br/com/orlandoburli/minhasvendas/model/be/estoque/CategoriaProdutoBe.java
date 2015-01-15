package br.com.orlandoburli.minhasvendas.model.be.estoque;

import java.util.List;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.CategoriaProdutoDao;
import br.com.orlandoburli.minhasvendas.model.domains.SimNao;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Estoque.CategoriaProduto;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.CategoriaProdutoVo;

public class CategoriaProdutoBe extends BaseBe<CategoriaProdutoVo, CategoriaProdutoDao> {

	public CategoriaProdutoBe(DAOManager manager) {
		super(manager);
	}

	public List<CategoriaProdutoVo> getListAtivos(EmpresaVo empresa) throws ListException {
		CategoriaProdutoVo filter = new CategoriaProdutoVo();
		filter.setAtivo(SimNao.SIM);
		filter.setIdEmpresa(empresa.getIdEmpresa());

		return getList(filter, null, CategoriaProduto.TABELA_CATEGORIA + "." + CategoriaProduto.Colunas.NOME);
	}
}