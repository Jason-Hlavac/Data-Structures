class CircNode(object):
    def __init__ (self, d, n = None):
        self.data = d
        self.next = n
        
    def get_data(self):
        return self.data

    def set_next(self, new_next):
        self.next = new_next

class CircLinkedList(object):
    def __init__(self, last = None):
        self.last = last
#APPEND
    def append(self, value):
        current = self.last
        new_node = CircNode(value)
        if(self.last == None):
            self.last = new_node
            self.last.set_next(self.last)
        else:
            new_node.set_next(self.last.next)
            self.last.set_next(new_node)
            self.last = new_node

#PREPEND
    def prepend(self, value):
        if(self.last != None):
            new_node = CircNode(value)
            new_node.set_next(self.last.next)
            self.last.set_next(new_node)
            return
        else:
            append(value)
            
#INSERT
    def insert(self, value, index):
        if(self.last != None or index == 0 or index > self.getLength()-1):
            self.append(value)
            return
        current = self.last.next
        new_node = CircNode(value)
        i = 0
        while(current.next != self.last and i+1 < index):
            current = current.next
            i+=1
        new_node.set_next(current.next)
        current.set_next(new_node)
        return
    
#DELETE FIRST
    def deleteFirst(self, value):
        if(self.last == None):
            return
        current = self.last
        while(current.next != self.last and current.next.get_data() != value):
            current = current.next
        if(current.next.get_data() != value):
            return
        elif(current.next != self.last):
            current.set_next(current.next.next)
        else:
            tempCurrent = self.last
            if(self.last.get_data() == value):
                if(self.last.next == self.last):
                    return
                while(tempCurrent.next != self.last):
                    tempCurrent = tempCurrent.next
            tempCurrent.set_next(tempCurrent.next.next)
            self.last = tempCurrent
            return
        return

#DELETE ALL
    def deleteAll(self, value):
        current = self.last
        i = 0
        if(self.last == None):
            return
        while(current.next != self.last and i < self.get_length()):
            if(current.get_data() == value):
                i += 1
        for j in range(i):
            self.deleteFirst(value)
            
#DELETE AT
    def deleteAt(self, index):
        current = self.last
        if(index > self.get_length()-1):
            return
        elif(self.last == None):
            return
        elif(index == self.get_length()-1 and self.last.next != self.last):
            while(current.next != self.last):
                cuurrent = current.next
            current.set_next(current.next.next)
            self.last = current
            return
        else:
            i = 0
            while(current.next != self.last and i <index):
                current = current.next
                i +=1
            current.set_next(current.next.next)

#REVERSE
    def reverse(self):
        if(self.last == None):
            return
        current = self.last.next
        prev = self.last
        while(current != self.last):
            next = current.next
            current.set_next(prev)
            prev = current
            current = next
        next = current.next
        current.set_next(prev)
        prev = current
        self.last = next
        
#REVERSE RECURSIVE
    def reverseRecursive(self, curr, prev, stop):
        if(curr.next == stop):
            next = curr.next
            curr.set_next(prev)
            return next
        else:
            next = curr.next
            curr.set_next(prev)
            return(self.reverseRecursive(next, curr, stop))
#GET LIST
    def get_list(self):
        if(self.last == None):
            return
        else:
            current = self.last
            rlist = []
            while(current.next != self.last and current.next != None):
                current = current.next
                rlist.append(current.get_data())
                
                
            rlist.append(current.next.get_data())    
            return(rlist)
        
#GET LENGTH
    def get_length(self):
        if(self.last == None):
            return 0
        else:
            current = self.last
            i = 1
            while(current.next != self.last):
                current =current.next
                i+=1
            return i
#SET LAST
    def set_last(self, value):
        self.last = value

#GET LAST
    def get_last(self):
        return self.last

def main():
    l = CircLinkedList()
    l.append(1)
    l.append(2)
    l.append(3)
    l.prepend(0)
    l.insert(4,4)
    l.append(4)
    l.deleteFirst(4)
    l.append(3)
    l.prepend(3)
    l.deleteAll(3)
    l.deleteAt(2)
    print(l.get_list())
    l.reverse()
    print(l.get_list())
    l.set_last(l.reverseRecursive(l.get_last().next, l.get_last(), l.get_last().next)) 
    print(l.get_list())
    
if __name__ == "__main__":
    main()
