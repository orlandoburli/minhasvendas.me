package br.com.orlandoburli.minhasvendas.web.actions.estoque.localestoque;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.be.exceptions.persistence.InsertBeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.minhasvendas.model.be.estoque.LocalEstoqueBe;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.LocalEstoqueDao;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.LocalEstoqueVo;

public class LocalEstoqueCadastroAction extends BaseCadastroAction<LocalEstoqueVo, LocalEstoqueDao, LocalEstoqueBe> {

	private static final long serialVersionUID = 1L;

	private EmpresaVo usuario;

	@Override
	public String getJspCadastro() {
		return "web/pages/estoque/localestoque/localestoquecadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, LocalEstoqueVo vo, LocalEstoqueBe be, DAOManager manager) throws ListException {
		super.doBeforeVisualizar(request, response, vo, be, manager);
	}

	@Override
	public void doBeforeInserir(LocalEstoqueVo vo, DAOManager manager) throws InsertBeException {
		vo.setIdEmpresa(usuario.getIdEmpresa());

		super.doBeforeInserir(vo, manager);
	}

	public EmpresaVo getUsuario() {
		return usuario;
	}

	public void setUsuario(EmpresaVo usuario) {
		this.usuario = usuario;
	}
}