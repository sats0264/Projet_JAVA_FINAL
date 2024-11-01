package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.MySQLUserRepository;
import exception.RepositoryException;
import model.TypeUser;
import service.BusinessLayer;
import view.DirecteurView;
import view.GerantView;
import view.LoginView;
import view.ReceptionnisteView;

public class LoginController {
	private LoginView loginView;
	private BusinessLayer businessLayer;
	private MySQLUserRepository userRepo;

	public LoginController(LoginView loginView, BusinessLayer businessLayer, MySQLUserRepository userRepo) {
		this.loginView = loginView;
		this.businessLayer = businessLayer;
		this.userRepo = userRepo; 
		loginListener();
	}
	
	private void loginListener() {
		loginView.setLoginListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String login = loginView.getUsername();
				String password = loginView.getPassword();

				if (businessLayer.authentificate(login, password)) {
					// Authentification réussie, redirection vers la vue appropriée
					 redirectToAppropriateView(login, password);
					loginView.dispose();
				} else {
					// Affichage d'un message d'erreur en cas d'informations d'identification
					// incorrectes
					loginView.showMessage("Nom d'utilisateur ou mot de passe incorrect.");
				}
			}
		});
	}

	private void redirectToAppropriateView(String username, String password) {
		try {
			// Récupération du rôle de l'utilisateur
			TypeUser role = userRepo.getUserRole(username, password);

			// Redirection vers la vue appropriée en fonction du rôle de l'utilisateur
			switch (role) {
				case DIRECTEUR:
				DirecteurView directeurView = new DirecteurView(businessLayer);
					DirecteurController directeurController = new DirecteurController(directeurView, businessLayer);
					directeurController.run();
					break;
				case GERANT:
					GerantView gerantView = new GerantView(businessLayer);
					GerantController gerantController = new GerantController(gerantView, businessLayer);
					gerantController.run();
					break;
				case RECEPTIONNISTE:
					ReceptionnisteView receptionnisteView = new ReceptionnisteView(businessLayer);
					ReceptionnisteController receptionnisteController = new ReceptionnisteController(receptionnisteView, businessLayer);
					receptionnisteController.run();
					break;
				default:
					// En cas de rôle inconnu, afficher un message d'erreur
					loginView.showMessage("Rôle inconnu.");
			}
			// Fermeture de la fenêtre de connexion
			loginView.dispose();
		} catch (RepositoryException ex) {
			// En cas d'erreur lors de la récupération du rôle de l'utilisateur
			System.err.println("Error while getting user role: " + ex.getMessage());
		}
	}

	public void exec() {
		loginView.run();
	}

}
