package com.conference;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;

/**
 * @author Evgeny Borisov
 */

public abstract class Parent<T> implements InitializingBean {
    @Autowired
    private Comparator<T> comparator;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(comparator.getClass().getName());
    }

    public Comparator<T> getComparator() {
        return comparator;
    }

    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }
}
