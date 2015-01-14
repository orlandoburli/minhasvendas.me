package br.com.orlandoburli.minhasvendas.model.vo.acesso;

import static br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Acesso.Menu.Colunas.CLASSE;
import static br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Acesso.Menu.Colunas.ID_MENU;
import static br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Acesso.Menu.Colunas.ID_MENU_PAI;
import static br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Acesso.Menu.Colunas.ID_OBJETO;
import static br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Acesso.Menu.Colunas.ID_OBJETO_SECUNDARIO;
import static br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Acesso.Menu.Colunas.NOME;
import static br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Acesso.Menu.Colunas.ORDEM;

import java.util.ArrayList;
import java.util.List;

import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNegative;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.JoinWhen;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario;

@Table(Dicionario.Acesso.Menu.TABELA_MENU)
public class MenuVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = ID_MENU, dataType = DataType.INT, isNotNull = true, isKey = true)
	private Integer idMenu;

	@Column(name = NOME, dataType = DataType.VARCHAR, maxSize = 200, isNotNull = true)
	@MaxSize(200)
	@Description("Nome")
	private String nome;

	@Column(name = ID_MENU_PAI, dataType = DataType.INT)
	private Integer idMenuPai;

	@Column(name = ORDEM, dataType = DataType.INT)
	@NotNegative
	@Description("Ordem")
	private Integer ordem;

	@Column(name = ID_OBJETO, dataType = DataType.INT)
	private Integer idObjeto;

	@Column(name = ID_OBJETO_SECUNDARIO, dataType = DataType.INT)
	private Integer idObjetoSecundario;

	@Column(name = CLASSE, dataType = DataType.VARCHAR, maxSize = 50)
	private String classe;

	@Join(columnsLocal = { ID_MENU }, columnsRemote = { ID_MENU }, joinWhen = JoinWhen.MANUAL)
	private MenuVo menuPai;

	@Join(columnsLocal = { ID_OBJETO }, columnsRemote = { Dicionario.Acesso.Objeto.Colunas.ID_OBJETO })
	private ObjetoVo objeto;

	@Join(columnsLocal = { ID_OBJETO_SECUNDARIO }, columnsRemote = { Dicionario.Acesso.Objeto.Colunas.ID_OBJETO }, tableAlias = "secundario")
	private ObjetoVo objetoSecundario;

	private List<MenuVo> subMenus;

	public Integer getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdMenuPai() {
		return idMenuPai;
	}

	public void setIdMenuPai(Integer idMenuPai) {
		this.idMenuPai = idMenuPai;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public Integer getIdObjeto() {
		return idObjeto;
	}

	public void setIdObjeto(Integer idObjeto) {
		this.idObjeto = idObjeto;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public MenuVo getMenuPai() {
		return menuPai;
	}

	public void setMenuPai(MenuVo menuPai) {
		this.menuPai = menuPai;
	}

	public ObjetoVo getObjeto() {
		return objeto;
	}

	public void setObjeto(ObjetoVo objeto) {
		this.objeto = objeto;
	}

	public List<MenuVo> getSubMenus() {
		if (subMenus == null) {
			subMenus = new ArrayList<MenuVo>();
		}
		return subMenus;
	}

	public void setSubMenus(List<MenuVo> subMenus) {
		this.subMenus = subMenus;

		if (this.subMenus != null) {
			for (MenuVo i : this.subMenus) {
				i.setMenuPai(this);
			}
		}
	}

	public Integer getIdObjetoSecundario() {
		return idObjetoSecundario;
	}

	public void setIdObjetoSecundario(Integer idObjetoSecundario) {
		this.idObjetoSecundario = idObjetoSecundario;
	}

	public ObjetoVo getObjetoSecundario() {
		return objetoSecundario;
	}

	public void setObjetoSecundario(ObjetoVo objetoSecundario) {
		this.objetoSecundario = objetoSecundario;
	}

}
