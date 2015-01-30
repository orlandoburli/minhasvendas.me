package br.com.orlandoburli.minhasvendas.model.dicionario.vendas;

import br.com.orlandoburli.minhasvendas.model.dicionario.cadastros.Empresa;

public final class Vendedor {
	public static final String TABELA_VENDEDOR = "vendedor";

	public final class Colunas {
		public static final String ID_VENDEDOR = "id_vendedor";
		public static final String NOME = "nome";
		public static final String ATIVO = "ativo";
		public static final String ID_CATEGORIA_VENDEDOR = CategoriaVendedor.Colunas.ID_CATEGORIA_VENDEDOR;
		public static final String ID_EMPRESA = Empresa.Colunas.ID_EMPRESA;
	}
}