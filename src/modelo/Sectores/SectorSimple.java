package modelo.Sectores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modelo.productoElemento.Botella;
import modelo.productoElemento.Ejemplar;
import modelo.productoElemento.Elemento;
import modelo.productoElemento.Libro;
import modelo.productoElemento.Producto;

public class SectorSimple extends Sector {
	// atributos
	private List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
	private List<Botella> botellas = new ArrayList<Botella>();

	// constructor
	public SectorSimple(String nombre) {
		super(nombre);
	}

	// metodos
	public void agregarEjemplar(Ejemplar ejemplar) {
		this.getEjemplares().add(ejemplar);
	}

	public void agregarBotella(Botella botella) {
		this.getBotellas().add(botella);
	}

	public List<Libro> librosconAutor(String autor) {
		return this.getEjemplares().stream().filter(e -> e.fueEscritoPor(autor)).map(e -> e.getLibro())
				.collect(Collectors.toList());
	}
	public List<SectorSimple> totalDeSectores() {
		List<SectorSimple> ss = new ArrayList<SectorSimple>();
		ss.add(this);
		return ss;
	}

	@Override
	public List<Elemento> getElementosTotalesDelSector() {
		return this.getElementos();
	}

	@Override
	public List<Elemento> elementosPorProducto(Producto unProducto) {
		return this.getElementosTotalesDelSector().stream().filter(e -> e.esElementoDelProducto(unProducto))
				.collect(Collectors.toList());
	}

	@Override
	public List<Sector> getSectores() {
		return null;
	}

	@Override
	public boolean contieneAElementoCon(Integer identificador) {
		return this.getElementos().stream().filter(e -> e.getNroInventario().equals(identificador))
				.collect(Collectors.toList()).size() > 0;
	}

	// vaciar un sector simple, mandando todos sus elementos a otro sector simple
	// que
	// se pasa como parametro
	public void vaciarSectorYPasarAOtro(SectorSimple sector) {
		sector.agregarBotellas(this.getBotellas());
		this.getBotellas().clear();
		sector.agregarEjemplares(this.getEjemplares());
		this.getEjemplares().clear();
	}

	public void agregarBotellas(List<Botella> botellas) {
		this.getBotellas().addAll(botellas);

	}

	public void agregarEjemplares(List<Ejemplar> ejemplares) {
		this.getEjemplares().addAll(ejemplares);
	}

	public void borrarElemento(Elemento elemento) {
		if (elemento.esBotella()) {
			this.borrarBotella(elemento);
		} else {
			this.borrarEjemplar(elemento);
		}

	}

	private void borrarBotella(Elemento elemento) {
		this.getBotellas().remove(elemento);

	}

	private void borrarEjemplar(Elemento elemento) {
		this.getEjemplares().remove(elemento);
	}

	// setters & getters

	public List<Elemento> getElementos() {
		List<Elemento> lista = new ArrayList<>();
		lista.addAll(this.getBotellas());
		lista.addAll(getEjemplares());
		return lista;
	}

	public List<Ejemplar> getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(List<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}

	public List<Botella> getBotellas() {
		return botellas;
	}

	public void setBotellas(List<Botella> botellas) {
		this.botellas = botellas;
	}

}
