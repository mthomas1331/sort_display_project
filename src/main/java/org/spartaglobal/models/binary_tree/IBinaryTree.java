package org.spartaglobal.models.binary_tree;
import org.spartaglobal.controllers.ChildNotFoundException;

/**
 * @implNote This is the binary tree interface that provides the methods that needs to be utilised
 *           by the binary tree class. Not all the methods are tested however this is something that will require
 *           updating in the future.
 */
public interface IBinaryTree {
    int getRootElement();

    int getNumberOfElements();

    void addElement(int element);

    void addElements(final int[] elements);

    boolean findElement(int element);

    int getLeftChild(int element) throws ChildNotFoundException;

    int getRightChild(int element) throws ChildNotFoundException;

    int[] getSortedTreeAsc();

    int[] getSortedTreeDesc();

}
