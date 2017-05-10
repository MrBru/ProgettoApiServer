package com.jersey.model;

import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;

public class PazienteModel {

	public String selectPazienti() throws SQLException, ClassNotFoundException {
		System.out.println("selectPazienti");
		
		Connection connection = DatabaseConnection.getConnection();

		if (connection!=null)
			return "funge";
		else
			return "non funge";
		
	}
//		JSONArray jArray = new JSONArray();
//		try (Connection connection = DatabaseConnection.getConnection();
//				PreparedStatement statement = connection.prepareStatement("SELECT " + "[idPaziente] " + ",[nome] "
//						+ ",[cognome] " + ",[data_nascita] " + ",[luogo] " + ",[cod_fis] " + ",[residenza] "
//						+ ",[provincia] " + ",[indirizzo] " + ",[telefono] " + ",[mobile] " + ",[email] "
//						+ ",[cod_sanitario] " + ",[cod_medico] " + ",[data_update] " + ",[data_inserimento] "
//						+ ",[Sesso] " + "FROM [project_work].[dbo].[paziente]");
//				ResultSet resultSet = statement.executeQuery();) {
//			while (resultSet.next()) {
//				String id = resultSet.getString("id");
//				String nome = resultSet.getString("nome");
//				String cognome = resultSet.getString("cognome");
//				String data_nascita = resultSet.getString("data_nascita");
//				String luogo = resultSet.getString("luogo");
//				String cod_fis = resultSet.getString("cod_fis");
//				String residenza = resultSet.getString("residenza");
//				String provincia = resultSet.getString("provincia");
//				String indirizzo = resultSet.getString("indirizzo");
//				String telefono = resultSet.getString("telefono");
//				String mobile = resultSet.getString("mobile");
//				String email = resultSet.getString("email");
//				String cod_sanitario = resultSet.getString("cod_sanitario");
//				String cod_medico = resultSet.getString("cod_medico");
//				String data_update = resultSet.getString("data_update");
//				String data_inserimento = resultSet.getString("data_inserimento");
//				String sesso = resultSet.getString("sesso");
//
//				JSONObject jobj = new JSONObject();
//				jobj.put("id", id);
//				jobj.put("nome", nome);
//				jobj.put("cognome", cognome);
//				jobj.put("data_nascita", data_nascita);
//				jobj.put("luogo", luogo);
//				jobj.put("cod_fis", cod_fis);
//				jobj.put("residenza", residenza);
//				jobj.put("provincia", provincia);
//				jobj.put("indirizzo", indirizzo);
//				jobj.put("telefono", telefono);
//				jobj.put("mobile", mobile);
//				jobj.put("email", email);
//				jobj.put("cod_sanitario", cod_sanitario);
//				jobj.put("cod_medico", cod_medico);
//				jobj.put("data_update", data_update);
//				jobj.put("data_inserimento", data_inserimento);
//				jobj.put("sesso", sesso);
//				jArray.put(jobj);
//			}
//		}return jArray;
//	}

}
