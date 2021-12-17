package org.spartaglobal.controllers;

public class ExecutionTime {
    //Class that can be reused to confirm the time of executing the sorting algorithm
    static long totalTimeOfExecution;
    public static long startTime, endTime;

    public static long getTotalTimeOfExecution() {
        return totalTimeOfExecution;
    }

    public static void setTotalTimeOfExecution(long startTime, long endTime) {
        totalTimeOfExecution = endTime - startTime;
    }
}
