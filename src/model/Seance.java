package model;

public enum Seance {
	DIX(10, "10"),
	VINGT(20, "20"),
	TRENTE(30, "30");
	
	private int nombre;
	private String seance;
	
	private Seance(int nombre, String seance){
		this.nombre = nombre;
		this.seance = seance;
	}
	
	public int getNombre() {
		return nombre;
	}

	public String getSeance() {
		return seance;
	}
}
