package org.spartaglobal.controllers;

import java.util.Scanner;

public class SortManager {

    private Scanner userInput;
    int[] unsortedArray;

    public SortManager() {
        intialiseUserInputs();
    }
    //my method for initialising console input - create separate class for printing outputs later down the line

    private void intialiseUserInputs() {
        this.userInput = new Scanner(System.in);
        boolean runProgram = true;
        int optionchoice;

        while(runProgram) {
                System.out.println("Choose the following option for sort: \n 0: Quit the program  \n 1: Bubble Sort \n 2: Insertion Sort \n 3: Binary Tree");
           optionchoice = userInput.nextInt();
            if (optionchoice > 3 || optionchoice < 0) {
                System.out.println("You entered a wrong option that isn't available please try again");
            } else if (optionchoice == 0) {
                runProgram = false;
                System.out.println("You have decided to quit the program. Thank you for using this program");
            } else {
                SortFactory.getSorterAlgorithm(optionchoice, unsortedArray);
            }
        }

        //int optionNumber = userInput.nextInt();
        System.out.println("End of program");

    }


    }
