package com.example.resource;

import com.example.HelloWorldQuarkusTestResourceLifecycleManager;
import io.quarkus.test.common.QuarkusTestResource;

@QuarkusTestResource(HelloWorldQuarkusTestResourceLifecycleManager.class)
public class HelloWorldTestResource {
}
