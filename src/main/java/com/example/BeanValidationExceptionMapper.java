package com.example;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *  Provider - set an implementation of an extension interface discoverable by the JAX-RS runtime
 */
@Provider
public class BeanValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(createErrorMessage(exception))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    private JsonArray createErrorMessage(ConstraintViolationException exc){
        JsonArrayBuilder error = Json.createArrayBuilder();
        for (ConstraintViolation<?>violation : exc.getConstraintViolations()){
            error.add(
                    Json.createObjectBuilder()
                            .add("file-path",violation.getPropertyPath().toString())
                            .add("message",violation.getMessage())

            );
        }
        return error.build();
    }
}
