package br.com.inforium.util;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataUtil {

	public static Date parseDate(String data) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		try {
			return format.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static Date parseDate2(String data) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		try {
			return format.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	public static String parseDate2(Date data) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		return format.format(data);

	}
	
	public static Date parseDate3(String data) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		try {
			return format.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	public static String parseDate(Date data) {
		if(data != null){
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			String dataRetorno= "";

			dataRetorno = format.format(data);
			return dataRetorno;
		}else{
			return "";
		}
		
	
 
	}
	
	
	

	public static String buscaHoraAtual() {

		StringBuilder sb = new StringBuilder();

		GregorianCalendar d = new GregorianCalendar();
		sb.append(d.get(GregorianCalendar.HOUR_OF_DAY));
		sb.append(":");
		sb.append(d.get(GregorianCalendar.MINUTE));
		sb.append(":");
		sb.append(d.get(GregorianCalendar.SECOND));
		return sb.toString();

	}
	
	public static String dataExtenso(String data) {
		String mes = data.substring(3, 5);

		switch (new Integer(mes).intValue()) {
		case 1:
			mes = "janeiro";
			break;
		case 2:
			mes = "fevereiro";
			break;
		case 3:
			mes = "mar�o";
			break;
		case 4:
			mes = "abril";
			break;
		case 5:
			mes = "maio";
			break;
		case 6:
			mes = "junho";
			break;
		case 7:
			mes = "julho";
			break;
		case 8:
			mes = "agosto";
			break;
		case 9:
			mes = "setembro";
			break;
		case 10:
			mes = "outubro";
			break;
		case 11:
			mes = "novembro";
			break;
		case 12:
			mes = "dezembro";
			break;
		}

		String dataret = data.substring(0, 2) + " de " + mes + " de "
				+ data.substring(6, 10);

		return dataret;
	}
	public static String dataToDataInvertida (String data) {
		String dataInvertida = data.substring(6, 10) + data.substring(3, 5) + data.substring(0, 2);
		return dataInvertida;
	}
	
	public static boolean dataMaior(Date data, Date dataAtual){
		boolean flagData = false;
		
		if(data.after(dataAtual)){
			flagData = true;
		}else{
			flagData = false;
		}
		
		return flagData;
		
	}

}
