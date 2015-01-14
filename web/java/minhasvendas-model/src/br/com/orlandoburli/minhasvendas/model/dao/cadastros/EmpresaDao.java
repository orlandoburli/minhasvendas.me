package br.com.orlandoburli.minhasvendas.model.dao.cadastros;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;

public class EmpresaDao extends BaseCadastroDao<EmpresaVo> {

	public EmpresaDao(DAOManager manager) {
		super(manager);
	}
}