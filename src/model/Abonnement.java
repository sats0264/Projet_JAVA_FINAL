package model;

public enum Abonnement {
	MENSUEL ("Mensuel"),
	TRIMESTRIEL ("Trimestriel"),
	ANNUEL ("Annuel"),
	DIX("Dix"),
	VINGT("Vingt"),
	TRENTE("Trente");
	
	private String name;
	
	private Abonnement(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
