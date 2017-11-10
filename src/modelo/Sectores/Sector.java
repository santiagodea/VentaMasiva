package modelo.Sectores;

import java.util.List;
import java.util.stream.Collectors;

import modelo.productoElemento.Elemento;
import modelo.productoElemento.Libro;
import modelo.productoElemento.Producto;

public abstract class Sector {
	// atributo
	private String nombre;

	// constructor
	public Sector(String nombre) {
		this.setNombre(nombre);
	}

	// metodos
	public abstract List<Elemento> getElementosTotalesDelSector();

	public abstract List<Libro> librosconAutor(String autor);

	public abstract List<Elemento> elementosPorProducto(Producto unProducto);

	public abstract List<Sector> getSectores();

	public abstract boolean contieneAElementoCon(Integer identificador);

	// queda raro el casting, mejorar!, no quiero hacerlo en la super clase ya que
	// no tiene sentido xq se podria borrar un elemento solo
	// en un Sector Simple
	public List<Sector> totalDeSectores() {
		return this.getSectores().stream().map(s -> s.getSectores()).flatMap(l -> l.stream())
				.collect(Collectors.toList());
	}

	// setter & getter
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
