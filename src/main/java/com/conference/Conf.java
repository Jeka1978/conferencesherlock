package com.conference;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * @author Evgeny Borisov
 */
@Configuration
public class Conf {

    @Bean
    public Behavior<String> properBehavior() {
        return new Good();
    }

    @Bean // Comment the method and you will have an error.
    public Behavior<Serializable> delinquentBehavior() {
        return new Bad();
    }

    @Bean // Qualifier can be removed
    public DelinquentSon<String> son1(@Qualifier("properBehavior") Behavior<String> behavior) {
        return new DelinquentSon<>(behavior);
    }

    @Bean // Qualifier can be removed
    public GoodSon<String> son2(@Qualifier("properBehavior") Behavior<String> behavior) {
        return new GoodSon<>(behavior);
    }

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(Conf.class);
    }

    private static class Good implements Behavior<String> {
    }

    private static class Bad implements Behavior<Serializable> {
    }
}
