package br.com.orlandoburli.minhasvendas.model.vo.estoque;

import java.util.Calendar;

import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.minhasvendas.model.domains.StatusProcessamento;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Cadastros.Empresa;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Estoque.Entrada;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Estoque.Entrada.Colunas;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;

@Table(Entrada.TABELA_ENTRADA)
public class EntradaVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = Colunas.ID_ENTRADA, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idEntrada;

	@Column(name = Colunas.ID_EMPRESA, dataType = DataType.INT, isNotNull = true)
	private Integer idEmpresa;

	@Column(name = Colunas.NUMERO_DOCUMENTO, dataType = DataType.VARCHAR, maxSize = 100)
	@Description("Número Documento")
	private String numeroDocumento;

	@Column(name = Colunas.SERIE, dataType = DataType.VARCHAR, maxSize = 10)
	@Description("Série")
	private String serie;

	@Column(name = Colunas.DATA_EMISSAO_DOCUMENTO, dataType = DataType.DATE)
	@Description("Data de Emissão")
	private Calendar dataEmissaoDocumento;

	@Column(name = Colunas.STATUS, dataType = DataType.CHAR, isNotNull = true, maxSize = 1)
	@NotNull
	@NotEmpty
	@Domain(StatusProcessamento.class)
	@Description("Status")
	private String status;
	private Calendar dataProcessamento;

	@Join(columnsLocal = { Colunas.ID_EMPRESA }, columnsRemote = { Empresa.Colunas.ID_EMPRESA })
	private EmpresaVo empresa;

	public Integer getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(Integer idEntrada) {
		this.idEntrada = idEntrada;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Calendar getDataEmissaoDocumento() {
		return dataEmissaoDocumento;
	}

	public void setDataEmissaoDocumento(Calendar dataEmissaoDocumento) {
		this.dataEmissaoDocumento = dataEmissaoDocumento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Calendar getDataProcessamento() {
		return dataProcessamento;
	}

	public void setDataProcessamento(Calendar dataProcessamento) {
		this.dataProcessamento = dataProcessamento;
	}

	public EmpresaVo getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaVo empresa) {
		this.empresa = empresa;
	}
}
