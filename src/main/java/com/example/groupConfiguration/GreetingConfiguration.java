package com.example.groupConfiguration;


import io.quarkus.arc.config.ConfigProperties;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@ConfigProperties(prefix = "hello")
public class GreetingConfiguration {
    public String message;
    public String suffix="!";
    public OutputConfiguration output;
    @Min(1)
    @Max(3)
    public Integer repeat;

    @Email
    public String email;


    public static class OutputConfiguration{
        public List<String> recipients;
    }

}
