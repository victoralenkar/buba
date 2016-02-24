package org.br.victorhaus.buffett.util;

public class Constants {

	public static final String LOCALE_BASE_LANG = "languages.language";

	public static final String DATA_SOURCE_URL = "java:/datasources/sapsDS";

	public static final String BASE_RELATORIOS = "reports";

	public static final String DIRETORIO_RELATORIOS = "/" + BASE_RELATORIOS;

	public static final String FINALIDADES_SOURCE_REPORT = BASE_RELATORIOS + "/finalidades.jrxml";

	public static final String FINALIDADES_JASPER_REPORT = BASE_RELATORIOS + "/finalidades.jasper";

	public static final String SEIS_SOURCE_REPORT = BASE_RELATORIOS + "/SEIS.jrxml";

	public static final String SEIS_JASPER_REPORT = BASE_RELATORIOS + "/SEIS.jasper";

	public static final String RELATORIO_SEIS = "/" + BASE_RELATORIOS + "/SEIS.jasper";

	public static final Object PARAMETRO_RELATORIO_CODIGO = "codigo";

	public static final Object PARAMETRO_SUBRELATORIO = "SUBREPORT_DIR";
}
