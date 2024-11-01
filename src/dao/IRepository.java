package dao;

import java.util.List;

import exception.RepositoryException;

public interface IRepository<C> {
	/**
	 * @param instance
	 * @throws RepositoryException
	 */
	void create(C instance) throws RepositoryException;
	/**
	 * @return
	 * @throws RepositoryException
	 */
	List<C> list() throws RepositoryException;
	/**
	 * @param id
	 * @return
	 * @throws RepositoryException
	 */
	C read (int id) throws RepositoryException;
	/**
	 * @param instance
	 * @throws RepositoryException
	 */
	void update(C instance) throws RepositoryException;
	/**
	 * @param id
	 * @throws RepositoryException
	 */
	void delete(int id) throws RepositoryException;


}
