package br.com.orlandoburli.minhasvendas.web.actions.venda.orcamento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.minhasvendas.model.be.venda.OrcamentoBe;
import br.com.orlandoburli.minhasvendas.model.dao.venda.OrcamentoDao;
import br.com.orlandoburli.minhasvendas.model.vo.venda.OrcamentoVo;

public class OrcamentoConsultaAction extends BaseConsultaAction<OrcamentoVo, OrcamentoDao, OrcamentoBe> {

	private static final long serialVersionUID = 1L;

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
		return null;
	}
	
	@Override
	public void doBeforeFilter(OrcamentoVo filter, OrcamentoBe be, HttpServletRequest request, HttpServletResponse response, StringBuilder whereCondition) {
		if (this.getParametroPesquisa() != null) {
			if (this.getParametroPesquisa().equalsIgnoreCase("idOrcamento")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(this.getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdOrcamento(codigo);
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("idEmpresa")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(this.getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdEmpresa(codigo);
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("idCliente")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(this.getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdCliente(codigo);
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("dataOrcamento")) {
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("idVendedor")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(this.getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdVendedor(codigo);
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("dataValidade")) {
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("valorItens")) {
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("valorDesconto")) {
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("valorTotal")) {
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("observacoes")) {
				filter.setObservacoes("%" + this.getPesquisarPor() + "%");
			}
		}
	}
}