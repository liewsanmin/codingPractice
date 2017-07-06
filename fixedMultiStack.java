public class fixedMultiStack{
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public fixedMultiStack(int stackSize){
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    public void push(int stackNum, int value){
        if(isFull(stackNum)){
            System.out.print("stack full lol ");
        }
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum){
        if(isEmpty(stackNum)){
            System.out.print("stack empty lol ");
            return -1;
        }
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
    }

    public int peek(int stackNum){
        return values[indexOfTop(stackNum)];
    }

    public boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0;
    }

    public boolean isFull(int stackNum){
        return sizes[stackNum] == stackCapacity;
    }

    private int indexOfTop(int stackNum){
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

    /*
    public class oneArray3Stacks{
        public static void main(String[] args){
            fixedMultiStack stack = new fixedMultiStack(2);
            stack.push(0, 1);
            stack.push(0, 8);
            stack.push(0, 8);
            stack.push(1, 2);
            stack.push(2, 3);


            System.out.println(stack.peek(0));
            System.out.println(stack.peek(1));
            System.out.println(stack.peek(2));

            System.out.println(stack.pop(2));


            System.out.println(stack.pop(2));
            System.out.println(stack.peek(2));

            System.out.println(stack.isEmpty(2));
            System.out.println(stack.isEmpty(1));
            System.out.println(stack.isEmpty(0));

        }
    }



    */
}
