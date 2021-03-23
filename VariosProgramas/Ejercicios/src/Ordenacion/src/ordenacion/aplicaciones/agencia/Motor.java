package ordenacion.aplicaciones.agencia;

import java.util.Comparator;

public class Motor implements Comparable<Motor>{

	private double cb;
	private int cilindros;
	
	public Motor() {
		super();
	}

	public Motor(double cb, int cilindros) {
		super();
		this.cb = cb;
		this.cilindros = cilindros;
	}

	public double getCb() {
		return cb;
	}

	public void setCb(double cb) {
		this.cb = cb;
	}

	public int getCilindros() {
		return cilindros;
	}

	public void setCilindros(int cilindros) {
		this.cilindros = cilindros;
	}

	@Override
	public String toString() {
		return "Motor [caballos=" + cb + ", cilindros=" + cilindros + "]";
	}

	@Override
	public int compareTo(Motor o) {
		 return Comparator.comparing(Motor::getCb)
	              .thenComparing(Motor::getCilindros)
	              .compare(this, o);
	}

}
