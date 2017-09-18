package com.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author oscarmalagon
 * @since 8/12/17.
 */
class LinkedListImplTest {

    @Test
    void oneElement() {
        LinkedList list = new LinkedListImpl("1");
        assertEquals(1, list.getSize());
    }

    @Test
    void noElements() {
        LinkedList list = new LinkedListImpl();
        assertEquals(0, list.getSize());
    }

    @Test
    void removeElement() {
        LinkedList list = new LinkedListImpl("1");
        list.addElement(new Node("2"));
        list.addElement(new Node("3"));
        list.addElement(new Node("4"));
        list.addElement(new Node("5"));
        list.addElement(new Node("6"));
        list.addElement(new Node("7"));

        list.removeElement(new Node("3"));

        list.enumerateElements();
        assertEquals(6, list.getSize());
    }

    @Test
    void enumerateElements() {
        LinkedList list = new LinkedListImpl("1");
        list.addElement(new Node("2"));
        list.addElement(new Node("3"));
        list.addElement(new Node("4"));
        list.addElement(new Node("5"));
        list.addElement(new Node("6"));
        list.addElement(new Node("7"));
        list.enumerateElements();
    }

    @Test
    void findElement() {
        LinkedList list = new LinkedListImpl("1");
        list.addElement(new Node("2"));
        list.addElement(new Node("3"));


        assertEquals("2", list.findElement("2").getValue());
        assertNotEquals(new Node("2"), list.findElement("2"));
    }

    @Test
    void removingHeadElements() {
        LinkedList list = new LinkedListImpl("1");
        list.addElement(new Node("2"));
        list.addElement(new Node("3"));
        list.addElement(new Node("4"));
        list.addElement(new Node("5"));
        list.addElement(new Node("6"));
        list.addElement(new Node("7"));

        list.removeElement(new Node("1"));
        list.enumerateElements();
        System.out.println("1 has been removed");
        list.removeElement(new Node("2"));
        list.enumerateElements();
        System.out.println("2 has been removed");
        list.removeElement(new Node("3"));
        list.enumerateElements();
        System.out.println("3 has been removed");
        list.removeElement(new Node("4"));
        list.enumerateElements();
        System.out.println("4 has been removed");
        list.removeElement(new Node("5"));
        list.enumerateElements();
        System.out.println("5 has been removed");
        assertEquals(2, list.getSize());
    }


}