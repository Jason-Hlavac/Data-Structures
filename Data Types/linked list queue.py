class QueueNode(object):
    def __init__ (self, d, n = None):
        self.data = d
        self.next = n
        
    def get_data(self):
        return self.data

    def set_next(self, new_next):
        self.next = new_next
        
class Queue(object):
    def __init__(self, head = None, tail = None):
        self.head = head
        self.tail = tail
    def isEmpty(self):
        return (self.head == None)
    def peek(self):
        return self.head.get_data()
    def push(self, value):
        newNode = QueueNode(value)
        if(self.isEmpty()):
            self.head = newNode
            self.tail = newNode
        else:
            self.tail.set_next(newNode)
            self.tail = newNode
    def pop(self):
        if(self.isEmpty()):
            self.head = None
            self.tail = None
            return
        else:
            self.head = self.head.next
    def display(self):
        arr = []
        current = self.head
        while(current != None):
            arr.append(current.get_data())
            current = current.next
        return arr

def main():
    l = Queue()
    l.push(1)
    l.push(2)
    l.push(3)
    l.push(4)
    
    l.pop()
    l.peek()
    
    arr = l.display()
    
    for j in range(len(arr)):
        print(arr[j])
    
if __name__ == "__main__":
    main()
