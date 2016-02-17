import java.util.Random;
public class cs2hw3Preliminary
{

public static void main(String[] args)
{

Random rand = new Random();

// part 1, generating 50 vaules in range
	System.out.println("Part 1 of preliminary testing");
	int []vals = new int[50];
	for (int i = 0 ; i < 50; i++)
	{
		vals [i] =  getRandomInt(rand,20,25);
		System.out.println (vals[i]);
	}
	
// part 2, generating 1000 vals
	int counters [] = new int[6] ;
	for (int j = 0 ; j < 1000 ; j++)
	{
		switch(getRandomInt(rand,20,25))
		{
		  case 20: counters[0]++;break;
		  case 21: counters[1]++;break;
		  case 22: counters[2]++;break;
		  case 23: counters[3]++; break;
		  case 24: counters[4]++;break;
		  case 25: counters[5]++;break;
		}
	}
	System.out.println("Part 2 of preliminary testing:");
	
	for (int k = 0; k < 6; k++)
	{ 
		System.out.printf("%d:%d\n",20+k,counters[k]  );
	}
}

   public static int getRandomInt (Random rand, int low, int high)
    {
        int out;
        out = rand.nextInt((high - low) + 1) + low;
        return out;
    }


}
