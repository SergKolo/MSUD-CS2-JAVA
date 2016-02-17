public class stack
{
    private int top = -1;
    int size;
    int[] stack ;

    // default constructor with size 10
    public stack()
    {
        size=10;
        stack = new int[size];
    }
    // constructor with custom size
    public stack(int arraySize)
    {
        size=arraySize;
        stack= new int[size];
    }

    public void push(int value)
    {
        if(!(top==size-1))
            {
                top=top+1;
                stack[top]=value;
            }
        else
            {
                System.err.println("Stack is full, can't push a value");
                System.exit(-1);

            }
    }

    public int pop()
    {
        if(!isEmpty())
            {

                int num = stack[top];
                top--;
                return num;

            }
        else
            {
                return -1;
            }
    }

    public boolean isEmpty()
    {
        return (top==-1);
    }

    public void display()
    {

        for(int i=0; i<=top; i++)
            {
                System.out.print(stack[i]+ " ");
            }
        System.out.println();
    }
}
