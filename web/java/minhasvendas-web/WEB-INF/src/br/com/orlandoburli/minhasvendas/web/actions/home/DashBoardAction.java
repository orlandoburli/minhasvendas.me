package br.com.orlandoburli.minhasvendas.web.actions.home;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.orlandoburli.framework.core.web.BaseAction;

public class DashBoardAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private Integer novasEntradas;
	private Integer novasTransferencias;
	private Integer novasDevolucoes;

	private Integer quantidadeReceber;
	private BigDecimal valorReceber;

	private Integer quantidadePagar;
	private BigDecimal valorPagar;

	public void execute() {
		setNovasEntradas(2);
		setNovasTransferencias(3);
		setNovasDevolucoes(4);

		setQuantidadeReceber(3);
		setValorReceber(new BigDecimal(1233.34).setScale(2, RoundingMode.CEILING));

		setQuantidadePagar(5);
		setValorPagar(new BigDecimal(2093.33).setScale(2, RoundingMode.CEILING));

		forward("web/pages/home/dashboard.jsp");
	}

	public Integer getNovasEntradas() {
		return novasEntradas;
	}

	public void setNovasEntradas(Integer novasEntradas) {
		this.novasEntradas = novasEntradas;
	}

	public Integer getNovasTransferencias() {
		return novasTransferencias;
	}

	public void setNovasTransferencias(Integer novasTransferencias) {
		this.novasTransferencias = novasTransferencias;
	}

	public Integer getNovasDevolucoes() {
		return novasDevolucoes;
	}

	public void setNovasDevolucoes(Integer novasDevolucoes) {
		this.novasDevolucoes = novasDevolucoes;
	}

	public Integer getQuantidadeReceber() {
		return quantidadeReceber;
	}

	public void setQuantidadeReceber(Integer quantidadeReceber) {
		this.quantidadeReceber = quantidadeReceber;
	}

	public BigDecimal getValorReceber() {
		return valorReceber;
	}

	public void setValorReceber(BigDecimal valorReceber) {
		this.valorReceber = valorReceber;
	}

	public Integer getQuantidadePagar() {
		return quantidadePagar;
	}

	public void setQuantidadePagar(Integer quantidadePagar) {
		this.quantidadePagar = quantidadePagar;
	}

	public BigDecimal getValorPagar() {
		return valorPagar;
	}

	public void setValorPagar(BigDecimal valorPagar) {
		this.valorPagar = valorPagar;
	}
}
