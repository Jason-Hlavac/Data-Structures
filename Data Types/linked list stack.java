// package whatever; // don't place package name!

import java.io.*;
import java.lang.Exception;
import java.util.ArrayList;

class StackNode{
  int value;
  StackNode down;
  public StackNode(int value){
    this.value = value;
    down = null;
  }
  
}

class Stack{
  StackNode top;
  public void push(int value){
    if(top == null){
      top = new StackNode(value);
      return;
    }else{
      StackNode newNode = new StackNode(value);
      newNode.down = top;
      top = newNode;
    }
  }
  public void pop(){
    if(top == null){
      return;
    }
    top = top.down;
  }
  public ArrayList<Integer> display(){
    ArrayList<Integer> list = new ArrayList<Integer>();
    StackNode current = top;
    while(current != null){
      list.add(current.value);
      current = current.down;
    }
    return list;
  }
  public int peek(){
    return top.value;
  }
}

class MyCode {
  public static void main(String[] args){
    Stack l = new Stack();
    l.push(4);
    l.push(3);
    l.push(2);
    l.push(1);
    l.pop();
    ArrayList<Integer> list = l.display();
    for(int i = 0; i < list.size(); i++){
      System.out.println(list.get(i));
    }
    System.out.println("Top : " l.peek());
  }
}
