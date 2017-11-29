package modelo.EnvoltoriosCierres;

public class Folio extends Envoltorio {
	
	private static Integer cm2 = 150;
	
	public Folio() {
		this.setPeso(60);
	}
	public static Integer getCm2() {
		return cm2;
	}
	
	public void setCm2 (Integer cms) {
		this.cm2 = cms;
	}
}

