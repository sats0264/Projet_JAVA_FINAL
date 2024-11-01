package model;

public class User {
	private int id;
    private String username;
    private String password;
    private TypeUser role;
    private Statut statut;

    public User(String username, String password, TypeUser role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    

    public User(String username, String password, TypeUser role, Statut statut) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.statut = statut;
	}


	public User(int id, String username, String password, TypeUser role, Statut statut) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.statut = statut;
	}

	// Getters and setters
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
    public String getUsername() {
        return username;
    }

	public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TypeUser getRole() {
        return role;
    }

    public void setRole(TypeUser role) {
        this.role = role;
    }

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}
    
	
    
}
