package com.binarytree;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author oscarmalagon
 * @since 9/3/17.
 */
class BinaryTreeImplTest {


    private BinaryTree<Integer> bst;

    @Test
    void addNode() {
        fillTree();
        assertEquals(new Integer(9), bst.getSize());
    }

    private void fillTree() {
        bst = new BinaryTreeImpl();
        bst.addNode(getNode(7));
        bst.addNode(getNode(3));
        bst.addNode(getNode(1));
        bst.addNode(getNode(5));
        bst.addNode(getNode(11));
        bst.addNode(getNode(15));
        bst.addNode(getNode(9));
        bst.addNode(getNode(6));
        bst.addNode(getNode(8));
    }


    private void fillTreeToRemoveNodeThatHasNoRightChild() {
        bst = new BinaryTreeImpl();
        bst.addNode(getNode(4));
        bst.addNode(getNode(2));
        bst.addNode(getNode(1));
        bst.addNode(getNode(3));
        bst.addNode(getNode(8));
        bst.addNode(getNode(6));
        bst.addNode(getNode(5));
        bst.addNode(getNode(7));
    }

    private void fillToRemoveWith2Children() {
        bst = new BinaryTreeImpl();
        bst.addNode(getNode(12));
        bst.addNode(getNode(5));
        bst.addNode(getNode(3));
        bst.addNode(getNode(7));
        bst.addNode(getNode(1));
        bst.addNode(getNode(9));
        bst.addNode(getNode(8));
        bst.addNode(getNode(11));
        bst.addNode(getNode(14));
        bst.addNode(getNode(13));
        bst.addNode(getNode(17));
    }



    @Test
    void removeNodeLeaf() {
        fillTree();
        System.out.println(bst.inorder(bst.getBinaryTree()));
        bst.resetNodeList();
        bst.removeNode(getNode(15));
        bst.removeNode(getNode(1));
        System.out.println(bst.inorder(bst.getBinaryTree()));
        assertEquals(new Integer(7), bst.getSize());
    }

    @Test
    void removeNodeThatHasNoRightChild(){
        fillTreeToRemoveNodeThatHasNoRightChild();
        bst.removeNode(getNode(8));

        assertNull(bst.searchNode(8));
        System.out.println(bst.inorder(bst.getBinaryTree()));
        assertEquals(new Integer(7), bst.getSize());
    }

    @Test
    void removeRoot(){
        fillTreeToRemoveNodeThatHasNoRightChild();
        bst.removeNode(getNode(4));

        assertNull(bst.searchNode(4));
        System.out.println(bst.inorder(bst.getBinaryTree()));
        assertEquals(new Integer(7), bst.getSize());
    }

    @Test
    void removeWith2Children(){
        fillToRemoveWith2Children();
        bst.removeNode(getNode(5));

        assertNull(bst.searchNode(5));
        System.out.println(bst.inorder(bst.getBinaryTree()));
        assertEquals(new Integer(10), bst.getSize());
    }

    @Test
    void removeAllNodes(){
        fillTree();
        bst.removeNode(getNode(7));
        bst.removeNode(getNode(3));
        bst.removeNode(getNode(1));
        bst.removeNode(getNode(5));
        bst.removeNode(getNode(11));
        bst.removeNode(getNode(15));
        bst.removeNode(getNode(9));
        bst.removeNode(getNode(6));
        bst.removeNode(getNode(8));

        System.out.println(bst.inorder(bst.getBinaryTree()));
        assertNull(bst.getBinaryTree());
    }


    @Test
    void searchNode() {
        fillTree();
        Node value = bst.searchNode(1);
        assertEquals(1, value.getValue());
    }

    @Test
    void preorder() {
        fillTree();
        List<Object> values = bst.preorder(bst.getBinaryTree());
        List<Object> expected = Arrays.asList(7,3,1,5,6,11,9,8,15);
        assertEquals(expected, values);
    }

    @Test
    void inorder() {
        fillTree();
        List<Object> values = bst.inorder(bst.getBinaryTree());
        List<Object> expected = Arrays.asList(1,3,5,6,7,8,9,11,15);
        assertEquals(expected, values);
    }

    @Test
    void postorder() {
        fillTree();
        List<Object> values = bst.postorder(bst.getBinaryTree());
        List<Object> expected = Arrays.asList(1,6,5,3,8,9,15,11,7);
        assertEquals(expected, values);
    }

    @Before
    void setUp(){
        bst.resetNodeList();
    }

    @After
    public void tearDown(){
        bst = null;
    }


    public Node<Integer> getNode(Integer value){
        return new Node<>(null, null, value);
    }
}
