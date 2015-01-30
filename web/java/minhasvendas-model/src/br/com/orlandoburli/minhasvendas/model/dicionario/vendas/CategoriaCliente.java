package br.com.orlandoburli.minhasvendas.model.dicionario.vendas;

import br.com.orlandoburli.minhasvendas.model.dicionario.cadastros.Empresa;

public final class CategoriaCliente {
	public static final String TABELA_CATEGORIA_CLIENTE = "categoria_cliente";

	public final class Colunas {
		public static final String ID_CATEGORIA_CLIENTE = "id_categoria_cliente";
		public static final String ID_EMPRESA = Empresa.Colunas.ID_EMPRESA;
		public static final String NOME = "nome";
		public static final String ATIVO = "ativo";
		public static final String PERCENTUAL_DESCONTO = "percentual_desconto";
	}
}