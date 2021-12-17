package org.spartaglobal.models;

import org.spartaglobal.controllers.ExecutionTime;
import org.spartaglobal.views.PrintLoader;

/**
 * @implNote This is the class where the merge sort is applied
 *           This uses the divide and conquer algorithm which is shown in the methods below
 */
public class MergeSort implements ISorter {
    private int[] finalSortedArray;

    /**
     * Constructor which is called from the {@link org.spartaglobal.controllers.SortFactory}
     * Implements the sort and outputs the result
     * @param unsortedArray initial random array
     */
    public MergeSort(int[] unsortedArray) {
        try {
            setFinalSortedArray(mergeSortAlgorithm(unsortedArray, unsortedArray.length));
            PrintLoader.printDisplaySortedArray(getFinalSortedArray());
            PrintLoader.printExecutionTimeOfSortingAlgorithm(ExecutionTime.getTotalTimeOfExecution());
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    /**
     * This is the divide part of the algorithm is mainly done. The unsorted array is passed into the method,
     * the middle of the array is calculated and split into 2 arrays that holds the values either side of the midpoint. 
     * This process is done recursively until there are only 2 elements in each array which are then compared with each other. 
     * This is done in the {@link #mergeArrayProcess(int[], int[], int[])} method.
     * @param arrayToBeSorted unsorted initial array
     * @param endPos length of the current array
     * @return the final sorted array
     */
    public int[] mergeSortAlgorithm(int[] arrayToBeSorted, int endPos) {
        //If elements in the array is less than 2, skip the rest of the algorithm
        if (arrayToBeSorted.length < 2) {
            return arrayToBeSorted;
        }
        //Find the middle pivot of the array
        int midPos = endPos / 2;
        int[] leftArray = new int[midPos];
        int[] rightArray = new int[arrayToBeSorted.length - midPos];
        //assign values either side of the midpoint to two separate arrays
        System.arraycopy(arrayToBeSorted, 0, leftArray, 0, leftArray.length);
        System.arraycopy(arrayToBeSorted, midPos, rightArray, 0, rightArray.length);
        //Start execution time
        ExecutionTime.startTime = System.nanoTime();
        //Recursive call on each divided array until there are two elements in the array
        mergeSortAlgorithm(leftArray, leftArray.length);
        mergeSortAlgorithm(rightArray, rightArray.length);
        //This method merges the left and right half of the arrays to for the sorted array
        mergeArrayProcess(arrayToBeSorted, leftArray, rightArray);
        //end execution time
        ExecutionTime.endTime = System.nanoTime();
        ExecutionTime.setTotalTimeOfExecution(ExecutionTime.startTime, ExecutionTime.endTime);

        return arrayToBeSorted;
    }

    /**
     * This is the merge part of the algorithm which compares the two arrays passed and orders them in
     * ascending order. This is then return to the {@link #mergeSortAlgorithm(int[], int)} method.
     * @param mergeArray the sorted array to be populated
     * @param leftArray the left sub-array
     * @param rightArray the right sub-array
     */
    private static void mergeArrayProcess(int[] mergeArray, int[] leftArray, int[] rightArray) {
        //Iterate through each array separately
        int leftArrayCounter = 0, rightArrayCounter = 0, mergeArrayCounter = 0;

        //while both counters are less than the array size of left array and right array
        //compare values from both arrays to order them in ascending order
        while (leftArrayCounter < leftArray.length && rightArrayCounter < rightArray.length) {
            if (leftArray[leftArrayCounter] <= rightArray[rightArrayCounter]) {
                mergeArray[mergeArrayCounter] = leftArray[leftArrayCounter];
                leftArrayCounter++;
            } else {
                mergeArray[mergeArrayCounter] = rightArray[rightArrayCounter];
                rightArrayCounter++;
            }
            mergeArrayCounter++;
        }
        //if there are any elements remaining in the left array add them to the main merge array
        while (leftArrayCounter < leftArray.length) {
            mergeArray[mergeArrayCounter] = leftArray[leftArrayCounter];
            mergeArrayCounter++;
            leftArrayCounter++;
        }
        //if there are any elements remaining in the right array add them to the main merge array
        while (rightArrayCounter < rightArray.length) {
            mergeArray[mergeArrayCounter] = rightArray[rightArrayCounter];
            mergeArrayCounter++;
            rightArrayCounter++;
        }
    }

    /**
     * The setter for the sorted array
     * @param finalSortedArray the sorted array to be set
     */
    public void setFinalSortedArray(int[] finalSortedArray) {
        this.finalSortedArray = finalSortedArray;
    }

    /**
     * The getter for the sorted array
     * @return a sorted int array
     */
    public int[] getFinalSortedArray() {
        return finalSortedArray;
    }

    /**
     * Interface method from {@link ISorter} class
     * @return a sorted int array
     */
    @Override
    public int[] sortArray() {
        return getFinalSortedArray();
    }
}
