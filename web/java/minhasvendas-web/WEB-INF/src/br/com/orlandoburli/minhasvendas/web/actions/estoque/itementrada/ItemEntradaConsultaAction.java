package br.com.orlandoburli.minhasvendas.web.actions.estoque.itementrada;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.minhasvendas.model.be.estoque.ItemEntradaBe;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.ItemEntradaDao;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.ItemEntradaVo;

public class ItemEntradaConsultaAction extends BaseConsultaAction<ItemEntradaVo, ItemEntradaDao, ItemEntradaBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/estoque/itementrada/itementradaconsulta.jsp";
	}
	
	@Override
	public String getJspGridConsulta() {
		return "web/pages/estoque/itementrada/itementradaconsulta_grid.jsp";
	}
	
	@Override
	public String getOrderFields() {
		return null;
	}
	
	@Override
	public void doBeforeFilter(ItemEntradaVo filter, ItemEntradaBe be, HttpServletRequest request, HttpServletResponse response, StringBuilder whereCondition) {
		if (this.getParametroPesquisa() != null) {
			if (this.getParametroPesquisa().equalsIgnoreCase("idItemEntrada")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(this.getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdItemEntrada(codigo);
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("idEntrada")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(this.getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdEntrada(codigo);
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("idProduto")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(this.getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdProduto(codigo);
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("quantidade")) {
			}
			else if (this.getParametroPesquisa().equalsIgnoreCase("valorCompra")) {
			}
		}
	}
}