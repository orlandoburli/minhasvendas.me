package br.com.orlandoburli.minhasvendas.web.actions.estoque.categoriaproduto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.be.exceptions.persistence.InsertBeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.minhasvendas.model.be.estoque.CategoriaProdutoBe;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.CategoriaProdutoDao;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.CategoriaProdutoVo;

public class CategoriaProdutoCadastroAction extends BaseCadastroAction<CategoriaProdutoVo, CategoriaProdutoDao, CategoriaProdutoBe> {

	private static final long serialVersionUID = 1L;

	private EmpresaVo usuario;

	@Override
	public String getJspCadastro() {
		return "web/pages/estoque/categoriaproduto/categoriaprodutocadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, CategoriaProdutoVo vo, CategoriaProdutoBe be, DAOManager manager) throws ListException {
		super.doBeforeVisualizar(request, response, vo, be, manager);
	}

	@Override
	public void doBeforeInserir(CategoriaProdutoVo vo, DAOManager manager) throws InsertBeException {
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