"""
Link the variable to the node
updating variable will then update the node automatically
"""

class DLinkedNode():
    def __init__(self):
        """
        key
        value
        prev
        next
        """
        self.key = 0
        self.next = None
        self.value = 0
        self.prev = None

class LRUCache():
    def _add_node(self, node):
        """
        Always add the new node right after head
        every add node has 4 arrows
        """
        node.next = self.head.next
        node.prev = self.head

        self.head.next.prev = node
        self.head.next = node

    def _remove_node(self, node):
        """
        Remove an exisiting node from the linked list
        """
        prev = node.prev
        new = node.next

        prev.next = new
        new.prev = prev
        node = None

    def _move_to_head(self, node):
        """
        Move certain node after head
        """
        self._remove_node(node)
        self._add_node(node)


        
    def _pop_tail(self): 
        """
        Pop the current tail
        """

        res = self.tail.prev
        self._remove_node(res)

        return res
        
    def __init__(self, capacity):
        """
        :type capacity: int
        cache 
        capacity # for limit to remove when hit limit
        size     # to track current size
        head
        tail
        """
        self.cache = {}
        self.capacity = capacity
        self.size = 0
        self.head, self.tail = DLinkedNode(), DLinkedNode()
        
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        node = self.cache.get(key, None)
        if node == None: return -1
        self._move_to_head(node)

        return node.value
    
    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        update cache and linked list
        """
        # get from cache
        node = self.cache.get(key)
        # if not
        if not node:
            # create new node (DlinkedNode, key, value)
            newNode = DLinkedNode()
            newNode.key = key
            newNode.value = value

            # put key into cache
            self.cache[key] = newNode
            # add to linkedlist
            self._add_node(newNode)
            # add size
            self.size += 1

            # if size > capacity
            if self.size > self.capacity:
                # pop the tail (cache key, and size too)
                popped = self._pop_tail()
                del self.cache[popped.key]
                self.size -= 1
        # else
        else:
            # update the value
            node.value = value
            self._move_to_head(node)