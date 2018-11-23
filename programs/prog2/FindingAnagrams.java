/**
 * This program was completed using pair programming by me
 * Samuel Shin and my partner Jessy Rakesh Armstrong.
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
 * Some of the code in the method "wordToHash" was taken from professor Bailey's
 * lecture to create the hash table.
 *
 * Assignment #2
 * This program takes in a string inputed by the user and goes through the 
 * word list checking for anagrams of the inputed string and prints them out.
 * 
 * Authors: Samuel Shin (sayshin@ucsc.edu)
 *          and Jessy Armstrong (jenarmst@ucsc.edu)
 **/



import java.util.*;
import java.io.*;
import java.lang.StringBuffer.*;

class FindingAnagrams 
{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner dataIn = new Scanner(new FileInputStream(args[0])); //reads in word file
        Scanner scan = new Scanner(System.in); //reads in word inputed by the user
        String input;
	String anagram;
	int size = dataIn.nextInt(); //size of the word file
	ArrayList<String> file = new ArrayList<String>();

	for (int i = 0; i < size; i++) //this loop makes a list of strings in the word file
	{
	    file.add(dataIn.nextLine());
	}
	
        do 
        {
            System.out.println("Type a string of letters.");    
            input = scan.next();
            System.out.println("The anagrams of '" + input + "' if any, are:");
            for (int a = 0; a < file.size(); a++) //checks through entire list of strings
	    {
		anagram = file.get(a);
		if (isAnagram(input, anagram) == true && !input.equals(anagram))//checks if anagram
		{
		    System.out.println(anagram);
		}
	    }
	    System.out.println("Do another (y/n)?");
	    input = scan.next();
        }while ((!input.equals("n"))); 

    }

    public static int wordToHash(String str) //converts a string into hash value
    {
        int seed = 1234;
        int sum = 0;
        int numberVal;
        Random rand = new Random(seed);
        int[] hashValues = new int[26];
        for (int i = 0; i < hashValues.length; i++)
        {
            hashValues[i] = rand.nextInt(); //create hash table
            
        }
        for (int j = 0; j < str.length(); j++) //matches each char with a hash value
        {
            char x = str.charAt(j);
            numberVal = hashValues[x-97];
            sum += numberVal;
            
        }
        return sum;
    }
    
    public static boolean isAnagram(String in, String data) //checks if two strings are anagrams
    {
        int hash1 = wordToHash(in);
        int hash2 = wordToHash(data);
        if (hash1 == hash2)
        {
            return true;
        }
        else return false;
    } 
}
