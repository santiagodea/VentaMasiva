package modelo.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Cepas;
import modelo.Cliente;
import modelo.Deposito;
import modelo.Pedido;
import modelo.Sectores.SectorCompuesto;
import modelo.Sectores.SectorSimple;
import modelo.productoElemento.Botella;
import modelo.productoElemento.Ejemplar;
import modelo.productoElemento.Libro;
import modelo.productoElemento.Vino;

public class test1 {
	SectorCompuesto SCA = new SectorCompuesto("sector A");
	SectorCompuesto SCB = new SectorCompuesto("sector B");
	SectorCompuesto SCC = new SectorCompuesto("sector C");
	SectorSimple S1 = new SectorSimple("sector 1");
	SectorSimple S2 = new SectorSimple("sector 2");
	SectorSimple S3 = new SectorSimple("sector 3");
	
	Vino vino1 = new Vino(30, 150, 200, "los Robles");
	// (double peso, double costo, double precioDeVenta, String bodega)
	Libro libro1 = new Libro("el libro de juan y pedro", 120, 100, 150, 30, 15, 5);
	
	Botella botella1 = new Botella(vino1);
	Botella botella2 = new Botella(vino1);

	Ejemplar ejemplar1 = new Ejemplar(libro1);
	Ejemplar ejemplar2 = new Ejemplar(libro1);
	
	@Test
	public void test() {

		

		SCA.agregarSector(SCB);
		SCB.agregarSector(SCC);
		SCC.agregarSector(S1);
		SCC.agregarSector(S2);

		
		vino1.agregarCepa(Cepas.MALBEC);
		
		libro1.agregarAutor("juan");
		libro1.agregarAutor("pedro");
		// (double peso, double costo, double precioDeVenta, int alto, int ancho, int
		// espesor)

		

		Deposito.store().agregarSector(SCA);

		// ejer 01
		S1.agregarBotella(botella1);
		S1.agregarBotella(botella2);
		assertEquals(1, botella1.getNroInventario(),0);
		assertEquals(2, botella2.getNroInventario(),0);
		// ejer 02
		S1.agregarEjemplar(ejemplar1);
		
		assertEquals(3, ejemplar1.getNroInventario(),0);
		S1.agregarEjemplar(ejemplar2);
		assertEquals(4, ejemplar2.getNroInventario(),0);
		
		// ejer 03

		assertEquals(2, S1.librosconAutor("juan").size(),0);
		assertEquals(1, Deposito.store().librosPorAutorTitulos("juan").size(),0);

		// ejer 04
		assertEquals(2, Deposito.store().elementosPorProducto(libro1).size(),0);

		//ejer 05
		assertEquals(S1, Deposito.store().sectorDondeEstaElElemento(1));
		
		// ejer 06
		assertEquals(2, Deposito.store().elementosPorProducto(libro1).size(),0);
		Deposito.store().eliminarElemento(ejemplar2);
		assertEquals(1, Deposito.store().elementosPorProducto(libro1).size(),0);
		
		
//		// ejer 07
		
		S2.agregarBotella(botella1);
		S2.agregarBotella(botella1);
		
		assertEquals(3,S1.getElementosTotalesDelSector().size(),0);
		assertEquals(2,S2.getElementosTotalesDelSector().size(),0);
		
		S2.vaciarSectorYPasarAOtro(S1);
		
		assertEquals(5,S1.getElementosTotalesDelSector().size(),0);
		assertEquals(0,S2.getElementosTotalesDelSector().size(),0);
		
		
		Cliente cliente1 = new Cliente("santiago","soler 209", "gral belgrano");
		Pedido unpedido = new Pedido(cliente1);
		unpedido.agregarProducto(libro1);
		unpedido.agregarProducto(vino1);
		unpedido.crearEnvio();
		assertEquals(310,unpedido.getEnvio().pesoTotal(),0);	//pesos: 30 + 120 + (peso de cierres y envoltorios)
		Deposito.store().agregarPedido(unpedido);
		
		assertEquals(2,unpedido.getEnvio().getEnvoltorios().size(),0);
		
		assertEquals(5,unpedido.getEnvio().getCierres().size(),0);
		

	}
	
	@Test (expected = RuntimeException.class)
	public void test2() {
		SCA.agregarSector(SCB);
		SCB.agregarSector(SCC);
		SCC.agregarSector(S1);
		SCC.agregarSector(S2);
		
		vino1.agregarCepa(Cepas.MALBEC);
		libro1.agregarAutor("juan");
		libro1.agregarAutor("pedro");
		S1.agregarBotella(botella1);
		S1.agregarBotella(botella2);
		S1.agregarEjemplar(ejemplar1);
		S1.agregarEjemplar(ejemplar2);
		Cliente cliente1 = new Cliente("santiago","soler 209", "gral belgrano");
		Cliente cliente2 = new Cliente("jose","dorrego 209", "gral belgrano");
		
		Deposito.store().agregarSector(SCA);
		Pedido pedidodos = new Pedido(cliente1);
		pedidodos.agregarProducto(new Vino(10, 20, 30, "mendoza"));
		//deberia tirar excepcion ya que no hay botellas para el producto que se solicita en el pedido.
		pedidodos.crearEnvio();
		
		
		//TESTEAR EL PUNTO 3 saber, DADO UN CLIENTE VER SI TIENE PERIODOS EN TRANSITO

		
		
	}
}
