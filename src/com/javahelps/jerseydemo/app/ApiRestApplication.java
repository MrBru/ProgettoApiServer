package com.javahelps.jerseydemo.app;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rs")
public class ApiRestApplication extends ResourceConfig {
    public ApiRestApplication() {
        // Define the package which contains the service classes.
        packages("com.javahelps.jerseydemo.services");
    }
}
