package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import exception.RepositoryException;
import model.ModelPieChart;
import model.PieChart;
import model.Utilitaire;
import service.BusinessLayer;

public class GerantView extends JFrame {
 
	private static final long serialVersionUID = 1L;
	private JButton accueilButton;
	private JButton logOutButton;
	private JButton creerUserButton;
	private JButton statistiqueButton;
	private JButton listUserButton;
	private JTabbedPane tabbedPane;
	private JTable tableUsers;
	private JTable clientTable;
	private BusinessLayer businessLayer;
	public JTextField usernameTF;
	public JPasswordField passwordField;
	public JComboBox<String> roleCB;
	private JButton addButton;

	
	public GerantView(BusinessLayer businessLayer) {
		this.businessLayer = businessLayer;
		try {
			initComponents();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}
	
	private void initComponents() throws RepositoryException {
	setTitle("Gérant");
    setSize(1310, 788);
    
	getContentPane().setLayout(null);
	
	Panel main = new Panel();
	main.setBackground(Color.GRAY);
	main.setBounds(-12, 0, 220, 772);
	getContentPane().add(main);
	main.setLayout(null);
	
	accueilButton = new JButton("Accueil");
	accueilButton.setFont(new Font("Algerian", Font.ITALIC, 14));
	accueilButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	        tabbedPane.setSelectedIndex(0);
		}
	});
	accueilButton.setBounds(21, 150, 180, 30);
	main.add(accueilButton);
	
	creerUserButton = new JButton("Creer Utilisateur");
	creerUserButton.setFont(new Font("Algerian", Font.ITALIC, 14));
	creerUserButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tabbedPane.setSelectedIndex(1);
		}
	});
	creerUserButton.setBounds(21, 250, 180, 30);
	main.add(creerUserButton);
	
	statistiqueButton = new JButton("Statistique");
	statistiqueButton.setFont(new Font("Algerian", Font.ITALIC, 14));
	statistiqueButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tabbedPane.setSelectedIndex(2); 
		}
	});
	statistiqueButton.setBounds(21, 450, 180, 30);
	main.add(statistiqueButton);
	
	logOutButton = new JButton("Log Out");
	logOutButton.setFont(new Font("Algerian", Font.ITALIC, 14));
	logOutButton.setBounds(21, 650, 180, 30);
	main.add(logOutButton);
	
	listUserButton = new JButton("Liste Utilisateur");
	listUserButton.setFont(new Font("Algerian", Font.ITALIC, 14));
	listUserButton.setPreferredSize(new Dimension(111, 23));
	listUserButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tabbedPane.setSelectedIndex(3);
		}
	});
	listUserButton.setBounds(21, 350, 180, 30);
	main.add(listUserButton);
	
	tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setBounds(205, -33, 1080, 733);
	getContentPane().add(tabbedPane);
	
	Panel accueilPane = new Panel();
	accueilPane.setBackground(Color.LIGHT_GRAY);
	tabbedPane.addTab("New tab", null, accueilPane, null);
	accueilPane.setLayout(null);
	
	JLabel labelPage1 = new JLabel("Page 1");
	labelPage1.setBounds(1075, 680, 60, 20);
	accueilPane.add(labelPage1);
	
	JScrollPane clientScrollPane = new JScrollPane();
	clientScrollPane.setBounds(0, 9, 1152, 837);
	accueilPane.add(clientScrollPane);
	
	clientTable = new JTable();

	clientTable.setModel(businessLayer.getClientModel());
	businessLayer.updateClientModel();
	
	clientTable.getColumnModel().getColumn(0).setPreferredWidth(70);
	clientTable.getColumnModel().getColumn(1).setPreferredWidth(95);
	clientTable.getColumnModel().getColumn(2).setPreferredWidth(100);
	clientTable.getColumnModel().getColumn(3).setPreferredWidth(100);
	clientTable.getColumnModel().getColumn(4).setPreferredWidth(50);
	clientTable.getColumnModel().getColumn(5).setPreferredWidth(100);
	clientTable.getColumnModel().getColumn(6).setPreferredWidth(60);
	clientScrollPane.setViewportView(clientTable);
	
	Panel creerUserPane = new Panel();
	creerUserPane.setBackground(Color.LIGHT_GRAY);
	tabbedPane.addTab("New tab", null, creerUserPane, null);
	creerUserPane.setLayout(null);
	
	Panel panel = new Panel();
	panel.setBounds(0, 10, 10, 10);
	creerUserPane.add(panel);
	
	JLabel labelPage2 = new JLabel("Page 2");
	labelPage2.setBounds(1075, 680, 60, 20);
	creerUserPane.add(labelPage2);
	
	Panel panelTitle = new Panel();
	panelTitle.setBounds(0, 10, 895, 88);
	creerUserPane.add(panelTitle);
	
	JLabel titleLabel = new JLabel("Ajout d'un nouvel utilisateur");
	titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
	titleLabel.setPreferredSize(new Dimension(500, 82));
	panelTitle.add(titleLabel);
	
	Panel panelValider = new Panel();
	panelValider.setBackground(Color.GRAY);
	panelValider.setBounds(895, 10, 238, 699);
	creerUserPane.add(panelValider);
	panelValider.setLayout(null);
	
	addButton = new JButton("Valider");
	addButton.setForeground(new Color(0, 0, 0));
	addButton.setBackground(new Color(0, 0, 0));
	addButton.setFont(new Font("Algerian", Font.BOLD, 20));
	addButton.setPreferredSize(new Dimension(111, 23));
	addButton.setBounds(30, 370, 135, 35);
	panelValider.add(addButton);
	
	JPanel panelAdd = new JPanel();
	panelAdd.setBackground(Color.LIGHT_GRAY);
	panelAdd.setBounds(0, 97, 895, 607);
	creerUserPane.add(panelAdd);
	panelAdd.setLayout(new GridLayout(3, 1, 0, 0));
	
	JPanel panelUsername = new JPanel();
	FlowLayout fl_panelUsername = (FlowLayout) panelUsername.getLayout();
	fl_panelUsername.setAlignment(FlowLayout.LEFT);
	panelUsername.setBackground(Color.LIGHT_GRAY);
	panelAdd.add(panelUsername);
	
	JLabel usernameLabel = new JLabel("Username :");
	usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	usernameLabel.setPreferredSize(new Dimension(120, 200));
	panelUsername.add(usernameLabel);
	
	usernameTF = new JTextField();
	usernameTF.setPreferredSize(new Dimension(30, 50));
	panelUsername.add(usernameTF);
	usernameTF.setColumns(30);
	
	JPanel panelPassword = new JPanel();
	panelPassword.setBackground(new Color(192, 192, 192));
	panelAdd.add(panelPassword);
	
	JLabel passwordLabel = new JLabel("Password :");
	passwordLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
	passwordLabel.setPreferredSize(new Dimension(120, 200));
	panelPassword.add(passwordLabel);
	
	passwordField = new JPasswordField();
	passwordField.setPreferredSize(new Dimension(10, 50));
	passwordField.setColumns(30);
	panelPassword.add(passwordField);
	
	JPanel panelRole = new JPanel();
	FlowLayout fl_panelRole = (FlowLayout) panelRole.getLayout();
	fl_panelRole.setAlignment(FlowLayout.RIGHT);
	panelRole.setBackground(Color.LIGHT_GRAY);
	panelAdd.add(panelRole);
	
	JLabel roleLabel = new JLabel("User Role :");
	roleLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
	roleLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
	roleLabel.setAlignmentX(10.0f);
	roleLabel.setPreferredSize(new Dimension(130, 200));
	panelRole.add(roleLabel);
	
	roleCB = new JComboBox<>();
	roleCB.setFont(new Font("Times New Roman", Font.BOLD, 16));
	roleCB.setPreferredSize(new Dimension(180, 50));
	roleCB.setModel(new DefaultComboBoxModel<>(new String[] {"Gerant", "Receptionniste"}));
	panelRole.add(roleCB);
	
	Panel statistiquePane = new Panel();
	statistiquePane.setBackground(Color.LIGHT_GRAY);
	tabbedPane.addTab("New tab", null, statistiquePane, null);
	statistiquePane.setLayout(null);
	
