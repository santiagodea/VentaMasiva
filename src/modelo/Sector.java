package modelo;

import java.util.List;
import java.util.stream.Collectors;

import modelo.productoElemento.Elemento;
import modelo.productoElemento.Libro;
import modelo.productoElemento.Producto;

public abstract class Sector {
	
	
	public abstract List<Elemento> getElementosTotalesDelSector();
	
	public abstract List<Libro> librosconAutor(String autor);

	public abstract List<Elemento> elementosPorProducto(Producto unProducto);

	public abstract List<Sector> getSectores();

	public abstract boolean contieneAElementoCon(Integer identificador);
	
	public List<Sector> totalDeSectores(){
		return this.getSectores()
				.stream().map(s -> s.getSectores())
				.flatMap(l -> l.stream())
				.collect(Collectors.toList());
	}
}
