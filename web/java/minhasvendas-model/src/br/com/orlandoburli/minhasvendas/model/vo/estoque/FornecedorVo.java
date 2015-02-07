package br.com.orlandoburli.minhasvendas.model.vo.estoque;

import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FilterOnly;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FullTrim;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.CpfCnpj;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.minhasvendas.model.dicionario.cadastros.Empresa;
import br.com.orlandoburli.minhasvendas.model.dicionario.estoque.Fornecedor;
import br.com.orlandoburli.minhasvendas.model.dicionario.estoque.Fornecedor.Colunas;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;

@Table(Fornecedor.TABELA_FORNECEDOR)
public class FornecedorVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = Colunas.ID_FORNECEDOR, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idFornecedor;

	@Column(name = Colunas.ID_EMPRESA, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@Description("Empresa")
	private Integer idEmpresa;

	@Column(name = Colunas.NOME, dataType = DataType.VARCHAR, maxSize = 200, isNotNull = true)
	@NotNull
	@NotEmpty
	@FullTrim
	@MaxSize(200)
	@Description("Nome")
	private String nome;

	@Column(name = Colunas.RAZAO_SOCIAL, dataType = DataType.VARCHAR, maxSize = 200)
	@FullTrim
	@MaxSize(200)
	@Description("Razão Social")
	private String razaoSocial;

	@Column(name = Colunas.CPF_CNPJ, dataType = DataType.VARCHAR, maxSize = 14)
	@FilterOnly("1234567890")
	@CpfCnpj
	@Description("Cpf / Cnpj")
	private String cpfCnpj;

	@Column(name = Colunas.FONE01, dataType = DataType.VARCHAR, maxSize = 20)
	@FilterOnly("1234567890")
	@Description("Fone 1")
	private String fone01;

	@Column(name = Colunas.FONE02, dataType = DataType.VARCHAR, maxSize = 20)
	@FilterOnly("1234567890")
	@Description("Fone 2")
	private String fone02;

	@Column(name = Colunas.FONE03, dataType = DataType.VARCHAR, maxSize = 20)
	@FilterOnly("1234567890")
	@Description("Fone 3")
	private String fone03;

	@Column(name = Colunas.OBSERVACOES, dataType = DataType.TEXT)
	@Description("Observações")
	private String observacoes;

	@Join(columnsLocal = { Colunas.ID_EMPRESA }, columnsRemote = { Empresa.Colunas.ID_EMPRESA })
	private EmpresaVo empresa;

	public Integer getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getFone01() {
		return fone01;
	}

	public void setFone01(String fone01) {
		this.fone01 = fone01;
	}

	public String getFone02() {
		return fone02;
	}

	public void setFone02(String fone02) {
		this.fone02 = fone02;
	}

	public String getFone03() {
		return fone03;
	}

	public void setFone03(String fone03) {
		this.fone03 = fone03;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public EmpresaVo getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaVo empresa) {
		this.empresa = empresa;
	}

}
