//import java.io.*;
//import java.util.Scanner;
public class scratchpad
{
    public static void main(String []  args)
    {
        String num = "31234567";
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
            formated = formated + temp.charAt(j);


    }

}
