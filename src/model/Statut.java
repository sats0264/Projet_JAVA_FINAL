package model;

public enum Statut {
	ACTIVATED ("Activated"),
	DESACTIVATED ("Desactivated");
	
	private String name;
	
	private Statut(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
