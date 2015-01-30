package br.com.orlandoburli.minhasvendas.web.actions.estoque.itementrada;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.minhasvendas.model.be.estoque.ItemEntradaBe;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.ItemEntradaDao;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.ItemEntradaVo;

public class ItemEntradaCadastroAction extends BaseCadastroAction<ItemEntradaVo, ItemEntradaDao, ItemEntradaBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/estoque/itementrada/itementradacadastro.jsp";
	}
	
	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, ItemEntradaVo vo, ItemEntradaBe be, DAOManager manager) throws ListException {
		super.doBeforeVisualizar(request, response, vo, be, manager);
	}
}