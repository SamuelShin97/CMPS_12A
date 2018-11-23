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
 * My partner and I did this program differently. (just the second program)
 *
 *
 * Assignment #3.
 * This program calculates and prints out the probability of winning 
 * the game craps for a certain amount of games played.
 * 
 * Authors: Samuel Shin (sayhin@ucsc.edu) 
 *                 and Jessy Armstrong (jemarmst@ucsc.edu)
 **/

public class SimCraps
{
    public static void main (String[] args)
    {
        int trials = Integer.parseInt(args[0]);//takes in number of times game is played
	int control = trials;
	int losses = 0;//not used in calculation of probability
	double wins = 0;//number of wins that occur 	
        Random rand = new Random();
        
        while(control > 0)
        {
            int sum = rollDice(rand);//roll the dice
            
            if (sum == 7 || sum == 12)
            {
                wins++;
                
            }
            else if (sum == 2 || sum == 3 || sum == 12)
            {
                losses++;//just a place holder, just restarts loop if a loss
            }
            else 
            {
                while(true)
                {
                    int newSum = rollDice(rand);//roll dice again for the point
                    if (newSum == 7)
                    {
                    	losses++; 
			break;
                    }
                    else if (newSum == sum)
                    {
                        wins++;
                        break;
                    }
                    else continue;
                }   
            }
	    if (control == 1)//will calculate and print out probability of winning during last trial
	    {
	        double prob = wins/trials;
                System.out.println("Prob of Winning = " + prob);
            }
            control --;
        }

    }

    public static int rollDice(Random rng)//rolls dice and returns sum of the dice
    {
        int roll = rng.nextInt(6) + 1;
        int roll2 = rng.nextInt(6) + 1;
        return roll + roll2;
    }

    
}
