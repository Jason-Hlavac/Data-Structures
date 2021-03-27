// package whatever; // don't place package name!

import java.io.*;

class PriorityNode{
  int value;
  int level;
  PriorityNode next;
  public PriorityNode(int value, int level){
    this.value = value;
    this.level = level;
  }
} 

class PriorityQueue{
  	PriorityNode head;
    
    public PriorityQueue(){
      head = null;
    }
    
    public boolean isEmpty(){
    if(head == null){
      return true;
    }else{
      return false;
    }
    }
    
    public int peek(){
      if(isEmpty()){
        return -99999;
      }
      PriorityNode current = head;
      PriorityNode temp = head;
      while(current != null){
        if(temp.level <= current.level){
          temp = current;
        }
        current = current.next;
      }
      return temp.value;
    }
    
public void enqueue(int value, int level){
      if(isEmpty()){
        head = new PriorityNode(value, level);
        return;
      }
      PriorityNode temp = head;
      head = new PriorityNode(value, level);
      head.next = temp;
  }

public int dequeue(){
      if(isEmpty()){
        return -99999;
      }
      PriorityNode current = head;
      PriorityNode temp = head;
      PriorityNode prev = head;
      PriorityNode tempprev = head;
      while(current != null){
        if(temp.level <= current.level){
          temp = current;
          tempprev = prev;
        }
        prev = current;
        current = current.next;
      }
    if(temp == head){
      
      head = temp.next;
      if(isEmpty()){
        return -999999;
      }
      return temp.value;
      }else{
      tempprev.next = temp.next;
      return temp.value;
    }
}
  
public void display(){
  PriorityNode current = head;
  while(current != null){
    System.out.println(Integer.toString(current.value) + " : " + Integer.toString(current.level));
    current = current.next;
  }
}
}



class MyCode {
	public static void main (String[] args) {
    PriorityQueue p = new PriorityQueue();
    p.enqueue(1,1);
    p.enqueue(5,5);
    p.enqueue(2,2);
    p.enqueue(7,1983475023);
    p.enqueue(3,3);
    p.enqueue(6,5);
    p.enqueue(4,4);
    //System.out.println(p.peek());
    p.display();
    System.out.println();
    p.dequeue();
    p.display();
	}
}
