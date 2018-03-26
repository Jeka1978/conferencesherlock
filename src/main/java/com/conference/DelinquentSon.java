package com.conference;

import java.io.Serializable;

/**
 * @author Evgeny Borisov
 */
public class DelinquentSon<T extends Serializable> extends LenientFather<T> {
    public DelinquentSon(Behavior<T> behavior) {
        setBehavior(behavior);
    }
}
