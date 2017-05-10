package com.javahelps.jerseydemo.services;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.json.JSONArray;

import com.jersey.DBO.Paziente;
import com.jersey.model.PazienteModelManager;



@Path("/Paziente")
public class PazienteApiRestController {

	
    @GET //RICERCA TUTTI I PAZIENTI DI TUTTI I MEDICI
    @Path("/all")
    public Response All() throws SQLException, ClassNotFoundException {
    	PazienteModelManager pm = new PazienteModelManager();
    	System.out.println("sayHello");
      
    	ArrayList<Paziente> output = pm.selectAll();
        int n = output.size();
        JSONArray ja = new JSONArray();
        for(int i = 0; i<n;i++){
        	Paziente p = output.get(i);
            ja.put(p.toJSONObject());
        }

        return Response.status(200).entity( ja.toString()).build();
    }
    
    @GET // RICERCA PER CODICE MEDICO
    @Path("/all/{cod_medico}")
    public Response AllMedico(@PathParam ("cod_medico") String cod_medico) throws SQLException, ClassNotFoundException {
    	PazienteModelManager pm = new PazienteModelManager();
      
    	ArrayList<Paziente> output = pm.selectByCod_Med(cod_medico);
        int n = output.size();
        JSONArray ja = new JSONArray();
        for(int i = 0; i<n;i++){
        	Paziente p = output.get(i);
            ja.put(p.toJSONObject());
        }

        return Response.status(200).entity( ja.toString()).build();
    }
    
    @GET  //RICERCA PER CODICE SANITARIO (UNICO)
    @Path("/get/{cod_sanitario}")
    public Response Single(@PathParam("cod_sanitario") String cod_sanitario) throws SQLException, ClassNotFoundException {
    	PazienteModelManager pm = new PazienteModelManager();
    	Paziente p = pm.select(cod_sanitario);
    	if(p!=null)
    	{
    		return Response.status(200).entity( p.toJSONObject().toString()).build();
    	}
    	else{
    		return Response.status(403).entity("Invalid cod_sanitario").build();
    	}
    }

}