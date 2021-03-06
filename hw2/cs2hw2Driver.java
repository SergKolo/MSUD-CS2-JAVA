/*******************
Author: Sergiy Kolodyazhnyy
Date: 09/14/2015
Instructor: Prof.Gurka
Purpose: Program for generating Soundex code
	for surnames
*******************/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class cs2hw2Driver
{

    /*********************
    The control flow of the main method is fairly straightforward.
    As required in the  point #3 of the assignment, the program
    starts with first phase, where user manually enters names, until
    they enters "nextphase" in order to go to phase 2.
    Phase 2 is where the user is prompted to enter file or path to file
    that will be analyzed.

    As stated in the requirements, the driver class merely creates
    the object, and the driver then calls getSoundex method in
    both cases.
    **********************/
    public static void main(String[] args) throws IOException
    {
        String lastName = "";
        cs2hw2Soundex toSoundex = new cs2hw2Soundex ();
// phase 1: getting  input from user
        Scanner readInputKbd = new Scanner ( System.in );
        while ( true  )
            {
                System.out.print("Enter a surname: ");
                lastName = readInputKbd.nextLine();
                if (! lastName.equalsIgnoreCase("nextphase"))
                    {
                        toSoundex.getSoundex(lastName);
                    }
                else
                    {
                        break;
                    }
            }
// phase 2: get input from file
        String listFile;
        System.out.print("Enter filename or path to file: ");
        listFile = readInputKbd.nextLine();
// inputData object and readInputFile object are
// created here, because we need to get filename form user first
        File inputData = new File (listFile);
        Scanner readInputFile = new Scanner ( inputData );

        while ( readInputFile.hasNext()  )
            {
                lastName = readInputFile.nextLine();
                toSoundex.getSoundex(lastName);
            }
        readInputFile.close();
    }


}
