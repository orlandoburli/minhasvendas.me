package br.com.orlandoburli.minhasvendas.model.domains;

import br.com.orlandoburli.framework.core.vo.BaseDomain;

public class StatusProcessamento extends BaseDomain {

	public static final String NAO_PROCESSADO = "N";
	public static final String PROCESSADO = "P";
	public static final String CANCELADO = "C";
	public static final String ESTORNADO = "E";

	public static final String NAO_PROCESSADO_DESCRITIVO = "Não processado";
	public static final String PROCESSADO_DESCRITIVO = "Processado";
	public static final String CANCELADO_DESCRITIVO = "Cancelado";
	public static final String ESTORNADO_DESCRITIVO = "Estornado";

	@Override
	public String[] getValues() {
		return new String[] { NAO_PROCESSADO, PROCESSADO, CANCELADO, ESTORNADO };
	}

	@Override
	public String[] getDescriptions() {
		return new String[] { NAO_PROCESSADO_DESCRITIVO, PROCESSADO_DESCRITIVO, CANCELADO_DESCRITIVO, ESTORNADO_DESCRITIVO };
	}

}
