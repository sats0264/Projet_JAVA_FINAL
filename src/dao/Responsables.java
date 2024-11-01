package dao;

import model.User;

public interface Responsables extends IRepository<User> {

	void creerUtilisateur();

	void statistiqueClient();

	void statistiqueAbonnement();
}
