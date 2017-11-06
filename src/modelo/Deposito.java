package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modelo.productoElemento.Elemento;
import modelo.productoElemento.Libro;
import modelo.productoElemento.Producto;

public class Deposito {

	// variables estaticas
	private static Deposito store = new Deposito();
	private static Integer numeradorDeInventario = 0;

	private List<Sector> sectores = new ArrayList<Sector>();

	public static Deposito store() {
		return store;
	}

	public static Integer numeroDeInventario() {
		numeradorDeInventario = numeradorDeInventario + 1;
		return numeradorDeInventario;
	}

	public Deposito() {
		this.llenarDatos();
	}

	private void llenarDatos() {
		// TODO crear datos para luego consultar!

	}

	public void agregarSector(Sector sector) {
		this.getSectores().add(sector);
	}

	// ejer03
	// dado un autor, obtener el conjunto de libros de ese autor de los que hay al
	// menos un ejemplar en el deposito.
	public List<Libro> librosPorAutor(String autor) {
		return this.getSectores().stream().map(s -> s.librosconAutor(autor)).flatMap(l -> l.stream()).distinct()
				.collect(Collectors.toList());
	}

	// devuelvo una lista de String de los libros para que sea mas claro al
	// mostrarlo
	public List<String> librosPorAutorTitulos(String autor) {
		return this.librosPorAutor(autor).stream().map(l -> l.getTitulo()).collect(Collectors.toList());
	}

	// ejer04
	// dado un producto (libro o vino), obtener un conjunto con los elementos
	// (ejemplares o botellas) de ese producto en el deposito.
	public List<Elemento> elementosPorProducto(Producto unProducto) {
		return this.getSectores().stream().map(s -> s.elementosPorProducto(unProducto)).flatMap(l -> l.stream())
				.collect(Collectors.toList());

	}
	//muestra una lista con los numeros de inventario de los productos
	public List<Integer> elemontosPorProductosNros(Libro libro){
		return this.elementosPorProducto(libro).stream().map(e ->e.getNroInventario()).collect(Collectors.toList());
	}

	// ejer05
	// dado un identificador, conocer en que sector simple esta el elemento con ese
	// identificador.
	// Si no esta en ninguno, que lance excepcion.
	public Sector sectorDondeEstaElElemento(Integer identificador) {
		try {
			return this.sectorConElemento(identificador);
	}
		catch (Exception e) {
			System.out.println("no existe ningun sector con un Elemento con el identificador " + identificador);
		} {	
		}
		return null;
		//queda muy raro devolver algo si lo encuentra y sino devolver null... pero tengo q preguntar como deberia ser...	
	}
	
	//ejer06
	//retirar un elemento de un sector simple. Si no esta, lanzar excepcion.
	public void eliminarElemento(Elemento elemento) {
		if (this.haySectorConElemento(elemento)) {
			this.sectorConElemento(elemento.getNroInventario()).borrarElemento(elemento);
		}
		else {
			throw new RuntimeException("el elemento nro" +  elemento.getNroInventario() + "no se puede eliminar porque no existe");
			}
	}
	
	public boolean haySectorConElemento(Elemento elemento) {
		return this.totalDeSectores().
				stream().map(s -> s.getElementosTotalesDelSector())
				.flatMap(l -> l.stream())
				.collect(Collectors.toList())
				.contains(elemento);
	}
	

	
	
	public Integer cantSectorConElemento(Integer nroInventario) {
		return this.totalDeSectores().stream().filter(s -> s.contieneAElementoCon(nroInventario)).collect(Collectors.toList()).size();
	}	
	
	public SectorSimple sectorConElemento(Integer nroInventario) {
		return (SectorSimple) this.totalDeSectores().stream().filter(s -> s.contieneAElementoCon(nroInventario)).findAny().get();
	}


	public Integer cantDeSectoresConElementoCon(Integer nroInventario) {
		return this.totalDeSectores().stream().filter(s -> s.contieneAElementoCon(nroInventario))
				.collect(Collectors.toList()).size();
	}

	public List<Sector> totalDeSectores() {
		return this.getSectores().stream().map(s -> s.totalDeSectores())
				.flatMap(l -> l.stream())
				.collect(Collectors.toList());
	}

	// setters & getters
	public List<Sector> getSectores() {
		return sectores;
	}

	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
	}
}
