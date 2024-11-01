package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import dao.MySQLUserRepository;
import exception.CrudOperationException;
import model.Abonnement;
import model.Client;
import model.ClientModel;
import model.Sexe;
import model.Statut;
import service.BusinessLayer;
import view.LoginView;
import view.ReceptionnisteView;

public class ReceptionnisteController {
    private ReceptionnisteView recepView;
    private BusinessLayer businessLayer;
    private Client client;
	private boolean update = false;
	public ReceptionnisteController(ReceptionnisteView recepView, BusinessLayer businessLayer) {
        this.recepView = recepView;
        this.businessLayer = businessLayer;
        logOutListener();
        validerListener();
        supprimerListener();
        modifierListener();
        ajouterListener();
    }
    
    public ReceptionnisteController(ReceptionnisteView recepView, BusinessLayer businessLayer, boolean update) {
        update= true;
    	this.recepView = recepView;
        this.businessLayer = businessLayer;
        this.update = update;
        logOutListener();
        validerListener();
        supprimerListener();
        modifierListener();
        ajouterListener();
    }


    protected void onValiderClicked() {
		if (isUpdate()) {
			validerModification();
		} else {
			valider();
		}
	}

	private boolean isUpdate() {
		return update;
	}
	
	private void ajouterListener() {
		recepView.setAjouterListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ajouter();
				
			}
		});
	}
	
	private void ajouter() {
		recepView.tabbedPane.setSelectedIndex(1);
	}
	
	private void modifierListener() {
	    recepView.setModifierListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            ReceptionnisteController receptionnisteController = new ReceptionnisteController(recepView, businessLayer, update);
	            receptionnisteController.modifier();
	        }
	    });
	}


	private void supprimerListener() {
		recepView.setSupprimerListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				supprimer();
				
			}			
		});
		
	}
    
    private void setSelectedRow(int row) {
		if (row < 0) return;
		
		int clientsSize = businessLayer.getAllClientSize();
		if (clientsSize > row) {
			this.recepView.clientTable.setRowSelectionInterval(row, row);
		}
	}
    
    
	private void validerListener() {
    	recepView.setValiderListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				valider();
			}
		});
    }

	private void modifier() {
		int row = recepView.clientTable.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(null, 
					"Veuillez sélectionner un client à modifier.");
		} else {
			Client client = (Client) businessLayer.getClientModel().getValueAt(row, ClientModel.OBJECT_COL);
			  // Remplir les champs de la vue d'inscription client avec les informations du client sélectionné
	        recepView.nomTA.setText(client.getNom());
	        recepView.prenomTA.setText(client.getPrenom());
	        recepView.adresseTA.setText(client.getAdresse());
	        recepView.telephoneTA.setText(client.getTelephone());
	        recepView.emailTA.setText(client.getEmail());
	        recepView.numPasseportTA.setText(client.getNumPasseport());
	        recepView.dateNaissanceformattedTF.setText(client.getDateAnniversaire().toString());
	        recepView.sexeCB.setSelectedItem(client.getSexe().toString());
	        recepView.abonnementCB.setSelectedItem(client.getAbonnement().toString());
	        recepView.statutCB.setSelectedItem(client.getStatut().toString());
	        
	        // Changer l'onglet actif pour la page d'inscription client
	        recepView.tabbedPane.setSelectedIndex(1);
	        
		}
		
	}
		
	public void valider() {
		 // Récupérer les informations saisies par l'utilisateur depuis la vue
	    String nom = recepView.getNom(); 
	    String prenom = recepView.getPrenom(); 
	    String adresse = recepView.getAdresse();
	    String telephone = recepView.getTelephone();
	    String email = recepView.getEmail();
        String numPasseport = recepView.getNumPasseport();
	   

	    // Vérifications nécessaires sur les données (validation)
	    if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || telephone.isEmpty() || email.isEmpty() || numPasseport.isEmpty()) {
	    	JOptionPane.showMessageDialog(null, 
					"Veuillez remplir tous les champs", "Invalid Input", JOptionPane.ERROR_MESSAGE);
	    }
	    else {
			try {
				LocalDate dateNaissance = LocalDate.parse(recepView.getDateNaissance());
				Sexe sexe = Sexe.valueOf(recepView.getSexe().toString().toUpperCase());
				Abonnement abonnement = Abonnement.valueOf(recepView.getAbonnement().toString().toUpperCase());
				Statut statut = Statut.valueOf(recepView.getStatut().toString().toUpperCase());
				
				Client client = new Client(nom, prenom, adresse, email, telephone, dateNaissance, sexe, numPasseport, abonnement,statut);
				businessLayer.addClient(client);
				
				clear();
				JOptionPane.showMessageDialog(null, "Nouveau client ajouté.", 
						"Ajout de client", 
						JOptionPane.INFORMATION_MESSAGE);
		        recepView.tabbedPane.setSelectedIndex(0);	

				
			} catch (DateTimeParseException e) {
				JOptionPane.showMessageDialog(null, 
						"Date de Naissance invalid", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				
			} catch (IllegalArgumentException | CrudOperationException e) {
				JOptionPane.showMessageDialog(null, 
						e.getMessage(), "Operation Performing Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void validerModification() {
		 // Récupérer les informations saisies par l'utilisateur depuis la vue
	    String nom = recepView.getNom(); 
	    String prenom = recepView.getPrenom(); 
	    String adresse = recepView.getAdresse();
	    String telephone = recepView.getTelephone();
	    String email = recepView.getEmail();
       String numPasseport = recepView.getNumPasseport();
	   

	    // Vérifications nécessaires sur les données (validation)
	    if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || telephone.isEmpty() || email.isEmpty() || numPasseport.isEmpty()) {
	    	JOptionPane.showMessageDialog(null, 
					"Veuillez remplir tous les champs", "Invalid Input", JOptionPane.ERROR_MESSAGE);
	    }
	    else {
			try {
				LocalDate dateNaissance = LocalDate.parse(recepView.getDateNaissance());
				Sexe sexe = Sexe.valueOf(recepView.getSexe().toString().toUpperCase());
				Abonnement abonnement = Abonnement.valueOf(recepView.getAbonnement().toString().toUpperCase());
				Statut statut = Statut.valueOf(recepView.getStatut().toString().toUpperCase());
				
				Client client = new Client(this.client.getIdClient(), nom, prenom, adresse, email, telephone, dateNaissance, sexe, numPasseport, abonnement,statut);
				businessLayer.modifyClient(client);
				
				clear();
				JOptionPane.showMessageDialog(null, "Client modifié.", 
						"Modification du client", 
						JOptionPane.INFORMATION_MESSAGE);
				
		        recepView.tabbedPane.setSelectedIndex(0);	
			} catch (DateTimeParseException e) {
				JOptionPane.showMessageDialog(null, 
						"Date de Naissance invalid", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				
			} catch (IllegalArgumentException | CrudOperationException e) {
				JOptionPane.showMessageDialog(null, 
						e.getMessage(), "Operation Performing Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	private void supprimer() {
		int row = recepView.clientTable.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(null, 
					"Aucun Client à supprimer.");
		} else {
			 try {
				    Client client = (Client) businessLayer.getClientModel().getValueAt(row, ClientModel.OBJECT_COL);
					businessLayer.removeClient(client);
					// -
					setSelectedRow(row-1);
					// -
					JOptionPane.showMessageDialog(null, "Client Supprimé.", 
							"Suppression de client", 
							JOptionPane.INFORMATION_MESSAGE);
				
			} catch (IllegalStateException | CrudOperationException e) {
				JOptionPane.showMessageDialog(null, 
						e.getMessage(), "Operation Performing Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	private void clear() {
		recepView.nomTA.setText(null);
		recepView.prenomTA.setText(null);
		recepView.adresseTA.setText(null);
		recepView.numPasseportTA.setText(null);
		recepView.emailTA.setText(null);
		recepView.telephoneTA.setText(null);
    	recepView.sexeCB.setSelectedItem(0);
    	recepView.abonnementCB.setSelectedItem(0);
    	recepView.statutCB.setSelectedItem(0);
	}

	private void logOutListener() {
        recepView.setLogOutListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
    }

    public void run() {
        recepView.setVisible(true);
    }

    public void exit() {
        // Fermeture de la vue du directeur
        recepView.dispose();
        // Création de la vue de connexion
        LoginView loginView = new LoginView();
        // Création du repository utilisateur
        MySQLUserRepository userRepo = new MySQLUserRepository();
        // Création de la couche métier avec le repository utilisateur
        BusinessLayer businessLayer = new BusinessLayer();
        // Création du contrôleur de connexion avec la vue de connexion et la couche
        // métier
        LoginController loginController = new LoginController(loginView, businessLayer, userRepo);
        // Affichage de la vue de connexion
        loginController.exec();
    }
}