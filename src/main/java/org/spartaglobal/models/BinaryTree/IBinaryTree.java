package org.spartaglobal.models.BinaryTree;

public interface IBinaryTree {
    int getRootElement();

    int getNumberOfElements();

    void addElement(int element);

    void addElements(final int[] elements);

    boolean findElement(int value);

    //int getLeftChild(int element) throws ChildNotFoundException;
    //int getRightChild(int element) throws ChildNotFoundException;

    int[] getSortedTreeAsc();

    int[] getSortedTreeDesc();

}
