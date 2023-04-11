package com.example.resource;

import com.example.cdi.*;
import com.example.custom.Quote;
import com.example.custom.SpainLocale;
import com.example.model.Message;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Locale;

@Path("/configuration")
public class GreetingResource {
    @Inject
    GreetingService service;

    @Inject
    LocaleProducer localeProducer;

    @Inject
    @SpainLocale
    Locale spain;

    @Inject
    @Quote(msg = "Hello Cho Cho",source = "God")
    Message myQuote;

    @Inject
    @Quote(msg = "Talk is cheap. Show me the code",source = "Linus Torvalds",date = "Today")
    Message quote2 ;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
       return service.getGreeting(localeProducer.getDefaultLocale().getCountry());
    }

    @GET
    @Path("/custom")
    @Produces(MediaType.TEXT_PLAIN)
    public String customQualifier(){
        return spain.getDisplayCountry();
    }

    @GET
    @Path("/config")
    @Produces(MediaType.TEXT_PLAIN)
    public String configurationQualifier(){
        System.out.println("msg: "+myQuote.getMsg() +" , source:" +myQuote.getSource());
        return myQuote.getMsg();
    }

    @GET
    @Path("/config2")
    @Produces(MediaType.APPLICATION_JSON)
    public Response configurationQualifier2(){
        return Response.ok(quote2).build();
    }

    @GET
    @Path("/log")
    @Produces(MediaType.TEXT_PLAIN)
    public String log(){
        return service.executeMessage("interceptor testing");
    }
}
