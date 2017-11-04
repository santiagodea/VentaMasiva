package modelo.productoElemento;

public class Botella extends Elemento {

	private Vino vino;

	public Botella(Vino vino) {
		this.setVino(vino);
	}

	public Vino getVino() {
		return vino;
	}

	public void setVino(Vino vino) {
		this.vino = vino;
	}

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
	
	public Producto getProducto() {
		return this.getVino();
	}

}
