import java.util.*;
class is2Movies{

    public boolean is2Movies(int flightLength, int[] movieLengths){
        HashSet<Integer> set = new HashSet<>();
        for(int curr : movieLengths){
            int counterPart = flightLength - curr;
            if(set.contains(counterPart))
                return true;

            set.add(curr);
        }
        // for(int curr : movieLengths){
        //     int counterPart = flightLength - curr;
        //     System.out.println(counterPart);
        //     if(set.contains(counterPart) && counterPart != curr)
        //         return true;
        // }
        return false;
    }

    public static void main(String[] args){
        int[] movieLengths = {2, 5, 8};
        int length = 10;

        is2Movies i = new is2Movies();
        System.out.println(i.is2Movies(length, movieLengths));
    }
}
