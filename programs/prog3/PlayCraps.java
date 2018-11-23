import java.util.*;
import java.io.*;
/**
 * This program was completed using pair programming by me
 * (Samuel Shin) and my partner (Jessy Armstrong).
 * I acknowledge that each partner in a programming pair should "drive"
 * roughly 50% of the time the pair is working together, and at most 25%
 * of an individual's effort for an assignment should be spent working
 * alone. Any work done by a solitary programmer must be reviewed by the
 * partner. The object is to work together, learning from each other, not
 * to divide the work into two pieces with each partner working on a
 * different piece.
 * I spent 1______ HOURS working alone.
 * I spent 3______ HOURS working with my partner on this assignment.
 * I estimate that of the time spent with my partner, I "drove" 50_____
 * PERCENT of the time. 
 *
 * Put any comment or explanation about variations from the 
 * expected pair programming practice here. E.g. if you didn't complete
 * the assignment with your partner, this is the place to explain why
 * not. 
 *
 * Assignment #3.
 * This program simulates the game of craps
 *
 * Authors: Samuel Shin (sayhin@ucsc.edu) 
 *                 and Jessy Armstrong (jemarmst@ucsc.edu)
 **/

public class PlayCraps
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);//create scanner object for user inputs
        int inputSeed, inputChips, inputBet;
        System.out.println("Enter the Seed.");
        inputSeed = scan.nextInt();//takes in value for the seed
        Random rand = new Random(inputSeed);
        System.out.println("How many chips do you want?");
        inputChips = scan.nextInt();//takes in value for the amount of chips the user wants
        while(inputChips != 0)
        {
            System.out.println("Enter Bet.");
            inputBet = scan.nextInt();//takes in value for the bet that the user wants
            if (validBet(inputChips, inputBet) == false)//checks to make sure if bet can be made
            {
                System.out.println("Not an ok bet.");
                continue;
            }

            scan.nextLine();
            System.out.println("hit return to roll the dice");
            scan.nextLine();
            int sum = rollDice(rand);//roll dice

            if (sum == 7 || sum == 12)
            {
                System.out.println("You won, you now have " + increaseChips(inputChips, inputBet));
                inputChips = increaseChips(inputChips, inputBet);//adds bet to chips
            }
            else if (sum == 2 || sum == 3 || sum == 12)
            {
                System.out.println("You lost, you now have " + decreaseChips(inputChips, inputBet));
                inputChips = decreaseChips(inputChips, inputBet);//subtracts bet from chips
            }
            else 
            {
                System.out.println("The point is " + sum);
                System.out.println("hit return to roll the dice"); 
                while(true)
                {
                    scan.nextLine();
                    int newSum = rollDice(rand);//roll dice for the point
                    if (newSum == 7)
                    {
                        System.out.println("You lost, you now have " + decreaseChips(inputChips, inputBet));
                        inputChips = decreaseChips(inputChips, inputBet);
                        break;
                    }
                    else if (newSum == sum)
                    {
                        System.out.println("You won, you now have " + increaseChips(inputChips, inputBet));
                        inputChips = increaseChips(inputChips, inputBet);
                        break;
                    }
                    else continue;
                }   
            }
        }
    }

    public static int rollDice(Random rng)//rolls the dice and returns sum of the dice
    {
        int roll = rng.nextInt(6) + 1;
        int roll2 = rng.nextInt(6) + 1;
        System.out.println("roll is " + roll + ", " + roll2);
        return roll + roll2;
    }

    public static int increaseChips(int chips, int bet)//returns added bet to chips
    {
        int total = chips;
        int amount = bet;
        return total + amount;
    }

    public static int decreaseChips(int chips, int bet)//returns subtracted bet from chips
    {
        int total = chips;
        int amount = bet;
        return total - amount;
    }

    public static boolean validBet(int chips, int bet)//checks and make sures user inputs a valid bet
    {
        if (bet > chips)
        {
            return false;
        }
        else return true;
    }
}
