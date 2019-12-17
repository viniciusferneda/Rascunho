package calculoDias;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class calculaDias {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAtual = sdf.parse("18/10/2014 01:00:00");
		long dia = 86400000;

		Date data1 = sdf.parse("19/10/2014 00:00:00");
		Calendar calendarInicio = onlyDate(dataAtual);
		Calendar calendarFim = onlyDate(data1);

		// Calcula a diferenca
		long diferencaMilisegundos = calendarFim.getTimeInMillis() - calendarInicio.getTimeInMillis();
		System.out.println("Diferença Milisegundos 1: " + diferencaMilisegundos);
		BigDecimal diferencaDias = new BigDecimal(diferencaMilisegundos).divide(new BigDecimal(dia),
				new MathContext(2, RoundingMode.HALF_UP));
		Double diferencaDiasDouble = (double) (diferencaMilisegundos / dia);
		System.out.println("Data 1 (BigDecimal): " + diferencaDias.intValue());
		System.out.println("Data 1 (Double): " + diferencaDiasDouble.intValue());

		System.out.println("-------------------------------------------------------------------------------");

		/*
		 * Date data2 = sdf.parse("28/10/2013 08:27:10"); Calendar
		 * calendarInicio2 = onlyDate(dataAtual); Calendar calendarFim2 =
		 * onlyDate(data2);
		 *
		 * // Calcula a diferenca long diferencaMilisegundos2 =
		 * calendarFim2.getTimeInMillis() - calendarInicio2.getTimeInMillis();
		 * System.out.println("Diferença Milisegundos 2: "
		 * +diferencaMilisegundos2); BigDecimal diferencaDiasBD2 = new
		 * BigDecimal(diferencaMilisegundos2).divide(new BigDecimal(dia), new
		 * MathContext(2, RoundingMode.HALF_UP)); System.out.println("Data 2: "
		 * +diferencaDiasBD2.intValue());
		 *
		 * /*int count=0; while
		 * (onlyDate(calendarInicio2.getTime()).compareTo(onlyDate(calendarFim2.
		 * getTime()))!=0){ calendarInicio2.add(Calendar.DAY_OF_MONTH, 1);
		 * count++; } System.out.println(
		 * "-------------------------------------------------------------------------------"
		 * ); System.out.println(count);
		 */
	}

	private static Calendar onlyDate(final Date date) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}

}
