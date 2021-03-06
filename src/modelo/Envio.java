package modelo;

import java.util.ArrayList;
import java.util.List;

import modelo.EnvoltoriosCierres.Cierre;
import modelo.EnvoltoriosCierres.Envoltorio;
import modelo.productoElemento.Elemento;

public class Envio {
	// atributos
	private Cliente cliente;
	private Estados estado;
	private Integer nroEnvio;
	private Pedido pedido;
	private List<Elemento> elementos = new ArrayList<>();
	private List<Envoltorio> envoltorios = new ArrayList<>();
	private List <Cierre> cierres = new ArrayList<>();

	// constructor
	public Envio(Pedido pedido) {
		nroEnvio = Numerador.numeroDeEnvio();
		this.setPedido(pedido);
		this.setNroEnvio(Numerador.numeroDeEnvio());
		this.setEstado(Estados.NUEVO);
	}

	// metodos
	public void agregarElemento(Elemento elemento) {
		this.getElementos().add(elemento);
	}
	
	public void agregarEnvoltorios(List<Envoltorio> envoltorios) {
		this.getEnvoltorios().addAll(envoltorios);
	}
	public void agregarCierres(List<Cierre> cierres) {
		this.getCierres().addAll(cierres);
	}
	public Double pesoTotal() {
		return (this.getElementos().stream().map(e -> e.getProducto()).mapToDouble(p -> p.getPeso()).sum()
				+ this.pesoEnvoltorios()
				+this.pesoCierres());
	}

	private double pesoCierres() {
		return this.getCierres().stream().mapToDouble(p -> p.getPeso()).sum();
	}

	private double pesoEnvoltorios() {
		return this.getEnvoltorios().stream().mapToDouble(p -> p.getPeso()).sum();
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

	public List<Envoltorio> getEnvoltorios() {
		return envoltorios;
	}

	public void setEnvoltorios(List<Envoltorio> envoltorios) {
		this.envoltorios = envoltorios;
	}

	public List <Cierre> getCierres() {
		return cierres;
	}

	public void setCierres(List <Cierre> cierres) {
		this.cierres = cierres;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}
	
}
