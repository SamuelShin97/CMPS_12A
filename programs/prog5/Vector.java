/**
 * Assignment #5.
 * This program can construct two kinds of vector objects and has 
 * 6 different functions in the form of instance methods that it can 
 * calculate.
 * 
 * Authors: Samuel Shin (sayshin@ucsc.edu)
 */

import java.util.*;
import java.lang.Math;

class Vector 
{
    private double x;
    private double y;

    public Vector()//default constructor
    {}
    
    public Vector (double xValue, double yValue)//constructs a 2D vector
    {
        x = xValue;
        y = yValue;
    }
    
    public double getX()//returns x component of vector
    {
        return x;
    }
    
    public double getY()//returns y component of vector
    {
        return y;
    }
    
    public Vector sum (Vector vec)//adds two vectors and returns the sum 
    {
        return (new Vector(vec.x + x, vec.y + y));
    }
    
    public Vector difference (Vector vec)//subtracts a vector from another and returns the difference
    {
        return (new Vector(x - vec.x, y - vec.y));
    }
    
    public double magnitude ()//returns the magnitude a single vector
    {
        return (Math.sqrt(x * x + y * y));
    }
    
    public Vector scalarProduct (double scalar)//returns a scalar multiple of a vector
    {
        return (new Vector(scalar * x, scalar * y));
    }
    
    public double dotProduct(Vector vec)//returns the dot product of two vectors
    {
        return (x * vec.x + y * vec.y);
    }
    
    public double angle(Vector vec)//returns the angle between two vectors
    {
        double dotProd = dotProduct(vec);
        double magX = magnitude();
        double magY = vec.magnitude();
        double prod = magX * magY;
        return (Math.acos(dotProd / prod));
    }
}
