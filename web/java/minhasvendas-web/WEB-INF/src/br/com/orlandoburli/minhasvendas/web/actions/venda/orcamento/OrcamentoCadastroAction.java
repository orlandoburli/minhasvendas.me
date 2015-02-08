package br.com.orlandoburli.minhasvendas.web.actions.venda.orcamento;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.be.exceptions.persistence.InsertBeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;
import br.com.orlandoburli.framework.core.utils.Utils;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.minhasvendas.model.be.venda.ClienteBe;
import br.com.orlandoburli.minhasvendas.model.be.venda.OrcamentoBe;
import br.com.orlandoburli.minhasvendas.model.be.venda.VendedorBe;
import br.com.orlandoburli.minhasvendas.model.dao.venda.OrcamentoDao;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.ClienteVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.OrcamentoVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.VendedorVo;

public class OrcamentoCadastroAction extends BaseCadastroAction<OrcamentoVo, OrcamentoDao, OrcamentoBe> {

	private static final long serialVersionUID = 1L;

	private EmpresaVo usuario;

	private String query;

	private Integer idSource;

	@Override
	public String getJspCadastro() {
		return "web/pages/venda/orcamento/orcamentocadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, OrcamentoVo vo, OrcamentoBe be, DAOManager manager) throws ListException {
		super.doBeforeVisualizar(request, response, vo, be, manager);
		if (getOperacao().equals(Constants.INSERIR)) {
			vo.setDataOrcamento(Calendar.getInstance());
		}
	}

	@Override
	public void doBeforeInserir(OrcamentoVo vo, DAOManager manager) throws InsertBeException {
		super.doBeforeInserir(vo, manager);

		vo.setIdEmpresa(usuario.getIdEmpresa());
		vo.setEmpresa(usuario);
	}

	public void clientes() {
		try {
			ClienteBe clienteBe = new ClienteBe(getManager());
			List<ClienteVo> listAtivos = null;

			if (getIdSource() != null && getIdSource() > 0) {
				// Busca unica
				listAtivos = new ArrayList<ClienteVo>();
				listAtivos.add(clienteBe.get(getIdSource()));
			} else {
				// Busca lista
				listAtivos = clienteBe.getListAtivos(usuario, getQuery());
			}
			write(Utils.listToJson(clienteBe.toJsonItemListCustom(listAtivos)));
		} catch (ListException e) {
			Log.error(e);
		} finally {
			getManager().commit();
		}
	}

	public void vendedores() {
		try {
			VendedorBe vendedorBe = new VendedorBe(getManager());
			List<VendedorVo> listAtivos = null;

			if (getIdSource() != null && getIdSource() > 0) {
				// Busca unica
				listAtivos = new ArrayList<VendedorVo>();
				listAtivos.add(vendedorBe.get(getIdSource()));
			} else {
				// Busca lista
				listAtivos = vendedorBe.getListAtivos(usuario, getQuery());
			}
			write(Utils.listToJson(vendedorBe.toJsonItemListCustom(listAtivos)));
		} catch (ListException e) {
			Log.error(e);
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

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Integer getIdSource() {
		return idSource;
	}

	public void setIdSource(Integer idSource) {
		this.idSource = idSource;
	}
}