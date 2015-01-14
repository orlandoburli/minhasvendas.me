package br.com.orlandoburli.minhasvendas.model.vo.estoque;

import java.math.BigDecimal;

import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FullTrim;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.Precision;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNegative;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.minhasvendas.model.domains.SimNao;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Cadastros.Empresa;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Estoque.CategoriaProduto;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Estoque.Produto;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Estoque.Produto.Colunas;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;

@Table(Produto.TABELA_PRODUTO)
public class ProdutoVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = Colunas.ID_PRODUTO, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	@Description("Código")
	private Integer idProduto;

	@Column(name = Colunas.ID_EMPRESA, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@Description("Empresa")
	private Integer idEmpresa;

	@Column(name = Colunas.CODIGO_PRODUTO, dataType = DataType.VARCHAR, maxSize = 100)
	@Description("Código do Produto")
	private String codigoProduto;

	@Column(name = Colunas.NOME, dataType = DataType.VARCHAR, maxSize = 200, isNotNull = true)
	@NotNull
	@NotEmpty
	@FullTrim
	@MaxSize(200)
	@Description("Nome")
	private String nome;

	@Column(name = Colunas.VALOR_VENDA, dataType = DataType.NUMERIC, precision = 4, maxSize = 20)
	@Precision(4)
	@NotNegative
	@Description("Valor de venda")
	private BigDecimal valorVenda;

	@Column(name = Colunas.ATIVO, dataType = DataType.CHAR, isNotNull = true, maxSize = 1, defaultValue = "'C'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	@Description("Ativo")
	private String ativo;

	@Column(name = Colunas.ID_CATEGORIA_PRODUTO, dataType = DataType.INT)
	@Description("Categoria")
	private Integer idCategoriaProduto;

	@Join(columnsLocal = { Colunas.ID_EMPRESA }, columnsRemote = { Empresa.Colunas.ID_EMPRESA })
	private EmpresaVo empresa;

	@Join(columnsLocal = { Colunas.ID_CATEGORIA_PRODUTO }, columnsRemote = { CategoriaProduto.Colunas.ID_CATEGORIA_PRODUTO })
	private CategoriaProdutoVo categoria;

	public String getAtivoDesc() {
		return new SimNao().getDescription(getAtivo());
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public Integer getIdCategoriaProduto() {
		return idCategoriaProduto;
	}

	public void setIdCategoriaProduto(Integer idCategoriaProduto) {
		this.idCategoriaProduto = idCategoriaProduto;
	}

	public EmpresaVo getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaVo empresa) {
		this.empresa = empresa;
	}

	public CategoriaProdutoVo getCategoria() {
		if (categoria == null) {
			categoria = new CategoriaProdutoVo();
		}
		return categoria;
	}

	public void setCategoria(CategoriaProdutoVo categoria) {
		this.categoria = categoria;
	}
}
