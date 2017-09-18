package com.binarytree;

import java.util.List;

/**
 * @author oscarmalagon
 * @since 9/3/17.
 */
interface BinaryTree <T extends Object>{

    void addNode(Node<T> node);

    void removeNode(Node<T> node);

    Node searchNode(T value);

    Node getBinaryTree();

    List<Object> preorder(Node<T> node);

    List<Object> inorder(Node<T> node);

    List<Object> postorder(Node<T> node);

    Integer getSize();

    void resetNodeList();
}
