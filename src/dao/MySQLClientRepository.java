package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import exception.RepositoryException;
import model.Abonnement;
import model.Client;
import model.Sexe;
import model.Statut;

public class MySQLClientRepository implements IClientRepository {

	@Override
	public void create(Client instance) throws RepositoryException {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "Insert into client (nom, prenom, adresse, email, telephone, dateAnniversaire, sexe, "
					+ "numPasseport, abonnement, statut) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, instance.getNom());
			ps.setString(2, instance.getPrenom());
			ps.setString(3, instance.getAdresse());
			ps.setString(4, instance.getEmail());
			ps.setString(5, instance.getTelephone());
			ps.setDate(6, java.sql.Date.valueOf(instance.getDateAnniversaire()));
			ps.setString(7, instance.getSexe().name());
			ps.setString(8, instance.getNumPasseport());
			ps.setString(9, instance.getAbonnement().name());
			ps.setString(10, instance.getStatut().name());

			ps.executeUpdate();

		} catch (Exception e) {
			throw new RepositoryException(e.getClass().getSimpleName() + ":" + e.getMessage());
		}
	}

	@Override
	public List<Client> list() throws RepositoryException {
		List<Client> clients = new ArrayList<>();

		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "Select * From client";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int idClient = rs.getInt("idClient");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String adresse = rs.getString("adresse");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				Date dateAnniversaire = rs.getDate("dateAnniversaire");
				String sexe = rs.getString("sexe");
				String numPasseport = rs.getString("numPasseport");
				String abonnement = rs.getString("abonnement");
				String statut = rs.getString("statut");

				Client client = new Client(idClient, nom, prenom, adresse, email, telephone,
						dateAnniversaire.toLocalDate(), Sexe.valueOf(sexe), numPasseport, Abonnement.valueOf(abonnement),Statut.valueOf(statut));
				clients.add(client);
			}

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
		return clients;
	}



	@Override
	public Client read(int id) throws RepositoryException {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "Select * From client where id=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.first()) {
//				int idClient = rs.getInt("idClient");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String adresse = rs.getString("adresse");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				Date dateAnniversaire = rs.getDate("dateAnniversaire");
				String sexe = rs.getString("sexe");
				String numPasseport = rs.getString("numPasseport");
				String abonnement = rs.getString("abonnement");
				String statut = rs.getString("statut");

				return new Client(nom, prenom, adresse, email, telephone,
						dateAnniversaire.toLocalDate(), Sexe.valueOf(sexe), numPasseport, Abonnement.valueOf(abonnement), Statut.valueOf(statut));
			}
		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
		return null;
	}

	public int getTotalNumberOfClients() throws RepositoryException {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "SELECT COUNT(*) FROM client";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (rs.next())
				return rs.getInt(1);
		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
		return 0;
	}
	
	public int getClientsActif() throws RepositoryException {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "SELECT COUNT(*) FROM client where statut= 'ACTIVATED'";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (rs.next())
				return rs.getInt(1);
		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
		return 0;
	}
	
	public int getClientsInactif() throws RepositoryException {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "SELECT COUNT(*) FROM client where statut= 'DESACTIVATED'";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (rs.next())
				return rs.getInt(1);
		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
		return 0;
	}
	
	public int getClientsAbonne() throws RepositoryException {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "SELECT COUNT(*) FROM client WHERE abonnement IN ('MENSUEL', 'TRIMESTRIEL', 'ANNUEL')";

			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (rs.next())
				return rs.getInt(1);
		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
		return 0;
	}
	
	public int getClientsAbonneMensuel() throws RepositoryException {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "SELECT COUNT(*) FROM client WHERE abonnement = 'MENSUEL'";

			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (rs.next())
				return rs.getInt(1);
		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
		return 0;
	}
	
	public int getClientsAbonneTrimestriel() throws RepositoryException {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "SELECT COUNT(*) FROM client WHERE abonnement = 'TRIMESTRIEL'";

			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (rs.next())
				return rs.getInt(1);
		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
		return 0;
	}
	
	public int getClientsAbonneAnnuel() throws RepositoryException {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "SELECT COUNT(*) FROM client WHERE abonnement = 'ANNUEL'";

			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (rs.next())
				return rs.getInt(1);
		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
		return 0;
	}
	
	public int getClientsSeance() throws RepositoryException {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "SELECT COUNT(*) FROM client WHERE abonnement IN ('DIX', 'VINGT', 'TRENTE')";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (rs.next())
				return rs.getInt(1);
		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
		return 0;
	}
	
	public int getClientsSeanceDix() throws RepositoryException {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "SELECT COUNT(*) FROM client WHERE abonnement ='DIX'";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (rs.next())
				return rs.getInt(1);
		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
		return 0;
	}
	
	public int getClientsSeanceVingt() throws RepositoryException {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "SELECT COUNT(*) FROM client WHERE abonnement ='VINGT'";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (rs.next())
				return rs.getInt(1);
		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
		return 0;
	}
	
	public int getClientsSeanceTrente() throws RepositoryException {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "SELECT COUNT(*) FROM client WHERE abonnement ='TRENTE'";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (rs.next())
				return rs.getInt(1);
		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
		return 0;
	}

	@Override
	public void update(Client instance) throws RepositoryException {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "Update client Set nom=?, prenom=?, adresse=?, email=?, telephone=?, "
					+ "dateAnniversaire=?, sexe=?, numPasseport=?, abonnement=?, statut=? Where idClient=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, instance.getIdClient());
			ps.setString(2, instance.getNom());
			ps.setString(3, instance.getPrenom());
			ps.setString(4, instance.getAdresse());
			ps.setString(5, instance.getEmail());
			ps.setString(6, instance.getTelephone());
			ps.setDate(7, java.sql.Date.valueOf(instance.getDateAnniversaire()));
			ps.setString(8, instance.getSexe().name());
			ps.setString(9, instance.getNumPasseport());
			ps.setString(10, instance.getAbonnement().name());
			ps.setString(11, instance.getStatut().name());

			ps.executeUpdate();

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
	}
	
	

	@Override
	public void delete(int id) throws RepositoryException {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "Delete From client where idClient=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
	}

	@Override
	public void desactivateClient(int idClient) throws RepositoryException {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "Update client Set statut=? Where idClient=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, idClient);
			ps.setString(2, Statut.DESACTIVATED.name());

			ps.executeUpdate();

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
	}

}
