package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.text.MaskFormatter;

import exception.RepositoryException;
import model.Statut;
import model.Utilitaire;
import service.BusinessLayer;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import model.Sexe;
import model.Abonnement;
import javax.swing.SwingConstants;

public class ReceptionnisteView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton accueilButton;
	private JButton logOutButton;
	private JButton ajouterButton;
	private JButton modifierButton;
	private JButton supprimerButton;
	private JButton ajoutClientButton;
	public JTabbedPane tabbedPane;
	public JTable clientTable;

	private BusinessLayer businessLayer;
	public JTextField nomTA;
	public JTextField prenomTA;
	public JTextField adresseTA;
	public JTextField emailTA;
	public JTextField telephoneTA;
	public JTextField numPasseportTA;
	private JButton validerButton;
	public JComboBox<String> sexeCB;
	public JComboBox<String> abonnementCB;
	public JComboBox<String> statutCB;
	public JFormattedTextField dateNaissanceformattedTF;
	
	
	public ReceptionnisteView(BusinessLayer businessLayer) {
		this.businessLayer = businessLayer;
		try {
			initComponent();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initComponent() throws RepositoryException {
		setTitle("Réceptionniste");
		setSize(1310, 788);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Utilitaire.setLookAndFeel(this);
		Utilitaire.center(this, getSize());
		getContentPane().setLayout(null);

		Panel main = new Panel();
		main.setBackground(Color.GRAY);
		main.setBounds(-12, 0, 220, 772);
		getContentPane().add(main);
		main.setLayout(null);

		accueilButton = new JButton("ACCUEIL");
		accueilButton.setFont(new Font("Algerian", Font.ITALIC, 14));
		accueilButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		accueilButton.setBounds(21, 250, 180, 30);
		main.add(accueilButton);

		ajoutClientButton = new JButton("Inscription Client");
		ajoutClientButton.setFont(new Font("Algerian", Font.ITALIC, 14));
		ajoutClientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		ajoutClientButton.setBounds(21, 350, 180, 30);
		main.add(ajoutClientButton);

		logOutButton = new JButton("Log Out");
		logOutButton.setFont(new Font("Algerian", Font.ITALIC, 14));
		logOutButton.setBounds(21, 650, 180, 30);
		main.add(logOutButton);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(205, -33, 1080, 733);
		getContentPane().add(tabbedPane);

		Panel accueilPane = new Panel();
		accueilPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("New tab", null, accueilPane, null);
		accueilPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Page 1");
		lblNewLabel.setBounds(1030, 680, 60, 20);
		accueilPane.add(lblNewLabel);

		Panel ajoutClientPane = new Panel();
		ajoutClientPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("New tab", null, ajoutClientPane, null);
		ajoutClientPane.setLayout(null);

		JLabel lblPage2 = new JLabel("Page 2");
		lblPage2.setBounds(1075, 680, 60, 20);
		ajoutClientPane.add(lblPage2);
		
		Panel panelTitle = new Panel();
		panelTitle.setBounds(0, 10, 875, 87);
		ajoutClientPane.add(panelTitle);
		
		JLabel titleLabel = new JLabel("Ajout d'un nouveau client");
		titleLabel.setPreferredSize(new Dimension(350, 90));
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelTitle.add(titleLabel);
		
		Panel panelValider = new Panel();
		panelValider.setBackground(Color.GRAY);
		panelValider.setBounds(876, 0, 199, 700);
		ajoutClientPane.add(panelValider);
		panelValider.setLayout(null);
		
		validerButton = new JButton("Valider");
		validerButton.setFont(new Font("Algerian", Font.BOLD, 20));
		validerButton.setBounds(50, 370, 135, 35);
		panelValider.add(validerButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 97, 875, 603);
		ajoutClientPane.add(panel);
		panel.setLayout(new GridLayout(5, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel nomLabel = new JLabel("Nom :");
		nomLabel.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		nomLabel.setBounds(214, 0, 437, 120);
		panel_1.add(nomLabel);
		
		JLabel prenomLabel = new JLabel("Prénom :");
		prenomLabel.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		prenomLabel.setBounds(660, 0, 437, 120);
		panel_1.add(prenomLabel);
		
		nomTA = new JTextField();
		nomTA.setFont(new Font("SansSerif", Font.PLAIN, 13));
		nomTA.setBounds(300, 46, 130, 25);
		panel_1.add(nomTA);
		nomTA.setColumns(10);
		
		prenomTA = new JTextField();
		prenomTA.setFont(new Font("SansSerif", Font.PLAIN, 13));
		prenomTA.setBounds(740, 46, 130, 25);
		panel_1.add(prenomTA);
		prenomTA.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel adresseLabel = new JLabel("Adresse :");
		adresseLabel.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		adresseLabel.setBounds(220, 0, 437, 120);
		panel_2.add(adresseLabel);
		
		JLabel emailLabel = new JLabel("Email :");
		emailLabel.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		emailLabel.setBounds(675, 0, 437, 120);
		panel_2.add(emailLabel);
		
		adresseTA = new JTextField();
		adresseTA.setFont(new Font("SansSerif", Font.PLAIN, 13));
		adresseTA.setBounds(300, 46, 130, 25);
		panel_2.add(adresseTA);
		adresseTA.setColumns(10);
		
		emailTA = new JTextField();
		emailTA.setFont(new Font("SansSerif", Font.PLAIN, 13));
		emailTA.setBounds(740, 46, 130, 25);
		panel_2.add(emailTA);
		emailTA.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel telephoneLabel = new JLabel("Telephone :");
		telephoneLabel.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		telephoneLabel.setBounds(200, 0, 437, 120);
		panel_3.add(telephoneLabel);
		
		JLabel naissanceLabel = new JLabel("Date de naissance :");
		naissanceLabel.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		naissanceLabel.setBounds(580, 0, 437, 120);
		panel_3.add(naissanceLabel);
		
		telephoneTA = new JTextField();
		telephoneTA.setFont(new Font("SansSerif", Font.PLAIN, 13));
		telephoneTA.setBounds(300, 46, 130, 25);
		panel_3.add(telephoneTA);
		telephoneTA.setColumns(10);
		
		try {
			MaskFormatter maskFormatter = new MaskFormatter("####-##-##");
			dateNaissanceformattedTF = new JFormattedTextField(maskFormatter);	
			dateNaissanceformattedTF.setSize(130, 25);
			dateNaissanceformattedTF.setLocation(740, 46);
			dateNaissanceformattedTF.setToolTipText("yyyy-mm-dd");
			dateNaissanceformattedTF.setColumns(10);
			panel_3.add(dateNaissanceformattedTF);
		} catch (ParseException ignored) {}
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel sexeLabel = new JLabel("Sexe :");
		sexeLabel.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		sexeLabel.setBounds(245, 0, 437, 120);
		panel_4.add(sexeLabel);
		
		JLabel numPasseportLabel = new JLabel("Numéro passeport :");
		numPasseportLabel.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		numPasseportLabel.setBounds(580, 0, 437, 120);
		panel_4.add(numPasseportLabel);
		
		sexeCB = new JComboBox<>();
		sexeCB.setFont(new Font("SansSerif", Font.PLAIN, 13));
		sexeCB.setModel(new DefaultComboBoxModel<>(new String[]
				{
						Sexe.MASCULIN.getName(),
						Sexe.FEMININ.getName()
				}));
		sexeCB.setBounds(300, 46, 130, 25);
		panel_4.add(sexeCB);
		
		numPasseportTA = new JTextField();
		numPasseportTA.setFont(new Font("SansSerif", Font.PLAIN, 13));
		numPasseportTA.setBounds(740, 46, 130, 25);
		panel_4.add(numPasseportTA);
		numPasseportTA.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel abonnementLabel = new JLabel("Abonnement :");
		abonnementLabel.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		abonnementLabel.setBounds(185, 0, 437, 120);
		panel_5.add(abonnementLabel);
		
		JLabel statutLabel = new JLabel("Statut :");
		statutLabel.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		statutLabel.setBounds(670, 0, 437, 120);
		panel_5.add(statutLabel);
		
		abonnementCB = new JComboBox<>();
		abonnementCB.setFont(new Font("SansSerif", Font.PLAIN, 13));
		abonnementCB.setModel(new DefaultComboBoxModel<>(new String[]
				{
						Abonnement.MENSUEL.getName(),
						Abonnement.TRIMESTRIEL.getName(),
						Abonnement.ANNUEL.getName(),
						Abonnement.DIX.getName(),
						Abonnement.VINGT.getName(),
						Abonnement.TRENTE.getName()
				}));
		abonnementCB.setBounds(300, 46, 130, 25);
		panel_5.add(abonnementCB);
		
		statutCB = new JComboBox<>();
		statutCB.setFont(new Font("SansSerif", Font.PLAIN, 13));
		statutCB.setModel(new DefaultComboBoxModel<>(new String[]
				{
						Statut.ACTIVATED.getName(),
						Statut.DESACTIVATED.getName()
				}));
		statutCB.setBounds(740, 46, 130, 25);
		panel_5.add(statutCB);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.LIGHT_GRAY);
		scrollPane.setBounds(0, 9, 1075, 650);
		accueilPane.add(scrollPane);

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
		scrollPane.setViewportView(clientTable);
		
		ajouterButton = new JButton("Ajouter");
		ajouterButton.setFont(new Font("Algerian", Font.ITALIC, 14));
		ajouterButton.setBounds(224, 670, 110, 23);
		accueilPane.add(ajouterButton);
		
		modifierButton = new JButton("Modifier");
		modifierButton.setFont(new Font("Algerian", Font.ITALIC, 14));
		modifierButton.setBounds(456, 670, 110, 23);
		accueilPane.add(modifierButton);
		
		supprimerButton = new JButton("Supprimer");
		supprimerButton.setFont(new Font("Algerian", Font.ITALIC, 14));
		supprimerButton.setHorizontalAlignment(SwingConstants.RIGHT);
		supprimerButton.setBounds(661, 670, 110, 23);
		accueilPane.add(supprimerButton);
	}

	public void setValiderListener(ActionListener listener) {
		validerButton.addActionListener(listener);
	}

	public void setLogOutListener(ActionListener listener) {
		logOutButton.addActionListener(listener);
	}
	
	public void setAjouterListener(ActionListener listener) {
		ajouterButton.addActionListener(listener);
	}
	
	public void setModifierListener(ActionListener listener) {
		modifierButton.addActionListener(listener);
	}
	
	public void setSupprimerListener(ActionListener listener) {
		supprimerButton.addActionListener(listener);
	}

	public String getNom() {
		return nomTA.getText();
	}

	public String getPrenom() {
		return prenomTA.getText();
	}

	public String getAdresse() {
		return adresseTA.getText();
	}

	public String getTelephone() {
		return telephoneTA.getText();
	}

	public String getNumPasseport() {
		return numPasseportTA.getText();
	}

	public String getAbonnement() {
		return (String) abonnementCB.getSelectedItem();
	}

	public String getSexe() {
		return (String) sexeCB.getSelectedItem();
	}

	public String getStatut() {
		return (String) statutCB.getSelectedItem();
	}

	public String getEmail() {
		return emailTA.getText();
	}

	public String getDateNaissance() {
		return dateNaissanceformattedTF.getText();
	}
}