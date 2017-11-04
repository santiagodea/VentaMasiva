package modelo.productoElemento;

import modelo.Deposito;

public abstract class Elemento {

	// atributos
	private Integer nroInventario;

	public Elemento() {
		nroInventario = Deposito.numeroDeInventario();
	}

	public Integer getNroInventario() {
		return nroInventario;
	}

	public abstract boolean fueEscritoPor(String autor);

	public abstract boolean esEjemplar();

	public abstract boolean esBotella();

	public boolean esElementoDelProducto(Producto unProducto) {
		return (this.getProducto().equals(unProducto));
	}	
	public abstract Producto getProducto();

}
