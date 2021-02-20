// package whatever; // don't place package name!

import java.io.*;
import java.util.ArrayList;

class DoublyNode{
  DoublyNode next;
  DoublyNode prev;
  int value;
  public DoublyNode(int value){
    this.value = value;
  }
}

class DoublyLinkedList{
  DoublyNode head;
  public DoublyNode getTail(){
    DoublyNode current = head;
    if(head != null){
      while(current.next != null){
        current = current.next;
      }
    if(head == null){
      return head;
    }
    }
    return(current);
  }
  public ArrayList<Integer> getList(){
    DoublyNode current = head;
    ArrayList<Integer> rlist = new ArrayList<Integer>();
    while(current != null){
      rlist.add(current.value);
      current = current.next;
    }
    return rlist;
  }
  
  public void append(int value){
    DoublyNode current = head;
    if(current == null){
      prepend(value);
    }
    while(current.next != null){
      current = current.next;
    }
    current.next = new DoublyNode(value);
    current.next.prev = current;
    return;
  }
  public void prepend(int value){
    DoublyNode current = head;
    if(current == null){
      head = new DoublyNode(value);
      return;
    }else{
      DoublyNode temp = new DoublyNode(value);
      temp.next = head;
      head.prev = temp;
      head = temp;
    }
  }
  public void insert(int index, int value){
    if(head == null || index == 0){
      prepend(value);
      return;
    }
    int i = 0;
    DoublyNode current = head;
    while(i+1 < index && current.next != null){
      current = current.next;
      i++;
    }
    if(current.next == null){
      append(value);
      return;
    }
    DoublyNode inserted = new DoublyNode(value);
    DoublyNode temp = current.next;
    current.next = inserted;
    inserted.next = temp;
    temp.prev = inserted;
    inserted.prev = current;
  }
  public int getLength(){
    DoublyNode current = head;
    int i = 0;
    while(current != null){
      i++;
      current = current.next;
    }
    return i;
  }
  public void deleteFirst(int value){
    if(head == null){
      return;
    }
    DoublyNode current = head;
    if(head.value == value){
      head = current.next;
      head.prev = null;
      return;
    }
    
    while(current.value != value && current != null){
      current = current.next;
    }
    if(current != null & current.next != null){
      current.prev.next = current.next;
      current.next.prev = current.prev;
    }else if(current != null){
      current.prev.next = current.next;
    }
    else{
      return;
    }
  }
  public void deleteAt(int index){
    if(head == null){
      return;
    }
    DoublyNode current = head;
    if (index == 0 && head.next != null){
      head = head.next;
      head.prev = null;
      return;
    }else if(index == 0){
      return;
    }
    int i = 0;
    while(i+1 < index && current != null){
      current = current.next;
      i++;
    }
    if(current ==null || current.next == null){
      return;
    }else if(current.next.next == null){
      current.next = null;
    }else{
      current.next = current.next.next;
      current.next.prev = current;
    }
    
  }
  public void deleteAll(int value){
    if(head == null){
      return;
    }
    DoublyNode current = head;
    while(current != null){
      if(head.value == value && head.next != null){
        head = head.next;
        head.prev = null;
      }else if(head.value == value){
        head = null;
        return;
      }
      else if(current.value == value && current.next != null){
        current.prev.next = current.next;
        current.next.prev = current.prev;
      }else if(current.value == value){
        current.prev.next = null;
      }
      current = current.next;
    }
  }
  public DoublyNode getHead(){
    return head;
  }
  public void setHead(DoublyNode value){
      this.head = value;
  }
  public void reverse(){
    DoublyNode current = head;
    DoublyNode tempNext;
    if(head == null){
      return;
    }
    while(current != null){
      if(current.next != null){
      tempNext = current.next;
      current.next = current.prev;
      current.prev = tempNext;
      current = current.prev;
      }else{
        head = current;
        head.next = head.prev;
        head.prev = null;
        return;
      }
    }
    head = current;
  }
  public DoublyNode recursiveReverse(DoublyNode current){
    if(current.next == null){
      current.next = current.prev;
      current.prev = null;
      return current;
    }else{
    DoublyNode tempNext = current.next;
    current.next = current.prev;
    current.prev = tempNext;
    return recursiveReverse(tempNext);
    }
  }
  
  
}

class MyCode {
  public static void main(String[] args){
    DoublyLinkedList l = new DoublyLinkedList();
    l.prepend(1);
    l.prepend(0);
    l.append(2);
    l.append(1);
    l.append(2);
    l.insert(4,3);
    l.deleteFirst(2);
    l.append(3);
    l.deleteAt(4);
    l.append(1);
    l.append(1);
    l.deleteAll(1);
    l.reverse();
    l.setHead(l.recursiveReverse(l.getHead()));
    System.out.println(l.getTail());
    ArrayList<Integer> rlist = l.getList();
    for(int i = 0; i < rlist.size(); i++){
      System.out.println(rlist.get(i));
    }
  }
}
