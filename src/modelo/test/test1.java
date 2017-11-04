package modelo.test;

import java.util.stream.Collectors;

import org.junit.Test;

import modelo.Cepas;
import modelo.Deposito;
import modelo.SectorCompuesto;
import modelo.SectorSimple;
import modelo.productoElemento.Botella;
import modelo.productoElemento.Ejemplar;
import modelo.productoElemento.Libro;
import modelo.productoElemento.Vino;

public class test1 {

	@Test
	public void test() {
		
		
		SectorCompuesto SCA = new SectorCompuesto();
		SectorCompuesto SCB = new SectorCompuesto();
		SectorCompuesto SCC = new SectorCompuesto();
		SectorSimple S1 = new SectorSimple(); 
		SectorSimple S2 = new SectorSimple(); 
		SectorSimple S3 = new SectorSimple(); 
		
		SCA.agregarSector(SCB);
		SCA.agregarSector(SCC);
		SCB.agregarSector(S1);
		SCB.agregarSector(S2);
		SCC.agregarSector(S3);
		
		Vino vino1 = new Vino(30,150, 200, "los Robles"); 
		// (double peso, double costo, double precioDeVenta, String bodega)
		vino1.agregarCepa(Cepas.MALBEC);
		Libro libro1 = new Libro("el libro de juan y pedro", 120, 100, 150, 30, 15, 5);
		libro1.agregarAutor("juan");
		libro1.agregarAutor("pedro");
		//(double peso, double costo, double precioDeVenta, int alto, int ancho, int espesor)
		
		Botella botella1 = new Botella(vino1);
		
		Ejemplar ejemplar1 = new Ejemplar(libro1);
		
		Deposito.store().agregarSector(SCA);
		
		
		System.out.println(libro1.fueEscritoPor("juan"));
		System.out.println(ejemplar1.fueEscritoPor("juan"));

		//ejer 01
		S1.agregarBotella(botella1);
		System.out.println(botella1.getNroInventario());
		//ejer 02
		S1.agregarEjemplar(ejemplar1);
		System.out.println(ejemplar1.getNroInventario());
		//ejer 03
		System.out.println(S1.librosconAutor("juan").size());
		System.out.println(Deposito.store().librosPorAutor("juan").stream().map(l->l.getTitulo()).collect(Collectors.toList()));
		
		//ejer 04
		System.out.println(Deposito.store().elementosPorProducto(libro1).stream().map(e ->e.getNroInventario()).collect(Collectors.toList()));
	
		//ejer 05

		System.out.println(Deposito.store().sectorDondeEstaElElemento(1));
		//ejer 06
		
		//ejer 07
	}

}
