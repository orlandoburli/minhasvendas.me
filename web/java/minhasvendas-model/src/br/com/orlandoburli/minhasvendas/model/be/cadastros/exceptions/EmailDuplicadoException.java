package br.com.orlandoburli.minhasvendas.model.be.cadastros.exceptions;

import br.com.orlandoburli.framework.core.be.exceptions.BeException;

public class EmailDuplicadoException extends BeException {
	private static final long serialVersionUID = 1L;

	public EmailDuplicadoException(String message, String field) {
		super(message, field);
	}

}
