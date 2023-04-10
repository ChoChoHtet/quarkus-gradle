package com.example;

import com.example.groupConfiguration.GreetingConfiguration;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/test")
public class GroupResource {
    @Inject
    GreetingConfiguration greetingConfiguration;

    @GET
    @Path("/configuration")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloConfiguration(){
        return greetingConfiguration.message + greetingConfiguration.suffix ;
    }

    @GET
    @Path("/nested")
    @Produces(MediaType.TEXT_PLAIN)
    public List<String> helloNestedConfiguration(){
        return greetingConfiguration.output.recipients ;
    }
}
