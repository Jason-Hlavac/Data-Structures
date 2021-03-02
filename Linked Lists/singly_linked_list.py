class Node(object):
    def __init__ (self, d, n = None):
        self.data = d
        self.next = n
        
    def get_data(self):
        return self.data

    def set_next(self, new_next):
        self.next = new_next

class LinkedList(object):
    def __init__(self, head = None):
        self.head = head
    #APPEND METHOD
    def append(self, value):
        current = self.head
        new_node = Node(value)
        if(self.head != None):
            while(current.next != None):
                current = current.next
            current.next = new_node
        else:
            self.head = new_node
    
    #PREPEND METHOD
    def prepend(self, value):
        if(self.head != None):
            new_node = Node(value)
            new_node.set_next(self.head)
            self.head = new_node
        elif(self.head == None):
            new_node = Node(value)
            self.head = new_node
        else:
            pass
            
    
    #INSERT METHOD
    def insert(self, value, index):
        current = self.head
        i = 0
        if(self.head != None and i != index):
            while(i+1 < index and current.next != None):
                current = current.next
                i+=1
            if(current.next == None):
                self.append(value)
            else:
                new_node = Node(value)
                new_node.set_next(current.next)
                current.set_next(new_node)
        else:
            self.prepend(value)
            
    #DELETE VALUE METHOD
    def deleteValue(self, value):
        current = self.head
        new_node = Node(value)
        if(self.head != None):
            while(current.next.get_data() != value and current.next != None):
                current = current.next
            if(current.next == None):
                pass
            else:
                current.next = current.next.next
        else:
            pass
    
    #DELETE INDEX METHOD
    def deleteIndex(self, index):
        i = 0
        current = self.head
        if((current == None) or (index >= self.get_length())):
            pass
        elif(i == index):
            self.head = current.next
        else:
            while(i+1 < index):
                current = current.next
                i+=1
            current.next = current.next.next
    
    #REVERSE ITERATIVE
    def reverse(self):
        current = self.head
        previous = None
        next_node = None
        if(self.head == None):
            pass
        while(current != None):
            next_node = current.next
            current.next = previous
            previous = current
            current = next_node
        self.head = previous
        
    #REVERSE RECURSIVE
    def reverseRecursive(self, curr, prev):
        if(curr == None):
            return prev
        next_node = curr.next
        curr.next = prev
        return(self.reverseRecursive(next_node, curr))
        
       
        
            
    #LINKED LIST GET LENGTH METHOD
    def get_length(self):
        current = self.head
        if(current != None):
            i = 0;
            while(current.next != None):
                current = current.next
                i+=1
            return(i)
        else:
            pass
        
    #LINKED LIST GETTER METHOD
    def get(self):
        current = self.head
        list = []
        while(current != None):
            list.append(current.get_data())
            current = current.next
        return(list)
            
def main():
    l = LinkedList()
    l.append(2)
    l.append(3)
    l.prepend(0)
    l.insert(1, 1)
    l.append(4)
    l.deleteValue(4)
    l.deleteIndex(7)
    l.reverse()
    print(l.get())
    l.head = l.reverseRecursive(l.head, None)
    print(l.get())
    
if __name__ == "__main__":
    main()
