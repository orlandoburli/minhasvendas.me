package br.com.orlandoburli.minhasvendas.web.servlets.filters;

import java.lang.reflect.Method;

import br.com.orlandoburli.framework.core.dao.DaoUtils;
import br.com.orlandoburli.framework.core.utils.Constants;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.framework.core.web.filters.BaseFilter;
import br.com.orlandoburli.minhasvendas.model.vo.cadastros.EmpresaVo;

public class EmpresaFilter extends BaseFilter {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean doFilter(Object facade) throws IllegalArgumentException, IllegalAccessException {
		EmpresaVo empresa = (EmpresaVo) getRequest().getSession().getAttribute(Constants.Session.SESSION_USUARIO);

		if (facade instanceof BaseCadastroAction) {
			BaseCadastroAction<?, ?, ?> cadastroAction = (BaseCadastroAction<?, ?, ?>) facade;

			if (cadastroAction.getMethodName().equals(Constants.INSERIR)) {

				// Seta o id da empresa no vo
				BaseVo voSession = cadastroAction.getVoSession();
				Method setterMethod = DaoUtils.getSetterMethod(voSession.getClass(), "idEmpresa");
				DaoUtils.setValue(setterMethod, voSession, empresa.getIdEmpresa());
			} else {
				// Qualquer outra operacao, verifica se ele pode alterar este
				// registro, se é da mesma empresa.
				BaseVo voSession = cadastroAction.getVoSession();

				Method getterMethod = DaoUtils.getGetterMethod(voSession.getClass(), "idEmpresa");

				Integer idEmpresa = (Integer) DaoUtils.getValue(getterMethod, voSession);

				if (!idEmpresa.equals(empresa.getIdEmpresa())) {
					return false;
				}
			}
		} else if (facade instanceof BaseConsultaAction) {

		}

		return true;
	}
}
