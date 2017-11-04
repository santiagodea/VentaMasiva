package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modelo.productoElemento.Elemento;
import modelo.productoElemento.Libro;
import modelo.productoElemento.Producto;

public class Deposito {
	
	//variables estaticas
	private static Deposito store = new Deposito();
	private static Integer numeradorDeInventario = 0;
	
	
	
	private List<Sector> sectores = new ArrayList<Sector>();
	
	public static Deposito store() {
		return store;
	}
	
	public static Integer numeroDeInventario() {
		numeradorDeInventario = numeradorDeInventario +1;
		return numeradorDeInventario;
	}

	
	public Deposito () {
		this.llenarDatos();
	}
	
	private void llenarDatos() {
		// TODO crear datos para luego consultar!
		
	}

	public void agregarSector(Sector sector) {
		this.getSectores().add(sector);
	}
	
	//ejer03
	//dado un autor, obtener el conjunto de libros de ese autor de los que hay al menos un ejemplar en el deposito.
	public List<Libro> librosPorAutor(String autor){
		return this.getSectores()
				.stream().map(s -> s.librosconAutor(autor))
				.flatMap(l -> l.stream())
				.distinct()
				.collect(Collectors.toList());
	}
	
	//ejer04
	//dado un producto (libro o vino), obtener un conjunto con los elementos (ejemplares o botellas) de ese producto en el deposito.
	public List<Elemento> elementosPorProducto(Producto unProducto){
		return this.getSectores()
				.stream().map(s -> s.elementosPorProducto(unProducto))
				.flatMap(l -> l.stream())
				.collect(Collectors.toList());
		
	}
	//ejer05
	//dado un identificador, conocer en que sector simple esta el elemento con ese identificador. 
	//Si no esta en ninguno, que lance excepcion.
	public Sector sectorDondeEstaElElemento(Integer identificador) {
		if(this.cantDeSectoresConElementoCon(identificador) > 0) {
			return this.totalDeSectores().stream()
					.filter(s -> s.contieneAElementoCon(identificador))
					.findAny().get();
		} 
		else{
			
			System.out.println("no existe ningun sector con un Elemento con el identificador " + identificador);
			return null;
		}

	}
	
	public Integer cantDeSectoresConElementoCon(Integer identificador) {
		return this.totalDeSectores().stream()
		.filter(s -> s.contieneAElementoCon(identificador))
		.collect(Collectors.toList()).size();
	}

	
	public List<Sector> totalDeSectores(){
		return this.getSectores()
				.stream().map(s -> s.totalDeSectores())
				.flatMap(l -> l.stream())
				.collect(Collectors.toList());
	}
	
	//setters & getters
	public List<Sector> getSectores() {
		return sectores;
	}

	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
	}
}
