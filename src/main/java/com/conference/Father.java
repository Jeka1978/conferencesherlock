package com.conference;

import org.springframework.beans.factory.InitializingBean;

/**
 * JavaDoc here
 *
 * @author Victor Polischuk
 * @since 27.03.2018 0:14
 */
public interface Father<T> extends InitializingBean {
    @Override
    default void afterPropertiesSet() throws Exception {
        System.out.println("I am '" + getClass().getSimpleName() + "' and I choose to be '" + getBehavior().getClass().getSimpleName() + "' after all");
    }

    Behavior<T> getBehavior();
}
