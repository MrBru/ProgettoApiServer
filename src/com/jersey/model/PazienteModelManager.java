package com.jersey.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.jersey.DBO.Paziente;

public class PazienteModelManager {

	public ArrayList<Paziente> selectAll() throws SQLException, ClassNotFoundException {
		System.out.println("selectPazienti");
		String s = "";
		ArrayList<Paziente> arrayRet = new ArrayList<>();
		/*
		 * Prova per vedere se la connessione funziona, cambiare la firma del
		 * metodo in string if (connection!=null) return "funge"; else return
		 * "non funge";
		 * 
		 * }
		 */
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT *"
						/*
						 * + "[idPaziente] " + ",[nome] " + ",[cognome] " +
						 * ",[data_nascita] " + ",[luogo] " + ",[cod_fis] " +
						 * ",[residenza] " + ",[provincia] " + ",[indirizzo] " +
						 * ",[telefono] " + ",[mobile] " + ",[email] " +
						 * ",[cod_sanitario] " + ",[cod_medico] " +
						 * ",[data_update] " + ",[data_inserimento] " +
						 * ",[Sesso] "
						 */ + " FROM [project_work].[dbo].[paziente]");
				ResultSet rs = statement.executeQuery();) {

			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();

			while (rs.next()) {
				Paziente p = new Paziente();
				for (int i = 1; i <= columns; i++) {
					p.set(md.getColumnName(i), rs.getString(i));
				}
				arrayRet.add(p);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arrayRet;
	}
	
	public Paziente select(String cod_sanitario) throws SQLException, ClassNotFoundException {
	
		/*
		 * Prova per vedere se la connessione funziona, cambiare la firma del
		 * metodo in string if (connection!=null) return "funge"; else return
		 * "non funge";
		 * 
		 * }
		 */
		Paziente p = null;
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT *"
						 + " FROM [project_work].[dbo].[paziente] where [project_work].[dbo].[paziente].[cod_sanitario] = '" + cod_sanitario + "'");
				ResultSet rs = statement.executeQuery();) {

			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			
			while (rs.next()) {
				p = new Paziente();
				for (int i = 1; i <= columns; i++) {
					p.set(md.getColumnName(i), rs.getString(i));
				}
				
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return p;
	}

}
