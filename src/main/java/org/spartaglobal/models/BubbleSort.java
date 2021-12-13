package org.spartaglobal.models;
public class BubbleSort extends Sorter {

   // public static int swapCount = 0;
   // private static int itrCount = 0;
   // private static long totalTime = 0;
    private final int[] unsortedArrayToSortedArray;

    public BubbleSort(int[] unsortedArray) {
        this.unsortedArrayToSortedArray = unsortedArray;
        sortArray();
    }

    public static int[] bubbleSort(int[] integers){
        //long timeStart = System.nanoTime();
        for (int i = 0; i < integers.length; i++) {
            for (int j = 0; j < integers.length; j++) {
                if (integers[i] < integers[j]) {
                    swapNumbers(integers, i, j);
                }
                //itrCount++;
            }
        }
        //long timeEnd = System.nanoTime();
        //totalTime = (timeEnd - timeStart) / 1000000;
        return integers;
    }

    //swapping numbers split to another method which is called in the BubbleSort algorithm
    private static void swapNumbers(int[] integers, int i, int j) {
        int temp;
        temp = integers[j];
        integers[j] = integers[i];
        integers[i] = temp;
        //swapCount++;
    }

    //can be used to check number of time swaps occur in the algorithm -
    //only do this if it doesn't break encapsulation
    /*public static int getSwapCount() {
        return swapCount;
    }*/

    //can be used to check the number of iterations taking place in the algorithm
    //only do this if it doesn't break encapsulation
    /*public static int getItrCount() {
        return itrCount;
    }*/

    @Override
    public int[] sortArray() {
        setSortedArray(bubbleSort(unsortedArrayToSortedArray));
        return getSortedArray();
    }

}
