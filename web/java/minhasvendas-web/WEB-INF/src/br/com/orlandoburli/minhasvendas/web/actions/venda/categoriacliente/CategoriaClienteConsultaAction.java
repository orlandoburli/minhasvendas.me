package br.com.orlandoburli.minhasvendas.web.actions.venda.categoriacliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.minhasvendas.model.be.venda.CategoriaClienteBe;
import br.com.orlandoburli.minhasvendas.model.dao.venda.CategoriaClienteDao;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Vendas.CategoriaCliente;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.CategoriaClienteVo;

public class CategoriaClienteConsultaAction extends BaseConsultaAction<CategoriaClienteVo, CategoriaClienteDao, CategoriaClienteBe> {

	private static final long serialVersionUID = 1L;

	private String somenteAtivos;

	private EmpresaVo usuario;

	@Override
	public String getJspConsulta() {
		return "web/pages/venda/categoriacliente/categoriaclienteconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/venda/categoriacliente/categoriaclienteconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return CategoriaCliente.TABELA_CATEGORIA_CLIENTE + "." + CategoriaCliente.Colunas.PERCENTUAL_DESCONTO;
	}

	@Override
	public void doBeforeFilter(CategoriaClienteVo filter, CategoriaClienteBe be, HttpServletRequest request, HttpServletResponse response, StringBuilder whereCondition) {
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