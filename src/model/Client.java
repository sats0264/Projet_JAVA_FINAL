package model;

import java.time.LocalDate;

public class Client {
	private int idClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String telephone;
	private LocalDate dateAnniversaire;
	private Sexe sexe;
	private String numPasseport;
	private Abonnement abonnement;
	private LocalDate dateAbonnement;
	private Statut statut;
	
	public Client(String nom, String prenom, String adresse, String email, String telephone, LocalDate dateAnniversaire,
			Sexe sexe, String numPasseport, Abonnement abonnement, Statut statut) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
		this.dateAnniversaire = dateAnniversaire;
		this.sexe = sexe;
		this.numPasseport = numPasseport;
		this.abonnement = abonnement;
		this.statut = statut;
	}
	
	
	public Client(int idClient, String nom, String prenom, String adresse, String email, String telephone, LocalDate dateAnniversaire,
			Sexe sexe, String numPasseport, Abonnement abonnement,Statut statut) {
		this.setIdClient(idClient);
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
		this.dateAnniversaire = dateAnniversaire;
		this.sexe = sexe;
		this.numPasseport = numPasseport;
		this.abonnement = abonnement;
		this.statut = statut;
	}
	
	public LocalDate getDateAbonnement() {
		return dateAbonnement;
	}

	public void setDateAbonnement(LocalDate dateAbonnement) {
		this.dateAbonnement = dateAbonnement;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		if(idClient > 0)
			this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public LocalDate getDateAnniversaire() {
		return dateAnniversaire;
	}

	public void setDateAnniversaire(LocalDate dateAnniversaire) {
		this.dateAnniversaire = dateAnniversaire;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public String getNumPasseport() {
		return numPasseport;
	}

	public void setNumPasseport(String numPasseport) {
		this.numPasseport = numPasseport;
	}

	public Abonnement getAbonnement() {
		return abonnement;
	}

	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	
	
}
