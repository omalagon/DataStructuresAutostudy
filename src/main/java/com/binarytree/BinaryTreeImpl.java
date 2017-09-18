package com.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary tree implementation
 * The value's nodes are considered as Integers so it's possible to compare them
 * @author oscarmalagon
 * @since 03/09/2017.|
 */
public class BinaryTreeImpl <T extends Object> implements BinaryTree<T> {

    private Node root;
    private Integer size;
    private List<Object> nodeList;

    /**
     * Constructor
     */
    public BinaryTreeImpl(){
        size = 0;
        nodeList = new ArrayList<>();
    }


    /**
     * Adds a node to the tree
     * @param node The node to be added
     */
    @Override
    public void addNode(Node node) {
        if(this.root == null){
            this.root = node;
            this.size = 1;
            return;
        }
        this.addNode(this.root, node);
        return;
    }

    /**
     * Adds a node to a subtree, given the root
     * @param parent The subtree's root
     * @param node The node to be added
     */
    public void addNode(Node parent, Node node) {
        if(root != null){
            if(isSmaller(parent, node)){
                addSmaller(parent, node);
            }
            if(isGreater(parent, node)){
                addGreater(parent, node);
            }
            return ;
        }
    }

    /**
     * Adds a node in the left side of the subtree
     * @param root the root of the subtree
     * @param node the node to be added
     */
    private void addSmaller(Node root, Node node) {
        if(root.getLeftChild() == null){
            root.setLeftChild(node);
            this.size++;
        }else {
            addNode(root.getLeftChild(), node);
        }
    }

    /**
     * Adds a node in the right side of the subtree
     * @param root the root of the subtree
     * @param node the node to be added
     */
    private void addGreater(Node root, Node node) {
        if(root.getRightChild() == null){
            root.setRightChild(node);
            this.size++;
        }else {
            addNode(root.getRightChild(), node);
        }
    }

    /**
     * Removes a node from the tree
     * @param node the node to be removed
     */
    @Override
    public void removeNode(Node<T> node) {
        this.root = removeNode(this.root, node);
        this.size--;
    }

    /**
     * Removes a node from the given subtree
     * @param root The subtree's root node
     * @param node The node to be removed from the subtree
     * @return The root node
     */
    private Node removeNode(Node root, Node<T> node) {
        if(root == null){
            return null;
        }
        if(isSmaller(root, node)){
            root.setLeftChild(removeNode(root.getLeftChild(), node));
        } else if(isGreater(root, node)){
            root.setRightChild(removeNode(root.getRightChild(), node));
        }
        else {
            if(root.getLeftChild() == null){
                return root.getRightChild();
            } else if(root.getRightChild() == null){
                return root.getLeftChild();
            }

            root.setValue(minRight(root.getRightChild()));
            root.setRightChild(removeNode(root.getRightChild(), root));
        }
        return root;
    }


    /**
     * Searches a node within the tree
     * @param value The value of the node to be found
     * @return null if the node couldn't be found, a Node otherwise
     */
    @Override
    public  Node searchNode(T value) {
        return searchNode(null, value);
    }

    /**
     * Searches a node within a subtree
     * @param root The subtree's root
     * @param value The value of the node to be found
     * @return
     */
    private Node searchNode(Node root, T value) {
        if(root == null){
            root = this.root;
        }

        if(root != null){
            if(root.getValue() == value){
                return root;
            }
            if(root.getLeftChild() != null && isSmaller(root, Node.builder().value(value).build())){
                return searchNode(root.getLeftChild(), value);
            }
            if(root.getRightChild() != null && isGreater(root, Node.builder().value(value).build())){
                return searchNode(root.getRightChild(), value);
            }
        }

        return null;
    }

    /**
     * @return Returns the root node of the complete tree
     */
    @Override
    public Node getBinaryTree() {
        return this.root;
    }

    /**
     * Returns a list with the values of the tree in preorder
     * @param node The node where it has to start
     * @return List of the values
     */
    @Override
    public List<Object> preorder(Node node) {
        if(node == null){
            return null;
        }
        if(node != null) {
            this.nodeList.add(node.getValue());
        }

        if(node.getLeftChild() != null){
            preorder(node.getLeftChild());
        }
        if(node.getRightChild() != null){
            preorder(node.getRightChild());
        }

        return this.nodeList;
    }


    /**
     * Returns a list with the values of the tree in inorder (Ordered)
     * @param node The node where it has to start
     * @return List of the values
     */

    @Override
    public List<Object> inorder(Node node) {
        if(node == null){
            return null;
        }

        if(node.getLeftChild() != null){
            inorder(node.getLeftChild());
        }
        if(node != null) {
            this.nodeList.add(node.getValue());
        }
        if(node.getRightChild() != null){
            inorder(node.getRightChild());
        }

        return this.nodeList;
    }


    /**
     * Returns a list with the values of the tree in postorder
     * @param node The node where it has to start
     * @return List of the values
     */
    @Override
    public List<Object> postorder(Node node) {
        if(node == null){
            return null;
        }
        if(node.getLeftChild() != null){
            postorder(node.getLeftChild());
        }
        if(node.getRightChild() != null){
            postorder(node.getRightChild());
        }
        if(node != null) {
            this.nodeList.add(node.getValue());
        }

        return this.nodeList;
    }

    /**
     * @return The number of nodes of the tree
     */
    @Override
    public Integer getSize() {
        return this.size;
    }

    @Override
    public void resetNodeList(){
        this.nodeList = new ArrayList<>();
    }

    // Auxiliar methods


    /**
     * Determines whether the node to be added is greater than the root node
     * @param root The root node
     * @param node The node to be adder
     * @return true whether the node's value is greater than the root's value
     */
    private boolean isGreater(Node root, Node node){
        return (Integer) node.getValue() > (Integer) root.getValue();
    }

    /**
     * Determines whether the node to be added is smaller than the root node
     * @param root The root node
     * @param node The node to be adder
     * @return true whether the node's value is smaller than the root's value
     */
    private boolean isSmaller(Node root, Node node){
        return (Integer) node.getValue() < (Integer) root.getValue();
    }

    /**
     * @param root The root when it starts searching
     * @return The minimum value of the right subtree of the current root
     */
    private Integer minRight(Node root) {
        int minValue = (Integer) root.getValue();
        while(root.getLeftChild() != null){
            minValue = (Integer)root.getLeftChild().getValue();
            root = root.getLeftChild();
        }

        return minValue;
    }
}
