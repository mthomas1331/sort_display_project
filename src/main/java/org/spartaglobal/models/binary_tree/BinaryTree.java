package org.spartaglobal.models.binary_tree;
import org.spartaglobal.controllers.ChildNotFoundException;
import org.spartaglobal.controllers.ExecutionTime;
import org.spartaglobal.models.*;
import org.spartaglobal.views.PrintLoader;

/**
 * @implNote This is the class where the binary tree sort is applied
 *           This class is the outer class and makes use of the inner class Node
 *           methods for its own methods
 */
public class BinaryTree implements IBinaryTree, ISorter {
    //Inner class Node

    /**
     * @implNote This is the inner nested class Node which is responsible for
     *           assignment of the value of a node and for setting/getting the
     *           left or right child nodes
     */
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

    //outer class code starts here
    private Node rootNode;
    private int totalCount = 1, counterDecrement = 0;
    private int[] unsortedToSortedArray;

    /**
     * Constructor which is called from the {@link org.spartaglobal.controllers.SortFactory}
     * Implements the sort and outputs the result
     * @param unsortedArray initial random array
     */
    public BinaryTree(int[] unsortedArray) {
        try {
            addElements(unsortedArray);
            //This is initialised so that array can be sorted in ascending order
            //This is decrement not increment due to recursion used
            setTotalCount(unsortedArray.length);
            setUnsortedToSortedArray(getSortedTreeAsc());
            PrintLoader.printDisplaySortedArray(getUnsortedToSortedArray());
            PrintLoader.printExecutionTimeOfSortingAlgorithm(ExecutionTime.getTotalTimeOfExecution());
        } catch (NullPointerException e) {
            PrintLoader.nullPointerExceptionMessage(e);
        }
    }
    /**
     * the getter for array that is sorted
     * @return sorted array
     */
    public int[] getUnsortedToSortedArray() {
        return unsortedToSortedArray;
    }

    /**
     * the setter for the array that is sorted
     * @param sortedArray array that has been sorted
     */
    public void setUnsortedToSortedArray(int[] sortedArray) {
        this.unsortedToSortedArray = sortedArray;
    }

    /**
     * Interface method from {@link IBinaryTree}
     * @return root node value
     */
    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    /**
     * Interface method from {@link IBinaryTree}
     * @return no of nodes in binary tree
     */
    @Override
    public int getNumberOfElements() {
        return getCount();
    }

    /**
     *  Interface method from {@link IBinaryTree}
     * @param element value to be added to the binary tree
     */
    @Override
    public void addElement(final int element) {
        addNodeToTree(rootNode, element);
    }

    /**
     * Interface method from {@link IBinaryTree}
     * @param elements ann array of values to be added to the binary tree
     */
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

    /**
     *
     * @param element value that is an int type
     * @return boolean value if it is in the binary tree
     */
    @Override
    public boolean findElement(final int element){
        Node node = findNode(element);
        return node != null;
    }

    /**
     * This method checks whether the node with the value passed has a left child
     * If so, it returns the value
     * Testing for this is not implemented - will be added in the future iteration
     * @param element the value of the node to check which is an int
     * @return the value of the left child node also an int
     * @throws ChildNotFoundException Custom exception that is handled in the {@link ChildNotFoundException} class
     */
    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        try {
            Node currentNode = findNode(element);
            return currentNode.getLeftChild().getValue();
        } catch (NullPointerException e) {
            throw new ChildNotFoundException("Left Child Node does not exist for this element", e);
        }
    }

    /**
     * This method checks whether the node with the value passed has a right child
     * If so, it returns the value
     * Testing for this is not implemented - will be added in the future iteration
     * @param element the value of the node to check which is an int
     * @return the value of the left child node also an int
     * @throws ChildNotFoundException Custom exception that is handled in the {@link ChildNotFoundException} class
     */
    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        try {
            Node currentNode = findNode(element);
            return currentNode.getRightChild().getValue();
        } catch (NullPointerException e) {
            throw new ChildNotFoundException("Right Child Node does not exist for this element", e);
        }
    }

    /**
     * This method does the sorting for the binary tree.
     * It traverses the tree recursively using the {@link #recursiveCall(Node)} method
     * and adds the elements into an ascending ordered array which is returned.
     * @return ascending sorted int array
     */
    @Override
    public int[] getSortedTreeAsc() {
        unsortedToSortedArray = new int[getCount()];
        //counter is used from length of array and decremented due to recursion method
        counterDecrement = getCount() - 1;
        ExecutionTime.startTime = System.nanoTime();
        recursiveCall(rootNode);
        ExecutionTime.endTime = System.nanoTime();
        ExecutionTime.setTotalTimeOfExecution(ExecutionTime.startTime,ExecutionTime.endTime);
        return unsortedToSortedArray;
    }

    /**
     * This method makes use of the {@link #getSortedTreeAsc()} method and adds all the elements
     * in the reverse order which is then returned
     * @return descending sorted array
     */
    @Override
    public int[] getSortedTreeDesc() {
       int[] descSortedArray = new int[getCount()];
       int[] reverseArray = getSortedTreeAsc();
        for (int i = 0; i < reverseArray.length; i++) {
            descSortedArray[i] = reverseArray[getCount() - 1];
        }
        return descSortedArray;
    }

    //go through this method once again - convoluted understanding

   /**
    * This method checks whether left/right child node is empty and if not, it calls itself
    * by assigning the current node as the child node. It keeps doing this until there are
    * no more child nodes at which point it is added to the array.
    * @param currentNode starting node
    */
    private void recursiveCall(Node currentNode){
        //traverse through the right child nodes until the end
        if (!currentNode.isRightChildEmpty()){
            recursiveCall(currentNode.getRightChild());
        }
        //This algorithm finds the largest values by going down the right child nodes
        // and the node at the ned is added to the last position of the array.
        // It is then decremented and the process repeats until it reaches the beginning of the array
        unsortedToSortedArray[counterDecrement] = currentNode.getValue();
        counterDecrement--;
        //traverse through the left child nodes until the end
        if (!currentNode.isLeftChildEmpty()){
            recursiveCall(currentNode.getLeftChild());
        }
    }

    /**
     * Setter method for the root node
     * @param node the root node
     */
    private void setRootNode(Node node) {
        this.rootNode = node;
    }

    /**
     * Getter method that gets the size of the nodes in the binary tree
     * @return the total size of the tree
     */
    private int getCount() {
        return totalCount;
    }

    /**
     * This is the setter method for total count
     * @param totalCount total size of the tree
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * This method searches the tree until it finds the element and returns the Node object
     * @param element int value
     * @return Node of the value
     */
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

    /**
     * This method is responsible for adding a Node to the binary tree.
     * It makes use of recursion to put the element in the right part of the tree
     * @param node the current node - first one is the root node
     * @param element the value to be added to the binary tree
     */
    private void addNodeToTree(Node node, int element){
        if (element <= node.getValue()) {
            if(node.isLeftChildEmpty()){
                node.setLeftChild(new Node(element));
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else if (element > node.getValue()) {
            if (node.isRightChildEmpty()){
                node.setRightChild(new Node(element));
            } else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }

    /**
     * Interface method from {@link ISorter} class
     * @return a sorted int array
     */
    @Override
    public int[] sortArray() {
        return getUnsortedToSortedArray();
    }
}
