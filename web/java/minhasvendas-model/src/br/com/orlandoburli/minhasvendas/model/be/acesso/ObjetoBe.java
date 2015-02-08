package br.com.orlandoburli.minhasvendas.model.be.acesso;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.InsertBeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.dao.acesso.ObjetoDao;
import br.com.orlandoburli.minhasvendas.model.domains.SimNao;
import br.com.orlandoburli.minhasvendas.model.utils.MinhasVendasConstants;
import br.com.orlandoburli.minhasvendas.model.vo.acesso.ObjetoVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.CategoriaProdutoVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.EntradaVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.FornecedorVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.LocalEstoqueVo;
import br.com.orlandoburli.minhasvendas.model.vo.estoque.ProdutoVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.CategoriaClienteVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.CategoriaVendedorVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.ClienteVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.OrcamentoVo;
import br.com.orlandoburli.minhasvendas.model.vo.venda.VendedorVo;

public class ObjetoBe extends BaseBe<ObjetoVo, ObjetoDao> {

	public ObjetoBe(DAOManager manager) {
		super(manager);
	}

	@Override
	public void doBeforeInsert(ObjetoVo vo) throws BeException {
		super.doBeforeInsert(vo);

		if (this.get(vo) != null) {
			throw new InsertBeException("Objeto com o Id " + vo.getIdObjeto() + " j√° cadastrado!", "idObjeto");
		}
	}

	public void inicializarObjetos() throws BeException {
		criaObjeto(MinhasVendasConstants.Objeto.DASHBOARD, "Home", "dashboard.action", true);

		criaPadraoVo(CategoriaProdutoVo.class, "Categoria de Produtos", MinhasVendasConstants.Objeto.CATEGORIA_PRODUTO_CONSULTA, MinhasVendasConstants.Objeto.CATEGORIA_PRODUTO_CADASTRO);
		criaPadraoVo(ProdutoVo.class, "Produtos", MinhasVendasConstants.Objeto.PRODUTO_CONSULTA, MinhasVendasConstants.Objeto.PRODUTO_CADASTRO);

		criaPadraoVo(LocalEstoqueVo.class, "Locais de Estoque", MinhasVendasConstants.Objeto.LOCAL_ESTOQUE_CONSULTA, MinhasVendasConstants.Objeto.LOCAL_ESTOQUE_CADASTRO);

		criaPadraoVo(CategoriaClienteVo.class, "Categoria de Clientes", MinhasVendasConstants.Objeto.CATEGORIA_CLIENTE_CONSULTA, MinhasVendasConstants.Objeto.CATEGORIA_CLIENTE_CADASTRO);
		criaPadraoVo(ClienteVo.class, "Clientes", MinhasVendasConstants.Objeto.CLIENTE_CONSULTA, MinhasVendasConstants.Objeto.CLIENTE_CADASTRO);

		criaPadraoVo(CategoriaVendedorVo.class, "Categoria de Vendedores", MinhasVendasConstants.Objeto.CATEGORIA_VENDEDOR_CONSULTA, MinhasVendasConstants.Objeto.CATEGORIA_VENDEDOR_CADASTRO);
		criaPadraoVo(VendedorVo.class, "Vendedores", MinhasVendasConstants.Objeto.VENDEDOR_CONSULTA, MinhasVendasConstants.Objeto.VENDEDOR_CADASTRO);
		criaPadraoVo(EntradaVo.class, "Entrada de Produtos", MinhasVendasConstants.Objeto.ENTRADA_CONSULTA, MinhasVendasConstants.Objeto.ENTRADA_CADASTRO);
<<<<<<< HEAD
		criaPadraoVo(OrcamentoVo.class, "OrÁamento", MinhasVendasConstants.Objeto.ORCAMENTO_CONSULTA, MinhasVendasConstants.Objeto.ORCAMENTO_CADASTRO);
=======
		criaPadraoVo(FornecedorVo.class, "Fornecedores", MinhasVendasConstants.Objeto.FORNECEDOR_CONSULTA, MinhasVendasConstants.Objeto.FORNECEDOR_CADASTRO);
>>>>>>> teste-tema-lte
	}

	public void criaPadraoVo(Class<?> vo, String descricao, Integer idConsulta, Integer idCadastro) throws BeException {
		String voname = vo.getSimpleName().replace("Vo", "").toLowerCase();
		saveIfNotExists(criaObjeto(idConsulta, "Consulta de " + descricao, voname + "consulta.action", false));
		saveIfNotExists(criaObjeto(idCadastro, "Cadastro de " + descricao, voname + "cadastro.action", false));
	}

	public void saveIfNotExists(ObjetoVo objeto) throws BeException {
		if (this.get(objeto) != null) {
			objeto.setNew(false);
		}
		save(objeto);
	}

	public ObjetoVo criaObjeto(Integer idObjeto, String nome, String url, boolean autoStart) {
		ObjetoVo objeto = new ObjetoVo();
		objeto.setIdObjeto(idObjeto);
		objeto.setNome(nome);
		objeto.setUrl(url);
		objeto.setAutoStart(autoStart ? SimNao.SIM : SimNao.NAO);
		return objeto;
	}
}
