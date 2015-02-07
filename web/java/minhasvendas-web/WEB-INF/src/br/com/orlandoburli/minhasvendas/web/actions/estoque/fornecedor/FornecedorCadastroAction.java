package br.com.orlandoburli.minhasvendas.web.actions.estoque.fornecedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.minhasvendas.model.be.estoque.FornecedorBe;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.FornecedorDao;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.FornecedorVo;

public class FornecedorCadastroAction extends BaseCadastroAction<FornecedorVo, FornecedorDao, FornecedorBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/estoque/fornecedor/fornecedorcadastro.jsp";
	}
	
	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, FornecedorVo vo, FornecedorBe be, DAOManager manager) throws ListException {
		super.doBeforeVisualizar(request, response, vo, be, manager);
	}
}