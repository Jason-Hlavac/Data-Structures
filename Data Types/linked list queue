import java.io.*;
import java.util.ArrayList;

class QueueNode{
  int value;
  QueueNode next;
  public QueueNode(int value){
    this.value = value;
    this.next = null;
  }
}
class Queue{
  QueueNode head;
  QueueNode tail;
  public boolean isEmpty(){
    return(head == null);
  }
  
  public int peek(){
    return head.value;
  }
  public void push(int value){
    QueueNode newNode = new QueueNode(value);
    if(isEmpty()){
      head = newNode;
      tail = newNode;
    }else{
      tail.next = newNode;
      tail = newNode;
    }
  }
  public void pop(){
    if(isEmpty()){
      return;
    }
    if(head.next == null){
      head = null;
      tail = null;
      return;
    }else{
      head = head.next;
    }
  }
  public ArrayList<Integer> display(){
    QueueNode current = head;
    ArrayList<Integer> list = new ArrayList<Integer>();
    while(current != null){
      list.add(current.value);
      current = current.next;
    }
    return list;
  }
}

class main{
  public static void main(String[] args){
    Queue l = new Queue();
    l.push(1);
    l.push(2);
    l.push(3);
    l.push(4);

    l.pop();
    
    System.out.println(l.display());
    System.out.println(l.peek());
    
  }
}
