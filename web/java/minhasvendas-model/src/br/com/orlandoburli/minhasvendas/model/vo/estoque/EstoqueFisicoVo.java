package br.com.orlandoburli.minhasvendas.model.vo.estoque;

import java.math.BigDecimal;

import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.Precision;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Estoque.EstoqueFisico;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Estoque.EstoqueFisico.Colunas;

@Table(EstoqueFisico.TABELA_ESTOQUE)
public class EstoqueFisicoVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = Colunas.ID_ESTOQUE, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	@Description("id do Estoque")
	private Integer idEstoque;

	@Column(name = Colunas.ID_LOCAL_ESTOQUE, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Local do Estoque")
	private Integer idLocalEstoque;

	@Column(name = Colunas.ID_PRODUTO, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Produto")
	private Integer idProduto;

	@Column(name = Colunas.QUANTIDADE_ESTOQUE, dataType = DataType.NUMERIC, maxSize = 10, precision = 4)
	@NotNull
	@Precision(4)
	@Description("Quantidade")
	private BigDecimal quantidadeEstoque;

	public Integer getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(Integer idEstoque) {
		this.idEstoque = idEstoque;
	}

	public Integer getIdLocalEstoque() {
		return idLocalEstoque;
	}

	public void setIdLocalEstoque(Integer idLocalEstoque) {
		this.idLocalEstoque = idLocalEstoque;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public BigDecimal getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(BigDecimal quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
}
