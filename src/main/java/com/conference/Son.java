package com.conference;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author Evgeny Borisov
 */
public class Son<T extends Serializable> extends Parent<T> {
    public Son(Comparator<T> comparator) {
        setComparator(comparator);
    }
}
