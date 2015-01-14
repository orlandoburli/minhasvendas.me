package br.com.orlandoburli.minhasvendas.model.vo.acesso;

import static br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Acesso.Objeto.Colunas.AUTO_START;
import static br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Acesso.Objeto.Colunas.ID_OBJETO;
import static br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Acesso.Objeto.Colunas.NOME;
import static br.com.orlandoburli.minhasvendas.model.utils.Dicionario.Acesso.Objeto.Colunas.URL;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.minhasvendas.model.domains.SimNao;
import br.com.orlandoburli.minhasvendas.model.utils.Dicionario;

@Table(Dicionario.Acesso.Objeto.TABELA_OBJETO)
public class ObjetoVo extends BaseVo {
	private static final long serialVersionUID = 1L;

	@Column(name = ID_OBJETO, dataType = DataType.INT, isKey = true)
	@NotNull
	@NotEmpty
	private Integer idObjeto;

	@Column(name = NOME, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@NotNull
	@NotEmpty
	@MaxSize(100)
	private String nome;

	@Column(name = URL, dataType = DataType.VARCHAR, maxSize = 150)
	@NotNull
	@NotEmpty
	@MaxSize(150)
	private String url;

	@Column(name = AUTO_START, dataType = DataType.CHAR, maxSize = 1, isNotNull = true, defaultValue = "'" + SimNao.NAO + "'")
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	@Description("Auto Start")
	private String autoStart;

	public Integer getIdObjeto() {
		return idObjeto;
	}

	public void setIdObjeto(Integer idObjeto) {
		this.idObjeto = idObjeto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAutoStart() {
		return autoStart;
	}

	public void setAutoStart(String autoStart) {
		this.autoStart = autoStart;
	}
}
