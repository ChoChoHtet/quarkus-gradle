package com.example;

import io.quarkus.vertx.http.runtime.filters.Filters;
import io.quarkus.vertx.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

/**
 * First approach - Reactive Routes
 * CDI - Context and dependency injection
 */
@ApplicationScoped
public class ApplicationRoutes {
    public void routes(@Observes Router router) {
        router
                .get("/ok")
                .handler(rc -> rc.response().end("OK from Route"));
    }


    /**
     * Second way
     * @param routingContext - request information
     */
    @Route(path = "/declarative", methods = Route.HttpMethod.GET)
    public void greetings(RoutingContext routingContext) {
        String name = routingContext.request().getParam("name");
        if (name == null) {
            name = "world";
        }
        routingContext.response().end("OK " + name + " you are right");
    }

    /**
     * Intercepting HTTP Requests
     * @param filters
     */
    public void filters(@Observes Filters filters){
        filters
                .register(
                        rc -> {
                            rc.response().putHeader("V-Header","Header added by Vertx Filter");
                            rc.next();
                        },10);
    }
}
