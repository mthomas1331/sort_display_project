package org.spartaglobal.controllers;
import org.spartaglobal.models.*;
import org.spartaglobal.models.BinaryTree.BinaryTree;


public class SortFactory {
    public static Sorter getSorterAlgorithm(int optionNumber, int[] unsortedArray) {

        if (optionNumber == 1 ) {
            return new BubbleSort(unsortedArray);
        } else if (optionNumber == 2) {
            return new InsertionSort(unsortedArray);
        } else if (optionNumber == 3) {
            return new BinaryTree(unsortedArray);
        }

        return null;
    }

}
