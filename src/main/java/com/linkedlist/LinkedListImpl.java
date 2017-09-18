package com.linkedlist;

/**
 * @author oscarmalagon
 * @since 8/12/17.
 */
public class LinkedListImpl<T extends Node> implements LinkedList<T>{

    T head;
    int size;

    public LinkedListImpl() {
        this.head = null;
        this.size = 0;
    }

    public LinkedListImpl(Object value) {
        this.head = (T) new Node(value);
        this.size = 1;
    }

    @Override
    public void addElement(T node) throws IllegalArgumentException {
        if(node == null || node.getValue() == null) {
            throw new IllegalArgumentException("Cannot insert null node");
        }

        T parent = findLast();
        parent.setNext(node);
        this.size++;
    }


    @Override
    public void removeElement(T current) throws IllegalArgumentException {
        if(current == null || current.getValue() == null || this.size < 1) {
            throw new IllegalArgumentException("Cannot remove values from null list");
        }

        T parent = getParent(current.getValue());

        if(this.head.getValue().equals(current.getValue())){
            this.head = (T) this.head.getNext();
        }
        else if(parent.hasNext()){
            T child = parent.getNext().hasNext() ? (T) parent.getNext().getNext() : null;
            parent.setNext(child);
        }
        this.size--;

    }

    @Override
    public void enumerateElements() {
        T val = this.head;
        while(val.hasNext()){
            System.out.println(val.getValue() + " ");
            val = (T) val.getNext();
        }

        System.out.println(val.getValue() + " ");
    }

    @Override
    public T findElement(Object value) {
        T parent = getParent(value);
        if(parent != null){
            return (T) parent.getNext();
        }

        return null;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    private T findLast() {
        T last = this.head;
        while(last.hasNext()){
            last = (T) last.getNext();
        }

        return last;
    }

    private T getParent(Object value){
        T parent = this.head;
        T child = this.head;

        while(child.hasNext()){
            child = (T) parent.getNext();
            if(child.getValue().equals(value)){
                return parent;
            }

            parent = child;
        }

        return null;
    }

}
