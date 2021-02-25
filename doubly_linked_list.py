class DoublyNode(object):
    def __init__ (self, d, n = None, p = None):
        self.data = d
        self.next = n
        self.prev = p
        
    def get_data(self):
        return self.data

    def set_next(self, new_next):
        self.next = new_next
        
    def set_prev(self, new_prev):
        self.prev = new_prev
        
class DoublyLinkedList(object):
    def __init__(self, haed = None):
        self.head = None

#APPEND
    def append(self, value):
        current = self.head
        new_node = DoublyNode(value)
        if(self.head != None):
            while(current.next != None):
                current = current.next
            current.set_next(new_node)
            current.next.set_prev(current)
            
        else:
            self.head = new_node
            
#PREPEND
    def prepend(self, value):
        current = self.head
        new_node = DoublyNode(value)
        if(current == None):
            self.head = new_node
        else:
            new_node.set_next(current)
            current.set_prev(new_node)
            self.head = new_node
    
#DELETE FIRST
    def deleteFirst(self, value):
        if(self.head == None):
            return
        current = self.head
        if(current.get_data() == value):
            self.head = current.next
            self.head.next.set_prev(self.head)

        while(current.get_data() != value and current != None):
            current = current.next
        if(current != None and current.next != None):
            current.prev.set_next(current.next)
            current.next.set_prev(current.prev)
        elif(current != None):
            current.prev.set_next(current.next)
            
#DELETE AT
    def deleteAt(self, index):
        i = 0
        current = self.head
        if(current == None):
            return
        if(index == 0 and self.head.next != null):
            self.head = self.head.next
            self.head.set_prev(None)
            return
        elif(index == 0):
            return
        while(current.next != None and i < index):
            current = current.next
            i+=1
        if(current == None or current.next == None):
            return
        elif(current.next.next == None):
            current.set_next(None)
        else:
            current.set_next(current.next.next)
            current.next.set_prev(current)
        
#DELETE ALL
    def deleteAll(self, value):
        if(self.head == None):
            return
        current = self.head
        while (current != None):
            if(self.head.get_data() == value and self.head.next != None):
                self.head = self.head.next
                self.head.set_prev(None)
                
            elif(self.head.get_data() == value):
                head = None
                return
            elif(current.get_data() == value and current.next != None):
                if(current == None):
                    return
                if(current.next == None):
                    current.set_next(None)
                else:
                    current.prev.set_next(current.next)
                    current.next.set_prev(current.prev)
            elif(current.get_data() == value):
                current.prev.set_next(None)
            current = current.next
        return
#INSERT
    def insert(self, value, index):
        current = self.head
        i = 0
        while(current.next != None and i < index):
            current = current.next
            i+=1
        
        
        
        if(i == 0):
            self.prepend(value)
        elif(current.next == None):
            self.append(value)
        else:
            new_node = DoublyNode(value)
            new_node.set_next(current.next)
            new_node.set_prev(current.next)
            current.next.set_prev(new_node)
            current.set_next(new_node)
        
#REVERSE
    def reverse(self):
        current = self.head
        if(self.head == None):
            return
        while(current != None):
            if(current.next != None):
                tempNext = current.next
                current.set_next(current.prev)
                current.set_prev(tempNext)
                current = current.prev
            else:
                self.head = current
                self.head.next = self.head.prev
                self.head.prev = None
                return
        self.head = current

# REVERSE RECURSIVE
    def recursiveReverse(self, current):
        if(current.next == None):
            current.set_next(current.prev)
            current.set_prev(None)
            return current
        else:
            tempNext = current.next
            current.set_next(current.prev)
            current.set_prev(tempNext)
            return self.recursiveReverse(tempNext)
#SET HEAD
    def set_head(self, value):
        self.head = value
#GET HEAD
    def get_head(self):
        return self.head
#GET LIST
    def get(self):
        current = self.head
        list = []
        while(current != None):
            list.append(current.get_data())
            current = current.next
        return(list)
#PREV TEST
    def get_prev(self):
        current = self.head
        while(current.next != None):
            current = current.next
        return current.prev

def main():
    l = DoublyLinkedList()
    l.deleteFirst(1)
    l.append(1)
    l.append(2)
    l.prepend(0)
    l.insert(3,4)
    l.append(3)
    l.deleteFirst(3)
    l.insert(3,3)
    l.deleteAt(3)
    l.append(2)
    l.prepend(2)
    l.deleteAll(2)
    print(l.get())
    l.reverse()
    print(l.get())
    l.set_head(l.recursiveReverse(l.get_head()))
    print(l.get())

if __name__ == "__main__":
    main()
