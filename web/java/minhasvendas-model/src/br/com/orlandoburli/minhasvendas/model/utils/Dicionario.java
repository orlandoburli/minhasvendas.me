package br.com.orlandoburli.minhasvendas.model.utils;

import br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Cadastros.Empresa;

public final class Dicionario {

	public final class Admin {

		public final class UsuarioAdmin {

		}

		public final class PerfilAdmin {

		}

	}

	public final class Acesso {
		public final class Objeto {
			public static final String TABELA_OBJETO = "objeto";

			public final class Colunas {
				public static final String ID_OBJETO = "id_objeto";
				public static final String NOME = "nome";
				public static final String URL = "url";
				public static final String AUTO_START = "auto_start";
			}
		}

		public final class Menu {
			public static final String TABELA_MENU = "menu";

			public final class Colunas {
				public static final String ID_MENU = "id_menu";
				public static final String NOME = "nome";
				public static final String ID_MENU_PAI = "id_menu_pai";
				public static final String ORDEM = "ordem";
				public static final String ID_OBJETO = Objeto.Colunas.ID_OBJETO;
				public static final String CLASSE = "classe";
				public static final String ID_OBJETO_SECUNDARIO = "id_objeto_secundario";
			}
		}
	}

	public final class Estoque {
		public final class CategoriaProduto {
			public static final String TABELA_CATEGORIA = "categoria_produto";

			public final class Colunas {
				public static final String ID_CATEGORIA_PRODUTO = "id_categoria_produto";
				public static final String ID_EMPRESA = Empresa.Colunas.ID_EMPRESA;
				public static final String NOME = "nome";
				public static final String ATIVO = "ativo";
			}
		}

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

		public final class LocalEstoque {
			public static final String TABELA_LOCAL_ESTOQUE = "local_estoque";

			public final class Colunas {
				public static final String ID_LOCAL_ESTOQUE = "id_local_estoque";
				public static final String ID_EMPRESA = "id_empresa";
				public static final String NOME = "nome";
				public static final String ATIVO = "ativo";
			}
		}

		public final class EstoqueFisico {
			public static final String TABELA_ESTOQUE = "estoque";

			public final class Colunas {
				public static final String ID_ESTOQUE = "id_estoque";
				public static final String ID_LOCAL_ESTOQUE = LocalEstoque.Colunas.ID_LOCAL_ESTOQUE;
				public static final String ID_PRODUTO = Produto.Colunas.ID_PRODUTO;
				public static final String QUANTIDADE_ESTOQUE = "quantidade_estoque";

			}
		}

		public final class Entrada {
			public static final String TABELA_ENTRADA = "entrada";

			public final class Colunas {
				public static final String ID_ENTRADA = "id_entrada";
				public static final String ID_EMPRESA = Empresa.Colunas.ID_EMPRESA;
				public static final String NUMERO_DOCUMENTO = "numero_documento";
				public static final String SERIE = "serie";
				public static final String DATA_EMISSAO_DOCUMENTO = "data_emissao_documento";
				public static final String STATUS = "status";
				public static final String DATA_PROCESSAMENTO = "data_processamento";
			}
		}

		public final class ItemEntrada {
			public static final String TABELA_ITEM_ENTRADA = "item_entrada";

			public final class Colunas {
				public static final String ID_ITEM_ENTRADA = "id_item_entrada";
				public static final String ID_ENTRADA = Entrada.Colunas.ID_ENTRADA;
				public static final String ID_PRODUTO = Produto.Colunas.ID_PRODUTO;
				public static final String QUANTIDADE = "quantidade";
				public static final String VALOR_COMPRA = "valor_compra";
			}
		}

	}

	public final class Cadastros {

		public final class Empresa {
			public static final String TABELA_EMPRESA = "empresa";

			public final class Colunas {
				public static final String ID_EMPRESA = "id_empresa";
				public static final String RAZAO_SOCIAL = "razao_social";
				public static final String FANTASIA = "fantasia";
				public static final String EMAIL = "email";
				public static final String TIPO = "tipo";
				public static final String CPF_CNPJ = "cpf_cnpj";
				public static final String SENHA = "senha";
				public static final String DATA_CADASTRO = "data_cadastro";
				public static final String FLAG_EMAIL_CONFIRMADO = "flag_email_confirmado";
				public static final String HASH = "hash";
			}
		}
	}

	public final class Vendas {

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
			}
		}
	}
}