// package whatever; // don't place package name!

import java.io.*;


class Stack{
  int[] stack;
  int topIndex;
  public Stack(int length){
    stack = new int[length+1];
    topIndex = 0;
  }
  
  public boolean isEmpty(){
    return(topIndex == 0);
}

public int peek(){
  if(isEmpty()){
    return -1;
  }
  return stack[topIndex-1];
}
public void pop(){
  if(isEmpty()){
    return;
  }else{
    topIndex--;
  }
}
  public void push(int value){
        if(topIndex < stack.length-1){ 
        stack[topIndex] = value;
        topIndex++;
        return; 
        }else{
        }
  }
  
  public int[] display(){
    int[] list = new int[topIndex];
    int j = 0;
    for(int i = topIndex-1; i >= 0 ; i--){
      list[j] = stack[i];
      j++;
    }
    return list;
  }
}

class MyCode {
  public static void main(String[] args){
  Stack l = new Stack(3);
  l.push(1);
  l.push(2);
  l.push(3);
  l.pop();
  int[] list = l.display();
  int i = 0;
  while(i < list.length){
    System.out.println(list[i]);
    i++;
  }
  System.out.println("Top: " +  l.peek());
}
}