//	PieChart pieChartClient = new PieChart();
//	pieChartClient.setBounds(700, 350, 350, 300); // Ajustez les dimensions selon votre mise en page
//	statistiquePane.add(pieChartClient);
//
//	// Préparez les données sur les clients (exemples fictifs)
//	List<ModelPieChart> clientData = new ArrayList<>();
//	clientData.add(new ModelPieChart("Client actifs", businessLayer.getClientsActif(), Color.BLUE));
////	clientData.add(new ModelPieChart("Nouveaux clients", businessLayer.getClientsInactif(), Color.GREEN));
//	clientData.add(new ModelPieChart("Clients inactifs", businessLayer.getClientsInactif(), Color.RED));
//
//	// Ajoutez les données au diagramme
//	for (ModelPieChart data : clientData) {
//	    pieChartClient.addData(data);
//	}
//
//	// Rafraîchissez l'affichage du diagramme
//	pieChartClient.repaint();
	
	// Créez une instance de PieChart
	PieChart pieChartClient = new PieChart();
	pieChartClient.setBounds(new Rectangle(10, 400, 300, 250));
	pieChartClient.setBounds(10, 163, 500, 450);
	statistiquePane.add(pieChartClient, BorderLayout.CENTER);

	// Préparez les données sur les clients (exemples fictifs)
	List<ModelPieChart> clientData = new ArrayList<>();
	clientData.add(new ModelPieChart("Client actifs", businessLayer.getClientsActif(), Color.BLUE));
	clientData.add(new ModelPieChart("Clients inactifs", businessLayer.getClientsInactif(), Color.RED));

	// Ajoutez les données au diagramme
	for (ModelPieChart data : clientData) {
		pieChartClient.addData(data);
	}

	// Rafraîchissez l'affichage du diagramme
	pieChartClient.repaint();
	PieChart pieChartAbonnement = new PieChart();
	pieChartAbonnement.setBounds(500, 163, 500, 450);
	statistiquePane.add(pieChartAbonnement, BorderLayout.CENTER);

	// Préparez les données sur les clients (exemples fictifs)
	List<ModelPieChart> clientData1 = new ArrayList<>();
	clientData1.add(new ModelPieChart("Abonnement", businessLayer.getClientsAbonne(), Color.ORANGE));
	clientData1.add(new ModelPieChart("Sceance", businessLayer.getClientsSeance(), Color.CYAN));

	// Ajoutez les données au diagramme
	for (ModelPieChart data : clientData1) {
		pieChartAbonnement.addData(data);
	}

	
	Panel totalClientPanel = new Panel();
	totalClientPanel.setBackground(Color.WHITE);
	totalClientPanel.setBounds(100, 51, 105, 65);
	statistiquePane.add(totalClientPanel);

	Label labelNbClientTotal = new Label("Total Client");
	labelNbClientTotal.setFont(new Font("Dialog", Font.BOLD, 12));
	labelNbClientTotal.setBounds(100, 20, 105, 21);
	statistiquePane.add(labelNbClientTotal);
	
	Label totalClient = new Label(Integer.toString(businessLayer.getTotalNumberOfClients()));
	totalClient.setAlignment(Label.CENTER);
	totalClient.setForeground(Color.GRAY);
	totalClient.setBackground(Color.WHITE);
	totalClient.setFont(new Font("Tahoma", Font.PLAIN, 50));
	totalClientPanel.add(totalClient);
	
	
	Label labelNbClientActif = new Label("Client Actif");
	labelNbClientActif.setFont(new Font("Dialog", Font.BOLD, 12));
	labelNbClientActif.setBounds(300, 20, 105, 21);
	statistiquePane.add(labelNbClientActif);
	
	Panel clientActifPanel = new Panel();
	clientActifPanel.setBackground(Color.WHITE);
	clientActifPanel.setBounds(300, 51, 105, 65);
	statistiquePane.add(clientActifPanel);
	
	Label clientActif = new Label(Integer.toString(businessLayer.getClientsActif()));
	clientActif.setAlignment(Label.CENTER);
	clientActif.setForeground(Color.GRAY);
	clientActif.setFont(new Font("Tahoma", Font.PLAIN, 50));
	clientActif.setBackground(Color.WHITE);
	clientActifPanel.add(clientActif);
	
	Label labelNbClientInactif = new Label("Client Inactif");
	labelNbClientInactif.setFont(new Font("Dialog", Font.BOLD, 12));
	labelNbClientInactif.setBounds(500, 20, 105, 21);
	statistiquePane.add(labelNbClientInactif);
	
	Panel clientInactifPanel = new Panel();
	clientInactifPanel.setBackground(Color.WHITE);
	clientInactifPanel.setBounds(500, 51, 105, 65);
	statistiquePane.add(clientInactifPanel);
	
	Label clientInactif = new Label(Integer.toString(businessLayer.getClientsInactif()));
	clientInactif.setAlignment(Label.CENTER);
	clientInactif.setForeground(Color.GRAY);
	clientInactif.setFont(new Font("Tahoma", Font.PLAIN, 50));
	clientInactif.setBackground(Color.WHITE);
	clientInactifPanel.add(clientInactif);
	
	Label labelNbClientAbonnement = new Label("Abonnement");
	labelNbClientAbonnement.setFont(new Font("Dialog", Font.BOLD, 12));
	labelNbClientAbonnement.setBounds(700, 20, 105, 21);
	statistiquePane.add(labelNbClientAbonnement);
	
	Panel clientAbonnePanel = new Panel();
	clientAbonnePanel.setBackground(Color.WHITE);
	clientAbonnePanel.setBounds(700, 51, 105, 65);
	statistiquePane.add(clientAbonnePanel);
	
	Label clientAbonne = new Label(Integer.toString(businessLayer.getClientsAbonne()));
	clientAbonne.setAlignment(Label.CENTER);
	clientAbonne.setForeground(Color.GRAY);
	clientAbonne.setFont(new Font("Tahoma", Font.PLAIN, 50));
	clientAbonne.setBackground(Color.WHITE);
	clientAbonnePanel.add(clientAbonne);
	
	Label labelNbClientSeance = new Label("Seance");
	labelNbClientSeance.setFont(new Font("Dialog", Font.BOLD, 12));
	labelNbClientSeance.setBounds(900, 20, 105, 21);
	statistiquePane.add(labelNbClientSeance);
	
	Panel clientSeancePanel = new Panel();
	clientSeancePanel.setBackground(Color.WHITE);
	clientSeancePanel.setBounds(900, 51, 105, 65);
	statistiquePane.add(clientSeancePanel);
	
	Label clientSeance = new Label(Integer.toString(businessLayer.getClientsSeance()));
	clientSeance.setAlignment(Label.CENTER);
	clientSeance.setForeground(Color.GRAY);
	clientSeance.setFont(new Font("Tahoma", Font.PLAIN, 50));
	clientSeance.setBackground(Color.WHITE);
	clientSeancePanel.add(clientSeance);
	
