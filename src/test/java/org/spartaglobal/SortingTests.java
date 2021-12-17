package org.spartaglobal;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.spartaglobal.controllers.SortFactory;
import org.spartaglobal.controllers.SortManager;
import org.spartaglobal.models.ISorter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SortingTests {
    private int[] randomArray;
    final int ARRAY_LIMIT = 100;
    final int LARGE_ARRAY_SIZE = 10000;
    int optionValue;
    ISorter sortMethod;

    /**
     * This is the setup before all the tests below are run
     * random array is initialised - maybe removed
     * optionValue variable - denotes the type of sorting implemented - refer below to change the type of sort
     * 1 - Bubble Sort
     * 2 - Merge Sort
     * 3 - Binary Tree Sort
     * Other options can be added here for other sorts - {@link SortManager} class will need editing to do so
     *
     */
    @BeforeEach
    void setup() {
        randomArray = SortManager.initialiseRandomArray(ARRAY_LIMIT);
        optionValue = 3;
    }
    /**
     * This method is used to pass an ArrayList of integers for the sorted array test
     *  {@link #alreadySortedArrayTest(ArrayList)}
     * @return Arraylist of sorted integers
     */
    public static Stream<ArrayList<Integer>> listOfSortedArray() {
        return Stream.of(new ArrayList<>(List.of(new Integer[]{Integer.MIN_VALUE, 1331, 500000, Integer.MAX_VALUE})));
    }
    /**
     * This method is used to pass an ArrayList of odd integers to check the sort test
     * {@link #oddArraySizeTest(ArrayList)}
     * @return Arraylist of 5 integers
     */
    public static Stream<ArrayList<Integer>> listOfOddSizedArray() {
        return Stream.of(new ArrayList<>(List.of(new Integer[]{-50, Integer.MAX_VALUE, 500000, 1441, Integer.MIN_VALUE})));
    }
    /**
     * This method is used to pass an ArrayList of duplicated values to check sort test
     * {@link #duplicateValuesTest(ArrayList)}
     * @return Arraylist of duplicated values
     */
    public static Stream<ArrayList<Integer>> listOfDuplicateValues() {
        return Stream.of(new ArrayList<>(List.of(new Integer[]{13, 23, 13, 5, 7, 23, 13, 101, 12, 13})));
    }

    /**
     * This method converts the ArrayList of integers into a primitive int array to be used for the sort tests
     * {@link #oddArraySizeTest}, {@link #alreadySortedArrayTest(ArrayList)}, {@link #duplicateValuesTest(ArrayList)}
     * are methods that make use of this
     * @param inputArr an ArrayList of integers
     * @return an int[] array of integers
     */
    static int[] arrayListIntoIntArray(ArrayList<Integer> inputArr) {
        Integer[] sortedArr = inputArr.toArray(new Integer[0]);
        int[] arrCheck = new int[inputArr.size()];
        for (int i = 0; i < inputArr.size(); i++) {
            arrCheck[i] = sortedArr[i];
        }
        return arrCheck;
    }
    /**
     * This is the base test for all sort algorithms
     */
    @Test
    @DisplayName("Normal Array Sized Sort Test")
    void normalArraySizedSortTest() {
        //this testing can be used for all sorts
        int[] testSortedArray = randomArray.clone();
        sortMethod = SortFactory.getSorterAlgorithm(optionValue, randomArray);
        Arrays.sort(testSortedArray);
        assert sortMethod != null;
        Assertions.assertArrayEquals(testSortedArray, sortMethod.sortArray());
    }
    /**
     * This test checks whether odd sized array passed into the sort algorithm works
     * Especially useful to test the merge algorithm
     * @param inputArr ArrayList of integers
     */
    @ParameterizedTest
    @MethodSource("listOfOddSizedArray")
    @DisplayName("Odd array size test ")
    void oddArraySizeTest(ArrayList<Integer> inputArr) {
        int[] checkOddArr = arrayListIntoIntArray(inputArr);
        sortMethod = SortFactory.getSorterAlgorithm(optionValue, checkOddArr);
        Arrays.sort(checkOddArr);
        assert sortMethod != null;
        Assertions.assertArrayEquals(checkOddArr, sortMethod.sortArray());
    }
    /**
     * This test checks whether an already sorted array still works when entered into the sort algorithm
     * @param inputArr ArrayList of integers
     */
    @ParameterizedTest
    @MethodSource("listOfSortedArray")
    @DisplayName("Already sorted array test")
    void alreadySortedArrayTest(ArrayList<Integer> inputArr) {
        int[] sortedArr = arrayListIntoIntArray(inputArr);
        sortMethod = SortFactory.getSorterAlgorithm(optionValue, sortedArr);
        assert sortMethod != null;
        Assertions.assertArrayEquals(sortedArr, sortMethod.sortArray());
    }
    /**
     * This test checks whether duplicated values in the array will still be sorted correctly
     * @param inputArr ArrayList of integers
     */
    @ParameterizedTest
    @MethodSource("listOfDuplicateValues")
    @DisplayName("Duplicate values Test")
    void duplicateValuesTest(ArrayList<Integer> inputArr) {
        int[] duplicateArr = arrayListIntoIntArray(inputArr);
        sortMethod = SortFactory.getSorterAlgorithm(optionValue, duplicateArr);
        Arrays.sort(duplicateArr);
        assert sortMethod != null;
        Assertions.assertArrayEquals(duplicateArr, sortMethod.sortArray());
    }

    /**
     * This test checks if the sort algorithm can still work on a single element
     */
    @Test
    @DisplayName("Single Value Test")
    void singleValueTest() {
        int[] singleElementArray = {1};
        sortMethod = SortFactory.getSorterAlgorithm(optionValue, singleElementArray);
        assert sortMethod != null;
        Assertions.assertArrayEquals(singleElementArray, sortMethod.sortArray());
    }
    /**
     * This test checks if sort can be applied to a large sized array
     */
    @Test
    @DisplayName("Large Array Test")
    void largeArrayTest() {
        int[] largeArray = SortManager.initialiseRandomArray(LARGE_ARRAY_SIZE);
        sortMethod = SortFactory.getSorterAlgorithm(optionValue, largeArray);
        Arrays.sort(largeArray);
        assert sortMethod != null;
        Assertions.assertArrayEquals(largeArray, sortMethod.sortArray());
    }

    @AfterEach
    void tearDown(){
        System.out.println("Finished one test");
    }

    @AfterAll
    static void tearDownAll(TestInfo testInfo){
        System.out.println("All the tests are complete");
    }


}
