package br.com.orlandoburli.minhasvendas.web.actions.venda.categoriacliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.be.exceptions.persistence.InsertBeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.minhasvendas.model.be.venda.CategoriaClienteBe;
import br.com.orlandoburli.minhasvendas.model.dao.venda.CategoriaClienteDao;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.CategoriaClienteVo;

public class CategoriaClienteCadastroAction extends BaseCadastroAction<CategoriaClienteVo, CategoriaClienteDao, CategoriaClienteBe> {

	private static final long serialVersionUID = 1L;

	private EmpresaVo usuario;

	@Override
	public String getJspCadastro() {
		return "web/pages/venda/categoriacliente/categoriaclientecadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, CategoriaClienteVo vo, CategoriaClienteBe be, DAOManager manager) throws ListException {
		super.doBeforeVisualizar(request, response, vo, be, manager);
	}

	@Override
	public void doBeforeInserir(CategoriaClienteVo vo, DAOManager manager) throws InsertBeException {
		vo.setIdEmpresa(getUsuario().getIdEmpresa());

		super.doBeforeInserir(vo, manager);
	}

	public EmpresaVo getUsuario() {
		return usuario;
	}

	public void setUsuario(EmpresaVo usuario) {
		this.usuario = usuario;
	}
}