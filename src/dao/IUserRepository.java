package dao;

import exception.RepositoryException;
import model.User;

public interface IUserRepository extends IRepository<User>{
	/**
	 * @param id
	 * @throws RepositoryException
	 */
	void activateUser(int id) throws RepositoryException;

	void desactivateUser(int id) throws RepositoryException;
}
