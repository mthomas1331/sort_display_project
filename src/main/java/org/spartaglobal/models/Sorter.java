package org.spartaglobal.models;

public class Sorter implements ISorter {

    private int[] sortedArray;

    public int[] getSortedArray() {
        return sortedArray;
    }

    public void setSortedArray(int[] sortedArray) {
        this.sortedArray = sortedArray;
    }

    @Override
    public int[] sortArray() {
        return getSortedArray();
    }
}
