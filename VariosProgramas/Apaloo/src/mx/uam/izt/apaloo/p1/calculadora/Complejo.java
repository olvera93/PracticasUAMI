package mx.uam.izt.apaloo.p1.calculadora;

public class Complejo {

	private float real;
	private float imag;
	public static int contadorResultado;
		
	
	public Complejo(float real, float imag) {
		
		this.real = real;
		this.imag = imag;
	}
	
	public Complejo() {
		this.real = real;
		this.imag = imag;
	}

	public float getReal() {
		return real;
	}
	public void setReal(float real) {
		this.real = real;
	}
	public float getImag() {
		return imag;
	}
	public void setImag(float imag) {
		this.imag = imag;
	}
	public int getContadorResultado() {
		return contadorResultado;
	}
	public void setContadorResultado(int contadorResultado) {
		Complejo.contadorResultado = contadorResultado;
	}
}
