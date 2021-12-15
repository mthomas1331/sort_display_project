package org.spartaglobal.controllers;
import org.spartaglobal.views.PrintLoader;
import java.util.Random;
import java.util.Scanner;

public class SortManager {

    public static void initialiseUserInputs() {
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

    //Initiate a random array to be used for the sort at runtime
    public static int[] initialiseRandomArray(int arraySizeLimit){
        Random random = new Random();
        int[] randomArray = new int[random.nextInt(arraySizeLimit)];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(arraySizeLimit);
        }
        return randomArray;
    }

}
