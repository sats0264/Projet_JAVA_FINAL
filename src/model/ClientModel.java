package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class ClientModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	public static final int OBJECT_COL=-1;
	
	private static String [] nomColumns = {
			"Nom", "Prénom", "Adresse", "Telephone", "Sexe", "Abonnement","Statut"
	};
	
	private Vector<Object[]> rows;
	private List<Client> clients;
	
	public ClientModel() {
		clients = new ArrayList<>();
		rows = new Vector<>();
	}
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
			case OBJECT_COL : return clients.get(rowIndex);
			default : return rows.get(rowIndex)[columnIndex];
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return nomColumns[column]; 
	}
	
    public void add(Client client) throws Exception {
        this.clients.add(client);
        this.rows.add(new Object[] {
                client.getNom(),
                client.getPrenom(),
                client.getAdresse(),
                client.getTelephone(),
                client.getSexe().getName(),
                client.getAbonnement().getName(),
                client.getStatut().getName()
        });
        
        fireTableDataChanged();
    }
    public void loadClients(List<Client> clients) throws Exception {
        rows.clear();
        this.clients.clear();
        for(Client client: clients) {
            add(client);
        }
        fireTableDataChanged();
    }


	
	public List<Client> all(){
		return clients;
	}

}
