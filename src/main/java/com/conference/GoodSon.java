package com.conference;

import java.io.Serializable;

/**
 * @author Evgeny Borisov
 */
public class GoodSon<T extends Serializable> extends StrictFather<T> {
    public GoodSon(Behavior<T> behavior) {
        super(behavior);
    }
}
