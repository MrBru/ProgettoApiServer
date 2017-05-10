package com.javahelps.jerseydemo.services;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.jersey.model.PazienteModel;

@Path("/a")
public class HelloWorldService {

	PazienteModel pm = new PazienteModel();
    @GET
    @Path("/{name}")
    public Response sayHello() throws SQLException, ClassNotFoundException {
    	System.out.println("sayHello");
        String output = pm.selectPazienti();
        return Response.status(200).entity(output).build();
    }

}