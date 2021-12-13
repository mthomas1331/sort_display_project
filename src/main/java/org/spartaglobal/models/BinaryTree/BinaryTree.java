package org.spartaglobal.models.BinaryTree;
import org.spartaglobal.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//outer class BinaryTree
public class BinaryTree extends Sorter implements IBinaryTree{
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
    private List<Integer> intList;
    private int[] unsortedToSortedArray;

    public BinaryTree(int[] unsortedArray) {
        this.unsortedToSortedArray = unsortedArray;
        addElements(unsortedToSortedArray);
        //This is initialised so that array can be sorted in ascending order
        //This is decrement not increment due to recursion used
        counterDecrement = getCount() - 1;
        getSortedTreeAsc();
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
        //do execution time for traversal start here

        recursiveCall(rootNode);
        //end execution time for traversal
        setSortedArray(unsortedToSortedArray);


        //returns the convert to int array method
        //return convertToIntArray(intList);
        return getSortedArray();
    }

    @Override
    public int[] getSortedTreeDesc() {
        intList = new ArrayList<>();
        //recursive method call
        recursiveCall(rootNode);
        //easy sort to descending order
        intList.sort(Collections.reverseOrder());
        //returns the convert to int array method
        return convertToIntArray(intList);
    }

    //method for converting into int array from List
    private int[] convertToIntArray(List<Integer> intList){
        int itr = 0;
        int[] sortedArray = new int[intList.size()];
        //convert into int array from list
        for (Integer value: intList) {
            sortedArray[itr] = value;
            itr++;
        }
        return sortedArray;
    }

    //go through this method once again - convoluted understanding
    private void recursiveCall(Node currentNode){
        //traverse through the right child nodes until the end
        if (!currentNode.isRightChildEmpty()){
            recursiveCall(currentNode.getRightChild());
        }
        //add to List here as the code should go through here all the time.
        //intList.add(currentNode.getValue());
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

    private void addNodeToTree(Node node, int element){
        if (element <= node.getValue()) {
            if(node.isLeftChildEmpty()){
                node.setLeftChild(new Node(element));
                totalCount++;
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else if (element > node.getValue()) {
            if (node.isRightChildEmpty()){
                node.setRightChild(new Node(element));
                totalCount++;
            } else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }


}
