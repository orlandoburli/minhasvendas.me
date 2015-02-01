package br.com.orlandoburli.minhasvendas.model.dicionario.estoque;

import br.com.orlandoburli.minhasvendas.model.dicionario.cadastros.Empresa;

public final class Produto {
	public static final String TABELA_PRODUTO = "produto";

	public final class Colunas {
		public static final String ID_PRODUTO = "id_produto";
		public static final String ID_EMPRESA = Empresa.Colunas.ID_EMPRESA;
		public static final String CODIGO_PRODUTO = "codigo_produto";
		public static final String NOME = "nome";
		public static final String VALOR_VENDA = "valor_venda";
		public static final String ID_CATEGORIA_PRODUTO = CategoriaProduto.Colunas.ID_CATEGORIA_PRODUTO;
		public static final String ATIVO = "ativo";
	}
}
