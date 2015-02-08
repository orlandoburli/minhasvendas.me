package br.com.orlandoburli.minhasvendas.web.actions.venda.orcamento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.minhasvendas.model.be.venda.OrcamentoBe;
import br.com.orlandoburli.minhasvendas.model.dao.venda.OrcamentoDao;
import br.com.orlandoburli.minhasvendas.model.dicionario.vendas.Orcamento;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.OrcamentoVo;

public class OrcamentoConsultaAction extends BaseConsultaAction<OrcamentoVo, OrcamentoDao, OrcamentoBe> {

	private static final long serialVersionUID = 1L;

	private EmpresaVo usuario;

	@Override
	public String getJspConsulta() {
		return "web/pages/venda/orcamento/orcamentoconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/venda/orcamento/orcamentoconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Orcamento.TABELA_ORCAMENTO + "." + Orcamento.Colunas.DATA_ORCAMENTO + " DESC";
	}

	@Override
	public void doBeforeFilter(OrcamentoVo filter, OrcamentoBe be, HttpServletRequest request, HttpServletResponse response, StringBuilder whereCondition) {
		filter.setIdEmpresa(usuario.getIdEmpresa());

		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("idOrcamento")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdOrcamento(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("idEmpresa")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdEmpresa(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("idCliente")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdCliente(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("dataOrcamento")) {
			} else if (getParametroPesquisa().equalsIgnoreCase("idVendedor")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdVendedor(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("dataValidade")) {
			} else if (getParametroPesquisa().equalsIgnoreCase("valorItens")) {
			} else if (getParametroPesquisa().equalsIgnoreCase("valorDesconto")) {
			} else if (getParametroPesquisa().equalsIgnoreCase("valorTotal")) {
			} else if (getParametroPesquisa().equalsIgnoreCase("observacoes")) {
				filter.setObservacoes("%" + getPesquisarPor() + "%");
			}
		}
	}

	public EmpresaVo getUsuario() {
		return usuario;
	}

	public void setUsuario(EmpresaVo usuario) {
		this.usuario = usuario;
	}
}