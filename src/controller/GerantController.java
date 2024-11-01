package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.MySQLUserRepository;
import exception.CrudOperationException;
import model.Statut;
import model.TypeUser;
import model.User;
import service.BusinessLayer;
import view.GerantView;
import view.LoginView;

public class GerantController {
    private GerantView gerantView;
    private BusinessLayer businessLayer;
    private User user;
    
    public GerantController(GerantView gerantView, BusinessLayer businessLayer) {
        this.gerantView = gerantView;
        this.businessLayer = businessLayer;
        this.gerantView.setAddListener(new AddListener());
		logOutListener();
		
	}

	private void logOutListener() {
        gerantView.setLogOutListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
    }

    public void run() {
        gerantView.setVisible(true);
    }

    public void exit() {
        // Fermeture de la vue du directeur
        gerantView.dispose();
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
    class AddListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String username = gerantView.getUsername();
			if(username.isEmpty()) {
				gerantView.showMessage("Veuillez renseigner le nom de l'utilisateur");
			}else {
				try {
					String password = gerantView.getPassword();
					TypeUser role = TypeUser.valueOf(gerantView.getRole().toString().toUpperCase());
					
					user = new User(username, password, role, Statut.DESACTIVATED);
					businessLayer.addUser(user);
					
					clear();
					gerantView.showMessage("Nouvel utilisateur ajouté");
				}catch(CrudOperationException x) {
					System.out.println(x.getMessage() + "Saisie invalide");
				}
			}
		}
    	
    }
    
    private void clear() {
		gerantView.usernameTF.setText(null);
		gerantView.passwordField.setText(null);
		gerantView.roleCB.setSelectedIndex(0);
	}
    


}
