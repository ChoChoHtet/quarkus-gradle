package com.example.cdi;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

/**
 * Executing Application Life Cycle Events
 * [StartupEvent]- application start up
 * [ShutdownEvent]- application shut down
 */
@ApplicationScoped
public class ApplicationEventListener {
    private final Logger logger = LoggerFactory.getLogger(ApplicationEventListener.class);

    void onStart(@Observes StartupEvent event){
        logger.info("Quarkus Gradle Example Application starting...");
    }

    void onStop(@Observes ShutdownEvent event){
        logger.info("Quarkus Gradle Example Application shutting down");
    }
}
