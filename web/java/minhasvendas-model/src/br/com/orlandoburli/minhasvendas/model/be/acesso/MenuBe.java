package br.com.orlandoburli.minhasvendas.model.be.acesso;

import java.util.List;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.SaveBeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.minhasvendas.model.dao.acesso.MenuDao;
import br.com.orlandoburli.minhasvendas.model.dicionario.acesso.Menu;
import br.com.orlandoburli.minhasvendas.model.utils.MinhasVendasConstants;
import br.com.orlandoburli.minhasvendas.model.vo.acesso.MenuVo;

public class MenuBe extends BaseBe<MenuVo, MenuDao> {

	public MenuBe(DAOManager manager) {
		super(manager);
	}

	@Override
	public void doBeforeInsert(MenuVo vo) throws BeException {
		super.doBeforeInsert(vo);

		if (this.get(vo) != null) {
			throw new SaveBeException("Menu com o Id " + vo.getIdMenu() + " já cadastrado!", "idMenu");
		}
	}

	public void inicializarMenus() throws BeException {
		saveIfNotExists(criaMenu(MinhasVendasConstants.Menu.HOME, null, null, "Home", "fa-home", 0, null));
		saveIfNotExists(criaMenu(MinhasVendasConstants.Menu.ESTOQUE, null, null, "Estoque", "", 1, null));

		saveIfNotExists(criaMenu(MinhasVendasConstants.Menu.CATEGORIA_PRODUTOS, MinhasVendasConstants.Objeto.CATEGORIA_PRODUTO_CONSULTA, MinhasVendasConstants.Objeto.CATEGORIA_PRODUTO_CADASTRO, "Categoria de Produtos", "", 1, MinhasVendasConstants.Menu.ESTOQUE));
		saveIfNotExists(criaMenu(MinhasVendasConstants.Menu.PRODUTOS, MinhasVendasConstants.Objeto.PRODUTO_CONSULTA, MinhasVendasConstants.Objeto.PRODUTO_CADASTRO, "Produtos", "", 3, MinhasVendasConstants.Menu.ESTOQUE));
		saveIfNotExists(criaSeparador(MinhasVendasConstants.Menu.SEPARADOR01, 4, MinhasVendasConstants.Menu.ESTOQUE));
		saveIfNotExists(criaMenu(MinhasVendasConstants.Menu.LOCAL_ESTOQUE, MinhasVendasConstants.Objeto.LOCAL_ESTOQUE_CONSULTA, MinhasVendasConstants.Objeto.LOCAL_ESTOQUE_CADASTRO, "Locais de Estoque", "", 5, MinhasVendasConstants.Menu.ESTOQUE));
		saveIfNotExists(criaMenu(MinhasVendasConstants.Menu.ENTRADA, MinhasVendasConstants.Objeto.ENTRADA_CONSULTA, MinhasVendasConstants.Objeto.ENTRADA_CADASTRO, "Entrada de Mercadorias", "", 6, MinhasVendasConstants.Menu.ESTOQUE));

		saveIfNotExists(criaMenu(MinhasVendasConstants.Menu.VENDAS, null, null, "Vendas", "", 2, null));

		saveIfNotExists(criaMenu(MinhasVendasConstants.Menu.CATEGORIA_CLIENTE, MinhasVendasConstants.Objeto.CATEGORIA_CLIENTE_CONSULTA, MinhasVendasConstants.Objeto.CATEGORIA_CLIENTE_CADASTRO, "Categorias de Clientes", "", 1, MinhasVendasConstants.Menu.VENDAS));
		saveIfNotExists(criaMenu(MinhasVendasConstants.Menu.CLIENTE, MinhasVendasConstants.Objeto.CLIENTE_CONSULTA, MinhasVendasConstants.Objeto.CLIENTE_CADASTRO, "Clientes", "", 2, MinhasVendasConstants.Menu.VENDAS));
		saveIfNotExists(criaSeparador(MinhasVendasConstants.Menu.SEPARADOR02, 3, MinhasVendasConstants.Menu.VENDAS));
		saveIfNotExists(criaMenu(MinhasVendasConstants.Menu.CATEGORIA_VENDEDOR, MinhasVendasConstants.Objeto.CATEGORIA_VENDEDOR_CONSULTA, MinhasVendasConstants.Objeto.CATEGORIA_VENDEDOR_CADASTRO, "Categorias de Vendedores", "", 4, MinhasVendasConstants.Menu.VENDAS));
		saveIfNotExists(criaMenu(MinhasVendasConstants.Menu.VENDEDOR, MinhasVendasConstants.Objeto.VENDEDOR_CONSULTA, MinhasVendasConstants.Objeto.VENDEDOR_CADASTRO, "Vendedores", "", 5, MinhasVendasConstants.Menu.VENDAS));

	}

	public void saveIfNotExists(MenuVo menu) throws BeException {
		if (this.get(menu) != null) {
			Log.info("Menu com o id " + menu.getIdMenu() + "encontrado, atualizando!");
			menu.setNew(false);
		}
		save(menu);
	}

	public MenuVo criaSeparador(Integer idMenu, Integer ordem, Integer idMenuPai) {
		MenuVo menu = new MenuVo();

		menu.setIdMenu(idMenu);
		menu.setOrdem(ordem);
		menu.setIdMenuPai(idMenuPai);
		menu.setNome("SEPARADOR");

		return menu;
	}

	public MenuVo criaMenu(Integer idMenu, Integer idObjeto, Integer idObjetoSecundario, String nome, String classe, Integer ordem, Integer idMenuPai) {
		MenuVo menu = new MenuVo();

		menu.setIdMenu(idMenu);
		menu.setIdMenuPai(idMenuPai);
		menu.setIdObjeto(idObjeto);
		menu.setIdObjetoSecundario(idObjetoSecundario);
		menu.setClasse(classe);
		menu.setNome(nome);
		menu.setOrdem(ordem);

		return menu;
	}

	public List<MenuVo> getMenus() throws ListException {
		String sql = Menu.TABELA_MENU + "." + Menu.Colunas.ID_MENU_PAI + " IS NULL";
		List<MenuVo> rootMenus = this.getList(null, sql, Menu.TABELA_MENU + "." + Menu.Colunas.ORDEM);

		// Busca os sub-menus de cada um
		for (MenuVo root : rootMenus) {
			root.setSubMenus(getListChildren(root));
		}

		return rootMenus;
	}

	public List<MenuVo> getListChildren(MenuVo menuPai) throws ListException {
		MenuVo filter = new MenuVo();
		filter.setIdMenuPai(menuPai.getIdMenu());
		return this.getList(filter, null, Menu.TABELA_MENU + "." + Menu.Colunas.ORDEM);
	}

}
