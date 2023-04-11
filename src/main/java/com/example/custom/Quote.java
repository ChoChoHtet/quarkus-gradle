package com.example.custom;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Qualifying and Configuring Annotations
 * Using a combination of InjectionPoint in a producer and nonbinding attributes on the qualifier annotation,
 * it is possible to both qualify and configure a bean.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER,ElementType.TYPE})
public @interface Quote {
    @Nonbinding String msg() default "";
    @Nonbinding String source() default "";
    @Nonbinding String date() default "";
}
