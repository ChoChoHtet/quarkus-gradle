package com.example.customResource;



import org.eclipse.microprofile.config.spi.Converter;

import javax.annotation.Priority;

/**
 * By default, if no @Priority annotation can be found on a converter, it is registered with a priority of 100.
 * Quarkus converters are registered with a priority of 200,
 * so if you want to replace a Quarkus converter, you should use a higher value;
 * if you don’t need to replace a Quarkus converter, then the default one is perfectly fine
 */
@Priority(300)
public class PercentageConverter implements Converter<Percentage> {
    @Override
    public Percentage convert(String value) throws IllegalArgumentException, NullPointerException {
        String numeric = value.substring(0,value.length() -1);
        return new Percentage(Double.parseDouble(numeric)/100);
    }
}
