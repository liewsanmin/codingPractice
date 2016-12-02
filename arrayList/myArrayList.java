import java.util.Arrays;
public class myArrayList<T>{
    private T[] myArray;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public myArrayList(){
        // start my own default size at 10
        myArray = (T[]) new Object[2];
    }

    public int size(){
        return size;
    }

    @SuppressWarnings("unchecked")
    public void add(T t){
        // check if array is full
        if(size == myArray.length){
            myArray = Arrays.copyOf(myArray, size * 2);
        }
        myArray[size++] = t;
    }

    @SuppressWarnings("unchecked")
    public T get(int idx){
        if(idx < 0 || idx >= myArray.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        else
            return myArray[idx];
    }

    public void remove(int idx){
        if(idx < 0 || idx >= myArray.length)
            throw new ArrayIndexOutOfBoundsException();
        myArray[idx] = null;
        int currIdx = idx;
        /**
        [0  1   2 3]
        [0 null 2 3]
        [0  2   n 3]
        [0  2   3 n]
        */
        while(currIdx < size){
            myArray[currIdx] = myArray[currIdx + 1];
            myArray[currIdx + 1] = null;
            currIdx++;
        }
        size--;
    }
}
