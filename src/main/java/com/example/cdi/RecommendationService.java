package com.example.cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;

/**
 * Executing Object Life Cycle Events
 */
@ApplicationScoped
public class RecommendationService {
    List<String> products;

    /**
     * PostConstruct -  after constructor is called and after all injection happen
     * this will be called after object creation
     */
    @PostConstruct
    public void init(){
        products = Arrays.asList("Orange","Apple");
        System.out.println("Product initialized");
    }

    /**
     * PreDestroy - before object is destroyed
     * if  logic need to be executed before the object is destroyed. example closing connection, cleaning up resource
     */
    @PreDestroy
    public void cleanup(){
        products = null;
        System.out.println("Product cleaned up");
    }

    public List<String> getProducts(){
        return products;
    }
}
