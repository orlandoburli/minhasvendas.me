package br.com.orlandoburli.minhasvendas.model.vo.cadastros;

import java.util.Calendar;

import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FullTrim;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.Lower;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.Upper;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Email;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MinSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.minhasvendas.model.dicionario.cadastros.Empresa;
import br.com.orlandoburli.minhasvendas.model.dicionario.cadastros.Empresa.Colunas;
import br.com.orlandoburli.minhasvendas.model.domains.SimNao;

@Table(Empresa.TABELA_EMPRESA)
public class EmpresaVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = Colunas.ID_EMPRESA, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	@Description("Código")
	private Integer idEmpresa;

	@Column(name = Colunas.RAZAO_SOCIAL, dataType = DataType.VARCHAR, maxSize = 200, isNotNull = true)
	@Description("Razão Social")
	@NotEmpty
	@NotNull
	@MaxSize(200)
	@MinSize(3)
	@Upper
	@FullTrim
	private String razaoSocial;

	@Column(name = Colunas.FANTASIA, dataType = DataType.VARCHAR, maxSize = 200, isNotNull = true)
	@Description("Fantasia")
	@NotEmpty
	@NotNull
	@MaxSize(200)
	@MinSize(3)
	@Upper
	@FullTrim
	private String fantasia;

	@Column(name = Colunas.EMAIL, dataType = DataType.VARCHAR, maxSize = 200, isNotNull = true)
	@Description("Email")
	@NotEmpty
	@NotNull
	@Email
	@MaxSize(200)
	@MinSize(3)
	@Lower
	private String email;

	@Column(name = Colunas.TIPO, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@Domain(TipoEmpresa.class)
	@NotNull
	@NotEmpty
	@Description("Tipo")
	private String tipo;

	@Column(name = Colunas.SENHA, dataType = DataType.VARCHAR, maxSize = 200)
	@Description("Senha")
	private String senha;

	@Column(name = Colunas.DATA_CADASTRO, dataType = DataType.DATETIME, isNotNull = true)
	@NotNull
	@Description("Data de Cadastro")
	private Calendar dataCadastro;

	@Column(name = Colunas.FLAG_EMAIL_CONFIRMADO, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@Domain(SimNao.class)
	@NotNull
	@NotEmpty
	@Description("Email confirmado")
	private String flagEmailConfirmado;

	@Column(name = Colunas.HASH, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	private String hash;

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getFlagEmailConfirmado() {
		return flagEmailConfirmado;
	}

	public void setFlagEmailConfirmado(String flagEmailConfirmado) {
		this.flagEmailConfirmado = flagEmailConfirmado;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
}
