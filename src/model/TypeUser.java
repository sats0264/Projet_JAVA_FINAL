package model;
public enum TypeUser {
    GERANT ("Gerant"),
    DIRECTEUR ("Directeur"),
    RECEPTIONNISTE ("Receptionniste");
	
	private String name;
	
	private TypeUser(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}