package br.com.orlandoburli.minhasvendas.web.actions.estoque.fornecedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.be.exceptions.persistence.InsertBeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.minhasvendas.model.be.estoque.FornecedorBe;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.FornecedorDao;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.FornecedorVo;

public class FornecedorCadastroAction extends BaseCadastroAction<FornecedorVo, FornecedorDao, FornecedorBe> {

	private static final long serialVersionUID = 1L;

	private EmpresaVo usuario;

	@Override
	public String getJspCadastro() {
		return "web/pages/estoque/fornecedor/fornecedorcadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, FornecedorVo vo, FornecedorBe be, DAOManager manager) throws ListException {
		super.doBeforeVisualizar(request, response, vo, be, manager);
	}

	@Override
	public void doBeforeInserir(FornecedorVo vo, DAOManager manager) throws InsertBeException {
		super.doBeforeInserir(vo, manager);

		vo.setIdEmpresa(getUsuario().getIdEmpresa());
	}

	public EmpresaVo getUsuario() {
	    return usuario;
    }

	public void setUsuario(EmpresaVo usuario) {
	    this.usuario = usuario;
    }
}