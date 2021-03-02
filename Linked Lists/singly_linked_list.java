// package whatever; // don't place package name!

import java.io.*;
import java.util.ArrayList;

class Node {
	Node next;
  int value;
  public Node(int value){
    this.value = value;
  }
}

class LinkedList{
  Node head;
  
  //APPEND
  public void append(int value){
    if(head == null){
      head = new Node(value);
      return;
    }
    Node current = head;
    while(current.next != null){
      current = current.next;
    }
    current.next = new Node(value);
  }
  //PREPEND
  public void prepend(int value){
    Node newHead = new Node(value);
    newHead.next = head;
    head = newHead;
  }
  //INSERT
  public void insert(int value, int index){
    Node current = head;
    int i = 0;
    if(i != index){
      while(i+1 < index && current.next != null){
        current = current.next;
        i++;
      }
      
      if(current.next == null){
        append(value);
        return;
      }
      
      Node inserted = new Node(value);
      Node next = current.next;
      current.next = inserted;
      inserted.next = next;
    }else{
      prepend(value);
      return;
    }
    
  }
  
  //DELETE VALUE
  public void deleteValue(int target){
    Node current = head;
    if(head == null){
      return;
    }
    while(current.next.value != target && current.next != null){
      current = current.next;
    }
    if(current.next == null){
      return;
    }else{
      current.next = current.next.next;
    }
  }
  
  // DELETE AT INDEX
  public void deleteAt(int index){
    int i = 0;
    Node current = head;
    if(current == null || index >= getLength()){
      return;
    }
    if(i == index){
      head = current.next;
      return;
    }
      while(i+1 < index){
        current =current.next;
        i++;
      }
      current.next = current.next.next;
    }
  
  //GET LENGTH
  public int getLength(){
    Node current = head;
    if(current != null){
      int i = 0;
      while(current != null){
        i++;
        current = current.next;
      }
      return(i);
    }else{
      return(0);
    }
  }
  //REVERSE
  public void reverse(){
    Node current = head;
    Node previous = null;
    Node next;
    if(head == null){
      return;
    }
    while(current != null){
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    head = previous;
    
    
  }
  
  // REVERSE RECURSIVE
  
  public Node reverseRecursive(Node curr, Node prev){
    Node next;
    if(curr == null){
      return(prev);
    }
    next = curr.next;
    curr.next = prev;
    return(reverseRecursive(next, curr));

  }
  public Node getHead(){
    return head;
  }
  public void setHead(Node value){
    head = value;
  }
  
  
  //       Head
  //Null -> 0 - > 1 -> 2 -> Null
  //Null -> 2 -> 1 -> 0 -> Null
  
  
  //GET LIST
  public ArrayList<Node> getList(){
    ArrayList<Node> finished = new ArrayList<Node>();
    if(head == null){
      return finished;
    }
    Node current = head;
    
    while(current != null){
      finished.add(current);
      current = current.next;
    }
    return(finished);
  }
}

//MAIN
class MyCode{
  public static void main(String[] args){
    LinkedList l = new LinkedList();
    l.append(0);
    l.append(1);
    for(int i  = 0; i < 10; i++){
      l.append(i);
    }
    l.insert(-1, 0);
    l.insert(9, 3);
    l.deleteValue(0);
    l.deleteAt(l.getLength()+2);
    l.setHead(l.reverseRecursive(l.getHead(), null));
    System.out.println(l.getLength());
    ArrayList<Node> list = l.getList();
    for(int i = 0 ; i< list.size(); i++){
      System.out.println(list.get(i).value);
    }
  }
}


