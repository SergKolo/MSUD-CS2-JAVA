public class data
{

    //String planAuthor;
    String caseDescription;
    String opA;
    String opB;
    String result;
    int sumStkSize;

    public String performAddition()
    {
        String output = "" ;
        stack numA = new stack(opA.length());
        stack numB = new stack(opB.length());

        if ( numA.size > numB.size )
            {
                sumStkSize =  numA.size + 1;
            }
        else
            {
                sumStkSize = numB.size + 1;
            }

        stack sumStk = new stack(sumStkSize);
        int result;

        // break strings into individual numbers, push onto stacks
        for (int i=0; i<opA.length(); i++)
            numA.push(Character.getNumericValue(opA.charAt(i)));

        for (int i=0; i<opB.length(); i++)
            numB.push(Character.getNumericValue(opB.charAt(i)));

        int carry = 0;
        while( !(numA.isEmpty()) || !(numB.isEmpty())  )
            {
                int num1 = numA.pop();
                int num2 = numB.pop();

                if ( num1 == -1 )
                    {
                        sumStk.push(num2 + carry);
                        carry=0;// this ensures  carry is used only once
                        // if there is one
                        continue;
                    }
                else if (num2 == -1)
                    {
                        sumStk.push(num1 + carry);
                        carry=0; // same as above
                        continue;
                    }


                int sumNums = num1 + num2 + carry;
                // This part considers the carry number in  normal addition
                if (sumNums >= 10 )
                    {
                        sumNums = sumNums - 10;
                        carry = 1;
                        // the if statement bellow considers special case where both
                        // numbers have carry resulting form adding highest
                        // digits, as in case of 512 + 512 = 1024
                        if (numA.isEmpty() && numB.isEmpty())
                            {
                                sumStk.push(sumNums);
                                sumStk.push(carry);
                                break;
                            }
                    }
                else
                    {
                        carry = 0;
                    }
                sumStk.push(sumNums);
            }

        // now that we have answer stack ready
        // we build the string out of the digits
        // on the stack for later processing in
        // the driver class
        for(int i = 0; i <sumStk.size; i++ )
            {
                int poppedNum = sumStk.pop();
                if ( poppedNum != -1 )
                    output+=poppedNum;
            }


        return output;
    }// end of performAddition()

} //end of class
