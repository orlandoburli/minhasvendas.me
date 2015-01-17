package br.com.orlandoburli.minhasvendas.model.vo.estoque;

import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.minhasvendas.model.domains.SimNao;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Cadastros.Empresa;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Estoque.LocalEstoque;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Estoque.LocalEstoque.Colunas;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;

@Table(LocalEstoque.TABELA_LOCAL_ESTOQUE)
public class LocalEstoqueVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = Colunas.ID_LOCAL_ESTOQUE, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idLocalEstoque;

	@Column(name = Colunas.ID_EMPRESA, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Empresa")
	private Integer idEmpresa;

	@Column(name = Colunas.NOME, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@NotNull
	@NotEmpty
	@MaxSize(100)
	@Description("Nome")
	private String nome;

	@Column(name = Colunas.ATIVO, dataType = DataType.CHAR, isNotNull = true, maxSize = 1)
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	@Description("Ativo")
	private String ativo;

	@Join(columnsLocal = { Colunas.ID_EMPRESA }, columnsRemote = { Empresa.Colunas.ID_EMPRESA })
	private EmpresaVo empresa;

	public String getAtivoDesc() {
		return new SimNao().getDescription(getAtivo());
	}

	public Integer getIdLocalEstoque() {
		return idLocalEstoque;
	}

	public void setIdLocalEstoque(Integer idLocalEstoque) {
		this.idLocalEstoque = idLocalEstoque;
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

	public EmpresaVo getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaVo empresa) {
		this.empresa = empresa;
	}
}
