package br.com.orlandoburli.minhasvendas.web.utils;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;

public final class Versao {

	private static Versao versao;

	private ServletContext servletContext;

	private Versao() {

	}

	public static Versao getInstance(ServletContext servletContext) {
		if (Versao.versao == null) {
			Versao.versao = new Versao();
			Versao.versao.servletContext = servletContext;
		}
		return Versao.versao;
	}

	public String getVersao() {
		Properties prop = new Properties();
		try {
			prop.load(servletContext.getResourceAsStream("/META-INF/MANIFEST.MF"));
			return prop.getProperty("Versao");
		} catch (NullPointerException | IOException e) {
		}
		return "SEM VERSAO";
	}

	@Override
	public String toString() {
		return getVersao();
	}
}
