package modelo;

public class Cliente {

	private String nombre;
	private String direccion;
	private String ciudad;
	
	
	public Cliente (String nombre, String direccion, String ciudad) {
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setCiudad(ciudad);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
}
