package br.com.orlandoburli.minhasvendas.model.dicionario.estoque;

public final class ItemEntrada {
	public static final String TABELA_ITEM_ENTRADA = "item_entrada";

	public final class Colunas {
		public static final String ID_ITEM_ENTRADA = "id_item_entrada";
		public static final String ID_ENTRADA = Entrada.Colunas.ID_ENTRADA;
		public static final String ID_PRODUTO = Produto.Colunas.ID_PRODUTO;
		public static final String QUANTIDADE = "quantidade";
		public static final String VALOR_UNITARIO = "valor_unitario";
		public static final String VALOR_DESCONTO = "valor_desconto";
		public static final String VALOR_TOTAL = "valor_total";
	}
}