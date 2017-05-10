package com.jersey.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jersey.DBO.Paziente;

public class PazienteModelManager {

	public ArrayList<Paziente> selectAll() throws SQLException, ClassNotFoundException {
		System.out.println("selectPazienti");
		ArrayList<Paziente> arrayRet = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet rs =null;
		try {
			Connection connection = DatabaseConnection.getConnection();
			statement = connection.prepareStatement("SELECT *"
					/*
					 * + "[idPaziente] " + ",[nome] " + ",[cognome] " +
					 * ",[data_nascita] " + ",[luogo] " + ",[cod_fis] " +
					 * ",[residenza] " + ",[provincia] " + ",[indirizzo] " +
					 * ",[telefono] " + ",[mobile] " + ",[email] " +
					 * ",[cod_sanitario] " + ",[cod_medico] " +
					 * ",[data_update] " + ",[data_inserimento] " + ",[Sesso] "
					 */ + " FROM [project_work].[dbo].[paziente]");
			rs = statement.executeQuery();
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
		}finally{
			statement.close();
			rs.close();
		}
		return arrayRet;
	}
	
	
	
	public ArrayList<Paziente> selectByCod_Med(String cod_medico) throws SQLException, ClassNotFoundException {
		ArrayList<Paziente> arrayRet = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet rs =null;
		try {
			Connection connection = DatabaseConnection.getConnection();
			statement = connection.prepareStatement("SELECT *"
					/*
					 * + "[idPaziente] " + ",[nome] " + ",[cognome] " +
					 * ",[data_nascita] " + ",[luogo] " + ",[cod_fis] " +
					 * ",[residenza] " + ",[provincia] " + ",[indirizzo] " +
					 * ",[telefono] " + ",[mobile] " + ",[email] " +
					 * ",[cod_sanitario] " + ",[cod_medico] " +
					 * ",[data_update] " + ",[data_inserimento] " + ",[Sesso] "
					 */ + " FROM [project_work].[dbo].[paziente] WHERE [project_work].[dbo].[paziente].[cod_medico] = '" + cod_medico + "'");
			rs = statement.executeQuery();
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
		}finally{
			statement.close();
			rs.close();
		}
		return arrayRet;
	}
	
	public ArrayList<Paziente> selectByCod_MedAfterDate(String cod_medico, String Date) throws SQLException, ClassNotFoundException {
		ArrayList<Paziente> arrayRet = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet rs =null;
		try {
			Connection connection = DatabaseConnection.getConnection();
			statement = connection.prepareStatement("SELECT *"
					/*
					 * + "[idPaziente] " + ",[nome] " + ",[cognome] " +
					 * ",[data_nascita] " + ",[luogo] " + ",[cod_fis] " +
					 * ",[residenza] " + ",[provincia] " + ",[indirizzo] " +
					 * ",[telefono] " + ",[mobile] " + ",[email] " +
					 * ",[cod_sanitario] " + ",[cod_medico] " +
					 * ",[data_update] " + ",[data_inserimento] " + ",[Sesso] "
					 */ + " FROM [project_work].[dbo].[paziente] WHERE [project_work].[dbo].[paziente].[cod_medico] = '" + cod_medico + "' AND [project_work].[dbo].[paziente].[data_update] >= '"+ Date /*La date deve essere in formato yyyy/dd/mm o trasformata*/ + "'");
			rs = statement.executeQuery();
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
		}finally{
			statement.close();
			rs.close();
		}
		return arrayRet;
	}

	public Paziente select(String cod_sanitario) throws SQLException, ClassNotFoundException {

		Paziente p = null;
		PreparedStatement statement = null;
		ResultSet rs =null;
		try {
			Connection connection = (DatabaseConnection.getConnection());
			statement = connection.prepareStatement("SELECT *"
					+ " FROM [project_work].[dbo].[paziente] where [project_work].[dbo].[paziente].[cod_sanitario] = '"
					+ cod_sanitario + "'");
			rs = statement.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();

			while (rs.next()) {
				p = new Paziente();
				for (int i = 1; i <= columns; i++) {
					p.set(md.getColumnName(i), rs.getString(i));
				}

			}
			// TODO da gestire l'eccezione particolare
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			statement.close();
			rs.close();
		}
		return p;
	}

}
