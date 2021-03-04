import java.io.*;
import java.util.ArrayList;

class Queue{
  int[] queue;
  int tailIndex;
  int headIndex;
  public Queue(int length){
    queue = new int[length];
    tailIndex = 0;
    headIndex = 0;
  }
  public boolean isEmpty(){
    return(headIndex == tailIndex);
  }
  public int peek(){
    if(isEmpty()){
      return -1;
    }
    return(queue[headIndex]);
  }
  public void push(int value){
    
    queue[tailIndex] = value;
    tailIndex++;
    if(tailIndex > queue.length){
      tailIndex = 0; 
    }
  }
  
  public void pop(){
    if(isEmpty()){
      return;
    }
    headIndex++; 
    if(headIndex > queue.length){
      headIndex = 0;
    }
  }
  public int[] display(){
    int dif;
    if(tailIndex < headIndex){
      dif = ((queue.length-1) - tailIndex) + headIndex-1;
    }else{
      dif = tailIndex - headIndex;
    }
    int i = 0;
    int[] arr = new int[dif];
    while(i < dif){
      if(headIndex +i > queue.length-1){
        arr[i] = queue[headIndex - (queue.length-1) + i];
      }else{
        arr[i] = queue[headIndex +i];
      }
      i++;
    }
    return arr;
  }
}


class main{
  public static void main(String[] args){
    Queue l = new Queue(5);
    l.push(1);
    l.push(2);
    l.push(3);
    l.push(4);
    l.pop();
    l.push(3);

    int[] list = l.display();
    
    for(int i = 0; i < list.length; i++){
      System.out.println(list[i]);
    }
    
  }
}
