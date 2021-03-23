package ordenacion.aplicaciones.libreria;

import java.util.Comparator;



public class Libro implements Comparable<Libro>{

	private String autor;
	private String titulo;
	private Fecha fedicion;
	private String pais;
	private String isbn;
	public Libro() {
		super();
	}
	public Libro(String autor, String titulo, Fecha fedicion, String pais, String isb) {
		super();
		this.autor = autor;
		this.titulo = titulo;
		this.fedicion = fedicion;
		this.pais = pais;
		this.isbn = isb;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Fecha getFedicion() {
		return fedicion;
	}
	public void setFedicion(Fecha fedicion) {
		this.fedicion = fedicion;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "\nLibro: \n\tAutor=" + autor + ", \n\tTitulo=" + titulo + ", \n\tISBN=" + isbn+ ", \n\tFecha=" + fedicion;
	}
	@Override
	public Libro clone() {
		
		return  new Libro(autor,titulo,fedicion,pais,isbn);
		
	}
	@Override
	public int compareTo(Libro o) {
		 return Comparator.comparing(Libro::getAutor)
				 .thenComparing(Libro::getTitulo)	
	              .thenComparing(Libro::getIsbn)	    
	              .thenComparing(Libro::getPais)
	              .thenComparing(Libro::getFedicion)
	              .compare(this, o);
	} 
}