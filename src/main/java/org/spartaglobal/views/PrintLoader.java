package org.spartaglobal.views;

import org.spartaglobal.models.BinaryTree.BinaryTree;
import org.spartaglobal.models.BubbleSort;
import org.spartaglobal.models.MergeSort;

import java.util.Arrays;

public class PrintLoader {

    public static void printChoiceQuestion(){
       // System.out.println("Choose the following option for sort: \n 0: Quit the program  \n 1: Bubble Sort \n 2: Merge Sort \n 3: Binary Tree");
        System.out.println("Choose from the following options for a sorting algorithm: \n 0: Quit the program  \n 1: " + BubbleSort.class.getSimpleName() + "\n 2: " + MergeSort.class.getSimpleName() + "\n 3: " + BinaryTree.class.getSimpleName());
    }

    public static void printWrongOptionMessage() {
        System.out.println("You entered a wrong option that isn't available please try again");
    }

    public static void printExitMessage() {
        System.out.println("You have decided to quit the program. Thank you for using this program");
    }

    public static void printDisplayUnsortedArray(int[] unsortedArray) {
        System.out.println("Initial random array: \n " + Arrays.toString(unsortedArray));
    }

    public static void printDisplaySortedArray(int[] sortedArray) {
        System.out.println("Final sorted array: \n " + Arrays.toString(sortedArray));
    }

    public static void printExecutionTimeOfSortingAlgorithm(long totalExecutionTime) {
        System.out.println("Execution time of algorithm: " + totalExecutionTime + " nanoseconds");

    }

    public static void printLengthOfArrayQuestion() {
        System.out.println("Enter the size of the array you want sorted: ");
    }

    public static void printSorterBeingUsed(String sorterName){
        System.out.println("Using " + sorterName + " to sort the array");
    }




}
