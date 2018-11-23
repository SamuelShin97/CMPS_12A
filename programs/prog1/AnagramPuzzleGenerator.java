import java.util.*;
import java.io.*;
import java.lang.StringBuffer.*;
/**
  This program was completed using pair programming by me
  (Sameul Shin) and my partner (Jessy Armstrong).
  I acknowledge that each partner in a programming pair should "drive"
  roughly 50% of the time the pair is working together, and at most 25%
  of an individual's effort for an assignment should be spent working
  alone. Any work done by a solitary programmer must be reviewed by the
  partner. The object is to work together, learning from each other, not
  to divide the work into two pieces with each partner working on a
  different piece.
  I spent 1______ HOURS working alone.
  I spent 2______ HOURS working with my partner on this assignment.
  I estimate that of the time spent with my partner, I "drove" 50_____
  PERCENT of the time. 

  Put any comment or explanation about variations from the 
  expected pair programming practice here. E.g. if you didn't complete
  the assignment with your partner, this is the place to explain why
  not. 
  We took the echo program and copied and pasted it into this program as a starting point. 
  Also, my code and Jessy's code share the same logic but we named our variables different names and  it's not necessarily exactly the same but very similar.

 * Assignment #1.
 * This program generates anagrams...
 * 
 * Authors: Samuel Shin (sayshin@ucsc.edu) 
 *          and Jessy Armstrong (jenarmst@ucsc.edu)
 **/


class AnagramPuzzleGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream(args[0])); //scan in a word list
        Random rand = new Random();
        
        int size = in.nextInt(); //size is how many words there are in the file
        int rng = rand.nextInt(size); //generates random index for the word to scramble
        int i = 0;
         
        while (i < rng) //finds the random word 
        {
            in.next();
            i++;
        }
        
        StringBuffer sb = new StringBuffer(in.next()); //create stringbuffer for random word 
        StringBuffer temp = new StringBuffer(); //creates a second stringbuffer

        int j = 0;
        int randNum = 0;
	char letter;
	int wordSize = sb.length();

        while (j < wordSize)
        {
            randNum = rand.nextInt(sb.length());//generates random number from 0-word length
            letter = sb.charAt(randNum); //save the random char as letter
	    temp.append(letter); //places the char in a temp stringbufffer
	    sb.deleteCharAt(randNum);//deletes the char in original sb to prevent duplication
            j++;
        }
	
	System.out.println(temp);
    }
}
