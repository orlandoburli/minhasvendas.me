package br.com.orlandoburli.minhasvendas.web.actions.venda.vendedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.minhasvendas.model.be.venda.CategoriaVendedorBe;
import br.com.orlandoburli.minhasvendas.model.be.venda.VendedorBe;
import br.com.orlandoburli.minhasvendas.model.dao.venda.VendedorDao;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.VendedorVo;

public class VendedorCadastroAction extends BaseCadastroAction<VendedorVo, VendedorDao, VendedorBe> {

	private static final long serialVersionUID = 1L;

	private EmpresaVo usuario;

	@Override
	public String getJspCadastro() {
		return "web/pages/venda/vendedor/vendedorcadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, VendedorVo vo, VendedorBe be, DAOManager manager) throws ListException {
		super.doBeforeVisualizar(request, response, vo, be, manager);

		request.setAttribute("categorias", new CategoriaVendedorBe(manager).getListAtivos(usuario));
	}

	@Override
	public void doBeforeInserir(VendedorVo vo, DAOManager manager) throws br.com.orlandoburli.framework.core.be.exceptions.persistence.InsertBeException {
		vo.setIdEmpresa(usuario.getIdEmpresa());

		super.doBeforeInserir(vo, manager);
	};

	@Override
	public void rapido() {
		try {
			VendedorVo rapido = new VendedorBe(getManager()).cadastroRapido(getTerm(), usuario);

			writeSucesso("Vendedor adicionado com sucesso!", rapido);

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