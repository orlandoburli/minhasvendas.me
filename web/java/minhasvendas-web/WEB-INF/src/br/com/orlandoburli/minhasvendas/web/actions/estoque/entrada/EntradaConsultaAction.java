package br.com.orlandoburli.minhasvendas.web.actions.estoque.entrada;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.minhasvendas.model.be.estoque.EntradaBe;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.EntradaDao;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Estoque.Entrada;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.EntradaVo;

public class EntradaConsultaAction extends BaseConsultaAction<EntradaVo, EntradaDao, EntradaBe> {

	private static final long serialVersionUID = 1L;

	private EmpresaVo usuario;

	@Override
	public String getJspConsulta() {
		return "web/pages/estoque/entrada/entradaconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/estoque/entrada/entradaconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Entrada.TABELA_ENTRADA + "." + Entrada.Colunas.DATA_EMISSAO_DOCUMENTO + " DESC";
	}

	@Override
	public void doBeforeFilter(EntradaVo filter, EntradaBe be, HttpServletRequest request, HttpServletResponse response, StringBuilder whereCondition) {
		filter.setIdEmpresa(usuario.getIdEmpresa());

		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("idEntrada")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdEntrada(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("idEmpresa")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdEmpresa(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("numeroDocumento")) {
				filter.setNumeroDocumento("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("serie")) {
				filter.setSerie("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("dataEmissaoDocumento")) {
			} else if (getParametroPesquisa().equalsIgnoreCase("status")) {
				filter.setStatus("%" + getPesquisarPor() + "%");
			}
		}
	}

	public EmpresaVo getUsuario() {
		return usuario;
	}

	public void setUsuario(EmpresaVo usuario) {
		this.usuario = usuario;
	}
}