class StackNode(object):
    def __init__ (self, d, n = None):
        self.data = d
        self.down = n
        
    def get_data(self):
        return self.data

    def set_down(self, new_down):
        self.down = new_down
        
class Stack(object):
    def __init__(self, top = None):
        self.top = top
    def push(self, value):
        if(self.top == None):
            self.top = StackNode(value)
        else:
            newNode = StackNode(value)
            newNode.set_down(self.top)
            self.top = newNode
            
    def pop(self):
        if(self.top == None):
            return
        else:
            self.top = self.top.down
    def display(self):
        arr = []
        current = self.top
        while(current != None):
            arr.append(current.get_data())
            current = current.down
        return arr

        
def main():
    l = Stack()
    l.push(1)
    l.push(2)
    l.push(3)
    l.push(4)
    
    l.pop()
    
    arr = l.display()
    
    for j in range(len(arr)):
        print(arr[j])
    
if __name__ == "__main__":
    main()
