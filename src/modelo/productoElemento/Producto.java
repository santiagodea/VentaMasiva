package modelo.productoElemento;

import java.util.ArrayList;
import java.util.List;

import modelo.EnvoltoriosCierres.Cierre;
import modelo.EnvoltoriosCierres.Envoltorio;

public abstract class Producto {
	// atributos
	private double peso;
	private double costo;
	private double precioDeVenta;
	
	private List<Cierre> cierres = new ArrayList<>();
	private List<Envoltorio> envoltorios = new ArrayList<>();

	// constructor
	public Producto(double peso, double costo, double precioDeVenta) {
		this.setPeso(peso);
		this.setCosto(costo);
		this.setPrecioDeVenta(precioDeVenta);
		this.agregarEnvoltorio();
		this.agregarCierres();
	}

	public abstract void agregarCierres();
	public abstract void agregarEnvoltorio();

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

	public List<Cierre> getCierres() {
		return cierres;
	}

	public void setCierres(List<Cierre> cierres) {
		this.cierres = cierres;
	}

	public List<Envoltorio> getEnvoltorios() {
		return envoltorios;
	}

	public void setEnvoltorios(List<Envoltorio> envoltorios) {
		this.envoltorios = envoltorios;
	}

}
