package com.example;

import io.smallrye.common.constraint.NotNull;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * JAX-RS
 */
@Path("/hello")
public class ExampleResource {
    public static enum Order{
        desc,asc;
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(
            @Context UriInfo uriInfo,
            @QueryParam("order") Order order,
            @NotNull @HeaderParam("authorization") String authorization
            ) {
        return String.format("URL: %s - Order %s -Authorization: %s",uriInfo.getAbsolutePath(),order,authorization);
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void create(String message){
        System.out.println("Create");
    }

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String update(String message){
        System.out.println("Create");
        return message;
    }

    @DELETE
    public void delete(){
        System.out.println("Delete");
    }

    @LOCK
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{id}")
    public String lockResource(@PathParam("id") long id){
        return id + " locked";
    }


}