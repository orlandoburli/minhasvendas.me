package br.com.orlandoburli.minhasvendas.web.utils;

import java.util.Locale;

import br.com.orlandoburli.framework.core.web.BaseAction;
import br.com.orlandoburli.framework.core.web.filters.IgnoreFacadeAuthentication;

@IgnoreFacadeAuthentication
public class LocaleUtilsAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	public void execute() {
		// get the default locale
		Locale l = Locale.getDefault();
		writeln("   Language, Country, Variant, Name");
		writeln("");
		writeln("Default locale: ");
		writeln("   " + l.getLanguage() + ", " + l.getCountry() + ", " + ", " + l.getVariant() + ", " + l.getDisplayName());
		// get a predefined locale
		l = Locale.CANADA_FRENCH;
		writeln("A predefined locale - Locale.CANADA_FRENCH:");
		writeln("   " + l.getLanguage() + ", " + l.getCountry() + ", " + ", " + l.getVariant() + ", " + l.getDisplayName());
		// define a new locale
		l = new Locale("en", "CN");
		writeln("User defined locale -Locale(\"en\",\"CN\"):");
		writeln("   " + l.getLanguage() + ", " + l.getCountry() + ", " + ", " + l.getVariant() + ", " + l.getDisplayName());
		// define another new locale
		l = new Locale("ll", "CC");
		writeln("User defined locale -Locale(\"ll\",\"CC\"):");
		writeln("   " + l.getLanguage() + ", " + l.getCountry() + ", " + ", " + l.getVariant() + ", " + l.getDisplayName());
		// get the supported locales
		Locale[] s = Locale.getAvailableLocales();
		writeln("Supported locales: ");
		for (int i = 0; i < s.length; i++) {
			writeln("   " + s[i].getLanguage() + ", " + s[i].getCountry() + ", " + s[i].getVariant() + ", " + s[i].getDisplayName());
		}
	}

	public void writeln(String what) {
		write(what + "\n");
	}
}