//	//Créer une instance de PieChart
//	PieChart pieChartAbonnement = new PieChart();
//	pieChartAbonnement.setBounds(150, 350, 350, 300);
//	statistiquePane.add(pieChartAbonnement);
//	
//	// Préparez les données sur les clients (exemples fictifs)
//	List<ModelPieChart> clientData1 = new ArrayList<>();
//	clientData1.add(new ModelPieChart("Abonnement", businessLayer.getClientsAbonne(), Color.ORANGE));
//	clientData1.add(new ModelPieChart("Sceance", businessLayer.getClientsSeance(), Color.CYAN));
//
//	// Ajoutez les données au diagramme
//	for (ModelPieChart data : clientData1) {
//	    pieChartAbonnement.addData(data);
//	}
//
//	// Rafraîchissez l'affichage du diagramme
//	pieChartClient.repaint();
	
	JLabel labelPage4 = new JLabel("Page 4");
	labelPage4.setBounds(1075, 680, 60, 20);
	statistiquePane.add(labelPage4);
	
	Panel listUserPane = new Panel();
	tabbedPane.addTab("New tab", null, listUserPane, null);
	listUserPane.setLayout(null);
	
	JLabel labelPage3 = new JLabel("Page 3");
	labelPage3.setBounds(1075, 680, 60, 20);
	listUserPane.add(labelPage3);
	
	JScrollPane userScrollPane = new JScrollPane();
	userScrollPane.setBounds(0, 9, 1152, 837);
	listUserPane.add(userScrollPane);
	
	tableUsers = new JTable();
	
	tableUsers.setModel(businessLayer.getUserModel());
	businessLayer.updateUserModel();
	
	tableUsers.getColumnModel().getColumn(0).setPreferredWidth(100);
	tableUsers.getColumnModel().getColumn(1).setPreferredWidth(100);
	tableUsers.getColumnModel().getColumn(2).setPreferredWidth(100);
	tableUsers.getColumnModel().getColumn(3).setPreferredWidth(100);
	userScrollPane.setViewportView(tableUsers);
	
	Utilitaire.setLookAndFeel(this);
	Utilitaire.center(this, getSize());
	}
	

    public void setLogOutListener(ActionListener listener) {
        logOutButton.addActionListener(listener);
    }
    
    public void setAddListener(ActionListener listener) {
    	addButton.addActionListener(listener);
    }
    
    public String getUsername() {
    	return usernameTF.getText();
    }
    
    public String getPassword() {
    	return new String(passwordField.getPassword());
    }

    public String getRole() {
        return (String) roleCB.getSelectedItem();
    }

//    public String getRole() {
//    	return roleCB.getName().toString().toUpperCase();
//    }


	public void showMessage(String string) {
		
	}
}