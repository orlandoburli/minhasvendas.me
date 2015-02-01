package br.com.orlandoburli.minhasvendas.web.actions.venda.orcamento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.minhasvendas.model.be.venda.OrcamentoBe;
import br.com.orlandoburli.minhasvendas.model.dao.venda.OrcamentoDao;
import br.com.orlandoburli.minhasvendas.model.vo.venda.OrcamentoVo;

public class OrcamentoCadastroAction extends BaseCadastroAction<OrcamentoVo, OrcamentoDao, OrcamentoBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/venda/orcamento/orcamentocadastro.jsp";
	}
	
	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, OrcamentoVo vo, OrcamentoBe be, DAOManager manager) throws ListException {
		super.doBeforeVisualizar(request, response, vo, be, manager);
	}
}