package br.com.orlandoburli.minhasvendas.web.actions.estoque.localestoque;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.minhasvendas.model.be.estoque.LocalEstoqueBe;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.LocalEstoqueDao;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Estoque.LocalEstoque;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.LocalEstoqueVo;

public class LocalEstoqueConsultaAction extends BaseConsultaAction<LocalEstoqueVo, LocalEstoqueDao, LocalEstoqueBe> {

	private static final long serialVersionUID = 1L;

	private String somenteAtivos;

	private EmpresaVo usuario;

	@Override
	public String getJspConsulta() {
		return "web/pages/estoque/localestoque/localestoqueconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/estoque/localestoque/localestoqueconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return LocalEstoque.TABELA_LOCAL_ESTOQUE + "." + LocalEstoque.Colunas.NOME;
	}

	@Override
	public void doBeforeFilter(LocalEstoqueVo filter, LocalEstoqueBe be, HttpServletRequest request, HttpServletResponse response, StringBuilder whereCondition) {
		filter.setIdEmpresa(usuario.getIdEmpresa());

		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("idLocalEstoque")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdLocalEstoque(codigo);
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