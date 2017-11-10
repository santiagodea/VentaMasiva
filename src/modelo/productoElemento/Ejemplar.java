package modelo.productoElemento;

public class Ejemplar extends Elemento {
	// atributos
	private Libro libro;

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
}
