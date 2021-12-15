package org.spartaglobal.models;

import java.util.Arrays;

public class MergeSort implements Sorter {

    private int[] finalSortedArray;

    public void setFinalSortedArray(int[] finalSortedArray) {
        this.finalSortedArray = finalSortedArray;
    }

    public int[] getFinalSortedArray() {
        return finalSortedArray;
    }

    public MergeSort(int[] unsortedArray) {
        mergeSort(unsortedArray, 0, unsortedArray.length);

    }

    public void mergeSort(int[] arrayToBeSorted, int startPos, int endPos) {
        //If elements in the array is less than too, skip the rest of the algorithm
        if (arrayToBeSorted.length < 2) {
            return;
        }

        //Find the middle point of the array
        int midPos = endPos / 2;
        int[] leftArray = new int[midPos];
        int[] rightArray = new int[arrayToBeSorted.length - midPos];

        //assign values either side of the midpoint to two separate arrays
        System.arraycopy(arrayToBeSorted, 0, leftArray, 0, leftArray.length);
        System.arraycopy(arrayToBeSorted, midPos, rightArray, 0, rightArray.length);

        //Recursive call on each divided array unitil there are two elements in the array
        mergeSort(leftArray, 0, leftArray.length);
        mergeSort(rightArray, 0, rightArray.length);
        //This method merges the left and right half of the arrays to for the sorted array
        mergeArray(arrayToBeSorted, leftArray, rightArray, leftArray.length, rightArray.length);
        setFinalSortedArray(arrayToBeSorted);
        //return finalSortedArray;
    }

    private static void mergeArray(int[] mergeArray, int[] leftArray, int[] rightArray, int lenOfLeftArray, int lenOfRightArray) {
        //Iterate through each array separately
        int leftArrayCounter = 0;
        int rightArrayCounter = 0;
        int mergeArrayCounter = 0;

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

        while (leftArrayCounter < lenOfLeftArray) {
            mergeArray[mergeArrayCounter] = leftArray[leftArrayCounter];
            mergeArrayCounter++;
            leftArrayCounter++;
        }

        while (rightArrayCounter < lenOfRightArray) {
            mergeArray[mergeArrayCounter] = rightArray[rightArrayCounter];
            mergeArrayCounter++;
            rightArrayCounter++;
        }

        //setFinalSortedArray(finalSortedArray);
    }

    @Override
    public int[] sortArray() {
        return getFinalSortedArray();
    }
}
