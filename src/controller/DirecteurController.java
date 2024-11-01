package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.MySQLUserRepository;
import exception.ActivatedUserException;
import exception.CrudOperationException;
import model.Statut;
import model.TypeUser;
import model.User;
import model.UserModel;
import service.BusinessLayer;
import view.DirecteurView;
import view.LoginView;

public class DirecteurController {
	private DirecteurView directeurView;
	private BusinessLayer businessLayer;

	public DirecteurController(DirecteurView directeurView, BusinessLayer businessLayer) {
		this.directeurView = directeurView;
		this.businessLayer = businessLayer;
		logOutListener();
		ajoutListener();
		approuverListener();
		deleteListener();
	}

	private void approuverListener() {
		directeurView.approuverAccountListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				approuver();

			}
		});
	}
	private void deleteListener() {
		directeurView.deleteAccountListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deleteAccount();

			}
		});
	}

	private void logOutListener() {
		directeurView.setLogOutListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
	}

	private void ajoutListener() {
		directeurView.ajouterUserListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ajout();
			}
		});
	}

	public void run() {
		directeurView.run();
	}

	private void ajout() {
		String username = directeurView.getUsername();
		if (username.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Veuillez renseigner le nom de l'utilisateur");
		} else {
			try {
				String password = directeurView.getPassword();
				TypeUser role = TypeUser.valueOf(directeurView.getRole().toString().toUpperCase());

				User user = new User(username, password, role, Statut.ACTIVATED);
				businessLayer.addUser(user);

				clear();
				JOptionPane.showMessageDialog(null, "Nouvel utilisateur ajouté");
			} catch (CrudOperationException x) {
				System.out.println(x.getMessage() + "Saisie invalide");
			}
		}
	}

	private void exit() {
		// Fermeture de la vue du directeur
		directeurView.dispose();
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

	private void approuver() {
		int row = directeurView.userTable.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(null, "Veuillez sélectionner un utilisateur");
		} else {
			User user = (User) businessLayer.getUserModel().getValueAt(row, UserModel.OBJECT_COL);
			try {
				businessLayer.activatedUser(user);
				setSelectedRow(row - 1);
				JOptionPane.showMessageDialog(null, "L'utilisateur a été approuvé avec succès.");
				System.out.println("ID = :"+ user.getId());
				System.out.println("USER = :"+ user.toString());
			} catch (ActivatedUserException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erreur lors de l'approbation de l'utilisateur : ");
			}
		}

	}
	
	private void deleteAccount() {
		int row = directeurView.userTable.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(null, 
					"Aucun Utilisateur à supprimer.");
		} else {
			 try {
				    User user = (User) businessLayer.getUserModel().getValueAt(row, UserModel.OBJECT_COL);
				    
					businessLayer.deleteUser(user);
					// -
					setSelectedRow(row-1);
					// -
					JOptionPane.showMessageDialog(null, "Utilisateur Supprimé.", 
							"Suppression d'un Utilisateur", 
							JOptionPane.INFORMATION_MESSAGE);
					System.out.println("ID = :"+ user.getId());
					System.out.println("USER = :"+ user.toString());
			} catch (IllegalStateException | CrudOperationException e) {
				JOptionPane.showMessageDialog(null, 
						e.getMessage(), "Operation Performing Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

	private void setSelectedRow(int row) {
		if (row < 0)
			return;

		int userSize = businessLayer.getAllUserSize();
		if (userSize > row) {
			this.directeurView.userTable.setRowSelectionInterval(row, row);
		}
	}

	private void clear() {
		directeurView.usernameTF.setText(null);
		directeurView.passwordField.setText(null);
		directeurView.roleCB.setSelectedIndex(0);
	}
}
