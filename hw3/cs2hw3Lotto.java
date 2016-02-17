import java.lang.Math;
import java.util.Random;
import java.util.Arrays;

public class cs2hw3Lotto
{
	// MAX and MIN are made private and final, because
	// we want these to remain constant and unalterable
	private final int MAX =  41;
	private final int MIN = 1;
	
	int [] userNums;
//	int stats [] = new int[5];

	Random rand = new Random();

	public cs2hw3Lotto()
	{
		
	}

	// Constructor for our Lotto object
	public cs2hw3Lotto (int [] a)
	{
	  userNums = a;
	}

	public void checkUserInput()
	{
		for (int i = 0 ; i < userNums.length; i++)
			System.out.print(userNums[i]);
	}
//=====================================================================
	// random number generator method
	public int getRandomInt ()
	{
          int out;
          out = rand.nextInt((MAX - MIN) + 1) + MIN;
          return out;
    	}

//=====================================================================
	// a helper method that tests whether an array has duplicates
	// will be used to test user's input as well as
	// the generated numbers
	public boolean hasDuplicates (int[] a)
	{
          boolean result = false;
          Arrays.sort(a);

          for(int i = 1; i < a.length; i++)
            {
                if(a[i] == a[i - 1])
                    {
                        result = true;
                    }
            }
          return result;

    	}
//========================================================================

	public int [] playTillJackpot()
	{
		// stats array hold total number of plays,
		// how many times we matched 3 numbers,
		// 4 numbers, 5 numbers, and total payouts in 
		// that order respectivelly
		int stats [] = new int[5];
		int countMatched = 0;
		int lottoNums [] = new int[6];
		while (true)
                    {
			// generate numbers
                        for (int i = 0; i < 6; i++)
                            {
                                lottoNums[i] = getRandomInt();
                            }
			// re-run number generator if we have duplicate numbers
                        if (hasDuplicates(lottoNums))
                            {
                                continue;
                            }
			stats[0] ++ ;
                        //compare userNums to lottoNums
                        // count matched numbers
                        for (int j = 0; j < 6; j++)
                            {
                                for (int k = 0 ; k < 6; k++)
                                    {
                                        if (lottoNums[k] == userNums[j])
                                            countMatched++;
                                    }
                            }
			switch (countMatched)
			{
				case 3: stats[1]++;break;
				case 4: stats[2]++;break;
				case 5: stats[3]++;break;
				default: break;
			}

                        if (countMatched == 6)
                            {
                               // System.out.println("Jackpot");
				//System.out.println("Played " + stats[0] + " times");
				stats[4] = stats[1]*10 + stats[2]*50 + stats[3]*1000;
				//System.out.println("Payout " + stats[4]);
                                break;
                            }
                        countMatched = 0;

	}
  return stats;
  }
}
