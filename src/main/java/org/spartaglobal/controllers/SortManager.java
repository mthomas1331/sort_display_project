package org.spartaglobal.controllers;
import org.spartaglobal.views.PrintLoader;
import java.util.Random;
import java.util.Scanner;

/**
 * @implNote This is where the bulk of the program is called to run from App
 *
 */
public class SortManager {

    static final int LIMIT = 100;
    /**
     * This is method called which allows the program to receive inputs from the user
     * and display the output accordingly.
     * There is a while loop that keeps running the program until the user enters 0 which is the quit command
     * User can currently only select 1, 2, 3 as numbers to proceed with rest of the program
     */
    public static void initialiseUserInputs(){
        //open scanner class connection
        Scanner userInput = new Scanner(System.in);
        boolean runProgram = true;
        int optionChoice, arraySizeChoice;
        while (runProgram) {
            PrintLoader.printChoiceQuestion();
            optionChoice = userInput.nextInt();
            if (optionChoice > 3 || optionChoice < 0) {
                PrintLoader.printWrongOptionMessage();
            } else if (optionChoice == 0) {
                runProgram = false;
                PrintLoader.printExitMessage();
            } else {
                PrintLoader.printLengthOfArrayQuestion();
                arraySizeChoice = userInput.nextInt();
                SortFactory.getSorterAlgorithm(optionChoice, initialiseRandomArray(arraySizeChoice));
            }
        }
        //always close connection after opening it
        userInput.close();
    }

    /**
     * This method is used to generate a random array for the program to use as the initial array
     * @param arraySizeLimit Size of the array
     * @return int random array of {@param arraySizeLimit}
     */
    public static int[] initialiseRandomArray(int arraySizeLimit){
        Random random = new Random();
        int[] randomArray = new int[arraySizeLimit];
        try {
            for (int i = 0; i < randomArray.length; i++) {
                randomArray[i] = random.nextInt(LIMIT);
            }
        } catch (NullPointerException e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println("Start the program again");
            initialiseUserInputs();
        }
        return randomArray;
    }
}
