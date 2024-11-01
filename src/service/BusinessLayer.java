package service;

import java.util.List;

import javax.swing.table.TableModel;

import dao.MySQLClientRepository;
import dao.MySQLUserRepository;
import exception.ActivatedUserException;
import exception.CrudOperationException;
import exception.DesactivatedClientException;
import exception.RepositoryException;
import model.Client;
import model.ClientModel;
import model.Statut;
import model.User;
import model.UserModel;

public class BusinessLayer implements IService {
	
	private MySQLUserRepository userRepository;
	private MySQLClientRepository clientRepository;
	
	private ClientModel clientModel;
	private UserModel userModel;

	public BusinessLayer() {
		clientRepository= new MySQLClientRepository();
		userRepository= new MySQLUserRepository();
		
		clientModel = new ClientModel();
		userModel = new UserModel();
	}


	public BusinessLayer(MySQLUserRepository userRepo) {
		this.userRepository = userRepo;
	}
	

	@Override
	public boolean authentificate(String username, String password) {
		try {

			return userRepository.read(username, password);

		} catch (RepositoryException e) {
			System.err.println("Error while authenticate : " + e.getMessage());
		}
		return false;
	}

	@Override
	public void addClient(Client client) throws CrudOperationException {
		try {
			clientRepository.create(client);
			updateClientModel();
		}catch(RepositoryException e) {
			throw new CrudOperationException("Erreur pendant l'ajout du client: " + e.getMessage());
		}
	}
	
	public int getTotalNumberOfClients() throws RepositoryException {
	    return clientRepository.getTotalNumberOfClients();
	}
	public int getClientsActif() throws RepositoryException {
	    return clientRepository.getClientsActif();
	}
	public int getClientsInactif() throws RepositoryException {
	    return clientRepository.getClientsInactif();
	}
	public int getClientsAbonne() throws RepositoryException {
	    return clientRepository.getClientsAbonne();
	}
	public int getClientsSeance() throws RepositoryException {
	    return clientRepository.getClientsSeance();
	}
	public double chiffreAffaireMensuelle() throws RepositoryException {
		return clientRepository.getClientsAbonneMensuel()*30000;
	}
	public double chiffreAffaireSeance10() throws RepositoryException {
		return clientRepository.getClientsSeanceDix()*10000;
	}
	public double chiffreAffaireSeance20() throws RepositoryException {
		return clientRepository.getClientsSeanceVingt()*18000;
	}
	public double chiffreAffaireSeance30() throws RepositoryException {
		return clientRepository.getClientsSeanceTrente()*27000;
	}
	public double chiffreAffaireTrimestriel() throws RepositoryException {
		return clientRepository.getClientsAbonneTrimestriel()*80000;//reduc peux etre??
	}
	public double chiffreAffaireAnnuel() throws RepositoryException {
		return clientRepository.getClientsAbonneAnnuel()*320000;//reduc peux etre??
	}
	public double chiffreAffaireFrais() throws RepositoryException {
		return clientRepository.getClientsAbonne()*5000;
	}
	public double chiffreAffaireAbonnement() throws RepositoryException {
		return chiffreAffaireAnnuel()+chiffreAffaireMensuelle()+chiffreAffaireTrimestriel()+chiffreAffaireFrais();
	}
	public double chiffreAffaireSeance() throws RepositoryException {
		return chiffreAffaireSeance10()+chiffreAffaireSeance20()+chiffreAffaireSeance30();
	}
	public double chiffreAffaireTotalMensuelle() throws RepositoryException {
		return chiffreAffaireAbonnement()+chiffreAffaireSeance();
	}
	

	@Override
	public void modifyClient(Client client) throws CrudOperationException {
		try{
			clientRepository.update(client);
			updateClientModel();
		}catch(RepositoryException e) {
			throw new CrudOperationException("Erreur pendant la modification du client: " + e.getMessage());
		}
	}

	@Override
	public void removeClient(Client client) throws CrudOperationException {
		try {
			clientRepository.delete(client.getIdClient());
			updateClientModel();
		}catch(RepositoryException e) {
			throw new CrudOperationException("Erreur pendant la suppression du client: " + e.getMessage());
		}
	}

	@Override
	public TableModel getClientModel() {
		return clientModel;
	}

	@Override
	public int getAllClientSize() {
		return clientModel.getRowCount();
	}
	@Override
	public int getAllUserSize() {
		return userModel.getRowCount();
	}
	@Override
	public void updateClientModel() throws RepositoryException {
		List<Client> clients = clientRepository.list();
		try {
			clientModel.loadClients(clients);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void desactivatedClient(Client client) throws DesactivatedClientException {
		try {
			client.setStatut(Statut.DESACTIVATED);
			clientRepository.desactivateClient(client.getIdClient());
			clientRepository.update(client);
			updateClientModel();
		}catch(RepositoryException e) {
			throw new DesactivatedClientException("Erreur pendant la désactivation du client: " + e.getMessage());
		}
	}
	@Override
	public void addUser(User user) throws CrudOperationException {
		try {
			userRepository.create(user);
			updateUserModel();
			
		}catch(RepositoryException e) {
			throw new CrudOperationException("Erreur pendant l'ajout d'un nouvel utilisateur: " + e.getMessage());
		}
	}

	@Override
	public void modifyUser(User user) throws CrudOperationException {
		try {
			userRepository.update(user);
			updateUserModel();
			
		}catch(RepositoryException e) {
			throw new CrudOperationException("Erreur pendant la modification d'un nouvel utilisateur: " + e.getMessage());
		}		
	}
	
	@Override
	public void deleteUser(User user) throws CrudOperationException {
		try {
			userRepository.delete(user.getId());
			updateUserModel();
			System.out.println("Bonjour je suis le businessLayer voici l'ID = :"+ user.getId());
		}catch(RepositoryException e) {
			throw new CrudOperationException("Erreur pendant la suppression de l'utilisateur: " + e.getMessage());
		}
	}

	@Override
	public void activatedUser(User user) throws ActivatedUserException {
		try {
			userRepository.activateUser(user.getId());
			updateUserModel();
			
		}catch(RepositoryException e) {
			throw new ActivatedUserException("Erreur pendant l'activation d'un utilisateur: " + e.getMessage());
		}		
	}
	@Override
	public void desactivatedUser(User user) throws ActivatedUserException {
		try {
			userRepository.desactivateUser(user.getId());
			updateUserModel();
			
		}catch(RepositoryException e) {
			throw new ActivatedUserException("Erreur pendant la desactivation d'un utilisateur: " + e.getMessage());
		}		
	}

	@Override
	public TableModel getUserModel() {
		return userModel;
	}
	
	
	
	
	@Override
	public void updateUserModel() throws RepositoryException {
		List<User> users = userRepository.list();
		try {
			userModel.loadUsers(users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
