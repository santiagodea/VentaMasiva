package modelo.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Cepas;
import modelo.Deposito;
import modelo.Pedido;
import modelo.Sectores.SectorCompuesto;
import modelo.Sectores.SectorSimple;
import modelo.productoElemento.Botella;
import modelo.productoElemento.Ejemplar;
import modelo.productoElemento.Libro;
import modelo.productoElemento.Vino;

public class test1 {

	@Test
	public void test() {

		SectorCompuesto SCA = new SectorCompuesto("sector A");
		SectorCompuesto SCB = new SectorCompuesto("sector B");
		SectorCompuesto SCC = new SectorCompuesto("sector C");
		SectorSimple S1 = new SectorSimple("sector 1");
		SectorSimple S2 = new SectorSimple("sector 2");
		SectorSimple S3 = new SectorSimple("sector 3");

		SCA.agregarSector(SCB);
		SCA.agregarSector(SCC);
		SCB.agregarSector(S1);
		SCB.agregarSector(S2);
		SCC.agregarSector(S3);

		Vino vino1 = new Vino(30, 150, 200, "los Robles");
		// (double peso, double costo, double precioDeVenta, String bodega)
		vino1.agregarCepa(Cepas.MALBEC);
		Libro libro1 = new Libro("el libro de juan y pedro", 120, 100, 150, 30, 15, 5);
		libro1.agregarAutor("juan");
		libro1.agregarAutor("pedro");
		// (double peso, double costo, double precioDeVenta, int alto, int ancho, int
		// espesor)

		Botella botella1 = new Botella(vino1);
		Botella botella2 = new Botella(vino1);

		Ejemplar ejemplar1 = new Ejemplar(libro1);
		Ejemplar ejemplar2 = new Ejemplar(libro1);

		Deposito.store().agregarSector(SCA);

		// ejer 01
		S1.agregarBotella(botella1);
		System.out.println("elemento agregado con nro de inventario: ");
		System.out.println(botella1.getNroInventario());
		// ejer 02
		S1.agregarEjemplar(ejemplar1);
		System.out.println("elemento agregado con nro de inventario: ");
		System.out.println(ejemplar1.getNroInventario());
		S1.agregarEjemplar(ejemplar2);
		System.out.println("elemento agregado con nro de inventario: ");
		System.out.println(ejemplar2.getNroInventario());
		// ejer 03
		System.out.println("cantidad de libros para el autor juan: ");
		System.out.println(S1.librosconAutor("juan").size());
		System.out.println("libros para el autor juan: ");
		System.out.println(Deposito.store().librosPorAutorTitulos("juan"));

		// ejer 04
		System.out.println("cantidad de elementos en el deposito para el " + libro1.getTitulo());
		System.out.println(Deposito.store().elementosPorProducto(libro1).size());
		System.out.println("elementos en el deposito para el " + libro1.getTitulo());
		System.out.println(Deposito.store().elemontosPorProductosNros(libro1));

		// ejer 05
		System.out.println("sector donde se encuentra el elemento conb id 1");
		System.out.println(Deposito.store().sectorDondeEstaElElemento(1).getNombre());
		// ejer 06

		System.out.println("eliminar un elemento y muestra cuantos queda:");
		Deposito.store().eliminarElemento(ejemplar2);
		System.out.println(Deposito.store().elementosPorProducto(libro1).size());

		
		S2.agregarBotella(botella1);
		// ejer 07
		System.out.println("cantidad d eelementos en el S1 y S2 antes: ");
		System.out.println(S1.getElementosTotalesDelSector().size());
		System.out.println(S2.getElementosTotalesDelSector().size());
		
		S2.vaciarSectorYPasarAOtro(S1);
		
		System.out.println("cantidad d eelementos en el S1 y S2 despues: ");
		System.out.println(S1.getElementosTotalesDelSector().size());
		System.out.println(S2.getElementosTotalesDelSector().size());
		
		
		
		Pedido unpedido = new Pedido("jose");
		unpedido.agregarProducto(libro1);
		unpedido.agregarProducto(vino1);
		unpedido.crearEnvio();
		assertEquals(150,unpedido.getEnvio().pesoTotal(),0);	//pesos: 30 + 120
		
		
	}

}
