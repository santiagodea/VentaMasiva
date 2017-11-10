package modelo.productoElemento;

public class Botella extends Elemento {
	// atributos
	private Vino vino;
	private int filmAlveolars;
	private int cintas;

	// constructor
	public Botella(Vino vino) {
		this.setVino(vino);
	}

	// metodos
	@Override
	public boolean fueEscritoPor(String autor) {
		return this.getVino().fueEscritoPor(autor);
	}

	@Override
	public boolean esEjemplar() {
		return false;
	}

	@Override
	public boolean esBotella() {
		return true;
	}

	@Override
	public void agregarEnvoltorio() {
		this.setFilmAlveolars(1);

	}

	@Override
	public void agregarCierre() {
		if (this.getVino().getPeso() <= 1) {

		} else {
			this.setCintas(2);
		}

	}

	// setters & getters
	public int getFilmAlveolars() {
		return filmAlveolars;
	}

	public void setFilmAlveolars(int filmAlveolars) {
		this.filmAlveolars = filmAlveolars;
	}

	public int getCintas() {
		return cintas;
	}

	public void setCintas(int cintas) {
		this.cintas = cintas;
	}

	public Producto getProducto() {
		return this.getVino();
	}

	public Vino getVino() {
		return vino;
	}

	public void setVino(Vino vino) {
		this.vino = vino;
	}

}
