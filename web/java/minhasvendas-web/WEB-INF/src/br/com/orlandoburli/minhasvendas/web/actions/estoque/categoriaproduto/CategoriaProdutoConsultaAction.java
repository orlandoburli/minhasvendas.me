package br.com.orlandoburli.minhasvendas.web.actions.estoque.categoriaproduto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.minhasvendas.model.be.estoque.CategoriaProdutoBe;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.CategoriaProdutoDao;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Estoque.CategoriaProduto;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.CategoriaProdutoVo;

public class CategoriaProdutoConsultaAction extends BaseConsultaAction<CategoriaProdutoVo, CategoriaProdutoDao, CategoriaProdutoBe> {

	private static final long serialVersionUID = 1L;

	private String somenteAtivos;

	private EmpresaVo usuario;

	@Override
	public String getJspConsulta() {
		return "web/pages/estoque/categoriaproduto/categoriaprodutoconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/estoque/categoriaproduto/categoriaprodutoconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return CategoriaProduto.TABELA_CATEGORIA + "." + CategoriaProduto.Colunas.NOME;
	}

	@Override
	public void doBeforeFilter(CategoriaProdutoVo filter, CategoriaProdutoBe be, HttpServletRequest request, HttpServletResponse response, StringBuilder whereCondition) {
		filter.setIdEmpresa(usuario.getIdEmpresa());

		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("idCategoria")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdCategoria(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("idEmpresa")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdEmpresa(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			}
		}
		if (getSomenteAtivos() != null && !getSomenteAtivos().trim().equals("")) {
			filter.setAtivo(getSomenteAtivos());
		}
	}

	public String getSomenteAtivos() {
		return somenteAtivos;
	}

	public void setSomenteAtivos(String somenteAtivos) {
		this.somenteAtivos = somenteAtivos;
	}

	public EmpresaVo getUsuario() {
		return usuario;
	}

	public void setUsuario(EmpresaVo usuario) {
		this.usuario = usuario;
	}
}