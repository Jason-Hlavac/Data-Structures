
class Node:
    def __init__(self,k, v):
        self.next = None
        self.key = k
        self.value = v
class LinkedList:
    def __init__(self):
        self.head = None
        
    def prepend(self, key, value):
        if(self.head == None):
            self.head = Node(key, value)
            return
        else:
            newNode = Node(key, value)
            newNode.next = self.head
            self.head = newNode
            return
    def findValue(self, key):
        current = self.head
        while(current != None and current.key != key):
            current = current.next
        if(current == None):
            return -1
        else:
            return current.value
        
    def delete(self, key):
        if(self.head == None):
            return
        if(self.head.key == key):
            self.head = self.head.next
            return
        current = self.head
        while(current.next != null and current.next != key):
            current = current.next
        if(current.next == None or current.next != key):
            return
        current.next = current.next.next
        return
    def show(self):
        current = self.head
        print("{", end="")
        while(current != None):
            print("[{} : {} ]".format(current.key, str(current.value)) , end="")
            current = current.next
        print("}")
        
class HashMap:
    def __init__(self, s):
        self.size = s
        l = []
        for i in range(s):
            l.append(0)
        self.hashMap = l
    def add(self, key, value):
        hash = self.djb2(key)
        if(self.hashMap[hash] == 0):
            self.hashMap[hash] = LinkedList()
        if(self.hashMap[hash].findValue(key) != -1):
            return
        self.hashMap[hash].prepend(key, value)
        
    def delete(self, key):
        hash = self.djb2(key)
        if(self.hashMap[hash] == None):
            return
        self.hashMap[hash].delete(key)
        
    def get(self, key):
        hash = self.djb2(key)
        if(self.hashMap[hash] == None):
            return -1
        
        return (self.hashMap[hash].findValue(key))
    
    def djb2(self, key):
        hash = 0
        for i in range(2):
            if(len(key) > i):
                hash = ord(key[i]) + ((hash << 1) - hash)
        return hash
    
    def display(self):
        for hash in range(self.size):
            if(self.hashMap[hash] != 0):
                print("Hash Value : {} ".format(str(hash)) , end="")
                self.hashMap[hash].show()
        return
        
def main():
    l = HashMap(253)
    l.add("chicken", 123)
    l.add("omega", 24)
    l.add("keen", 83)
    l.add("ken", 84)
    l.add("check", 92)
    l.delete("check")
    l.display()
    
if __name__ == "__main__":
    main()
       
