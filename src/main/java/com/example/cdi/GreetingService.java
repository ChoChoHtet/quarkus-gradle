package com.example.cdi;

import com.example.custom.LogEvent;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Min;
import java.util.Locale;

@ApplicationScoped
public class GreetingService {

    @Inject
    @Named("en_US")
    Locale en_US;

    @Inject
    @Named("th_TH")
    Locale th_TH;

    public String getGreeting(String locale){
        if (locale.startsWith("en")){
            return "Hello from "+ en_US.getDisplayCountry();
        }
        if (locale.startsWith("TH")){
            return "Hello from " + th_TH.getDisplayCountry();
        }
        return "Unknown Locale: " +locale;
    }

    @LogEvent
    public String executeMessage(String hello){
        return hello;
    }

    public String greetingMessage(@Min(value =16) int age){
        if(age < 19){
            return  "Hey boys and girls";
        }else {
            return "Hey ladies and gentleman";
        }
    }
}
