package dao;

import exception.RepositoryException;
import model.Client;

public interface IClientRepository extends IRepository<Client> {
	/**
	 * @param id
	 * @throws RepositoryException
	 */
	void desactivateClient(int id) throws RepositoryException;
}
