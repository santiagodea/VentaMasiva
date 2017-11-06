package modelo;

import java.util.List;
import java.util.stream.Collectors;

import modelo.productoElemento.Botella;
import modelo.productoElemento.Elemento;
import modelo.productoElemento.Libro;
import modelo.productoElemento.Producto;

public abstract class Sector {
	
	private String nombre;
	
	public Sector (String nombre) {
		this.setNombre(nombre);
	}
	
	public abstract List<Elemento> getElementosTotalesDelSector();
	
	public abstract List<Libro> librosconAutor(String autor);

	public abstract List<Elemento> elementosPorProducto(Producto unProducto);

	public abstract List<Sector> getSectores();

	public abstract boolean contieneAElementoCon(Integer identificador);
	
	//queda raro el casting, mejorar!, no quiero hacerlo en la super clase ya que no tiene sentido xq se podria borrar un elemento solo
	//en un Sector Simple
	public List<Sector> totalDeSectores(){
		return this.getSectores()
				.stream().map(s -> s.getSectores())
				.flatMap(l -> l.stream())
				.collect(Collectors.toList());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
