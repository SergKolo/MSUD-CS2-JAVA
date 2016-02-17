/****************************************
Author: Sergiy Kolodyazhnyy
Course: CS 2050
Date: Sept 21 2015
Instructor: Prof Gurka
Java version: OpenJDK, 1.7.0
IDE: nano text-editor and java compiler
Project: #4, Big Addition, preliminary
*****************************************/

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class driver
{
    public static void main(String[] args) throws IOException
    {
        String planAuthor;
        File inpFile = new File(args[0]);
        Scanner readData = new Scanner(inpFile);
        data inputData = new data();
        planAuthor = readData.nextLine();

        printHeader(planAuthor);

        while (readData.hasNext())
            {

                inputData.caseDescription = readData.nextLine();
                inputData.opA = readData.nextLine();
                inputData.opB = readData.nextLine();
                inputData.result = readData.nextLine();

                System.out.println("Case:" + inputData.caseDescription);
                System.out.println("Operand 1: " + formatNumber(inputData.opA) );
                System.out.println("Operand 2: " + formatNumber(inputData.opB) );
                System.out.println("Expected Result: " + formatNumber(inputData.result) );
                System.out.print("Result from stack arithmetic: ");
                System.out.print(formatNumber( inputData.performAddition() ) );
                System.out.printf("\n\n");

            }


    }

    public static void printHeader(String testAuthor)
    {
        System.out.println("Author: Sergiy Kolodyazhnyy\tCS-2050,Fall-2015");
        System.out.println("Project #4 - Big Addition\n\n");
        System.out.println("Plan author:" + testAuthor);
    }

    public static String formatNumber(String num)
    {
        String temp = "";
        String formated = "";
        int digitCount = 0;

        for (int i = num.length() - 1 ; i >=0 ; i-- )
            {

                digitCount++;
                if (digitCount%3==0)
                    {
                        temp = temp + num.charAt(i) + "," ;
                    }
                else
                    temp = temp + num.charAt(i) ;

            }

        for (int j = temp.length()-1; j >= 0; j-- )
            {
                if (j == temp.length() - 1 && temp.charAt(j) == ',')
                    continue;
                formated = formated + temp.charAt(j);
            }

        return formated;
    }


}
