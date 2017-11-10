package modelo.productoElemento;

import modelo.Numerador;

public abstract class Elemento {

	// atributos
	private Integer nroInventario;
	
	//constructor
	public Elemento() {
		nroInventario = Numerador.numeroDeInventario();
	}

	//metodos

	public abstract boolean fueEscritoPor(String autor);

	public abstract boolean esEjemplar();

	public abstract boolean esBotella();

	public boolean esElementoDelProducto(Producto unProducto) {
		return (this.getProducto().equals(unProducto));
	}	
	public abstract Producto getProducto();
	
	//getter
	public Integer getNroInventario() {
		return nroInventario;
	}

}
