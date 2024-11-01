package runtime;

import controller.LoginController;
import dao.MySQLUserRepository;
import service.BusinessLayer;
import view.LoginView;

public class Main {
    public static void main(String[] args) {
        // Création de l'objet BusinessLayer avec les repositories appropriés
        MySQLUserRepository userRepo = new MySQLUserRepository();
        BusinessLayer businessLayer = new BusinessLayer();

        // Création de la vue de connexion et du contrôleur correspondant
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginView, businessLayer,userRepo);

        // Exécution de l'application
        loginController.exec();
    }
}
