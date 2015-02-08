package br.com.orlandoburli.minhasvendas.model.dicionario.estoque;

import br.com.orlandoburli.minhasvendas.model.dicionario.cadastros.Empresa;

public final class Fornecedor {
	public static final String TABELA_FORNECEDOR = "fornecedor";

	public final class Colunas {
		public static final String ID_FORNECEDOR = "id_fornecedor";
		public static final String ID_EMPRESA = Empresa.Colunas.ID_EMPRESA;
		public static final String NOME = "nome";
		public static final String RAZAO_SOCIAL = "razao_social";
		public static final String CPF_CNPJ = "cpf_cnpj";
		public static final String FONE01 = "fone01";
		public static final String FONE02 = "fone02";
		public static final String FONE03 = "fone03";
		public static final String OBSERVACOES = "observacoes";
	}
}
