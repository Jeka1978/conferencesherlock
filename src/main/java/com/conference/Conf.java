package com.conference;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Evgeny Borisov
 */
@Configuration
public class Conf {

    @Bean
    public Comparator<String> stringComparator() {
        return String::compareTo;
    }

    @Bean
    public Comparator<Double> doubleComparator() {
        return Double::compareTo;
    }

    @Bean
    public Comparator<Object> objectComparator() {
        return (a,b) -> 0;
    }

    @Bean
    public Son<String> son(Comparator<String> comparator) {
        return new Son<>(comparator);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
