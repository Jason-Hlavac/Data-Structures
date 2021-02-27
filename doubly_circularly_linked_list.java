// package whatever; // don't place package name!

import java.io.*;
import java.util.ArrayList;

class DoublyCircNode{
  DoublyCircNode next;
  DoublyCircNode prev;
  int value;
  
  public DoublyCircNode(int value){
    this.value = value;
    this.next = null;
    this.prev= null;
  }
  
}

class DoublyCircLinkedList{
  DoublyCircNode last;
  public void append(int value){
    DoublyCircNode newNode = new DoublyCircNode(value);
    if(last == null){
      last = newNode;
      last.next = newNode;
      last.prev = newNode;
      return;
    }
    newNode.prev = last;
    newNode.next = last.next;
    last.next.prev = newNode;
    last.next = newNode;
    last = newNode;
  }
  
  public void prepend(int value){
    DoublyCircNode newNode = new DoublyCircNode(value);
    if(last == null){
      append(value);
      return;
    }
    newNode.prev = last;
    newNode.next = last.next;
    last.next.prev = newNode;
    last.next = newNode;
    return;
  }
  
  public int getLength(){
    if(last != null){
      DoublyCircNode current = last;
      int i = 1;
      while(current.next != last){
        i++;
        current = current.next;
      }
      return i;
    }else{
      return 0;
    }
  }
  
  public void insert(int value, int index){
    if(index == 0){
      prepend(value);
      return;
    }else if(index > getLength() || last == null){
      append(value);
      return;
    }
    else{
      DoublyCircNode current = last;
      DoublyCircNode newNode = new DoublyCircNode(value);
      int i = 1;
      while(current.next != last && i < index){
        current = current.next;
        i++;
      }
      if(current.next == last){
        newNode.prev = current;
        newNode.next = current.next;
        current.next.prev = newNode;
        current.next = newNode;
      }else{
        newNode.prev = current;
        newNode.next = current.next;
        current.next.prev = newNode;
        current.next = newNode;
      }
    }
  }
  public void deleteFirst(int value){
    if(last == null){
      return;
    }else if(last.next == last && last.value == value){
      last = null;
      return;
    }
    DoublyCircNode current = last;
    while(current.next != last && current.next.value != value){
      current = current.next;
    }
    if(current.next == last && last.value == value){
      last.prev.next = last.next;
      last.next.prev = last.prev;
      last = last.prev;
      return;
    }else if(current.next == last && !(last.value == value)){
      return;
    }else{
    current.next = current.next.next;
    current.next.prev = current;
    return;
    }
  }
  
  public void deleteAll(int value){
    if(last == null){
      return;
    }
    DoublyCircNode current = last.next;
    while(current != last){
      if(current.value == value){
        deleteFirst(value);
      }
      current = current.next;
    }
      deleteFirst(value);
  }
  public void deleteAt(int index){
    if(last == null || index > getLength()-1){
      return;
    }
    if(last.next == last){
      last = null;
      return;
    }
    DoublyCircNode current = last;
    int i = 0;
    while(current.next != last && i < index){
      current = current.next;
      i++;
    }
    if(current == current.next.next){
      last.next = last;
      last.prev = last;
    }
    else if(current.next == last){
      current.next = current.next.next;
      current.next.prev = current;
      last = current;
    }else{
      current.next = current.next.next;
      current.next.prev = current;
    }
  }
    
  public ArrayList<Integer> getValues(){
    ArrayList<Integer> rlist = new ArrayList<Integer>();
    DoublyCircNode current = last.next;
    while(current != last){
      rlist.add(current.value);
      current = current.next;
    }
    rlist.add(last.value);
    return rlist;
  }
  
  public void reverse(){
    if(last == null){
      return;
    }
    DoublyCircNode current = last.next;
    DoublyCircNode previous = last;
    DoublyCircNode next = last.next;
    
    while(current != last){
      next = current.next;
      current.next = previous;
      current.prev = next;
      previous = current;
      current = next;
    }
      next = current.next;
      current.next = previous;
      current.prev = next;
      last = next;  
  }

public DoublyCircNode reverseRecursive(DoublyCircNode previous, DoublyCircNode current, DoublyCircNode stop){
  DoublyCircNode next;
  if(current == stop){
     next = current.next;
    current.next = previous;
    current.prev = next;
    last = next;
    return last;
  }
  next = current.next;
  current.next = previous;
  current.prev = next;
  
  return(reverseRecursive(current, next, stop));  
}
public void setLast(DoublyCircNode value){
last = value;
}
public DoublyCircNode getLast(){
  return last;
}

}
class MyCode {
	public static void main (String[] args) {
	DoublyCircLinkedList l = new DoublyCircLinkedList();
  l.append(1);
  l.append(2);
  l.append(3);
  l.prepend(0);
  l.insert(4,4);
  l.append(4);
  l.deleteFirst(4);
  l.append(3);
  l.prepend(3);
  l.deleteAll(3);
  l.deleteAt(3);
  l.append(4);
  l.append(5);
  
  System.out.println(l.getValues());
  l.reverse();
  System.out.println(l.getValues());
  l.reverseRecursive(l.getLast(), l.getLast().next, l.getLast());
  System.out.println(l.getValues());
	}
}
