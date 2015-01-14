package br.com.orlandoburli.minhasvendas.web.actions.estoque.produto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.minhasvendas.model.be.estoque.ProdutoBe;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.ProdutoDao;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Estoque.Produto;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.ProdutoVo;

public class ProdutoConsultaAction extends BaseConsultaAction<ProdutoVo, ProdutoDao, ProdutoBe> {

	private static final long serialVersionUID = 1L;

	private EmpresaVo usuario;

	private String somenteAtivos;

	@Override
	public String getJspConsulta() {
		return "web/pages/estoque/produto/produtoconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/estoque/produto/produtoconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Produto.TABELA_PRODUTO + "." + Produto.Colunas.NOME;
	}

	@Override
	public void doBeforeFilter(ProdutoVo filter, ProdutoBe be, HttpServletRequest request, HttpServletResponse response, StringBuilder whereCondition) {
		filter.setIdEmpresa(usuario.getIdEmpresa());

		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("idProduto")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdProduto(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("idEmpresa")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdEmpresa(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("codigoProduto")) {
				filter.setCodigoProduto("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("categoria.nome")) {
				filter.getCategoria().setNome("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("valorVenda")) {
			}
		}

		if (getSomenteAtivos() != null && !getSomenteAtivos().trim().equals("")) {
			filter.setAtivo(getSomenteAtivos());
		}
	}

	public EmpresaVo getUsuario() {
		return usuario;
	}

	public void setUsuario(EmpresaVo usuario) {
		this.usuario = usuario;
	}

	public String getSomenteAtivos() {
		return somenteAtivos;
	}

	public void setSomenteAtivos(String somenteAtivos) {
		this.somenteAtivos = somenteAtivos;
	}
}