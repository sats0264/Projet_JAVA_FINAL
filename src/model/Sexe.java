package model;

public enum Sexe {
	MASCULIN ("Masculin"),
	FEMININ ("Feminin");
	
	private String name;
	
	private Sexe(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}