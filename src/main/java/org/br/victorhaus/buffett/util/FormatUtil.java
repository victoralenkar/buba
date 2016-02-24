package org.br.victorhaus.buffett.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;

public class FormatUtil {

	public static String calendarToString(Calendar cal) {
		String dataString = "-";
		if (cal != null) {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy", FacesContext.getCurrentInstance().getViewRoot().getLocale());
			dataString = df.format(cal.getTime());
		}
		return dataString;
	}

	public static String dateToString(Date data) {
		String dataString = "-";
		if (data != null) {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy", FacesContext.getCurrentInstance().getViewRoot().getLocale());
			dataString = df.format(data);
		}
		return dataString;
	}

	public static Date stringToDate(String dataString) throws ParseException {
		Date date = null;
		if (dataString != null) {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy", FacesContext.getCurrentInstance().getViewRoot().getLocale());
			date = df.parse(dataString);
		}
		return date;
	}

	public static Calendar stringToCalendar(String dataString) throws ParseException {
		Date date = null;
		if (dataString != null) {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy", FacesContext.getCurrentInstance().getViewRoot().getLocale());
			date = df.parse(dataString);
		}
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal;
	}

	public static String doubleToString(double d) {
		DecimalFormat df = new DecimalFormat();
		Currency currency = Currency.getInstance(FacesContext.getCurrentInstance().getViewRoot().getLocale());
		df.setCurrency(currency);
		return df.format(d);
	}

	public static double arredondar(double valor, int casas, int ceilOrFloor) {
		double arredondado = valor;
		arredondado *= (Math.pow(10, casas));
		if (ceilOrFloor == 0) {
			arredondado = Math.ceil(arredondado);
		} else {
			arredondado = Math.floor(arredondado);
		}
		arredondado /= (Math.pow(10, casas));
		return arredondado;
	}

	public static Map<String, String> listarEstados() {
		Map<String, String> estados = new HashMap<String, String>();

		// NORTE
		estados.put("AC", "AC");
		estados.put("AP", "AP");
		estados.put("AM", "AM");
		estados.put("PA", "PA");
		estados.put("RR", "RR");
		estados.put("RO", "RO");

		// NORDESTE
		estados.put("PI", "PI");
		estados.put("MA", "MA");
		estados.put("CE", "CE");
		estados.put("RN", "RN");
		estados.put("PB", "PB");
		estados.put("PE", "PE");
		estados.put("AL", "AL");
		estados.put("SE", "SE");
		estados.put("BA", "BA");

		// CENTRO-OESTE
		estados.put("MT", "MT");
		estados.put("MS", "MS");
		estados.put("TO", "TO");
		estados.put("GO", "GO");

		// SUDESTE
		estados.put("MG", "MG");
		estados.put("ES", "ES");
		estados.put("RJ", "RJ");
		estados.put("SP", "SP");

		// SUL
		estados.put("PR", "PR");
		estados.put("SC", "SC");
		estados.put("RS", "RS");
		estados = MapUtil.sortByValue(estados);
		return estados;
	}
}
