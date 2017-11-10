package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modelo.productoElemento.Elemento;
import modelo.productoElemento.Producto;

public class Pedido {
	//atributos
	private String cliente;
	private LocalDate fechaDelPedido;
	private Envio envio;

	private List<Producto> productos = new ArrayList<>();
	//constructor
	public Pedido(String cliente) {
		this.setCliente(cliente);
		this.setFechaDelPedido(LocalDate.now());
	}
	//metodos
	public Envio crearEnvio() {
		this.setEnvio(new Envio(this));

		if (this.puedeCrearEnvio()) {
			this.agregarElementos();
		} else {
			throw new RuntimeException("no se puede crear el envio porque falta algun producto");
		}

		return this.getEnvio();

	}
	
	public void agregarProducto(Producto producto) {
		this.getProductos().add(producto);
	}

	private void agregarElementos() {
		this.getProductos().forEach(p -> this.agregarUnelemento(p));
	}

	private void agregarUnelemento(Producto producto) {
		Elemento elemento = Deposito.store().elementosPorProducto(producto).get(0);
		Deposito.store().eliminarElemento(elemento);
		elemento.agregarEnvoltorio();
		elemento.agregarCierre();
		this.agregarElemento(elemento);
	}

	private boolean puedeCrearEnvio() {
		return (this.getProductos().stream().filter(p -> Deposito.store().cantElementosParaProducto(p) > 0)
				.collect(Collectors.toList()).equals(this.getProductos()));
	}

	private void agregarElemento(Elemento elemento) {
		this.getEnvio().agregarElemento(elemento);
	}
	
	//setters & getters
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFechaDelPedido() {
		return fechaDelPedido;
	}

	public void setFechaDelPedido(LocalDate fechaDelPedido) {
		this.fechaDelPedido = fechaDelPedido;
	}

	public Envio getEnvio() {
		return envio;
	}

	public void setEnvio(Envio envio) {
		this.envio = envio;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
