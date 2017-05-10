package com.javahelps.jerseydemo.app;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rs")
public class HelloWorldApplication extends ResourceConfig {
    public HelloWorldApplication() {
    	System.out.println("HelloWorldApplication");
        // Define the package which contains the service classes.
        packages("com.javahelps.jerseydemo.services");
    }
}
