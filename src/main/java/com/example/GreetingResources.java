package com.example;

import com.example.customResource.Percentage;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
public class GreetingResources {

   // private static org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger(GreetingResources.class);

    @ConfigProperty(name = "greeting.message")
    String message;

    @ConfigProperty(name = "greeting.upper-case",defaultValue = "true")
    boolean uppercase;

    @ConfigProperty(name = "greeting.suffix")
    List<String> suffixes;

    @ConfigProperty(name = "greeting.color")
    String color;

    @ConfigProperty(name = "greeting.vat")
    Percentage vat;

    @Inject
    Config config;

    /*@Inject
    GreetingConfiguration greetingConfiguration;*/


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return message;
    }

    @GET
    @Path("/optional")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloOptional(){
        return uppercase ? message.toUpperCase():message;
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String helloList(){
        return message + suffixes.get(1);
    }

    /**
     * Accessing Configuration Properties Programmatically
     */
    @GET
    @Path("/config")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloConfig(){
        //config.getPropertyNames().forEach(System.out::println);
        return config.getValue("greeting.suffix",String.class);
    }

    @GET
    @Path("/log")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloLog(){
       // logger.info("I said Hello Logging");
        return "hello";
    }

    /**
     * Create custom source
     */
    @GET
    @Path("/color")
    @Produces(MediaType.TEXT_PLAIN)
    public String color(){
        return color;
    }

    @GET
    @Path("/vat")
    @Produces(MediaType.TEXT_PLAIN)
    public String vat(){
        return Double.toString(vat.getPercentage());
    }


}
