/*
Author:  Serg Kolo
Date: Aug 26, 2015
Class: CS2050, Fall 2015
Instructor: Prof. Gurka
Purpose: a program to find prime numbers under specific limit
*/


import javax.swing.JOptionPane;
import java.util.*;
import java.lang.Math;

public class skolodya_hw1_primes
{
    public static void main (String[] args)
    {
        int userInput = 0;
        while ( userInput <=1 )
            {
                userInput = Integer.parseInt(JOptionPane.showInputDialog("Enter a positive integer limit for finding primes, greater than 2 "));
            }

        ArrayList<Integer> integerList = new  ArrayList<Integer>();
        fillArrayList (integerList,userInput);
        sievePrimes(integerList,userInput);
        printPrimes (integerList,userInput);
    }

    public static void fillArrayList ( ArrayList<Integer> nums,int limit )
    {
        /*
        Arrays go from 0 to n. So, if user asks for, say, 13 as limit,
        we allocate array list that is 13+1 items in size.
        */
        for (int i=0; i<(limit+1); i++)
            {
                nums.add(1);
            }
    }

// Sieve of Erathosenes.
// Basic idea is to cross out the multiples of known primes bellow
// the limit. The remaining numbers are prime.
// On paper it would be making a table or list of numbers and
// crossing out numbers for each prime. In this case, we set
// specific items whose positional number is not prime

    public static void sievePrimes (ArrayList <Integer> nums, int limit)
    {


// if an integer has prime factors, then at least one
// of them does not exceed the square root of that integer
        for(int i=2; i<Math.sqrt(limit); i++)
            {
                for (int j=2; j<limit; j++)
                    {
                        if ( i*j > limit)
                            break;

// Mark items in the ArrayList , whose positional number is a multiple
// of a prime number
                        nums.set(i*j,0);

                    }
            }
    }
    public static void printPrimes (ArrayList <Integer> nums, int limit )
    {
        // JOptionPane dialogs require string, so
// we need to convert integers to strings

        ArrayList <String> primes =  new ArrayList();
        String output =" ";

// list numbers that have not been marked as false into
// the primes ArrayList.
        for (int i=2; i<limit; i++)
            {
                if (nums.get(i) == 1)
                    {
                        primes.add(Integer.toString(i));
                    }
            }

        for (int j=0; j<primes.size(); j++ )
            {
                output += primes.get(j) + " ";
            }

        JOptionPane.showMessageDialog(null," Primes found  " + output);

    }
}
