package org.spartaglobal.controllers;
import org.spartaglobal.models.*;
import org.spartaglobal.models.binary_tree.BinaryTree;
import org.spartaglobal.views.PrintLoader;

/**
 * @implSpec This is where the factory class is defined to access the rest of the sorter classes
 */
public class SortFactory {
    /**
     * This is the method in factory class that assigns which sorter is used depending
     * on the option chosen by the user.
     * 1 - Bubble Sort
     * 2 - Merge Sort
     * 3 - Binary Tree Sort
     * @param optionNumber - the number choice selected by the user in the {@link SortManager}
     * @param unsortedArray - the random array that is generated from the linkSortManager
     * @return ISorter - this is the sorting algorithm that the user selects
     */
    public static ISorter getSorterAlgorithm(int optionNumber, int[] unsortedArray) {
        //print initial array
        PrintLoader.printDisplayUnsortedArray(unsortedArray);
        //try catch null pointer exception here maybe
        //use another variable to pass sorted array so that it can be repeated
        int[] toBeSortedArray = unsortedArray.clone();
        if (optionNumber == 1 ) {
            PrintLoader.printSorterBeingUsed(BubbleSort.class.getSimpleName());
            return new BubbleSort(toBeSortedArray);
        } else if (optionNumber == 2) {
            PrintLoader.printSorterBeingUsed(MergeSort.class.getSimpleName());
            return new MergeSort(toBeSortedArray);
        } else if (optionNumber == 3) {
            PrintLoader.printSorterBeingUsed(BinaryTree.class.getSimpleName());
            return new BinaryTree(toBeSortedArray);
        } else {
            return null;
        }
    }
}
