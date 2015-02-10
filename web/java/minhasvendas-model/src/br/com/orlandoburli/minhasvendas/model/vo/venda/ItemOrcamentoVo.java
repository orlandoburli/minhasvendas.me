package br.com.orlandoburli.minhasvendas.model.vo.venda;

import java.math.BigDecimal;

import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNegative;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotZero;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.minhasvendas.model.dicionario.estoque.Produto;
import br.com.orlandoburli.minhasvendas.model.dicionario.vendas.ItemOrcamento;
import br.com.orlandoburli.minhasvendas.model.dicionario.vendas.ItemOrcamento.Colunas;
import br.com.orlandoburli.minhasvendas.model.dicionario.vendas.Orcamento;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.ProdutoVo;

@Table(ItemOrcamento.TABELA_ITEM_ORCAMENTO)
public class ItemOrcamentoVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = Colunas.ID_ITEM_ORCAMENTO, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idItemOrcamento;

	@Column(name = Colunas.ID_ORCAMENTO, dataType = DataType.INT, isNotNull = true)
	@Description("Orçamento")
	private Integer idOrcamento;

	@Column(name = Colunas.ID_PRODUTO, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@Description("Produto")
	private Integer idProduto;

	@Column(name = Colunas.QUANTIDADE, dataType = DataType.NUMERIC, maxSize = 10, precision = 2, isNotNull = true)
	@NotNull
	@NotZero
	@NotNegative
	@Description("Quantidade")
	private BigDecimal quantidade;

	@Column(name = Colunas.VALOR_UNITARIO, dataType = DataType.NUMERIC, maxSize = 10, precision = 2, isNotNull = true)
	@NotNull
	@NotZero
	@NotNegative
	@Description("Valor Unitário")
	private BigDecimal valorUnitario;

	@Column(name = Colunas.VALOR_DESCONTO, dataType = DataType.NUMERIC, maxSize = 18, precision = 2, isNotNull = true)
	@NotNull
	@NotNegative
	@Description("Valor Desconto")
	private BigDecimal valorDesconto;

	@Column(name = Colunas.VALOR_TOTAL, dataType = DataType.NUMERIC, maxSize = 18, precision = 2, isNotNull = true)
	@NotNull
	@NotNegative
	private BigDecimal valorTotal;

	@Join(columnsLocal = { Colunas.ID_ORCAMENTO }, columnsRemote = { Orcamento.Colunas.ID_ORCAMENTO })
	private OrcamentoVo orcamento;

	@Join(columnsLocal = { Colunas.ID_PRODUTO }, columnsRemote = { Produto.Colunas.ID_PRODUTO })
	private ProdutoVo produto;

	public Integer getIdItemOrcamento() {
		return idItemOrcamento;
	}

	public void setIdItemOrcamento(Integer idItemOrcamento) {
		this.idItemOrcamento = idItemOrcamento;
	}

	public Integer getIdOrcamento() {
		return idOrcamento;
	}

	public void setIdOrcamento(Integer idOrcamento) {
		this.idOrcamento = idOrcamento;
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

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public OrcamentoVo getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(OrcamentoVo orcamento) {
		this.orcamento = orcamento;
	}

	public ProdutoVo getProduto() {
		return produto;
	}

	public void setProduto(ProdutoVo produto) {
		this.produto = produto;
	}
}
