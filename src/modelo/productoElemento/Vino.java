package modelo.productoElemento;

import java.util.ArrayList;
import java.util.List;

import modelo.Cepas;
import modelo.EnvoltoriosCierres.Cinta;
import modelo.EnvoltoriosCierres.FilmAlveolar;

public class Vino extends Producto {
	// atributos
	private String bodega;
	private List<Cepas> cepas = new ArrayList<Cepas>();

	// constructor
	public Vino(double peso, double costo, double precioDeVenta, String bodega) {
		super(peso, costo, precioDeVenta);
		this.setBodega(bodega);
	}

	// metodos
	public void agregarCepa(Cepas cepa) {
		this.getCepas().add(cepa);
	}

	@Override
	public void agregarEnvoltorio() {
		this.getEnvoltorios().add(new FilmAlveolar());

	}

	@Override
	public void agregarCierres() {
		if (this.getPeso() <= 1) {
			this.getCierres().add(new Cinta());
		} else {
			this.getCierres().add(new Cinta());
			this.getCierres().add(new Cinta());
		}

	}

	@Override
	public boolean fueEscritoPor(String autor) {
		return false;
	}

	// setters & getters
	public String getBodega() {
		return bodega;
	}

	public void setBodega(String bodega) {
		this.bodega = bodega;
	}

	public List<Cepas> getCepas() {
		return cepas;
	}

	public void setCepas(List<Cepas> cepas) {
		this.cepas = cepas;
	}

}
