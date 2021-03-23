package ordenacion.aplicaciones.libreria;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class Fecha extends GregorianCalendar {
	public Fecha() {
		super();
	}

	public Fecha(int year, int month, int dayOfMonth) {
		super(year, month, dayOfMonth);
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date thisDate = getTime();
		return  sdf.format(thisDate);
	}
}