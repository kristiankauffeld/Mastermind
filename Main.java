package com.company;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        Integer[] colorpattern = new Integer[6];
        Integer[] guess = new Integer[6];

        int turnlimit = 10;
        int blackkeypeg;
        int whitekeypeg;

        //Inserts random numbers between 0-6 into the codepattern array:
        for (int i = 0; i < colorpattern.length; i++) {
            colorpattern[i] = i;
        }

        //The built in Collections class and shuffle method randomizes the numbers in the color pattern array. It also makes sure the same number is not repeated twice in color pattern.
        Collections.shuffle(Arrays.asList(colorpattern));
        //System.out.println(Arrays.toString(colorpattern));

        System.out.println("----Welcome to Mastermind----");
        System.out.println();
        System.out.println("You have to guess a pattern of 6 random numbers in the correct order.");
        System.out.println("You have 10 attempts. Each time you guess you will recieve a colored or white key peg.");
        System.out.println("Lets begin!");
        System.out.println();

        Scanner in = new Scanner(System.in);

//Gives the player 10 turns
        for (int h = 0; h < turnlimit; h++) {
            blackkeypeg = 0;
            whitekeypeg = 0;
            System.out.println("----Turn: " + (h + 1) + "----");

//Makes the player able to guess six times pr. turn and writes out the places in the code.
            for (int j = 0; j < guess.length; j++) {
                System.out.print("Place " + (j + 1) + ": ");
                guess[j] = in.nextInt();
            }
            System.out.println(Arrays.toString(guess));

//Calculates key pegs:
            for (int k = 0; k < guess.length; k++) {
                if (guess[k] == colorpattern[k]) {
                    blackkeypeg = blackkeypeg + 1;
                }
                if (Arrays.asList(guess).contains(colorpattern[k])) {
                    whitekeypeg = whitekeypeg + 1;
                }
            }
            whitekeypeg = whitekeypeg - blackkeypeg;
            System.out.println("Black keyges: " + blackkeypeg + " and white keyges: " + whitekeypeg);

//Decides when the player has either won or lost:
            if (blackkeypeg == 6) {

                System.out.println("You've won! The color pattern is: " + Arrays.toString(colorpattern));
                break;
            } else if (h == turnlimit - 1) {
                System.out.println("GAME OVER. The color pattern is " + Arrays.toString(colorpattern));
            }
        }
    }
}