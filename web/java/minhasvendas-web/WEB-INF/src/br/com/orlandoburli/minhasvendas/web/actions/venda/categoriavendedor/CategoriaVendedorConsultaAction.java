package br.com.orlandoburli.minhasvendas.web.actions.venda.categoriavendedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.minhasvendas.model.be.venda.CategoriaVendedorBe;
import br.com.orlandoburli.minhasvendas.model.dao.venda.CategoriaVendedorDao;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Vendas.CategoriaVendedor;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.CategoriaVendedorVo;

public class CategoriaVendedorConsultaAction extends BaseConsultaAction<CategoriaVendedorVo, CategoriaVendedorDao, CategoriaVendedorBe> {

	private static final long serialVersionUID = 1L;

	private String somenteAtivos;

	private EmpresaVo usuario;

	@Override
	public String getJspConsulta() {
		return "web/pages/venda/categoriavendedor/categoriavendedorconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/venda/categoriavendedor/categoriavendedorconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return CategoriaVendedor.TABELA_CATEGORIA_VENDEDOR + "." + CategoriaVendedor.Colunas.NOME;
	}

	@Override
	public void doBeforeFilter(CategoriaVendedorVo filter, CategoriaVendedorBe be, HttpServletRequest request, HttpServletResponse response, StringBuilder whereCondition) {
		filter.setIdEmpresa(usuario.getIdEmpresa());

		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("idCategoriaVendedor")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdCategoriaVendedor(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("idEmpresa")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdEmpresa(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("percentualComissao")) {
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