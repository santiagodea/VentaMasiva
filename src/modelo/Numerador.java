package modelo;

public class Numerador {

	private static Integer numeradorDeInventario = 0;

	private static Integer numeradorDeEnvio = 0;

	public static Integer numeroDeInventario() {
		numeradorDeInventario = numeradorDeInventario + 1;
		return numeradorDeInventario;
	}

	public static Integer numeroDeEnvio() {
		numeradorDeEnvio = numeradorDeEnvio + 1;
		return numeradorDeEnvio;
	}
}
