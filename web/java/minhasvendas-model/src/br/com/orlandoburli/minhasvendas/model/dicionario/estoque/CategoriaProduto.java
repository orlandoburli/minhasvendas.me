package br.com.orlandoburli.minhasvendas.model.dicionario.estoque;

import br.com.orlandoburli.minhasvendas.model.dicionario.cadastros.Empresa;

public final class CategoriaProduto {
	public static final String TABELA_CATEGORIA = "categoria_produto";

	public final class Colunas {
		public static final String ID_CATEGORIA_PRODUTO = "id_categoria_produto";
		public static final String ID_EMPRESA = Empresa.Colunas.ID_EMPRESA;
		public static final String NOME = "nome";
		public static final String ATIVO = "ativo";
	}
}