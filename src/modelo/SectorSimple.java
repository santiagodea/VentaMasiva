package modelo;

import java.util.ArrayList;
import java.util.List;

public class SectorSimple extends Sector {
	
	private List<Elemento> elementos = new ArrayList<Elemento>();
	
	public void agregarEjemplar(Ejemplar libro) {
		this.getElementos().add(libro);
	}
	public void agregarBotella(Botella vino) {
		this.getElementos().add(vino);
	}
	
	
	
	//setters & getters

	public List<Elemento> getElementos() {
		return elementos;
	}
	public void setElementos(List<Elemento> elementos) {
		this.elementos = elementos;
	}
}
