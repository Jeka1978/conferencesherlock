package com.conference;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Evgeny Borisov
 */
public class Daughter<T extends Serializable> extends Parent<T> {
}
