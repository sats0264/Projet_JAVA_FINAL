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
import model.PieChart.PeiChartType;
import model.Utilitaire;
import service.BusinessLayer;

public class DirecteurView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton accueilButton;
	private JButton logOutButton;
	private JButton creerUserButton;
	private JButton chiffreAffaireButton;
	private JButton statistiqueButton;
	private JButton afficherUtilisateur;
	private JButton ajouterButton;
	private JButton validateButton;
	private JButton deleteButton;
	
	private JTabbedPane tabbedPane;

	private JTable clientTable;
	public JTextField usernameTF;
	public JPasswordField passwordField;
	public JComboBox<String> roleCB;

	private BusinessLayer businessLayer;
	public JTable userTable;



	
	public DirecteurView(BusinessLayer businessLayer){
		this.businessLayer = businessLayer;
			try {
				initComposent();
			} catch (RepositoryException e) {
				e.printStackTrace();
			}
	}
	public void initComposent() throws RepositoryException  {
		setBackground(Color.LIGHT_GRAY);
		setTitle("Directeur");
		setSize(1310, 788);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Utilitaire.setLookAndFeel(this);
		Utilitaire.center(this, getSize());
		getContentPane().setLayout(new BorderLayout(0, 0));

		Panel menu = new Panel();
		menu.setBackground(Color.GRAY);
		getContentPane().add(menu, BorderLayout.WEST);
		menu.setBounds(-12, 0, 220, 772);
		menu.setLayout(null);

		accueilButton = new JButton("ACCUEIL");
		accueilButton.setFont(new Font("Algerian", Font.ITALIC, 14));
		accueilButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		accueilButton.setBounds(21, 125, 180, 30);
		menu.add(accueilButton);

		creerUserButton = new JButton("Creer Utilisateur");
		creerUserButton.setFont(new Font("Algerian", Font.ITALIC, 14));
		creerUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		creerUserButton.setBounds(21, 200, 180, 30);
		menu.add(creerUserButton);

		statistiqueButton = new JButton("Statistique");
		statistiqueButton.setFont(new Font("Algerian", Font.ITALIC, 14));
		statistiqueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		statistiqueButton.setBounds(21, 275, 180, 30);
		menu.add(statistiqueButton);

		chiffreAffaireButton = new JButton("Chiffre d'Affaires");
		chiffreAffaireButton.setFont(new Font("Algerian", Font.ITALIC, 14));
		chiffreAffaireButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		chiffreAffaireButton.setBounds(21, 350, 180, 30);
		menu.add(chiffreAffaireButton);
		
		logOutButton = new JButton("Log Out");
		logOutButton.setFont(new Font("Algerian", Font.ITALIC, 14));
		logOutButton.setBounds(21, 650, 180, 30);
		menu.add(logOutButton);
		
		afficherUtilisateur = new JButton("Utilisateur");
		afficherUtilisateur.setFont(new Font("Algerian", Font.ITALIC, 14));
		afficherUtilisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		afficherUtilisateur.setBounds(21, 425, 180, 30);
		menu.add(afficherUtilisateur);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setBounds(205, -33, 1080, 733);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		Panel accueilPane = new Panel();
		accueilPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("New tab", null, accueilPane, null);
		accueilPane.setLayout(null);

		JLabel labelPage1 = new JLabel("Page 1");
		labelPage1.setBounds(1000, 650, 60, 20);
		accueilPane.add(labelPage1);

		JScrollPane clientScrollPane = new JScrollPane();
		clientScrollPane.setBounds(0, 0, 1100, 800);
		accueilPane.add(clientScrollPane);

		clientTable = new JTable();
		clientTable.setModel(businessLayer.getClientModel());
		businessLayer.updateClientModel();
		
		clientTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		clientTable.getColumnModel().getColumn(1).setPreferredWidth(55);
		clientTable.getColumnModel().getColumn(2).setPreferredWidth(60);
		clientTable.getColumnModel().getColumn(3).setPreferredWidth(60);
		clientTable.getColumnModel().getColumn(4).setPreferredWidth(20);
		clientTable.getColumnModel().getColumn(5).setPreferredWidth(60);
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
		labelPage2.setBounds(1000, 650, 60, 20);
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
		
		ajouterButton = new JButton("Valider");
		ajouterButton.setForeground(new Color(0, 0, 0));
		ajouterButton.setBackground(new Color(0, 0, 0));
		ajouterButton.setFont(new Font("Algerian", Font.BOLD, 20));
		ajouterButton.setPreferredSize(new Dimension(111, 23));
		ajouterButton.setBounds(30, 370, 135, 35);
		panelValider.add(ajouterButton);
		
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
		
//		PieChart pieChartClient = new PieChart();
//		pieChartClient.setBounds(700, 350, 350, 300); // Ajustez les dimensions selon votre mise en page
//		statistiquePane.add(pieChartClient);
//
//		// Préparez les données sur les clients (exemples fictifs)
//		List<ModelPieChart> clientData = new ArrayList<>();
//		clientData.add(new ModelPieChart("Client actifs", businessLayer.getClientsActif(), Color.BLUE));
////		clientData.add(new ModelPieChart("Nouveaux clients", businessLayer.getClientsInactif(), Color.GREEN));
//		clientData.add(new ModelPieChart("Clients inactifs", businessLayer.getClientsInactif(), Color.RED));
//
//		// Ajoutez les données au diagramme
//		for (ModelPieChart data : clientData) {
//		    pieChartClient.addData(data);
//		}
//
//		// Rafraîchissez l'affichage du diagramme
//		pieChartClient.repaint();
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
		
//		//Créer une instance de PieChart
//		PieChart pieChartAbonnement = new PieChart();
//		pieChartAbonnement.setBounds(150, 350, 350, 300);
//		statistiquePane.add(pieChartAbonnement);
//		
		JLabel labelPage3 = new JLabel("Page 3");
		labelPage3.setBounds(1000, 650, 60, 20);
		statistiquePane.add(labelPage3);
//		
//		// Préparez les données sur les clients (exemples fictifs)
//		List<ModelPieChart> clientData1 = new ArrayList<>();
//		clientData1.add(new ModelPieChart("Abonnement", businessLayer.getClientsAbonne(), Color.ORANGE));
//		clientData1.add(new ModelPieChart("Sceance", businessLayer.getClientsSeance(), Color.CYAN));
//
//		// Ajoutez les données au diagramme
//		for (ModelPieChart data : clientData1) {
//		    pieChartAbonnement.addData(data);
//		}
//
//		// Rafraîchissez l'affichage du diagramme
//		pieChartClient.repaint();

		Panel chiffreAffairePane = new Panel();
		chiffreAffairePane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("New tab", null, chiffreAffairePane, null);
		chiffreAffairePane.setLayout(null);

		Label labelChiffreAffaireTotal = new Label("Chiffre Affaire Total");
		labelChiffreAffaireTotal.setBounds(118, 317, 120, 21);
		chiffreAffairePane.add(labelChiffreAffaireTotal);

		Panel panelChiffreAffaireTotal = new Panel();
		panelChiffreAffaireTotal.setBackground(Color.WHITE);
		panelChiffreAffaireTotal.setBounds(118, 343, 170, 51);
		chiffreAffairePane.add(panelChiffreAffaireTotal);

		Label chiffreAffaireTotal = new Label(Double.toString(businessLayer.chiffreAffaireTotalMensuelle()) + "FCFA");
		chiffreAffaireTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelChiffreAffaireTotal.add(chiffreAffaireTotal);

		Panel panelChiffreAffaireAbonnement = new Panel();
		panelChiffreAffaireAbonnement.setBackground(Color.WHITE);
		panelChiffreAffaireAbonnement.setBounds(10, 438, 170, 51);
		chiffreAffairePane.add(panelChiffreAffaireAbonnement);

		Label chiffreAffaireAbonnement = new Label(Double.toString(businessLayer.chiffreAffaireAbonnement()) + "FCFA");
		chiffreAffaireAbonnement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelChiffreAffaireAbonnement.add(chiffreAffaireAbonnement);

		Label labelChiffreAffaireAbonnement = new Label("Chiffre Affaire Abonnement");
		labelChiffreAffaireAbonnement.setBounds(10, 412, 158, 21);
		chiffreAffairePane.add(labelChiffreAffaireAbonnement);

		Panel panelChiffreAffaireSeance = new Panel();
		panelChiffreAffaireSeance.setBackground(Color.WHITE);
		panelChiffreAffaireSeance.setBounds(218, 435, 170, 51);
		chiffreAffairePane.add(panelChiffreAffaireSeance);

		Label chiffreAffaireSeance = new Label(Double.toString(businessLayer.chiffreAffaireSeance()) + "FCFA");
		chiffreAffaireSeance.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelChiffreAffaireSeance.add(chiffreAffaireSeance);

		Label labelChiffreAffaireSeance = new Label("Chiffre Affaire Seance");
		labelChiffreAffaireSeance.setBounds(218, 409, 120, 21);
		chiffreAffairePane.add(labelChiffreAffaireSeance);

		Panel panelChiffreAffaireMensuel = new Panel();
		panelChiffreAffaireMensuel.setBackground(Color.WHITE);
		panelChiffreAffaireMensuel.setBounds(515, 53, 170, 51);
		chiffreAffairePane.add(panelChiffreAffaireMensuel);

		Label chiffreAffaireMensuel = new Label(Double.toString(businessLayer.chiffreAffaireMensuelle()) + "FCFA");
		chiffreAffaireMensuel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelChiffreAffaireMensuel.add(chiffreAffaireMensuel);

		Label labelChiffreAffaireMensuel = new Label("Chiffre Affaire Mensuel");
		labelChiffreAffaireMensuel.setBounds(515, 27, 170, 21);
		chiffreAffairePane.add(labelChiffreAffaireMensuel);

		Panel panelChiffreAffaireTrimestriel = new Panel();
		panelChiffreAffaireTrimestriel.setBackground(Color.WHITE);
		panelChiffreAffaireTrimestriel.setBounds(515, 137, 170, 51);
		chiffreAffairePane.add(panelChiffreAffaireTrimestriel);

		Label chiffreAffaireTrimestriel = new Label(
				Double.toString(businessLayer.chiffreAffaireTrimestriel()) + "FCFA");
		panelChiffreAffaireTrimestriel.add(chiffreAffaireTrimestriel);
		chiffreAffaireTrimestriel.setFont(new Font("Tahoma", Font.PLAIN, 20));

		Label labelChiffreAffaireTrimestriel = new Label("Chiffre Affaire Trimestriel");
		labelChiffreAffaireTrimestriel.setBounds(515, 111, 170, 21);
		chiffreAffairePane.add(labelChiffreAffaireTrimestriel);

		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.GRAY);
		panel1.setBounds(490, 0, 2, 309);
		chiffreAffairePane.add(panel1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 309, 490, 2);
		chiffreAffairePane.add(panel_1);

		// Créez une instance de PieChart
		PieChart pieChartChiffreAffaireTotal = new PieChart();
		pieChartChiffreAffaireTotal.setFont(new Font("Arial", Font.BOLD, 13));
		pieChartChiffreAffaireTotal.setBounds(new Rectangle(10, 400, 300, 250));
		pieChartChiffreAffaireTotal.setBounds(500, 321, 395, 283);
		chiffreAffairePane.add(pieChartChiffreAffaireTotal, BorderLayout.CENTER);
		// Rafraîchissez l'affichage du diagramme
		pieChartChiffreAffaireTotal.repaint();

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.GRAY);
		panel_1_1.setBounds(490, 309, 530, 2);
		chiffreAffairePane.add(panel_1_1);

		Panel panelChiffreAffaireAnnuel = new Panel();
		panelChiffreAffaireAnnuel.setBackground(Color.WHITE);
		panelChiffreAffaireAnnuel.setBounds(515, 223, 170, 51);
		chiffreAffairePane.add(panelChiffreAffaireAnnuel);

		Label chiffreAffaireAnnuel = new Label(Double.toString(businessLayer.chiffreAffaireAnnuel()) + "FCFA");
		chiffreAffaireAnnuel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelChiffreAffaireAnnuel.add(chiffreAffaireAnnuel);

		Label labelChiffreAffaireAnnuel = new Label("Chiffre Affaire Annuel");
		labelChiffreAffaireAnnuel.setBounds(515, 197, 170, 21);
		chiffreAffairePane.add(labelChiffreAffaireAnnuel);

		PieChart pieChartChiffreAffaireAbonnement = new PieChart();
		pieChartChiffreAffaireAbonnement.setFont(new Font("Arial", Font.BOLD, 13));
		pieChartChiffreAffaireAbonnement.setChartType(PeiChartType.DONUT_CHART);
		pieChartChiffreAffaireAbonnement.setBounds(new Rectangle(10, 400, 300, 250));
		pieChartChiffreAffaireAbonnement.setBounds(674, 36, 325, 232);
		chiffreAffairePane.add(pieChartChiffreAffaireAbonnement);

		Label labelChiffreAffaireSeance10 = new Label("Chiffre Affaire Seance(10)");
		labelChiffreAffaireSeance10.setBounds(0, 27, 170, 21);
		chiffreAffairePane.add(labelChiffreAffaireSeance10);

		Panel panelChiffreAffaireSeance10 = new Panel();
		panelChiffreAffaireSeance10.setBackground(Color.WHITE);
		panelChiffreAffaireSeance10.setBounds(0, 53, 170, 51);
		chiffreAffairePane.add(panelChiffreAffaireSeance10);

		Label chiffreAffaireSeance10 = new Label(Double.toString(businessLayer.chiffreAffaireSeance10()) + "FCFA");
		chiffreAffaireSeance10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelChiffreAffaireSeance10.add(chiffreAffaireSeance10);

		Label labelChiffreAffaireSeance20 = new Label("Chiffre Affaire Seance(20)");
		labelChiffreAffaireSeance20.setBounds(0, 111, 170, 21);
		chiffreAffairePane.add(labelChiffreAffaireSeance20);

		Panel panelChiffreAffaireSeance20 = new Panel();
		panelChiffreAffaireSeance20.setBackground(Color.WHITE);
		panelChiffreAffaireSeance20.setBounds(0, 137, 170, 51);
		chiffreAffairePane.add(panelChiffreAffaireSeance20);

		Label chiffreAffaireSeance20 = new Label(Double.toString(businessLayer.chiffreAffaireSeance20()) + "FCFA");
		chiffreAffaireSeance20.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelChiffreAffaireSeance20.add(chiffreAffaireSeance20);

		Label labelChiffreAffaireSeance30 = new Label("Chiffre Affaire Seance(30)");
		labelChiffreAffaireSeance30.setBounds(0, 197, 170, 21);
		chiffreAffairePane.add(labelChiffreAffaireSeance30);

		Panel panelChiffreAffaireSeance30 = new Panel();
		panelChiffreAffaireSeance30.setBackground(Color.WHITE);
		panelChiffreAffaireSeance30.setBounds(0, 223, 170, 51);
		chiffreAffairePane.add(panelChiffreAffaireSeance30);

		Label chiffreAffaireSeance30 = new Label(Double.toString(businessLayer.chiffreAffaireSeance30()) + "FCFA");
		chiffreAffaireSeance30.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelChiffreAffaireSeance30.add(chiffreAffaireSeance30);

		PieChart pieChartChiffreAffaireSeance = new PieChart();
		pieChartChiffreAffaireSeance.setFont(new Font("Arial", Font.BOLD, 13));
		pieChartChiffreAffaireSeance.setChartType(PeiChartType.DONUT_CHART);
		pieChartChiffreAffaireSeance.setBounds(new Rectangle(10, 400, 300, 250));
		pieChartChiffreAffaireSeance.setBounds(160, 37, 325, 232);
		chiffreAffairePane.add(pieChartChiffreAffaireSeance);

		// Préparez les données sur les clients (exemples fictifs)
		List<ModelPieChart> seanceData = new ArrayList<>();
		seanceData.add(new ModelPieChart("Seance 10", businessLayer.chiffreAffaireSeance10(), Color.BLUE));
		seanceData.add(new ModelPieChart("Seance 20", businessLayer.chiffreAffaireSeance20(), Color.RED));
		seanceData.add(new ModelPieChart("Seance 30", businessLayer.chiffreAffaireSeance30(), Color.ORANGE));

		// Ajoutez les données au diagramme
		for (ModelPieChart data : seanceData) {
			pieChartChiffreAffaireSeance.addData(data);
		}
		// Rafraîchissez l'affichage du diagramme
		pieChartChiffreAffaireSeance.repaint();
		// Rafraîchissez l'affichage du diagramme
		pieChartChiffreAffaireAbonnement.repaint();

		// Préparez les données sur les clients (exemples fictifs)
		List<ModelPieChart> totalData = new ArrayList<>();
		totalData.add(new ModelPieChart("Abonnement", businessLayer.chiffreAffaireAbonnement(), new Color(0, 191, 255)));
		totalData.add(new ModelPieChart("Seance", businessLayer.chiffreAffaireSeance(), new Color(220, 20, 60)));

		// Ajoutez les données au diagramme
		for (ModelPieChart data : totalData) {
			pieChartChiffreAffaireTotal.addData(data);
		}

		// Préparez les données sur les clients (exemples fictifs)
		List<ModelPieChart> abonnementData = new ArrayList<>();
		abonnementData.add(new ModelPieChart("Mensuel", businessLayer.chiffreAffaireMensuelle(), Color.BLUE));
		abonnementData.add(new ModelPieChart("Trimestriel", businessLayer.chiffreAffaireTrimestriel(), Color.RED));
		abonnementData.add(new ModelPieChart("Annuel", businessLayer.chiffreAffaireAnnuel(), Color.ORANGE));
		abonnementData.add(new ModelPieChart("Frais", businessLayer.chiffreAffaireFrais(), Color.GREEN));

		// Ajoutez les données au diagramme
		for (ModelPieChart data : abonnementData) {
			pieChartChiffreAffaireAbonnement.addData(data);
		}


		Panel utilisateur = new Panel();
		tabbedPane.addTab("New tab", null, utilisateur, null);
		utilisateur.setLayout(null);

		JLabel labelPage5 = new JLabel("Page 5");
		labelPage5.setBounds(1000, 650, 60, 20);
		utilisateur.add(labelPage5);
		
		JScrollPane userScrollPane = new JScrollPane();
		userScrollPane.setBounds(0, 0, 1152, 600);
		utilisateur.add(userScrollPane);
		
		userTable = new JTable();
		userTable.setModel(businessLayer.getUserModel());
		businessLayer.updateUserModel();
		
		userTable.getColumnModel().getColumn(0).setPreferredWidth(200);
		userTable.getColumnModel().getColumn(1).setPreferredWidth(150);
		userTable.getColumnModel().getColumn(2).setPreferredWidth(125);
		userTable.getColumnModel().getColumn(3).setPreferredWidth(100);

		userScrollPane.setViewportView(userTable);
		
		validateButton = new JButton("Approuver Creation");
		validateButton.setFont(new Font("Algerian", Font.ITALIC, 14));
		validateButton.setBounds(313, 620, 190, 34);
		utilisateur.add(validateButton);
		
		deleteButton = new JButton("Delete Account");
		deleteButton.setFont(new Font("Algerian", Font.ITALIC, 14));
		deleteButton.setBounds(681, 620, 190, 34);
		utilisateur.add(deleteButton);
		
		for (int i = 0; i < tabbedPane.getTabCount(); i++) {
			tabbedPane.setTabComponentAt(i, new JLabel());
		}
	}

	public void approuverAccountListener(ActionListener listener) {
		this.validateButton.addActionListener(listener);
	}
	public void deleteAccountListener(ActionListener listener) {
		this.deleteButton.addActionListener(listener);
	}
	public void ajouterUserListener(ActionListener listener) {
		this.ajouterButton.addActionListener(listener);
	}
	public void setLogOutListener(ActionListener listener) {
		this.logOutButton.addActionListener(listener);
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

	public void run() {
		setVisible(true);
	}

	public void exit() {
		dispose();
	}

	public void showMessage(String string) {
		
	}
}