package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class UserModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	public static final int OBJECT_COL=-1;
	
	private static String[] nomColumns = {
			"Username", "Password", "Role de l'utilisateur", "Status"
	};
	
	private Vector<Object[]> rows = new Vector<>();
	private List<User> users = new ArrayList<>();
	
	@Override
	public int getRowCount() {
		return rows.size();
	}

	@Override
	public int getColumnCount() {
		return nomColumns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case OBJECT_COL : return users.get(rowIndex);
			default : return rows.get(rowIndex)[columnIndex];
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return nomColumns[column];
	}
	
	public void add(User user) {
		this.users.add(user);
		this.rows.add(new Object[] {
				user.getUsername(),
				user.getPassword(),
				user.getRole().getName(),
				user.getStatut().getName()
		});
		
		fireTableDataChanged();;
	}

	public void loadUsers(List<User> users) {
		rows.clear();
		this.users.clear();
		for(User user: users) {
			add(user);
		}
		
		fireTableDataChanged();
	}
	
	public List<User> all(){
		return users;
	}
}
