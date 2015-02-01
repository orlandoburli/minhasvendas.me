package br.com.orlandoburli.minhasvendas.model.dicionario.vendas;

import br.com.orlandoburli.minhasvendas.model.dicionario.cadastros.Empresa;

public final class CategoriaVendedor {
	public static final String TABELA_CATEGORIA_VENDEDOR = "categoria_vendedor";

	public final class Colunas {
		public static final String ID_CATEGORIA_VENDEDOR = "id_categoria_vendedor";
		public static final String ID_EMPRESA = Empresa.Colunas.ID_EMPRESA;
		public static final String NOME = "nome";
		public static final String ATIVO = "ativo";
		public static final String PERCENTUAL_COMISSAO = "percentual_comissao";
	}
}