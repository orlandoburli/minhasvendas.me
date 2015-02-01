package br.com.orlandoburli.minhasvendas.model.dicionario.estoque;

public final class EstoqueFisico {
	public static final String TABELA_ESTOQUE = "estoque";

	public final class Colunas {
		public static final String ID_ESTOQUE = "id_estoque";
		public static final String ID_LOCAL_ESTOQUE = LocalEstoque.Colunas.ID_LOCAL_ESTOQUE;
		public static final String ID_PRODUTO = Produto.Colunas.ID_PRODUTO;
		public static final String QUANTIDADE_ESTOQUE = "quantidade_estoque";

	}
}