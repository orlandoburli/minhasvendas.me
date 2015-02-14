package br.com.orlandoburli.minhasvendas.web.actions.cadastros.empresa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.SaveBeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.utils.Constants;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.framework.core.web.filters.OutjectSession;
import br.com.orlandoburli.minhasvendas.model.be.cadastros.EmpresaBe;
import br.com.orlandoburli.minhasvendas.model.dao.cadastros.EmpresaDao;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;

public class EmpresaCadastroAction extends BaseCadastroAction<EmpresaVo, EmpresaDao, EmpresaBe> {

	private static final long serialVersionUID = 1L;

	@OutjectSession(Constants.Session.SESSION_USUARIO)
	private EmpresaVo usuario;

	@Override
	public String getJspCadastro() {
		return "web/pages/cadastros/empresa/empresacadastro.jsp";
	}

	@Override
	public void doBeforeGetOnVisualizar(HttpServletRequest request, HttpServletResponse response, EmpresaVo vo, EmpresaBe be, DAOManager manager) {
		super.doBeforeGetOnVisualizar(request, response, vo, be, manager);

		vo.setIdEmpresa(getUsuario().getIdEmpresa());
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, EmpresaVo vo, EmpresaBe be, DAOManager manager) throws ListException {
		super.doBeforeVisualizar(request, response, vo, be, manager);
	}

	@Override
	public void doAfterSalvar(EmpresaVo vo, DAOManager manager) throws SaveBeException, BeException {
		super.doAfterSalvar(vo, manager);

		// Salva na sessao novamente
		setUsuario(vo);
	}

	public EmpresaVo getUsuario() {
		return usuario;
	}

	public void setUsuario(EmpresaVo usuario) {
		this.usuario = usuario;
	}
}