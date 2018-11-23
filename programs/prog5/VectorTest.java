/**
 * Assignment #5.
 * This program tests the Vector class's methods and prints out the results
 * of the calculations performed.
 * 
 * Authors: Samuel Shin (sayshin@ucsc.edu)
 */

import java.util.*;
import java.lang.Math;

public class VectorTest
{
    public static void main (String[] args)
    {
        Vector v1 = new Vector(5.0, 2.0);//creates a vector object with x = 5.0 and y = 2.0
        Vector v2 = new Vector(3.0, 4.0);//creates a vector object with x = 3.0 and y = 4.0
        
        System.out.print("The sum of vectors v1 and v2, " + "(" + v1.getX() + 
                         ", " + v1.getY() + ")" + " + " + "(" + v2.getX() + 
                         ", " + v2.getY() + ")" + " is = ");
        Vector vec = v1.sum(v2);
        System.out.print("(" + vec.getX() + ", " + vec.getY() + ")");//prints out the sum of v1 and v2
        System.out.println();
        
        System.out.print("The difference of vectors v1 and v2, " + "(" + v1.getX() + 
                         ", " + v1.getY() + ")" + " - " + "(" + v2.getX() + 
                         ", " + v2.getY() + ")" + " is = ");
        vec = v1.difference(v2);
        System.out.print("(" + vec.getX() + ", " + vec.getY() + ")");//prints out the difference of v1 and v2.
        System.out.println();
        
        System.out.print("The magnitude of vector v1, " + "(" + v1.getX() + 
                         ", " + v1.getY() + ")" + " = ");
        double mag = v1.magnitude();
        System.out.print(mag);//prints out the magnitude of v1
        System.out.println();
        
        double s = 3.0;
        System.out.print("The scalar product of vector v1 and scalar s, " + 
                         "(" + v1.getX() + ", " + v1.getY() + ")" + " * " + s + " = ");
        vec = v1.scalarProduct(s);
        System.out.print("(" + vec.getX() + ", " + vec.getY() + ")");//prints out the scalar product between vector v1 and scalar s
        System.out.println();
                         
        System.out.print("The dot product of vectors v1 and v2, " + "(" + v1.getX() + 
                         ", " + v1.getY() + ")" + ", " + "(" + v2.getX() + ", " + 
                         v2.getY() + ")" + " is = ");
        double dotProd = v1.dotProduct(v2);
        System.out.print(dotProd);//prints out the dot product of v1 and v2
        System.out.println();
        
        System.out.print("The angle between vectors v1 and v2, " + "(" + v1.getX() + 
                         ", " + v1.getY() + ")" + ", " + "(" + v2.getX() + ", " + 
                         v2.getY() + ")" + " is = ");
        double theta = v1.angle(v2);
        System.out.print(theta);//prints out the angle between v1 and v2
	System.out.println();
    }
}
