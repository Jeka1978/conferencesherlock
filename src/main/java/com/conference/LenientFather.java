package com.conference;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Evgeny Borisov
 */

public abstract class LenientFather<T> implements Father<T> {
    @Autowired
    private Behavior<T> behavior;

    @Override
    public Behavior<T> getBehavior() {
        return behavior;
    }

    public void setBehavior(Behavior<T> behavior) {
// Uncomment it only for the problem investigation
//        System.out.println("I am '" + getClass().getSimpleName() + "' and I've been set '" + behavior.getClass().getSimpleName() + "' behavior");

        this.behavior = behavior;
    }
}
