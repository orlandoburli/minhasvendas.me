package br.com.orlandoburli.minhasvendas.model.dicionario.vendas;

import br.com.orlandoburli.minhasvendas.model.dicionario.cadastros.Empresa;

public final class Cliente {
	public static final String TABELA_CLIENTE = "cliente";

	public final class Colunas {
		public static final String ID_CLIENTE = "id_cliente";
		public static final String ID_EMPRESA = Empresa.Colunas.ID_EMPRESA;
		public static final String NOME = "nome";
		public static final String DATA_NASCIMENTO = "data_nascimento";
		public static final String EMAIL = "email";
		public static final String FONE1 = "fone1";
		public static final String FONE2 = "fone2";
		public static final String FONE3 = "fone3";
		public static final String CEP = "cep";
		public static final String ENDERECO = "endereco";
		public static final String NUMERO = "numero";
		public static final String COMPLEMENTO = "complemento";
		public static final String BAIRRO = "bairro";
		public static final String CIDADE = "cidade";
		public static final String UF = "uf";
		public static final String ID_CATEGORIA_CLIENTE = CategoriaCliente.Colunas.ID_CATEGORIA_CLIENTE;
		public static final String OBSERVACOES = "observacoes";
	}
}