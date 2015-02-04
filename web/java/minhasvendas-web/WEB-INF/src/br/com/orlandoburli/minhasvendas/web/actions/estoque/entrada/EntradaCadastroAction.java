package br.com.orlandoburli.minhasvendas.web.actions.estoque.entrada;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.InsertBeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.SaveBeException;
import br.com.orlandoburli.framework.core.be.exceptions.validation.ValidationBeException;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.Precision;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Utils;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.framework.core.web.filters.OutjectSession;
import br.com.orlandoburli.framework.core.web.retorno.RetornoAction;
import br.com.orlandoburli.minhasvendas.model.be.estoque.EntradaBe;
import br.com.orlandoburli.minhasvendas.model.be.estoque.ItemEntradaBe;
import br.com.orlandoburli.minhasvendas.model.be.estoque.ProdutoBe;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.EntradaDao;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.EntradaVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.ItemEntradaVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.ProdutoVo;

public class EntradaCadastroAction extends BaseCadastroAction<EntradaVo, EntradaDao, EntradaBe> {

	private static final long serialVersionUID = 1L;

	private EmpresaVo usuario;
	private String query;

	private Integer idProduto;

	private Integer index;

	@Precision(0)
	private BigDecimal quantidade;

	@Precision(2)
	private BigDecimal valorCompra;

	@OutjectSession("itensRemover")
	private List<ItemEntradaVo> itensRemover;

	@Override
	public String getJspCadastro() {
		return "web/pages/estoque/entrada/entradacadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, EntradaVo vo, EntradaBe be, DAOManager manager) throws ListException {
		super.doBeforeVisualizar(request, response, vo, be, manager);

		// Limpa ao entrar no cadastro
		itensRemover = null;
	}

	@Override
	public void doBeforeAlterar(EntradaVo vo, DAOManager manager) throws BeException {
		super.doBeforeAlterar(vo, manager);

		new ItemEntradaBe(manager).remove(getItensRemover());
	}

	public void total() {

		EntradaVo entrada = getVoSession();
		new EntradaBe(getManager()).calcularTotal(entrada);

		writeSucesso("OK", entrada);
	}

	@Override
	public void doBeforeWriteVo(EntradaVo vo) {
		super.doBeforeWriteVo(vo);
		try {
			if (vo != null) {
				vo.setItens(new ItemEntradaBe(getManager()).getList(vo));
			}
		} catch (ListException e) {
			Log.error(e);
		}
	}

	@Override
	public void doBeforeInserir(EntradaVo vo, DAOManager manager) throws InsertBeException {
		vo.setIdEmpresa(usuario.getIdEmpresa());
		super.doBeforeInserir(vo, manager);
	}

	@Override
	public void doBeforeSalvar(EntradaVo vo, DAOManager manager) throws SaveBeException {
		super.doBeforeSalvar(vo, manager);
	}

	public void produtos() {
		try {
			ProdutoBe produtoBe = new ProdutoBe(getManager());

			List<ProdutoVo> listAtivos = produtoBe.getListAtivos(usuario, query);

			write(Utils.voToJson(produtoBe.toJsonItemListCustom(listAtivos)));
		} catch (ListException e) {
			Log.error(e);
		}
	}

	public void grid() {
		getRequest().setAttribute("vo", getVoSession());

		forward("web/pages/estoque/itementrada/itementradaconsulta_grid.jsp");
	}

	public void adicionaritem() {
		try {
			EntradaVo entrada = getVoSession();

			if (entrada == null) {
				entrada = new EntradaVo();
				entrada.setIdEntrada(0);
			}

			ItemEntradaVo item = new ItemEntradaVo();
			injectVo(item);

			item.setIdEntrada(entrada.getIdEntrada());

			new ItemEntradaBe(getManager()).validate(item);

			entrada.getItens().add(item);

			setVoSession(entrada);

			write(Utils.voToJson(new RetornoAction(true, "Item adicionado!", item)));
		} catch (ValidationBeException e) {
			writeErrorMessage(e.getMessage());
		} catch (BeException e) {
			Log.error(e);
			writeErrorMessage(e.getMessage());
		}
	}

	public void removeritem() {
		EntradaVo entrada = getVoSession();

		if (getIndex() == null || getIndex() < 0) {
			writeErrorMessage("Indice não informado!");
			return;
		} else if (getIndex() >= entrada.getItens().size()) {
			writeErrorMessage("Indice " + getIndex() + " fora da faixa de valores!");
			return;
		}

		ItemEntradaVo itemRemover = entrada.getItens().remove(getIndex().intValue());

		getItensRemover().add(itemRemover);

		writeSucesso("Item removido!");
	}

	public void alteraritem() {
		try {
			Log.fine("Editando item...");

			EntradaVo entrada = getVoSession();

			if (entrada == null) {
				entrada = new EntradaVo();
			}

			if (getIndex() == null || getIndex() < 0) {
				writeErrorMessage("Indice não informado!");
				return;
			} else if (getIndex() >= entrada.getItens().size()) {
				writeErrorMessage("Indice " + getIndex() + " fora da faixa de valores!");
				return;
			}

			ItemEntradaVo item = entrada.getItens().get(getIndex());

			injectVo(item);

			new ItemEntradaBe(getManager()).validate(item);

			setVoSession(entrada);

			write(Utils.voToJson(new RetornoAction(true, "Item alterado!", item)));
		} catch (ValidationBeException e) {
			writeErrorMessage(e.getMessage(), e.getField());
		} catch (BeException e) {
			e.printStackTrace();
			writeErrorMessage(e.getMessage(), e.getField());
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

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}

	public List<ItemEntradaVo> getItensRemover() {
		if (itensRemover == null) {
			itensRemover = new ArrayList<ItemEntradaVo>();
		}
		return itensRemover;
	}

	public void setItensRemover(List<ItemEntradaVo> itensRemover) {
		this.itensRemover = itensRemover;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
}