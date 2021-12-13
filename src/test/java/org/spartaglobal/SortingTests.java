package org.spartaglobal;

import org.junit.jupiter.api.*;
import org.spartaglobal.controllers.SortFactory;
import org.spartaglobal.models.Sorter;

import java.util.Arrays;
import java.util.Random;

public class SortingTests {
    private int[] randomArray;
    private Sorter sortMethod;

    @BeforeEach
    void setup() {
        Random random = new Random();
        randomArray = new int[random.nextInt(10)];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(randomArray));
    }

    @Nested
    @DisplayName("Sorting Algorithm Test")
    /* This test can be used for all sorting algorithms
     * just change the value of option number as follows:
     *  1 - Bubble sort
     *  2 - Merge sort
     *  3 - Binary sort
     *  4 - Quick sort - if there is time do
     *  5 - Merge sort - if there is time do
     */
    class SortingAlgorithmTest {
        @Test
        @DisplayName("Normal Array Sized Sort Test")
        void normalArraySizedSortTest() {
            //this testing can be used for all sorts
            int[] testSortedArray = randomArray.clone();
            sortMethod =  SortFactory.getSorterAlgorithm(1, randomArray);
            Arrays.sort(testSortedArray);
            System.out.println(Arrays.toString(testSortedArray));
            Assertions.assertArrayEquals(testSortedArray, sortMethod.getSortedArray());
        }
        //Write exception handling code for null values and for file if I get to it

    }

}
