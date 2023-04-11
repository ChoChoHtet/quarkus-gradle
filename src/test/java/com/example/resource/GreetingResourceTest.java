package com.example.resource;

import com.example.cdi.GreetingService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@QuarkusTest
public class GreetingResourceTest {

    @InjectMock
    GreetingService greetingService;

    @BeforeEach
    public void prepareMocks(){
        when(greetingService.executeMessage(anyString()))
                .thenReturn("Hello Execute Message");

        when(greetingService.getGreeting(anyString()))
                .thenReturn("Hello from Thailand");

    }
    @Test
    public void testConfigurationEndpoint(){
        given()
                .when()
                .get("/configuration")
                .then()
                .statusCode(200)
                .body(is ("Hello from Thailand"));

    }

    @Test
    public void testLogEndpoint(){
        given()
                .when()
                .get("/configuration/log")
                .then()
                .statusCode(200)
                .body(is ("Hello Execute Message"));
    }
}
