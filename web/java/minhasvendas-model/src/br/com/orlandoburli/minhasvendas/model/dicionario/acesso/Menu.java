package br.com.orlandoburli.minhasvendas.model.dicionario.acesso;

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