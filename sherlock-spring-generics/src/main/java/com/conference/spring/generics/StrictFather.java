package com.conference.spring.generics;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Evgeny Borisov
 */

public abstract class StrictFather<T> implements Father<T> {
    private final Behavior<T> behavior;

    @Autowired
    public StrictFather(Behavior<T> behavior) {
        this.behavior = behavior;
    }

    @Override
    public Behavior<T> getBehavior() {
        return behavior;
    }
}
