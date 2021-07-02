

# Node class 
class Node: 
   
    # Function to initialize the node object 
    def __init__(self, data): 
        # Assign data 
        # Initialize  
        self.data = data
        # next as null 
        self.next = None

# Linked List class 
class LinkedList:
    # Function to initialize the Linked  
    # List object 
    def __init__(self):  
       self.head = None

    def printList(self): 
        temp = self.head
        while temp:
            print(temp.data)
            temp = temp.next

    # Function to insert a new node at the beginning
    def push(self, new_data): 
        newNode = Node(new_data)
        newNode.next = self.head


        self.head = newNode

    # Inserts a new node after the given prev_node. This method is  
    
    """
    prev -> newNode 
    """
    def insertAfter(self, prev_node, new_data):
        if prev_node == None: return

        newNode = Node(new_data)
        newNode.next = prev_node.next

        prev_node.next = newNode

    # This function is defined in Linked List class 
    # Appends a new node at the end.  
    """
    1 2 3 4
    curr -> newNode
    """
    def append(self, new_data):
        if self.head == None: return
        newNode = Node(new_data)
        curr = self.head
        while curr.next != None:
            curr = curr.next

        curr.next = newNode