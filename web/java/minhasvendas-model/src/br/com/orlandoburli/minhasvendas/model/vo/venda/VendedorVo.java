package br.com.orlandoburli.minhasvendas.model.vo.venda;

import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FullTrim;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
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
import br.com.orlandoburli.minhasvendas.model.dicionario.vendas.CategoriaVendedor;
import br.com.orlandoburli.minhasvendas.model.dicionario.vendas.Vendedor;
import br.com.orlandoburli.minhasvendas.model.dicionario.vendas.Vendedor.Colunas;
import br.com.orlandoburli.minhasvendas.model.domains.SimNao;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;

@Table(Vendedor.TABELA_VENDEDOR)
public class VendedorVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = Colunas.ID_VENDEDOR, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idVendedor;

	@Column(name = Colunas.ID_EMPRESA, dataType = DataType.INT, isNotNull = true)
	private Integer idEmpresa;

	@Column(name = Colunas.NOME, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@NotNull
	@NotEmpty
	@FullTrim
	@MaxSize(100)
	@Description("Nome")
	private String nome;

	@Column(name = Colunas.ATIVO, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	@Description("Ativo")
	private String ativo;

	@Column(name = Colunas.ID_CATEGORIA_VENDEDOR, dataType = DataType.INT)
	@Description("Categoria do Vendedor")
	private Integer idCategoriaVendedor;

	@Join(columnsLocal = { Colunas.ID_EMPRESA }, columnsRemote = { Empresa.Colunas.ID_EMPRESA }, joinWhen = JoinWhen.MANUAL)
	private EmpresaVo empresa;

	@Join(columnsLocal = { Colunas.ID_CATEGORIA_VENDEDOR }, columnsRemote = { CategoriaVendedor.Colunas.ID_CATEGORIA_VENDEDOR })
	private CategoriaVendedorVo categoria;

	public String getAtivoDesc() {
		return new SimNao().getDescription(getAtivo());
	}

	public Integer getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
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

	public Integer getIdCategoriaVendedor() {
		return idCategoriaVendedor;
	}

	public void setIdCategoriaVendedor(Integer idCategoriaVendedor) {
		this.idCategoriaVendedor = idCategoriaVendedor;
	}

	public CategoriaVendedorVo getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaVendedorVo categoria) {
		this.categoria = categoria;
	}
}
