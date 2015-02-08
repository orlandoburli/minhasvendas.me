package br.com.orlandoburli.minhasvendas.model.vo.venda;

import java.util.Calendar;

import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FullTrim;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.Lower;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.NoSpace;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.Upper;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Email;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
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
import br.com.orlandoburli.minhasvendas.model.dicionario.vendas.Cliente;
import br.com.orlandoburli.minhasvendas.model.dicionario.vendas.Cliente.Colunas;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;

@Table(Cliente.TABELA_CLIENTE)
public class ClienteVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = Colunas.ID_CLIENTE, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idCliente;

	@Column(name = Colunas.ID_EMPRESA, dataType = DataType.INT, isNotNull = true)
	private Integer idEmpresa;

	@Column(name = Colunas.NOME, dataType = DataType.VARCHAR, maxSize = 200)
	@NotNull
	@NotEmpty
	@MaxSize(200)
	@FullTrim
	@Description("Nome")
	private String nome;

	@Column(name = Colunas.DATA_NASCIMENTO, dataType = DataType.DATE)
	@Description("Data de nascimento")
	private Calendar dataNascimento;

	@Column(name = Colunas.EMAIL, dataType = DataType.VARCHAR, maxSize = 200)
	@MaxSize(200)
	@NoSpace
	@Lower
	@Email
	@Description("Email")
	private String email;

	@Column(name = Colunas.FONE1, dataType = DataType.VARCHAR, maxSize = 20)
	@MaxSize(20)
	@Description("Fone 1")
	private String fone1;

	@Column(name = Colunas.FONE2, dataType = DataType.VARCHAR, maxSize = 20)
	@MaxSize(20)
	@Description("Fone 2")
	private String fone2;

	@Column(name = Colunas.FONE3, dataType = DataType.VARCHAR, maxSize = 20)
	@MaxSize(20)
	@Description("Fone 3")
	private String fone3;

	@Column(name = Colunas.CEP, dataType = DataType.VARCHAR, maxSize = 10)
	@MaxSize(10)
	@Description("Cep")
	private String cep;

	@Column(name = Colunas.ENDERECO, dataType = DataType.VARCHAR, maxSize = 150)
	@MaxSize(150)
	@Description("Endereço")
	private String endereco;

	@Column(name = Colunas.NUMERO, dataType = DataType.VARCHAR, maxSize = 5)
	@MaxSize(5)
	@Description("Número")
	private String numero;

	@Column(name = Colunas.COMPLEMENTO, dataType = DataType.VARCHAR, maxSize = 100)
	@MaxSize(100)
	@FullTrim
	@Description("Complemento")
	private String complemento;

	@Column(name = Colunas.BAIRRO, dataType = DataType.VARCHAR, maxSize = 100)
	@MaxSize(100)
	@Description("Bairro")
	private String bairro;

	@Column(name = Colunas.CIDADE, dataType = DataType.VARCHAR, maxSize = 100)
	@MaxSize(100)
	@Description("Cidade")
	private String cidade;

	@Column(name = Colunas.UF, dataType = DataType.VARCHAR, maxSize = 2)
	@MaxSize(2)
	@FullTrim
	@Upper
	@Description("UF")
	private String uf;

	@Column(name = Colunas.ID_CATEGORIA_CLIENTE, dataType = DataType.INT)
	@Description("Categoria")
	private Integer idCategoriaCliente;

	@Column(name = Colunas.OBSERVACOES, dataType = DataType.TEXT)
	@Description("Observações")
	private String observacoes;

	@Join(columnsLocal = { Colunas.ID_CATEGORIA_CLIENTE }, columnsRemote = { CategoriaCliente.Colunas.ID_CATEGORIA_CLIENTE })
	private CategoriaClienteVo categoria;

	@Join(columnsLocal = { Colunas.ID_EMPRESA }, columnsRemote = { Empresa.Colunas.ID_EMPRESA }, joinWhen = JoinWhen.MANUAL)
	private EmpresaVo empresa;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getFone1() {
		return fone1;
	}

	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}

	public String getFone2() {
		return fone2;
	}

	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}

	public String getFone3() {
		return fone3;
	}

	public void setFone3(String fone3) {
		this.fone3 = fone3;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getIdCategoriaCliente() {
		return idCategoriaCliente;
	}

	public void setIdCategoriaCliente(Integer idCategoriaCliente) {
		this.idCategoriaCliente = idCategoriaCliente;
	}

	public CategoriaClienteVo getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaClienteVo categoria) {
		this.categoria = categoria;
	}

	public EmpresaVo getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaVo empresa) {
		this.empresa = empresa;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

}
