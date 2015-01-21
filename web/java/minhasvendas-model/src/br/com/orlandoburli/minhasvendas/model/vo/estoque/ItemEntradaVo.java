package br.com.orlandoburli.minhasvendas.model.vo.estoque;

import java.math.BigDecimal;

import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.Precision;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNegative;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotZero;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Estoque.Entrada;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Estoque.ItemEntrada;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Estoque.ItemEntrada.Colunas;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Estoque.Produto;

@Table(ItemEntrada.TABELA_ITEM_ENTRADA)
public class ItemEntradaVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = Colunas.ID_ITEM_ENTRADA, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idItemEntrada;

	@Column(name = Colunas.ID_ENTRADA, dataType = DataType.INT, isNotNull = true)
	@NotNull
	private Integer idEntrada;

	@Column(name = Colunas.ID_PRODUTO, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Produto")
	private Integer idProduto;

	@Column(name = Colunas.QUANTIDADE, dataType = DataType.NUMERIC, maxSize = 10, precision = 4, isNotNull = true)
	@Precision(0)
	@NotZero
	@NotNegative
	@Description("Quantidade")
	private BigDecimal quantidade;

	@Column(name = Colunas.VALOR_COMPRA, dataType = DataType.NUMERIC, maxSize = 20, precision = 4, isNotNull = true)
	@Precision(2)
	@NotNegative
	@Description("Valor de Compra")
	private BigDecimal valorCompra;

	@Join(columnsLocal = { Colunas.ID_ENTRADA }, columnsRemote = { Entrada.Colunas.ID_ENTRADA })
	private EntradaVo entrada;

	@Join(columnsLocal = { Colunas.ID_PRODUTO }, columnsRemote = { Produto.Colunas.ID_PRODUTO })
	private ProdutoVo produto;

	public Integer getIdItemEntrada() {
		return idItemEntrada;
	}

	public void setIdItemEntrada(Integer idItemEntrada) {
		this.idItemEntrada = idItemEntrada;
	}

	public Integer getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(Integer idEntrada) {
		this.idEntrada = idEntrada;
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

	public EntradaVo getEntrada() {
		return entrada;
	}

	public void setEntrada(EntradaVo entrada) {
		this.entrada = entrada;
	}

	public ProdutoVo getProduto() {
		return produto;
	}

	public void setProduto(ProdutoVo produto) {
		this.produto = produto;
	}
}
