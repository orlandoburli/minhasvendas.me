package br.com.orlandoburli.minhasvendas.model.utils;

import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.dao.exceptions.DAOException;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.minhasvendas.model.be.acesso.MenuBe;
import br.com.orlandoburli.minhasvendas.model.be.acesso.ObjetoBe;
import br.com.orlandoburli.minhasvendas.model.dao.acesso.MenuDao;
import br.com.orlandoburli.minhasvendas.model.dao.acesso.ObjetoDao;
import br.com.orlandoburli.minhasvendas.model.dao.cadastros.EmpresaDao;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.CategoriaProdutoDao;
import br.com.orlandoburli.minhasvendas.model.dao.estoque.ProdutoDao;
import br.com.orlandoburli.minhasvendas.model.dao.venda.CategoriaClienteDao;
import br.com.orlandoburli.minhasvendas.model.dao.venda.CategoriaVendedorDao;
import br.com.orlandoburli.minhasvendas.model.dao.venda.ClienteDao;
import br.com.orlandoburli.minhasvendas.model.dao.venda.VendedorDao;

public class DBUtils {

	public static void checkDaos() {
		DAOManager manager = DAOManager.getInstance();

		try {
			new ObjetoDao(manager).checkTable();
			new MenuDao(manager).checkTable();

			new EmpresaDao(manager).checkTable();

			new CategoriaProdutoDao(manager).checkTable();
			new ProdutoDao(manager).checkTable();

			new CategoriaClienteDao(manager).checkTable();
			new ClienteDao(manager).checkTable();

			new CategoriaVendedorDao(manager).checkTable();
			new VendedorDao(manager).checkTable();

			new ObjetoBe(manager).inicializarObjetos();
			new MenuBe(manager).inicializarMenus();

		} catch (DAOException | BeException e) {
			Log.critical(e);
		} finally {
			manager.commit();
		}
	}
}
