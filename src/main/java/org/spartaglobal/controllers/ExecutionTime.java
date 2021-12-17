package org.spartaglobal.controllers;

/**
 * This class is used to measure the time it takes for the sort algorithms to run
 */
public class ExecutionTime {
    //Class that can be reused to confirm the time of executing the sorting algorithm
    static long totalTimeOfExecution;
    public static long startTime, endTime;


    /**
     * Getter method for total time of execution for the sort algorithm
     * @return the total time
     */
    public static long getTotalTimeOfExecution() {
        return totalTimeOfExecution;
    }

    /**
     * The setter method to assign total time of execution for the sort algorithm
     * @param startTime the time when sort is started
     * @param endTime the time when the sort is ended
     */
    public static void setTotalTimeOfExecution(long startTime, long endTime) {
        totalTimeOfExecution = endTime - startTime;
    }
}
