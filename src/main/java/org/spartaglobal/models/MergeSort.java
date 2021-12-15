package org.spartaglobal.models;

import org.spartaglobal.controllers.ExecutionTime;
import org.spartaglobal.views.PrintLoader;

public class MergeSort implements ISorter {

    private int[] finalSortedArray;

    public MergeSort(int[] unsortedArray) {
        setFinalSortedArray(mergeSort(unsortedArray, unsortedArray.length));;
        PrintLoader.printDisplaySortedArray(getFinalSortedArray());
        PrintLoader.printExecutionTimeOfSortingAlgorithm(ExecutionTime.getTotalTimeOfExecution());
    }

    public int[] mergeSort(int[] arrayToBeSorted, int endPos) {
        //If elements in the array is less than too, skip the rest of the algorithm
        if (arrayToBeSorted.length < 2) {
            return arrayToBeSorted;
        }
        //Find the middle point of the array
        int midPos = endPos / 2;
        int[] leftArray = new int[midPos];
        int[] rightArray = new int[arrayToBeSorted.length - midPos];
        //assign values either side of the midpoint to two separate arrays
        System.arraycopy(arrayToBeSorted, 0, leftArray, 0, leftArray.length);
        System.arraycopy(arrayToBeSorted, midPos, rightArray, 0, rightArray.length);
        //Start execution time
        ExecutionTime.startTime = System.nanoTime();
        //Recursive call on each divided array until there are two elements in the array
        mergeSort(leftArray, leftArray.length);
        mergeSort(rightArray, rightArray.length);
        //This method merges the left and right half of the arrays to for the sorted array
        mergeArray(arrayToBeSorted, leftArray, rightArray, leftArray.length, rightArray.length);
        //end execution time
        ExecutionTime.endTime = System.nanoTime();
        ExecutionTime.setTotalTimeOfExecution(ExecutionTime.startTime, ExecutionTime.endTime);

        return arrayToBeSorted;
    }

    //merge part of the algorithm used
    private static void mergeArray(int[] mergeArray, int[] leftArray, int[] rightArray, int lenOfLeftArray, int lenOfRightArray) {
        //Iterate through each array separately
        int leftArrayCounter = 0;
        int rightArrayCounter = 0;
        int mergeArrayCounter = 0;
        //while both counters are less than the array size of left array and right array
        //compare values from both arrays to order them in ascending order
        while (leftArrayCounter < lenOfLeftArray && rightArrayCounter < lenOfRightArray) {
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
        while (leftArrayCounter < lenOfLeftArray) {
            mergeArray[mergeArrayCounter] = leftArray[leftArrayCounter];
            mergeArrayCounter++;
            leftArrayCounter++;
        }
        //if there are any elements remaining in the right array add them to the main merge array
        while (rightArrayCounter < lenOfRightArray) {
            mergeArray[mergeArrayCounter] = rightArray[rightArrayCounter];
            mergeArrayCounter++;
            rightArrayCounter++;
        }
        //setFinalSortedArray(finalSortedArray);
    }

    //setter
    public void setFinalSortedArray(int[] finalSortedArray) {
        this.finalSortedArray = finalSortedArray;
    }

    //getter
    public int[] getFinalSortedArray() {
        return finalSortedArray;
    }

    //Interface method used for testing purposes
    @Override
    public int[] sortArray() {
        return getFinalSortedArray();
    }
}
