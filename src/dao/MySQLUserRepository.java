package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import exception.RepositoryException;
import model.Statut;
import model.TypeUser;
import model.User;

public class MySQLUserRepository implements IUserRepository {

	@Override
	public void create(User instance) throws RepositoryException {
		try(Connection connection = DatabaseConnection.getConnection()){
			String query = "Insert into utilisateur (username, password, role, statut) values (?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, instance.getUsername());
			ps.setString(2, instance.getPassword());
			ps.setString(3, instance.getRole().name().toUpperCase());
			ps.setString(4, instance.getStatut().name());
			
			ps.executeUpdate();
			
		}catch(Exception e) {
			throw new RepositoryException(e.getMessage());
		}
	}

	@Override
	public List<User> list() throws RepositoryException {
		List<User> users = new ArrayList<>();

		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "Select * From utilisateur";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String role = rs.getString("role");
				String statut = rs.getString("statut");

				User user = new User(id, username, password, TypeUser.valueOf(role), Statut.valueOf(statut));
				users.add(user);
			}

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}

		return users;
	}

	@Override
	public User read(int id) throws RepositoryException {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "Select * From utilisateur where id=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.first()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String role = rs.getString("role");

				return new User(username, password, TypeUser.valueOf(role));
			}
			
		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
		
		return null;
	}

	public boolean read(String username, String password) throws RepositoryException {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "Select * From utilisateur where username=? and password=? and statut='ACTIVATED'";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			return rs.next();

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
	}
	@Override
	public void update(User instance) throws RepositoryException {
	}

	@Override
	public void delete(int id) throws RepositoryException {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "Delete From utilisateur where id=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
	}



		public TypeUser getUserRole(String username, String password) throws RepositoryException {
			try(Connection connection = DatabaseConnection.getConnection()){
				String query = "Select role From utilisateur Where username=? AND password=?";
				PreparedStatement ps = connection.prepareStatement(query);
				
				ps.setString(1, username);
				ps.setString(2, password);
				
				ResultSet rs =ps.executeQuery();
				
				if (rs.next()) {
		            String role = rs.getString("role");
		            return TypeUser.valueOf(role);
		        } else {
		            throw new RepositoryException("User not found or invalid credentials");
		        }
		    } catch (Exception e) {
		        throw new RepositoryException("Error fetching user role: " + e.getMessage());
		    }
		}

		
		@Override
		public void activateUser(int id) throws RepositoryException {

			try (Connection connection = DatabaseConnection.getConnection()) {
				String query = "Update utilisateur Set statut=? Where id=?";

				PreparedStatement ps = connection.prepareStatement(query);

				ps.setString(1, Statut.ACTIVATED.toString()); 
				ps.setInt(2, id);

				ps.executeUpdate();

			} catch (Exception e) {
				throw new RepositoryException(e.getMessage());
			}
		}
		@Override
		public void desactivateUser(int id) throws RepositoryException {

			try (Connection connection = DatabaseConnection.getConnection()) {
				String query = "Update utilisateur Set statut=? Where id=?";

				PreparedStatement ps = connection.prepareStatement(query);

				ps.setString(1, Statut.DESACTIVATED.toString()); 
				ps.setInt(2, id);

				ps.executeUpdate();

			} catch (Exception e) {
				throw new RepositoryException(e.getMessage());
			}
		}
}
