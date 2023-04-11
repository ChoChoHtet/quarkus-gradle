package com.example.cdi;

import io.quarkus.test.junit.QuarkusTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;

@QuarkusTest
public class GreetingServiceTest {
    @Inject
    GreetingService greetingService;


    @Test
    public void  testGreetingMessageForTeenagers(){
        String message = greetingService.greetingMessage(18);
        Assertions.assertThat(message).isEqualTo("Hey boys and girls");
    }

    @Test
    public void testGreetingMessageForAdults(){
        String message = greetingService.greetingMessage(20);
        Assertions.assertThat(message).isEqualTo("Hey ladies and gentleman");
    }

    @Test
    public void testGreetingMessageForYouth(){
        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(()-> greetingService.greetingMessage(15));
    }

    @Test
    public void  testMockedGreetingUSLocale(){
        GreetingService mockedGreetingService = new MockedGreetingService();
        String message = mockedGreetingService.getGreeting("MM");
        Assertions.assertThat(message).isEqualTo("Hello US");
    }

}
