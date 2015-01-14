package br.com.orlandoburli.minhasvendas.web.actions.venda.cliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.minhasvendas.model.be.venda.ClienteBe;
import br.com.orlandoburli.minhasvendas.model.dao.venda.ClienteDao;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Vendas.Cliente;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.ClienteVo;

public class ClienteConsultaAction extends BaseConsultaAction<ClienteVo, ClienteDao, ClienteBe> {

	private static final long serialVersionUID = 1L;

	private EmpresaVo usuario;

	@Override
	public String getJspConsulta() {
		return "web/pages/venda/cliente/clienteconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/venda/cliente/clienteconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Cliente.TABELA_CLIENTE + "." + Cliente.Colunas.NOME;
	}

	@Override
	public void doBeforeFilter(ClienteVo filter, ClienteBe be, HttpServletRequest request, HttpServletResponse response, StringBuilder whereCondition) {
		filter.setIdEmpresa(usuario.getIdEmpresa());

		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("idCliente")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdCliente(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("idEmpresa")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdEmpresa(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("dataNascimento")) {
			} else if (getParametroPesquisa().equalsIgnoreCase("fone1")) {
				filter.setFone1("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("fone2")) {
				filter.setFone2("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("fone3")) {
				filter.setFone3("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("cep")) {
				filter.setCep("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("endereco")) {
				filter.setEndereco("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("bairro")) {
				filter.setBairro("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("cidade")) {
				filter.setCidade("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("uf")) {
				filter.setUf("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("idCategoriaCliente")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdCategoriaCliente(codigo);
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