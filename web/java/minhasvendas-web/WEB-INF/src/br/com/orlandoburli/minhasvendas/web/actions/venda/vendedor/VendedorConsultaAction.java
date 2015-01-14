package br.com.orlandoburli.minhasvendas.web.actions.venda.vendedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.minhasvendas.model.be.venda.VendedorBe;
import br.com.orlandoburli.minhasvendas.model.dao.venda.VendedorDao;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Vendas.Vendedor;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.VendedorVo;

public class VendedorConsultaAction extends BaseConsultaAction<VendedorVo, VendedorDao, VendedorBe> {

	private static final long serialVersionUID = 1L;

	private String somenteAtivos;

	private EmpresaVo usuario;

	@Override
	public String getJspConsulta() {
		return "web/pages/venda/vendedor/vendedorconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/venda/vendedor/vendedorconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Vendedor.TABELA_VENDEDOR + "." + Vendedor.Colunas.NOME;
	}

	@Override
	public void doBeforeFilter(VendedorVo filter, VendedorBe be, HttpServletRequest request, HttpServletResponse response, StringBuilder whereCondition) {
		filter.setIdEmpresa(usuario.getIdEmpresa());

		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("idVendedor")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdVendedor(codigo);
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