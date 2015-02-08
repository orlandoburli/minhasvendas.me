package br.com.orlandoburli.minhasvendas.model.dicionario.vendas;

import br.com.orlandoburli.minhasvendas.model.dicionario.cadastros.Empresa;

public final class Orcamento {
	public static final String TABELA_ORCAMENTO = "orcamento";

	public final class Colunas {
		public static final String ID_ORCAMENTO = "id_orcamento";
		public static final String ID_EMPRESA = Empresa.Colunas.ID_EMPRESA;
		public static final String ID_CLIENTE = Cliente.Colunas.ID_CLIENTE;
		public static final String DATA_ORCAMENTO = "data_orcamento";
		public static final String ID_VENDEDOR = Vendedor.Colunas.ID_VENDEDOR;
		public static final String DATA_VALIDADE = "data_validade";
		public static final String VALOR_ITENS = "valor_itens";
		public static final String VALOR_DESCONTO = "valor_desconto";
		public static final String VALOR_TOTAL = "valor_total";
		public static final String OBSERVACOES = "observacoes";
	}
}