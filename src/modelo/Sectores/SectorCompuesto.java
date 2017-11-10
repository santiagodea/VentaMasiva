package modelo.Sectores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modelo.productoElemento.Elemento;
import modelo.productoElemento.Libro;
import modelo.productoElemento.Producto;

public class SectorCompuesto extends Sector {
	// atributo
	private List<Sector> sectores = new ArrayList<Sector>();

	// constructor
	public SectorCompuesto(String nombre) {
		super(nombre);
	}

	// metodos
	public void agregarSector(Sector sector) {
		this.getSectores().add(sector);
	}

	@Override
	public List<Elemento> getElementosTotalesDelSector() {
		return this.getSectores().stream().map(s -> s.getElementosTotalesDelSector()).flatMap(l -> l.stream())
				.collect(Collectors.toList());
	}

	@Override
	public List<Libro> librosconAutor(String autor) {
		return this.getSectores().stream().map(s -> s.librosconAutor(autor)).flatMap(l -> l.stream())
				.collect(Collectors.toList());
	}

	@Override
	public List<Elemento> elementosPorProducto(Producto unProducto) {
		return this.getSectores().stream().map(s -> s.elementosPorProducto(unProducto)).flatMap(l -> l.stream())
				.collect(Collectors.toList());
	}

	@Override
	public boolean contieneAElementoCon(Integer identificador) {
		return false;
	}

	// setters & getters
	public List<Sector> getSectores() {
		return sectores;
	}

	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
	}

}
