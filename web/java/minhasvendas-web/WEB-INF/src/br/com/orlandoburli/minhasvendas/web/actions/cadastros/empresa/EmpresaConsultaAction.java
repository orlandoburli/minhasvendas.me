package br.com.orlandoburli.minhasvendas.web.actions.cadastros.empresa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.minhasvendas.model.be.cadastros.EmpresaBe;
import br.com.orlandoburli.minhasvendas.model.dao.cadastros.EmpresaDao;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;

public class EmpresaConsultaAction extends BaseConsultaAction<EmpresaVo, EmpresaDao, EmpresaBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/cadastros/empresa/empresaconsulta.jsp";
	}
	
	@Override
	public String getJspGridConsulta() {
		return "web/pages/cadastros/empresa/empresaconsulta_grid.jsp";
	}
	
	@Override
	public String getOrderFields() {
		return null;
	}
	
	@Override
	public void doBeforeFilter(EmpresaVo filter, EmpresaBe be, HttpServletRequest request, HttpServletResponse response, StringBuilder whereCondition) {
		if (this.getParametroPesquisa() != null) {
			if (this.getParametroPesquisa().equalsIgnoreCase("idEmpresa")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(this.getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdEmpresa(codigo);
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("razaoSocial")) {
				filter.setRazaoSocial("%" + this.getPesquisarPor() + "%");
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("fantasia")) {
				filter.setFantasia("%" + this.getPesquisarPor() + "%");
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("email")) {
				filter.setEmail("%" + this.getPesquisarPor() + "%");
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("tipo")) {
				filter.setTipo("%" + this.getPesquisarPor() + "%");
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("senha")) {
				filter.setSenha("%" + this.getPesquisarPor() + "%");
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("dataCadastro")) {
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("flagEmailConfirmado")) {
				filter.setFlagEmailConfirmado("%" + this.getPesquisarPor() + "%");
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("hash")) {
				filter.setHash("%" + this.getPesquisarPor() + "%");
			}
		}
	}
}