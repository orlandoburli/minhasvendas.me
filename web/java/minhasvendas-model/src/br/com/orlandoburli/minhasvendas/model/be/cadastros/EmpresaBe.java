package br.com.orlandoburli.minhasvendas.model.be.cadastros;

import java.util.List;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.minhasvendas.model.dao.cadastros.EmpresaDao;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;

public class EmpresaBe extends BaseBe<EmpresaVo, EmpresaDao> {

	public EmpresaBe(DAOManager manager) {
		super(manager);
	}

	public EmpresaVo login(String email, String senha) throws ListException, LoginInvalidoException {
		EmpresaVo empresa = getByEmail(email);

		if (empresa == null) {
			throw new LoginInvalidoException("Usuário / Senha inválidos!", "login");
		}

		if (empresa.getEmail().equalsIgnoreCase(email) && empresa.getSenha().equals(senha)) {
			// TODO Tratamento para validade do login, pagamento, etc.
			return empresa;
		}

		throw new LoginInvalidoException("Usuário / Senha inválidos!", "login");
	}

	private EmpresaVo getByEmail(String email) throws ListException {
		EmpresaVo filter = new EmpresaVo();
		filter.setEmail(email);

		List<EmpresaVo> list = getList(filter);

		if (list.size() > 0) {
			return list.get(0);
		}

		return null;
	}
}