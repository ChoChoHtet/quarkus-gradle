package com.example.resource;

import com.example.model.Developer;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Path("/developer")
public class DeveloperResource {
    private final List<Developer> developers = new ArrayList<>();

    @Inject
    Validator validator;

    /**
     * @param developer mandatory to validate object in declarative way
     */
    @POST
    @Produces
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDeveloper(@Valid Developer developer) {
        developers.add(developer);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDevelopers() {
        return Response.ok(developers).build();
    }


    @POST
    @Path("/programmatic")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProgrammaticValidation(Developer developer) {
        Set<ConstraintViolation<Developer>> violations = validator.validate(developer);
        if (violations.isEmpty()) {
            developers.add(developer);
            return Response.ok(developer).build();
        } else {
            JsonArrayBuilder errors = Json.createArrayBuilder();
            for (ConstraintViolation<Developer> violation : violations) {
                errors.add(
                        Json.createObjectBuilder()
                                .add("path", violation.getPropertyPath().toString())
                                .add("message", violation.getMessage())
                );
            }
            return Response.status(Response.Status.BAD_REQUEST).entity(errors.build()).build();
        }
    }
}
