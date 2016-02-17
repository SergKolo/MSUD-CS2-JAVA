/****************************************
Author: Sergiy Kolodyazhnyy
Course: CS 2050
Date: Sept 16 2015
Instructor: Prof Gurka
Java version: OpenJDK, 1.7.0
IDE: nano text-editor and java compiler
*****************************************/
import javax.swing.JOptionPane;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class cs2hw3Driver
{
    public static void main (String[] args) throws IOException
    {

	String myName = "Sergiy Kolodyazhnyy";
        String outputFilePath = getFileName();
	FileWriter outputFile = new FileWriter(outputFilePath);
	PrintWriter writeToFile = new PrintWriter(outputFile);
        int numsArr [] = getNums( );
	cs2hw3Lotto Lotto  = new cs2hw3Lotto (numsArr);

	int [] statistics = new int[5];
	int[] sums = new int[5];
	printHeader(writeToFile,numsArr,myName);
	for (int x = 1; x<=10; x++)
	{ 	statistics = Lotto.playTillJackpot();
		printToFile(writeToFile,statistics,x);
		for (int y = 0; y<5; y++)
		{  
			sums[y] += statistics[y];
		}
	}
	printAverages(writeToFile,sums);
	writeToFile.close();

    }
//-------------------------------------------------------------------
    public static int[]  getNums(  )
    {
	// had to declare instance of the Lotto object here to use
	// hasDuplicates method
	cs2hw3Lotto Lottery = new cs2hw3Lotto();

        String numString = "";
	int arr[];
	// loop until the user gives right input
	while ( true )
{	numString = JOptionPane.showInputDialog("Please input 6 unique digits , from 1 to 41, comma-separated");
	// check if we have illegal characters with regex patter matching
        if(numString.matches(".*[^0-9,].*"))
         {
                System.out.println("REgex works");
                continue;
         }

	// protective feature - removing stray blanks from user's input
        numString = numString.replaceAll("\\s+","");


	// split the string into array of strings using comma as delimiter
        String [] numArrStr = numString.split(",");
	//declare int array of same size as numeric string array
        arr = new int[numArrStr.length];
	// check if the length is wrong (meaning user missed comma or put too many nums)
	if ( numArrStr.length < 6 || numArrStr.length > 6)
		continue;
	// If above conditions are OK, fill the array of ints by parsing array
	// of strings to int
        for (int i = 0 ; i < numArrStr.length; i++)
            {
                arr[i] = Integer.parseInt(numArrStr[i]);
            }

	// Check if we have duplicate numbers
 	if ( Lottery.hasDuplicates(arr))
	{	continue;
	}
	else
	{	break;
	}

}
        return arr;
    }
//===============================================================
	// as the name suggests, here we are getting the filename
	// where the output will be stored
    public static String getFileName ()
    {
        return JOptionPane.showInputDialog("Please input filename where data will be stored");
    }

//=============================================================
// the three methods bellow output to the file.  printToFile is called repeatedly
// while printHeader and printAverages serve purpose at the beginnning and ending
// of the 10 games
	public static void printToFile( PrintWriter statsFile,int[] stats, int game   )
	{
		statsFile.printf("%-2d: %-10d %-10d %-10d %-10d %-10d\n",game,stats[0],stats[1],stats[2],stats[3],stats[4]);
	}

	public static void printHeader( PrintWriter statsFile,int[] array,String author  )
	{
		statsFile.println(author);
		statsFile.print("User Input: ");
		for (int i = 0; i< array.length; i++)
			statsFile.print(array[i] + " ");
		statsFile.printf("\n%s %-10s %-10s %-10s %-10s %-10s\n","Game#","Rolls","Match 3","Match 4","Match 5","Payout");
		
	}
	public static void printAverages( PrintWriter statsFile, int sums [] )
	{
	  statsFile.println("Average values:");
	 for (int i=0; i<5;i++)
	  statsFile.printf("\t%-10d",sums[i]/10);
	}
}
