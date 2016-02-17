/*
Author:  Serg Kolo
Date: Aug 25, 2015
Class: CS2050, Fall 2015
Instructor: Prof. Gurka
Purpose: Line, Letter, and Digit counter
*/

import java.util.Scanner;
import java.io.*;

public class  skolodya_hw1_linechardigit_counter
{
    public static void main (String[] args)
    {

        if (args.length < 1 )
            {
                System.out.println("Usage: skolodya_hw1_linechardigit_counter FILE1 [FILE2] [FILE3] . . . ");
                System.exit(1);
            }

        for (int i=0; i<args.length; i++)
            {
                try
                    {
                        countLinesChars(args[i]);
                    }
                catch (IOException e)
                    {
                        System.err.println(args[i] + "File not found");
                    }
            }
    }

    public static void countLinesChars( String filename ) throws IOException
    {
        FileInputStream inputFile  = new FileInputStream (filename);
        BufferedReader readFile = new BufferedReader (new InputStreamReader(inputFile) );
        int lineCount=0,charCount=0,digitCount=0;
        String currentLine;

        while ( (currentLine = readFile.readLine() ) != null )
            {

                lineCount++;

                for (int j = 0 ; j < currentLine.length(); j++)
                    {

                        if ( Character.isLetter(currentLine.charAt(j)  ) )
                            {
                                charCount++;
                            }
                        else if ( Character.isDigit(currentLine.charAt(j) ) )
                            {
                                digitCount++;
                            }
                    }


            }

        readFile.close();
        System.out.println("File:" + filename );
        System.out.println("LineCount: " + lineCount +" CharCount: " + charCount + " Digits: " + digitCount );
    }



}
