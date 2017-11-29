package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modelo.productoElemento.Elemento;
import modelo.productoElemento.Producto;

public class Pedido {
	//atributos
	private Cliente cliente;
	private LocalDate fechaDelPedido;
	private Envio envio;
	private List<Producto> productos = new ArrayList<>();
	
	//constructor
	public Pedido(Cliente cliente) {
		this.setCliente(cliente);
		this.setFechaDelPedido(LocalDate.now());
	}
	//metodos
	public Envio crearEnvio() {
		this.setEnvio(new Envio(this));

		if (this.puedeCrearEnvio()) {
			this.agregarElementos();
		} else {
			this.getEnvio().setEstado(Estados.PENDIENTE);
			throw new RuntimeException("no se puede crear el envio porque falta algun producto");
		}
		this.getEnvio().setEstado(Estados.EN_TRANSITO);
		return this.getEnvio();

	}
	
	public void agregarProducto(Producto producto) {
		this.getProductos().add(producto);
		
	}

	private void agregarElementos() {
		this.getProductos().forEach(p -> this.agregarUnElemento(p));
	}

	private void agregarUnElemento(Producto producto) {
		Elemento elemento = Deposito.store().elementosPorProducto(producto).get(0);
		Deposito.store().eliminarElemento(elemento);
		this.getEnvio().agregarCierres(producto.getCierres());
		this.getEnvio().agregarEnvoltorios(producto.getEnvoltorios());
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
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
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
