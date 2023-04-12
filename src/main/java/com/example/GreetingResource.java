package com.example;

import io.quarkus.runtime.annotations.CommandLineArguments;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @CommandLineArguments
    String[] args;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return args[0];
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloTest(){
        return "Hello Testing";
    }

}
