package br.com.orlandoburli.minhasvendas.web.actions.estoque.fornecedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.minhasvendas.model.be.estoque.FornecedorBe;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.FornecedorDao;
import br.com.orlandoburli.minhasvendas.model.dicionario.estoque.Fornecedor;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.FornecedorVo;

public class FornecedorConsultaAction extends BaseConsultaAction<FornecedorVo, FornecedorDao, FornecedorBe> {

	private static final long serialVersionUID = 1L;

	private EmpresaVo usuario;

	@Override
	public String getJspConsulta() {
		return "web/pages/estoque/fornecedor/fornecedorconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/estoque/fornecedor/fornecedorconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Fornecedor.TABELA_FORNECEDOR + "." + Fornecedor.Colunas.NOME;
	}

	@Override
	public void doBeforeFilter(FornecedorVo filter, FornecedorBe be, HttpServletRequest request, HttpServletResponse response, StringBuilder whereCondition) {
		filter.setIdEmpresa(usuario.getIdEmpresa());

		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("idFornecedor")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdFornecedor(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("razaoSocial")) {
				filter.setRazaoSocial("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("cpfCnpj")) {
				filter.setCpfCnpj("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("fone01")) {
				filter.setFone01("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("fone02")) {
				filter.setFone02("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("fone03")) {
				filter.setFone03("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("observacoes")) {
				filter.setObservacoes("%" + getPesquisarPor() + "%");
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