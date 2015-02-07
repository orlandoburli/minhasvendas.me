package br.com.orlandoburli.minhasvendas.web.actions.estoque.fornecedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.minhasvendas.model.be.estoque.FornecedorBe;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.FornecedorDao;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.FornecedorVo;

public class FornecedorConsultaAction extends BaseConsultaAction<FornecedorVo, FornecedorDao, FornecedorBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/estoque/fornecedor/fornecedorconsulta.jsp";
	}
	
	@Override
	public String getJspGridConsulta() {
		return "web/pages/estoque/fornecedor/fornecedorconsulta_grid.jsp";
	}
	
	@Override
	public String getOrderFields() {
		return null;
	}
	
	@Override
	public void doBeforeFilter(FornecedorVo filter, FornecedorBe be, HttpServletRequest request, HttpServletResponse response, StringBuilder whereCondition) {
		if (this.getParametroPesquisa() != null) {
			if (this.getParametroPesquisa().equalsIgnoreCase("idFornecedor")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(this.getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdFornecedor(codigo);
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("nome")) {
				filter.setNome("%" + this.getPesquisarPor() + "%");
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("razaoSocial")) {
				filter.setRazaoSocial("%" + this.getPesquisarPor() + "%");
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("cpfCnpj")) {
				filter.setCpfCnpj("%" + this.getPesquisarPor() + "%");
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("fone01")) {
				filter.setFone01("%" + this.getPesquisarPor() + "%");
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("fone02")) {
				filter.setFone02("%" + this.getPesquisarPor() + "%");
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("fone03")) {
				filter.setFone03("%" + this.getPesquisarPor() + "%");
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("observacoes")) {
				filter.setObservacoes("%" + this.getPesquisarPor() + "%");
			}
		}
	}
}