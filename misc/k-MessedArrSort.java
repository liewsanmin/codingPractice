/**
K-Messed Array Sort

Given an array arr of length n where each element is at most k places away from its sorted position,
Plan and code an efficient algorithm to sort arr.
Analyze the runtime and space complexity of your solution.

Example: n=10, k=2. The element belonging to index 6 in the sorted array, may be at indices 4, 5, 6, 7 or 8 on the given array.


Build heap -- O(k)
insert and remove -- O(lg k)
O(n lg k) -- time
O(k+1) -- space
*/


private int[] kHeapSort(int[] arr, int k){
    minHeap heap = new minHeap();
    lastIdx = arr.length - 1;
    
    /**
    Since we know the 0th position is at most k position away for 0th
    we insert to minHeap(magix box that sorts and spits out the lowest element for you when you need it)
    only until k because that is the max position the 0th position can get
    */
    for(int i = 0; i <= k; i++){ // O(k)
        heap.insert(arr[i]);
    }
    
    /**
    Now that we have 0th to kth element, we can start telling our black box to spit out 
    the min element.
    
    But everytime we spit out the min element from 0th position we also have to consider
    the possibility of (k+1)th position did not move.
    
    So we greedily spit out the new element, put it starting from 0th position
    and also add the remaining elements to the blackbox
    */
    for(int i = k+1; k <= lastIdx; k++){ // O(n-k lg k)
        arr[i-(k+1)] = heap.remove();
        heap.insert(arr[i]);
    }
    
    /**
    Now that we have inserted all of the elements in the minHeap from the unsorted array
    we continue spitting out elements from minHeap until it is empty
    
    since the previous step is basically cancelling out each other after inserting and removing
    we know that these elements are basically the beginning element that we inserted from 0th to 
    kth position. that means we don't have to guess when the minHeap is going to be empty
    */
    for(int i = 0; i <= k; i++){ // O(k lg k)
        arr[lastIdx - k + i] = heap.remove();
    }
    return arr;
    
    // -- O(n lg k)
}
