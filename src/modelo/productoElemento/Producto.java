package modelo.productoElemento;

public abstract class Producto {
	// atributos
	private double peso;
	private double costo;
	private double precioDeVenta;

	// constructor
	public Producto(double peso, double costo, double precioDeVenta) {
		this.setPeso(peso);
		this.setCosto(costo);
		this.setPrecioDeVenta(precioDeVenta);
	}

	// metodos
	public abstract boolean fueEscritoPor(String autor);

	// setters & getters
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getPrecioDeVenta() {
		return precioDeVenta;
	}

	public void setPrecioDeVenta(double precioDeVenta) {
		this.precioDeVenta = precioDeVenta;
	}

}
