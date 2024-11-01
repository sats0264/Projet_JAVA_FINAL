package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Utilitaire;


public class LoginView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginView() {
        setTitle("Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null); // Centre la fenêtre

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255)); // Couleur de fond
        panel.setLayout(null); // Utilisation d'un layout null pour un positionnement précis

        JLabel titleLabel = new JLabel("Bienvenue !");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(130, 20, 200, 30); // Position et taille du label
        panel.add(titleLabel);

        JLabel usernameLabel = new JLabel("Nom d'utilisateur :");
        usernameLabel.setBounds(50, 80, 150, 25);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(200, 80, 150, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Mot de passe :");
        passwordLabel.setBounds(50, 120, 150, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 120, 150, 25);
        panel.add(passwordField);

        getContentPane().add(panel);
        
        loginButton = new JButton("Connexion");
        loginButton.setBorderPainted(false);
        loginButton.setBackground(new Color(64, 128, 128));
        loginButton.setBounds(141, 179, 111, 23);
        panel.add(loginButton);
        
		Utilitaire.setLookAndFeel(this);
		Utilitaire.center(this, getSize());
    }

    // Method to set action listener for login button
    public void setLoginListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    // Method to get username entered by user
    public String getUsername() {
        return usernameField.getText();
    }

    // Method to get password entered by user
    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    // Method to display message to user
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void run() {
        setVisible(true);
    }

    
}