package br.com.orlandoburli.minhasvendas.web.actions.venda.categoriavendedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.be.exceptions.persistence.InsertBeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.minhasvendas.model.be.venda.CategoriaVendedorBe;
import br.com.orlandoburli.minhasvendas.model.dao.venda.CategoriaVendedorDao;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.CategoriaVendedorVo;

public class CategoriaVendedorCadastroAction extends BaseCadastroAction<CategoriaVendedorVo, CategoriaVendedorDao, CategoriaVendedorBe> {

	private static final long serialVersionUID = 1L;

	private EmpresaVo usuario;

	@Override
	public String getJspCadastro() {
		return "web/pages/venda/categoriavendedor/categoriavendedorcadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, CategoriaVendedorVo vo, CategoriaVendedorBe be, DAOManager manager) throws ListException {
		super.doBeforeVisualizar(request, response, vo, be, manager);
	}

	@Override
	public void doBeforeInserir(CategoriaVendedorVo vo, DAOManager manager) throws InsertBeException {
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