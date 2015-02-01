package br.com.orlandoburli.minhasvendas.model.vo.venda;

import java.math.BigDecimal;
import java.util.Calendar;

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
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Cadastros.Empresa;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Vendas.Cliente;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Vendas.Orcamento;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Vendas.Orcamento.Colunas;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Vendas.Vendedor;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;

@Table(Orcamento.TABELA_ORCAMENTO)
public class OrcamentoVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = Colunas.ID_ORCAMENTO, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idOrcamento;
	
	@Column(name = Colunas.ID_EMPRESA, dataType = DataType.INT, isNotNull =  true)
	@NotNull
	@NotEmpty
	@Description("Empresa")
	private Integer idEmpresa;
	
	@Column(name = Colunas.ID_CLIENTE, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Cliente")
	private Integer idCliente;
	
	@Column(name = Colunas.DATA_ORCAMENTO, dataType = DataType.DATE, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Data Orçamento")
	private Calendar dataOrcamento;
	
	@Column(name = Colunas.ID_VENDEDOR, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Vendedor")
	private Integer idVendedor;
	
	@Column(name = Colunas.DATA_VALIDADE, dataType = DataType.DATE)
	@Description("Data Validade")
	private Calendar dataValidade;
	
	@Column(name = Colunas.VALOR_ITENS, dataType = DataType.NUMERIC, maxSize = 10, precision = 2, isNotNull = true)
	@NotNull
	@NotEmpty
	@NotZero
	@Precision(2)
	@Description("Valor Itens")
	private BigDecimal valorItens;
	
	@Column(name = Colunas.VALOR_DESCONTO, dataType = DataType.NUMERIC, maxSize = 10, precision = 2)
	@NotNegative
	@Description("Valor Desconto")
	private BigDecimal valorDesconto;
	
	@Column(name = Colunas.VALOR_TOTAL, dataType = DataType.NUMERIC, maxSize = 10, precision = 2, isNotNull = true)
	@NotNull
	@NotEmpty
	@NotZero
	@Precision(2)
	@Description("Valor Total")
	private BigDecimal valorTotal;
	
	@Column(name = Colunas.OBSERVACOES, dataType = DataType.TEXT)
	@Description("Observacoes")
	private String observacoes;
	
	
	@Join(columnsLocal = { Colunas.ID_EMPRESA }, columnsRemote = { Empresa.Colunas.ID_EMPRESA } )
	private EmpresaVo empresa;
	
	@Join(columnsLocal = { Colunas.ID_CLIENTE }, columnsRemote = { Cliente.Colunas.ID_CLIENTE } )
	private ClienteVo cliente;
	
	@Join(columnsLocal = { Colunas.ID_VENDEDOR }, columnsRemote = { Vendedor.Colunas.ID_VENDEDOR} )
	private VendedorVo vendedor;
	
	public Integer getIdOrcamento() {
		return idOrcamento;
	}
	public void setIdOrcamento(Integer idOrcamento) {
		this.idOrcamento = idOrcamento;
	}
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Calendar getDataOrcamento() {
		return dataOrcamento;
	}
	public void setDataOrcamento(Calendar dataOrcamento) {
		this.dataOrcamento = dataOrcamento;
	}
	public Integer getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}
	public Calendar getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}
	public BigDecimal getValorItens() {
		return valorItens;
	}
	public void setValorItens(BigDecimal valorItens) {
		this.valorItens = valorItens;
	}
	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public EmpresaVo getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaVo empresa) {
		this.empresa = empresa;
	}
	public ClienteVo getCliente() {
		return cliente;
	}
	public void setCliente(ClienteVo cliente) {
		this.cliente = cliente;
	}
	public VendedorVo getVendedor() {
		return vendedor;
	}
	public void setVendedor(VendedorVo vendedor) {
		this.vendedor = vendedor;
	}
}
