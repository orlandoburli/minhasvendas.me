package br.com.orlandoburli.minhasvendas.model.vo.venda;

import java.math.BigDecimal;

import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FullTrim;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNegative;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.JoinWhen;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.minhasvendas.model.dicionario.cadastros.Empresa;
import br.com.orlandoburli.minhasvendas.model.dicionario.vendas.CategoriaCliente;
import br.com.orlandoburli.minhasvendas.model.dicionario.vendas.CategoriaCliente.Colunas;
import br.com.orlandoburli.minhasvendas.model.domains.SimNao;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;

@Table(CategoriaCliente.TABELA_CATEGORIA_CLIENTE)
public class CategoriaClienteVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = Colunas.ID_CATEGORIA_CLIENTE, dataType = DataType.INT, isNotNull = true, isKey = true, isAutoIncrement = true)
	@Description("Código")
	private Integer idCategoria;

	@Column(name = Colunas.ID_EMPRESA, dataType = DataType.INT, isNotNull = true)
	@Description("Empresa")
	@NotNull
	private Integer idEmpresa;

	@Column(name = Colunas.NOME, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@Description("Nome")
	@NotNull
	@NotEmpty
	@MaxSize(100)
	@FullTrim
	private String nome;

	@Column(name = Colunas.ATIVO, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	@Description("Ativo")
	private String ativo;

	@Column(name = Colunas.PERCENTUAL_DESCONTO, dataType = DataType.NUMERIC, maxSize = 5, precision = 2)
	@NotNegative
	@Description("Percentual de Desconto")
	private BigDecimal percentualDesconto;

	@Join(columnsLocal = { Colunas.ID_EMPRESA }, columnsRemote = { Empresa.Colunas.ID_EMPRESA }, joinWhen = JoinWhen.MANUAL)
	private EmpresaVo empresa;

	public String getAtivoDesc() {
		return new SimNao().getDescription(getAtivo());
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public EmpresaVo getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaVo empresa) {
		this.empresa = empresa;
	}

	public BigDecimal getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(BigDecimal percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}
}
