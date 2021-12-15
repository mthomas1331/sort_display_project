package org.spartaglobal.models.BinaryTree;
import org.spartaglobal.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//outer class BinaryTree
public class BinaryTree implements IBinaryTree, Sorter {


    //Inner class Node
    public static class Node {
        //outer class variable declaration
        private final int value;
        private Node leftChild, rightChild;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public boolean isLeftChildEmpty(){
            return leftChild == null;
        }

        public boolean isRightChildEmpty(){
            return rightChild == null;
        }
    }

    //outer class variable declaration
    private Node rootNode;
    private int totalCount = 1, counterDecrement = 0;
    //private List<Integer> intList;
    private int[] unsortedToSortedArray;

    public BinaryTree(int[] unsortedArray) {
        addElements(unsortedArray);
        //This is initialised so that array can be sorted in ascending order
        //This is decrement not increment due to recursion used
        setTotalCount(unsortedArray.length);
        unsortedToSortedArray = getSortedTreeAsc();
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return getCount();
    }

    @Override
    public void addElement(final int element) {
        addNodeToTree(rootNode, element);
    }


    @Override
    public void addElements(int[] elements) {
        for (int element : elements) {
            if (rootNode == null) {
                setRootNode(new Node(element));
            } else {
                addNodeToTree(rootNode, element);
            }
        }
    }

    @Override
    public boolean findElement(final int value){
        Node node = findNode(value);
        return node != null;
    }

    @Override
    public int[] getSortedTreeAsc() {
        //start new traversal code for binary tree
        unsortedToSortedArray = new int[getCount()];
        counterDecrement = getCount() - 1;
        //do execution time for traversal start here
        recursiveCall(rootNode);
        //end execution time for traversal
        return unsortedToSortedArray;
    }

    @Override
    public int[] getSortedTreeDesc() {
        int[] descSortedArray = new int[getCount()];
       int[] reverseArray = getSortedTreeAsc();
        for (int i = 0; i < reverseArray.length; i++) {
            descSortedArray[i] = reverseArray[getCount() - 1];
        }
        return descSortedArray;
    }

    @Override
    public int[] sortArray() {
        return getSortedTreeAsc();
    }

    //go through this method once again - convoluted understanding
    private void recursiveCall(Node currentNode){
        //traverse through the right child nodes until the end
        if (!currentNode.isRightChildEmpty()){
            recursiveCall(currentNode.getRightChild());
        }
        unsortedToSortedArray[counterDecrement] = currentNode.getValue();
        counterDecrement--;
        //traverse through the left child nodes until the end
        if (!currentNode.isLeftChildEmpty()){
            recursiveCall(currentNode.getLeftChild());
        }
    }

    private void setRootNode(Node node) {
        this.rootNode = node;
    }

    //getter method
    private int getCount() {
        return totalCount;
    }

    private Node findNode(int element){
        Node node = rootNode;
        while(node != null) {
            if (element == node.getValue()) {
                return node;
            }
            if (element < node.getValue()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return null;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    private void addNodeToTree(Node node, int element){
        if (element <= node.getValue()) {
            if(node.isLeftChildEmpty()){
                node.setLeftChild(new Node(element));
                //totalCount++;
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else if (element > node.getValue()) {
            if (node.isRightChildEmpty()){
                node.setRightChild(new Node(element));
                //totalCount++;
            } else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }


}
