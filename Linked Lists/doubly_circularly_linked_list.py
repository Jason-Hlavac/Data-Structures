class DoublyCircNode(object):
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

class DoublyCircLinkedList(object):
    def __init__(self, last = None):
        self.last = last
        
    def append(self, value):
        newNode = DoublyCircNode(value)
        if(self.last == None):
            self.last = newNode
            self.last.set_next(newNode)
            self.last.set_prev(newNode)
            return
        newNode.set_prev(self.last)
        newNode.set_next(self.last.next)
        self.last.next.set_prev(newNode)
        self.last.set_next(newNode)
        self.last = newNode
        
    def prepend(self, value):
        newNode = DoublyCircNode(value)
        if(self.last == None):
            self.append(value)
            return
        newNode.set_prev(self.last)
        newNode.set_next(self.last.next)
        self.last.next.set_prev(newNode)
        self.last.set_next(newNode)
        return
    def getLength(self):
        if(self.last != None):
            current = self.last
            i = 1
            while(current.next != self.last):
                i+=1
                current = current.next
            return i
        else:
            return 0
        
    def insert(self, value, index):
        if(index == 0):
            prepend(value)
            return
        elif(index > self.getLength() or self.last == None):
            append(value)
            return
        else:
            current = self.last
            i = 1
            while(current.next != self.last and i <index):
                i+=1
                current = current.next
            newNode = DoublyCircNode(value)
            if(current.next == self.last):
                newNode.set_prev(current)
                newNode.set_next(current.next)
                current.next.set_prev(newNode)
                current.set_next(newNode)
            else:
                newNode.set_prev(current)
                newNode.set_next(current.next)
                current.next.set_prev(newNode)
                current.set_next(newNode)
                
    def deleteFirst(self, value):
        current = self.last
        if(self.last == None):
            return
        elif(self.last.next == self.last and self.last.get_data() != value):
            self.last = None
            return
        while(current.next != self.last and current.next.get_data() != value):
            current = current.next
        if(current.next == self.last and self.last.get_data() == value):
            self.last.prev.set_next(self.last.next)
            self.last.next.set_prev(self.last.prev)
            self.last = self.last.prev
            return
        elif(current.next == self.last and self.last.get_data() != value):
            return
        else:
            current.set_next(current.next.next)
            current.next.set_prev(current)
            return
    
    def deleteAll(self, value):
        if(self.last == None):
            return
        current = self.last.next
        while(current != self.last):
            if(current.get_data() == value):
                self.deleteFirst(value)
            current = current.next
        self.deleteFirst(value)
            
    def deleteAt(self, index):
        if(self.last == None or index > self.getLength()-1):
            return
        if(self.last.next == self.last):
            self.last = None
            return
        current = self.last
        i = 0
        while(current.next != self.last and i < index):
            current = current.next
            i+=1
        if(current == current.next.next):
            self.last.set_next(self.last)
            self.last.set_prev(self.last)
        elif(current.next == self.last):
            current.set_next(current.next.next)
            current.next.set_prev(current)
            self.last = current
        else:
            current.set_next(current.next.next)
            current.next.set_prev(current)
            
    def reverse(self):
        if(self.last == None):
            return
        current = self.last.next
        previous = self.last
        n = self.last.next
        while(current != self.last):
            n = current.next
            current.set_next(previous)
            current.set_prev(n)
            previous = current
            current = n
        n = current.next
        current.set_next(previous)
        current.set_prev(n)
        self.last = n
        
        
    def reverseRecursive(self, previous, current, stop):
        if(current == stop):
            n = current.next
            current.set_next(previous)
            current.set_prev(next)
            self.last = n
            return self.last
        n = current.next
        current.set_next(previous)
        current.set_prev(next)
        
        return (self.reverseRecursive(current, n, stop))
        
    def get_last(self):
        return self.last
    def set_last(self, value):
        self.last = DoublyCircNode(value)
    def getValues(self):
        arr = []
        current = self.last.next
        while(current != self.last):
            arr.append(current.get_data())
            current = current.next
        arr.append(self.last.get_data())
        return arr
def main():
        l = DoublyCircLinkedList()
        l.append(3)
        l.append(2)
        l.append(1)
        l.append(0)
        l.prepend(4)
        l.insert(3,3)
        l.deleteFirst(3)
        l.prepend(2)
        l.append(2)
        l.deleteAll(2)
        l.deleteAt(2)
        
        print(l.getValues())
        l.reverse()
        print(l.getValues())
        l.reverseRecursive(l.get_last(), l.get_last().next, l.get_last())
        print(l.getValues())
        
        
if __name__ == "__main__":
    main()
