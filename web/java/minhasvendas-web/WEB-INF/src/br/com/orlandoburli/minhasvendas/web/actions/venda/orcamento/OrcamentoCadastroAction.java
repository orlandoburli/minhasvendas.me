package br.com.orlandoburli.minhasvendas.web.actions.venda.orcamento;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.InsertBeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.UpdateBeException;
import br.com.orlandoburli.framework.core.be.exceptions.validation.ValidationBeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;
import br.com.orlandoburli.framework.core.utils.Utils;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.framework.core.web.ICadastroFilhoAction;
import br.com.orlandoburli.framework.core.web.filters.OutjectSession;
import br.com.orlandoburli.framework.core.web.retorno.RetornoAction;
import br.com.orlandoburli.minhasvendas.model.be.estoque.ProdutoBe;
import br.com.orlandoburli.minhasvendas.model.be.venda.ClienteBe;
import br.com.orlandoburli.minhasvendas.model.be.venda.ItemOrcamentoBe;
import br.com.orlandoburli.minhasvendas.model.be.venda.OrcamentoBe;
import br.com.orlandoburli.minhasvendas.model.be.venda.VendedorBe;
import br.com.orlandoburli.minhasvendas.model.dao.venda.OrcamentoDao;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.ProdutoVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.ClienteVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.ItemOrcamentoVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.OrcamentoVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.VendedorVo;

public class OrcamentoCadastroAction extends BaseCadastroAction<OrcamentoVo, OrcamentoDao, OrcamentoBe> implements ICadastroFilhoAction {

	private static final long serialVersionUID = 1L;

	private EmpresaVo usuario;

	private String query;

	private Integer idSource;

	private Integer index;

	@OutjectSession("itensOrcamentoRemover")
	private List<ItemOrcamentoVo> itensOrcamentoRemover;

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

		itensOrcamentoRemover = null;
	}

	@Override
	public void doBeforeAlterar(OrcamentoVo vo, DAOManager manager) throws UpdateBeException, BeException {
		super.doBeforeAlterar(vo, manager);

		new ItemOrcamentoBe(manager).remove(getItensOrcamentoRemover());
	}

	@Override
	public void doBeforeInserir(OrcamentoVo vo, DAOManager manager) throws InsertBeException {
		super.doBeforeInserir(vo, manager);

		vo.setIdEmpresa(usuario.getIdEmpresa());
		vo.setEmpresa(usuario);
	}

	@Override
	public void doBeforeWriteVo(OrcamentoVo vo) {
		super.doBeforeWriteVo(vo);

		try {
			if (vo != null) {
				vo.setItens(new ItemOrcamentoBe(getManager()).getList(vo));
			}
		} catch (ListException e) {
			Log.error(e);
		}
	}

	public void produtos() {
		try {
			ProdutoBe produtoBe = new ProdutoBe(getManager());
			List<ProdutoVo> listAtivos = null;

			if (getIdSource() != null && getIdSource() > 0) {
				// Busca unica
				listAtivos = new ArrayList<ProdutoVo>();
				listAtivos.add(produtoBe.get(getIdSource()));
			} else {
				// Busca lista
				listAtivos = produtoBe.getListAtivos(usuario, query);
			}
			write(Utils.listToJson(produtoBe.toJsonItemListCustom(listAtivos)));
		} catch (ListException e) {
			Log.error(e);
		} finally {
			getManager().commit();
		}
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

	@Override
	public void grid() {
		getRequest().setAttribute("vo", getVoSession());

		forward("web/pages/venda/itemorcamento/itemorcamentoconsulta_grid.jsp");
	}

	@Override
	public void adicionaritem() {
		try {
			OrcamentoVo orcamento = getVoSession();

			if (orcamento == null) {
				orcamento = new OrcamentoVo();
				orcamento.setIdOrcamento(0);
			}

			ItemOrcamentoVo item = new ItemOrcamentoVo();
			injectVo(item);

			item.setIdOrcamento(orcamento.getIdOrcamento());

			new ItemOrcamentoBe(getManager()).validate(item);

			orcamento.getItens().add(item);

			setVoSession(orcamento);

			write(Utils.voToJson(new RetornoAction(true, "Item adicionado!", item)));
		} catch (ValidationBeException e) {
			writeErrorMessage(e.getMessage(), e.getField());
		} catch (BeException e) {
			Log.error(e);
			writeErrorMessage(e.getMessage(), e.getField());
		}

	}

	@Override
	public void alteraritem() {
		try {
			Log.fine("Editando item...");

			OrcamentoVo orcamento = getVoSession();

			if (orcamento == null) {
				orcamento = new OrcamentoVo();
			}

			if (getIndex() == null || getIndex() < 0) {
				writeErrorMessage("Indice não informado!");
				return;
			} else if (getIndex() >= orcamento.getItens().size()) {
				writeErrorMessage("Indice " + getIndex() + " fora da faixa de valores!");
				return;
			}

			ItemOrcamentoVo item = orcamento.getItens().get(getIndex());

			injectVo(item);

			new ItemOrcamentoBe(getManager()).validate(item);

			setVoSession(orcamento);

			write(Utils.voToJson(new RetornoAction(true, "Item alterado!", item)));
		} catch (ValidationBeException e) {
			writeErrorMessage(e.getMessage(), e.getField());
		} catch (BeException e) {
			e.printStackTrace();
			writeErrorMessage(e.getMessage(), e.getField());
		}
	}

	@Override
	public void removeritem() {
		OrcamentoVo orcamento = getVoSession();

		if (getIndex() == null || getIndex() < 0) {
			writeErrorMessage("Indice não informado!");
			return;
		} else if (getIndex() >= orcamento.getItens().size()) {
			writeErrorMessage("Indice " + getIndex() + " fora da faixa de valores!");
			return;
		}

		ItemOrcamentoVo itemRemover = orcamento.getItens().remove(getIndex().intValue());

		getItensOrcamentoRemover().add(itemRemover);

		writeSucesso("Item removido!");

	}

	@Override
	public void total() {
		OrcamentoVo orcamento = getVoSession();

		if (orcamento == null) {
			orcamento = new OrcamentoVo();
			orcamento.setIdOrcamento(0);
		}

		injectVo(orcamento);

		new OrcamentoBe(getManager()).calcularTotal(orcamento);

		setVoSession(orcamento);

		writeSucesso("OK", orcamento);
	}

	public List<ItemOrcamentoVo> getItensOrcamentoRemover() {
		if (itensOrcamentoRemover == null) {
			itensOrcamentoRemover = new ArrayList<ItemOrcamentoVo>();
		}
		return itensOrcamentoRemover;
	}

	public void setItensOrcamentoRemover(List<ItemOrcamentoVo> itensOrcamentoRemover) {
		this.itensOrcamentoRemover = itensOrcamentoRemover;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
}