#list

# class
class theClass:
    def __init__(self) -> None:
        pass

# hashmap (dictionary)
hm = {'a':1}

# hashset (set)
hs = {1,2,3}

# array (list)
arr = []

# pair (tuple)
curPair = 1,'a',3.0

# queue (deque)
from collections import deque
q = deque([1,2,3])

# stack
s = []

# priority_queue (min heap)
from heapq import heapify, heappush
minHeap = []
heapify(minHeap)
heappush(minHeap, 10)