package com.example;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * This filter is applied only to JAX-RS resources, and not in reactive routes.
 */
@Provider
public class HeaderAdditionalContainerResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders()
                .add("X-Header","Header Added by JAX-RS filter");
    }
}
