package com.linkedlist;

import lombok.Data;

/**
 * @author oscarmalagon
 * @since 8/12/17.
 */
@Data
public class Node {

    private Object value;
    private Node next;
    private Node last;

    public Node(Object value) {
        this.value = value;

    }

    public boolean hasNext(){
        return this.getNext() != null;
    }
}
