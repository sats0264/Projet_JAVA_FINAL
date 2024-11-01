package service;

import javax.swing.table.TableModel;

import exception.ActivatedUserException;
import exception.CrudOperationException;
import exception.DesactivatedClientException;
import exception.RepositoryException;
import model.Client;
import model.User;

public interface IService {
	/**
	 * @param login
	 * @param password
	 * @return
	 */
	boolean authentificate (String login, String password);

	/**
	 * @param client
	 * @throws CrudOperationException 
	 */
	void addClient(Client client) throws CrudOperationException;

	/**
	 * @param client
	 * @throws CrudOperationException 
	 */
	void modifyClient(Client client) throws CrudOperationException;

	/**
	 * @param client
	 * @throws CrudOperationException 
	 */
	void removeClient(Client client) throws CrudOperationException;
	
	/**
	 * @return
	 */
	TableModel getClientModel();
	
	/**
	 * @return
	 */
	int getAllClientSize();
	
	/**
	 * @throws RepositoryException
	 */
	void updateClientModel() throws RepositoryException;
	
	/**
	 * @param client
	 * @throws DesactivatedClientException
	 */
	void desactivatedClient(Client client) throws DesactivatedClientException;

	/**
	 * @param user
	 * @throws CrudOperationException
	 */
	void addUser(User user) throws CrudOperationException;
	
	/**
	 * @param user
	 * @throws CrudOperationException
	 */
	void modifyUser(User user) throws CrudOperationException;
	
	/**
	 * @param user
	 * @throws CrudOperationException
	 */
	void deleteUser(User user)throws CrudOperationException;
	/**
	 * @param user
	 * @throws ActivatedUserException
	 */
	void activatedUser(User user) throws ActivatedUserException;
	
	/**
	 * @return
	 */
	TableModel getUserModel();
	/**
	 * @throws RepositoryException
	 */
	void updateUserModel() throws RepositoryException;

	/**
	 * @return
	 */
	int getAllUserSize();

	/**
	 * @param user
	 * @throws ActivatedUserException
	 */
	void desactivatedUser(User user) throws ActivatedUserException;
}
