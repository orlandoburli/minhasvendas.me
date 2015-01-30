package br.com.orlandoburli.minhasvendas.model.vo.venda;

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
import br.com.orlandoburli.framework.core.dao.annotations.JoinWhen;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.minhasvendas.model.dicionario.cadastros.Empresa;
import br.com.orlandoburli.minhasvendas.model.dicionario.vendas.CategoriaVendedor;
import br.com.orlandoburli.minhasvendas.model.dicionario.vendas.CategoriaVendedor.Colunas;
import br.com.orlandoburli.minhasvendas.model.domains.SimNao;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;

@Table(CategoriaVendedor.TABELA_CATEGORIA_VENDEDOR)
public class CategoriaVendedorVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = Colunas.ID_CATEGORIA_VENDEDOR, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idCategoriaVendedor;

	@Column(name = Colunas.ID_EMPRESA, dataType = DataType.INT, isNotNull = true)
	@NotNull
	private Integer idEmpresa;

	@Column(name = Colunas.NOME, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@NotNull
	@NotEmpty
	@MaxSize(100)
	@FullTrim
	@Description("Nome")
	private String nome;

	@Column(name = Colunas.ATIVO, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	@Description("Ativo")
	private String ativo;

	@Column(name = Colunas.PERCENTUAL_COMISSAO, dataType = DataType.NUMERIC, maxSize = 5, precision = 2)
	@Precision(2)
	@NotNegative
	@Description("Percentual de Comissão")
	private BigDecimal percentualComissao;

	@Join(columnsLocal = { Colunas.ID_EMPRESA }, columnsRemote = { Empresa.Colunas.ID_EMPRESA }, joinWhen = JoinWhen.MANUAL)
	private EmpresaVo empresa;

	public String getAtivoDesc() {
		return new SimNao().getDescription(getAtivo());
	}

	public Integer getIdCategoriaVendedor() {
		return idCategoriaVendedor;
	}

	public void setIdCategoriaVendedor(Integer idCategoriaVendedor) {
		this.idCategoriaVendedor = idCategoriaVendedor;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
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

	public BigDecimal getPercentualComissao() {
		return percentualComissao;
	}

	public void setPercentualComissao(BigDecimal percentualComissao) {
		this.percentualComissao = percentualComissao;
	}

	public EmpresaVo getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaVo empresa) {
		this.empresa = empresa;
	}
}
