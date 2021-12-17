package org.spartaglobal.views;

import org.spartaglobal.models.binary_tree.BinaryTree;
import org.spartaglobal.models.BubbleSort;
import org.spartaglobal.models.MergeSort;

import java.util.Arrays;

/**
 * @implNote This is the printer class that is responsible for handling displaying messages to the console view
 *           These methods are split and called in the relevant classes that require outputs for users
 *
 */
public class PrintLoader {

    /**
     * This method is responsible for printing the first question that is provided for the user when starting the program
     * This is used in the {@link org.spartaglobal.controllers.SortManager} class
     */
    public static void printChoiceQuestion(){
       // System.out.println("Choose the following option for sort: \n 0: Quit the program  \n 1: Bubble Sort \n 2: Merge Sort \n 3: Binary Tree");
        System.out.println("Choose from the following options for a sorting algorithm: \n 0: Quit the program  \n 1: " + BubbleSort.class.getSimpleName() + "\n 2: " + MergeSort.class.getSimpleName() + "\n 3: " + BinaryTree.class.getSimpleName());
    }

    /**
     * This method is responsible for printing the message when the user inputs an incorrect value for the options
     * This is used in the {@link org.spartaglobal.controllers.SortManager} class
     */
    public static void printWrongOptionMessage() {
        System.out.println("You entered a wrong option that isn't available please try again");
    }

    /**
     * This method is responsible for printing the final message after the user has decided to quit by selecting 0.
     * This is used in the {@link org.spartaglobal.controllers.SortManager} class
     */
    public static void printExitMessage() {
        System.out.println("You have decided to quit the program. Thank you for using this program");
    }

    /**
     * This method is responsible for printing the initial unsorted array for the user.
     * @param unsortedArray the initial unsorted array
     * This is used in the {@link org.spartaglobal.controllers.SortFactory} class
     */
    public static void printDisplayUnsortedArray(int[] unsortedArray) {
        System.out.println("Initial random array: \n " + Arrays.toString(unsortedArray));
    }

    /**
     * This method is responsible for printing the sorted array for the user.
     * @param sortedArray the sorted array
     * This is used in the {@link org.spartaglobal.models.BubbleSort}, {@link org.spartaglobal.models.MergeSort} and {@link org.spartaglobal.models.binary_tree.BinaryTree} classes
     */
    public static void printDisplaySortedArray(int[] sortedArray) {
        System.out.println("Final sorted array: \n " + Arrays.toString(sortedArray));
    }

    /**
     * This method is responsible for printing the question that prompts the user to input the
     * size of the array
     */
    public static void printLengthOfArrayQuestion() {
        System.out.println("Enter the size of the array you want sorted: ");
    }

    /**
     * This method is responsible for printing the message that shows which sorter is being used
     * @param sorterName the name of the sorter used
     * This is used in the {@link org.spartaglobal.controllers.SortFactory} class
     *
     */
    public static void printSorterBeingUsed(String sorterName){
        System.out.println("Using " + sorterName + " to sort the array");
    }

    /**
     * This method is responsible for printing the execution time of the sort algorithm.
     * @param totalExecutionTime total time of the sort algorithm
     * This is used in the {@link org.spartaglobal.models.BubbleSort}, {@link org.spartaglobal.models.MergeSort} and {@link org.spartaglobal.models.binary_tree.BinaryTree} classes
     */
    public static void printExecutionTimeOfSortingAlgorithm(long totalExecutionTime) {
        System.out.println("Execution time of algorithm: " + totalExecutionTime + " nanoseconds");

    }

    /**
     * This method is called for Null pointer exceptions as a custom message
     * @param e NullPointException
     */
    public static void nullPointerExceptionMessage(NullPointerException e) {
        System.out.println("You have encountered a Null Point Exception. More details: \n" + e);
    }

}
