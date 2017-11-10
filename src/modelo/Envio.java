package modelo;

import java.util.ArrayList;
import java.util.List;

import modelo.productoElemento.Elemento;

public class Envio {
	// atributos
	private Integer nroEnvio;
	private Pedido pedido;
	private List<Elemento> elementos = new ArrayList<>();

	// constructor
	public Envio(Pedido pedido) {
		nroEnvio = Numerador.numeroDeEnvio();
		this.setPedido(pedido);
		this.setNroEnvio(Numerador.numeroDeEnvio());
	}

	// metodos
	public void agregarElemento(Elemento elemento) {
		this.getElementos().add(elemento);
	}

	public Double pesoTotal() {
		return this.getElementos().stream().map(e -> e.getProducto()).mapToDouble(p -> p.getPeso()).sum();
	}

	// getters & setters
	public Integer getNroEnvio() {
		return nroEnvio;
	}

	public void setNroEnvio(Integer nroEnvio) {
		this.nroEnvio = nroEnvio;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Elemento> getElementos() {
		return elementos;
	}

	public void setElementos(List<Elemento> elementos) {
		this.elementos = elementos;
	}
}
