package modelo.productoElemento;

public class Ejemplar extends Elemento {
	
	private Libro libro;
	public Ejemplar(Libro libro) {
		this.setLibro(libro);
		
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
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
	
	public Producto getProducto() {
		return this.getLibro();
	}
	
	

}
