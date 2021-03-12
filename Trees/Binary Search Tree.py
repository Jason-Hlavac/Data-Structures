class BinaryNode(object):
    def __init__ (self, d, l = None, r = None):
        self.data = d
        self.left = l
        self.right = r
    def get_data(self):
        return self.data
    def set_left(self, new_left):
        self.left = new_left
    def set_right(self, new_right):
        self.right = new_right
    def set_data(self, new_data):
        self.data = new_data
        
class BinaryTree:
    def __init__(self, root = None):
        self.root = root
    
    def insert(self, value, current):
        if(self.find(value, self.root, 0) != -1):
            return -1
        if(self.root == None):
            self.root = BinaryNode(value)
            return -1
        if(current.get_data() < value):
            if(current.right == None):
                current.set_right(BinaryNode(value))
                return 1
            return(self.insert(value, current.right))
        elif(current.get_data() > value):
            if(current.left == None):
                current.set_left(BinaryNode(value))
                return -1
            return(self.insert(value, current.left))
        else:
            return 1
        
    def get_root(self):
        return self.root
    
    def find(self, value, current, counter):
        if(self.root == None):
            return -1
        if(current == None):
            return -1
        if(current.get_data() == value):
            return counter
        if(current.get_data() != value ):
            if(current.get_data() < value):
                counter+=1
                return(self.find(value, current.right, counter))
            elif(current.get_data() > value):
                counter +=1
                return (self.find(value, current.left, counter))
            else:
                return -1
        return -1
    
    def delete(self, value, current):
        if(current == None):
            return current
        if(value > current.get_data()):
            current.set_right(self.delete(value, current.right))
        elif(value < current.get_data()):
            current.set_left(self.delete(value, current.left))
        else:
            if(current.left == None and current.right == None):
                current = None
            elif((current.right == None) or (current.left == None)):
                if(current.right != None):
                    current. current.right
                else:
                    current.current.left
            else:
                temp = BinaryNode(self.predecessor(current))
                current.set_data(temp.get_data())
                current.set_left(self.delete(temp.get_data(), current.left))
                
        return current
    
    def predecessor(self, base):
        base = base.left
        while(base.right != None):
            base = base.right
        return base.get_data()
    
    def successor(base):
        base = base.right
        while(base.left != None):
            base = base.left
        return base.get_data()
                
    def inOrder(self, current):
        if(current == None):
            return
        self.inOrder(current.left)
        print(str(current.get_data()) + " ")
        self.inOrder(current.right)
        
    def preOrder(self, current):
        if(current == None):
            return
        print(str(current.get_data()) + " ")
        self.inOrder(current.left)
        self.inOrder(current.right)

    def postOrder(self, current):
        if(current == None):
            return
        self.inOrder(current.left)
        self.inOrder(current.right)
        print(str(current.get_data()) + " ")
    def reverse(self, current):
        if(current == None):
            return
        temp = current.left
        self.reverse(current.left)
        current.set_left(current.right)
        self.reverse(current.left)
        current.set_right(temp)
    
    def set_root(self, new_root):
        self.root = new_root

class main:
    l = BinaryTree()
    l.insert(3, l.get_root())
    l.insert(6, l.get_root())
    l.insert(2, l.get_root())
    l.inOrder(l.get_root())
    l.reverse(l.get_root())
    l.inOrder(l.get_root())
    l.set_root(l.delete(3, l.get_root()))
    l.inOrder(l.get_root())
    
if __name__ == "__main__":
    main()
