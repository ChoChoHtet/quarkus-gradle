package com.example.cdi;

import io.quarkus.test.Mock;

@Mock
public class MockedGreetingService extends GreetingService{

    @Override
    public String getGreeting(String locale) {
        return "Hello US";
    }
}
