public class cs2hw2Soundex
{

    public void getSoundex ( String surname  )
    {
// converting to uppercase simplifies processing
// I tried  adding if statement that would convert
// the initial letter when i==0 but then realized it
// extra code that was unnecessary
        surname = surname.toUpperCase();
        char[] surnameChars = surname.toCharArray();
        char initial = surnameChars[0]; //hold the initial letter
        String output = "";

// because we need to avoid duplicates, we need to convert
// the initial too, hence for loop starting at 0
        for (int i = 0 ; i < surnameChars.length; i++ )
            {
                switch (surnameChars[i])
                    {
                    case 'B':
                    case 'F':
                    case 'P':
                    case 'V':
                        surnameChars[i] = '1';
                        break;
                    case 'C':
                    case 'G':
                    case 'J':
                    case 'K':
                    case 'Q':
                    case 'S':
                    case 'X':
                    case 'Z':
                        surnameChars[i] = '2';
                        break;
                    case 'D':
                    case 'T':
                        surnameChars[i] = '3';
                        break;
                    case 'L':
                        surnameChars[i] = '4';
                        break;
                    case 'M':
                    case 'N':
                        surnameChars[i] = '5';
                        break;
                    case 'R':
                        surnameChars[i] = '6';
                        break;
                    default:
                        surnameChars[i] = '0';
                        break;
                    }
            }

// for loop that builds up the output string
// it skips duplicates and characters marked by 0 (vowels, h, and w)
        for (int i = 1; i < surnameChars.length; i++)
            {
                if ( surnameChars[i] == '0' || surnameChars[i] == surnameChars[i-1] )
                    continue;
                output += surnameChars[i];
            }
        output = initial +  output + "0000";

        System.out.printf("%s:%s\n",surname,output.substring(0,4));
    }


}
