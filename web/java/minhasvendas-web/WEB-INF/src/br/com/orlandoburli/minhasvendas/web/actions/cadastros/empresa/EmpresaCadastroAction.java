package br.com.orlandoburli.minhasvendas.web.actions.cadastros.empresa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.minhasvendas.model.be.cadastros.EmpresaBe;
import br.com.orlandoburli.minhasvendas.model.dao.cadastros.EmpresaDao;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;

public class EmpresaCadastroAction extends BaseCadastroAction<EmpresaVo, EmpresaDao, EmpresaBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/cadastros/empresa/empresacadastro.jsp";
	}
	
	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, EmpresaVo vo, EmpresaBe be, DAOManager manager) throws ListException {
		super.doBeforeVisualizar(request, response, vo, be, manager);
	}
}