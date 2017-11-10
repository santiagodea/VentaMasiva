package modelo.productoElemento;

public class Ejemplar extends Elemento {
	// atributos
	private Libro libro;
	private int folios;
	private int etiquetas;

	// constructor
	public Ejemplar(Libro libro) {
		this.setLibro(libro);

	}

	// metodos
	@Override
	public boolean fueEscritoPor(String autor) {
		return this.getLibro().fueEscritoPor(autor);
	}

	@Override
	public boolean esEjemplar() {
		return true;
	}

	@Override
	public boolean esBotella() {
		return false;
	}

	@Override
	public void agregarEnvoltorio() {
		this.setFolios(1 + (int) (this.perimetroAEnvolver() / 1500));
	}

	public int perimetroAEnvolver() {
		return (this.getLibro().getAlto() * this.getLibro().getEspesor() * 4)
				* (this.getLibro().getAncho() * 2 + this.getLibro().getEspesor() * 3);
	}

	@Override
	public void agregarCierre() {
		this.setEtiquetas(this.getFolios() * 3);

	}

	// setters & getters
	public Producto getProducto() {
		return this.getLibro();
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public int getFolios() {
		return folios;
	}

	public void setFolios(int folios) {
		this.folios = folios;
	}

	public int getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(int etiquetas) {
		this.etiquetas = etiquetas;
	}

}
