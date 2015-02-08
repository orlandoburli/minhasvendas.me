package br.com.orlandoburli.minhasvendas.web.actions.venda.cliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.InsertBeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.minhasvendas.model.be.venda.CategoriaClienteBe;
import br.com.orlandoburli.minhasvendas.model.be.venda.ClienteBe;
import br.com.orlandoburli.minhasvendas.model.dao.venda.ClienteDao;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.ClienteVo;

public class ClienteCadastroAction extends BaseCadastroAction<ClienteVo, ClienteDao, ClienteBe> {

	private static final long serialVersionUID = 1L;

	private EmpresaVo usuario;

	@Override
	public String getJspCadastro() {
		return "web/pages/venda/cliente/clientecadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, ClienteVo vo, ClienteBe be, DAOManager manager) throws ListException {
		super.doBeforeVisualizar(request, response, vo, be, manager);

		request.setAttribute("categorias", new CategoriaClienteBe(manager).getListAtivos(usuario));
	}

	@Override
	public void doBeforeInserir(ClienteVo vo, DAOManager manager) throws InsertBeException {
		vo.setIdEmpresa(usuario.getIdEmpresa());

		super.doBeforeInserir(vo, manager);
	}

	@Override
	public void rapido() {
		try {
			ClienteVo rapido = new ClienteBe(getManager()).cadastroRapido(getTerm(), usuario);

			writeSucesso("Cliente adicionado com sucesso!", rapido);

		} catch (BeException e) {
			writeErrorMessage(e.getMessage());
		} finally {
			getManager().commit();
		}
	}

	public EmpresaVo getUsuario() {
		return usuario;
	}

	public void setUsuario(EmpresaVo usuario) {
		this.usuario = usuario;
	}
}