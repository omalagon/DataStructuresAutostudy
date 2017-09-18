package com.linkedlist;

/**
 * @author oscarmalagon
 * @since 8/12/17.
 */
public interface LinkedList<T extends Node>{

    void addElement(T node) throws IllegalArgumentException;

    void removeElement(T node) throws IllegalArgumentException;

    void enumerateElements();

    T findElement(Object value);

    int getSize();
}
