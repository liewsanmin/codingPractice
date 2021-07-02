/**
I want to learn some big words so people think I'm smart.
I opened up a dictionary to a page in the middle and started flipping through,
looking for words I didn't know. I put each word I didn't know at increasing
indices in a huge array I created in memory. When I reached the end of the
dictionary, I started from the beginning and did the same thing until I reached
the page I started at.

Now I have an array of words that are mostly alphabetical, except they start
somewhere in the middle of the alphabet, reach the end, and then start from the
beginning of the alphabet. In other words, this is an alphabetically ordered
array that has been "rotated." For example:

  String[] words = new String[]{
    "ptolemaic",
    "retrograde",
    "supplant",
    "undulate",
    "xenoepist",
    "asymptote", // <-- rotates here!
    "babka",
    "banoffee",
    "engender",
    "karpatka",
    "othellolagkage",
};

Write a function for finding the index of the "rotation point," which is where
I started working from the beginning of the dictionary. This array is huge
(there are lots of words I don't know) so we want to be efficient here.

*/

import java.util.*;

class findRotationPoint{

    public int findRotationPoint(String[] words){
        int start, last, mid = 0;
        start = 0;
        last = words.length - 1;
        String startWord = words[start];
        while(start < last){
            mid = start + ((last - start) / 2);
            String midWord = words[mid];
            if(startWord.compareTo(midWord) >= 0){ // on the left
                last = mid;
            }
            else
                start = mid;
            if(start + 1 == last)
                break;
        }
        return last;
    }

    public static void main(String[] args){
        String[] words = new String[]{
            "ptolemaic",
            "retrograde",
            "supplant",
            "undulate",
            "xenoepist",
            "asymptote", // <-- rotates here!
            "babka",
            "banoffee",
            "engender",
            "karpatka",
            "othellolagkage",
        };
        findRotationPoint f = new findRotationPoint();

        System.out.println(f.findRotationPoint(words));
    }
}
