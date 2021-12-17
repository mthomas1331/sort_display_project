package org.spartaglobal.models;
import org.spartaglobal.controllers.ExecutionTime;
import org.spartaglobal.views.PrintLoader;

/**
 * @implNote This is the class where the bubble sort is implemented
 *           it makes use of a simple swap function, but it is the slowest
 *           compared to other sorting algorithms
 */
public class BubbleSort implements ISorter {
    private int[] unsortedArrayToSortedArray;

    /**
     * Constructor which is called from the {@link org.spartaglobal.controllers.SortFactory}
     * Implements the sort and outputs the result
     * @param unsortedArray initial random array
     */
    public BubbleSort(int[] unsortedArray) {
        try {
            setUnsortedArrayToSortedArray(bubbleSortAlgorithm(unsortedArray));
            PrintLoader.printDisplaySortedArray(getUnsortedArrayToSortedArray());
            PrintLoader.printExecutionTimeOfSortingAlgorithm(ExecutionTime.getTotalTimeOfExecution());
        } catch (NullPointerException e) {
                e.getLocalizedMessage();
        }
      }

    /**
     * This method implements the bubble sort algorithm which makes use of 2 for loops and a swap method {@link #swapNumbers(int[], int, int)}
     * @param arrayToBeSorted unsorted initial array
     * @return sorted int array
     */
    public int[] bubbleSortAlgorithm(int[] arrayToBeSorted){
        ExecutionTime.startTime = System.nanoTime();
        for (int i = 0; i < arrayToBeSorted.length; i++) {
            for (int j = 0; j < arrayToBeSorted.length; j++) {
                if (arrayToBeSorted[i] < arrayToBeSorted[j]) {
                    swapNumbers(arrayToBeSorted, i, j);
                }
            }
        }
        ExecutionTime.endTime = System.nanoTime();
        ExecutionTime.setTotalTimeOfExecution(ExecutionTime.startTime, ExecutionTime.endTime);
        return arrayToBeSorted;
    }

    /**
     * This method is extracted from the {@link #bubbleSortAlgorithm(int[])} to make the code more readable.
     * The index of the elements are used to get the values from the array, compare them and sort them in ascending order
     * @param arrayToBeSorted array passed from {@link #bubbleSortAlgorithm(int[])}
     * @param i the index of the element 1
     * @param j the index of element 2
     */
    private void swapNumbers(int[] arrayToBeSorted, int i, int j) {
        int temp;
        temp = arrayToBeSorted[j];
        arrayToBeSorted[j] = arrayToBeSorted[i];
        arrayToBeSorted[i] = temp;
    }

    /**
     * The getter for the sorted array
     * @return sorted int array
     */
    public int[] getUnsortedArrayToSortedArray() {
        return unsortedArrayToSortedArray;
    }

    /**
     * The setter for the sorted array
     * @param unsortedArrayToSortedArray sorted array
     */
    public void setUnsortedArrayToSortedArray(int[] unsortedArrayToSortedArray) {
        this.unsortedArrayToSortedArray = unsortedArrayToSortedArray;
    }

    /**
     * Interface method from {@link ISorter} class
     * @return a sorted int array
     */
    @Override
    public int[] sortArray() {
        return getUnsortedArrayToSortedArray();
    }
}
