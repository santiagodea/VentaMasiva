package modelo.productoElemento;

import java.util.ArrayList;
import java.util.List;

import modelo.EnvoltoriosCierres.Cierre;
import modelo.EnvoltoriosCierres.Folio;

public class Libro extends Producto {

	// atributos
	private String titulo;
	private List<String> autores = new ArrayList<String>();
	private int alto;
	private int ancho;
	private int espesor;

	// constructor
	public Libro(String titulo, double peso, double costo, double precioDeVenta, int alto, int ancho, int espesor) {
		super(peso, costo, precioDeVenta);
		this.setAlto(alto);
		this.setAncho(ancho);
		this.setEspesor(espesor);
		this.setTitulo(titulo);
	}

	// metodos

	public void agregarAutor(String autor) {
		this.getAutores().add(autor);
	}

	@Override
	public boolean fueEscritoPor(String autor) {
		return this.getAutores().contains(autor);
	}

	public int perimetroAEnvolver() {
		return (this.getAlto() * this.getEspesor() * 4) * (this.getAncho() * 2 + this.getEspesor() * 3);
	}
	
	@Override
	public void agregarEnvoltorio() {
		int folios = 1 + (int) (this.perimetroAEnvolver() / Folio.getCm2());
		for (int i = 0; i < folios; i++) {
			this.getEnvoltorios().add(new Folio());
		}
	}

	@Override
	public void agregarCierres() {
		int cierres = this.getEnvoltorios().size() * 3;
		for (int i = 0; i < cierres; i++) {
			this.getCierres().add(new Cierre());
		}
	}

	// setters & getters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<String> getAutores() {
		return autores;
	}

	public void setAutores(List<String> autores) {
		this.autores = autores;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getEspesor() {
		return espesor;
	}

	public void setEspesor(int espesor) {
		this.espesor = espesor;
	}
}
