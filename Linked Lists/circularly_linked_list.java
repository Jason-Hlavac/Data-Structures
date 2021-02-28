
// package whatever; // don't place package name!
import java.io.*;
import java.util.ArrayList;

class CircNode{
  CircNode next;
  int value;
  public CircNode(int value){
    this.value = value;
    this.next = null;
  }
  public CircNode(){
    this.value = -0;
    this.next = null;
  }
}

class CircLinkedList{
  CircNode last;
  
  public void append(int value){
    if(last == null){
      last = new CircNode(value);
      last.next = last;
      return;
    }else{
      CircNode newNode = new CircNode(value);
      newNode.next = last.next;
      last.next = newNode;
      last = newNode;
    }
  }
  public ArrayList<Integer> getList(){
    CircNode current = last;
    ArrayList<Integer> list = new ArrayList<Integer>();
    if(last == null){
      return list;
    }
    while(current.next != last){
      current = current.next;
      list.add(current.value);
    }
    list.add(current.next.value);
    return(list);
  }
  public int getLength(){
    if(last == null){
      return 0;
    }
    else{
      CircNode current = last;
      int i = 1;
      while(current.next != last){
        i++;
        current = current.next;
      }
      return i;
    }
  }
  
  public void prepend(int value){
    if(last != null){
      CircNode newNode = new CircNode(value);
      newNode.next = last.next;
      last.next = newNode;
      return;
    }else{
      append(value);
    }
  } 
  public void insert(int index, int value){
    if(last == null){
      append(value);
      return;
    }else if(index == 0){
    	prepend(value);
	return;
    }
    if(index > getLength()-1){
      append(value);
      return;
    }
      
    CircNode current = last.next;
    CircNode newNode = new CircNode(value);
    int i = 0;
    while(current.next != last && i+1 < index){
      current = current.next;
      i++;
    }
    
    newNode.next = current.next;
    current.next = newNode;
    return;
  }
  
  public void deleteFirst(int value){
    if(last == null){
      return;
    }
   
    CircNode current = last;
    while(current.next != last && current.next.value != value){
      current = current.next;
    }
  if(current.next.value != value){
    return;
  }else if(current.next != last){
    current.next = current.next.next;
  }
  else{
    CircNode tempCurrent = last;
    if(last.value == value){
      if(last.next == last){
        return;
      }
      while(tempCurrent.next != last){
        tempCurrent = tempCurrent.next;
      }
    tempCurrent.next = tempCurrent.next.next;
    last = tempCurrent;
    return;
  }
  
  return;
  }
  
  
}

public void deleteAll(int value){
  CircNode current = last;
  int i = 0;
  if(last == null){
    return;
  }
  while(current.next != last && i < getLength()){
    if(current.value == value){
      i++;
    }
    current = current.next;
  }
  for(int j = 0; j <= i; j++){
    deleteFirst(value);
  }
}

public void deleteAt(int index){
  CircNode current = last;
  if(index > getLength()-1){
    return;
    }else if(last == null){
    return;
  }else if(index == getLength()-1 && last.next != last){
    while(current.next != last){
      current = current.next;
    }
    current.next = current.next.next;
    last = current;
    return;
  }else if(index == getLength()-1){
    last = null;
    return;
  }else{
    int i = 0;
    while(current.next != last && i < index){
      current = current.next;
      i++;
    }
    current.next = current.next.next;
  }
}

public void reverse(){
if(last == null){
  return;
}
CircNode current = last.next;
CircNode prev = last;
CircNode next;

while(current != last){
  next  = current.next;
  current.next = prev;
  prev = current;
  current = next;
}
  next  = current.next;
  current.next = prev;
  prev = current;
  last = next;
}
 public CircNode CircRecursiveReverse(CircNode curr, CircNode prev, CircNode stop){
   CircNode next;
   if(curr.next == stop){
     next = curr.next;
     curr.next = prev;
     return next;
   }else{
   next = curr.next;
   curr.next = prev;
   return(CircRecursiveReverse(next, curr, stop));
   }
 }
public void setLast(CircNode value){
  last = value;
}
public CircNode getLast(){
  if(last == null){
    return last;
  }
  return last;
}
public CircNode getPrev(){
    if(last == null){
    return last;
  }
  CircNode current = last;
  while(current.next != last){
    current = current.next;
  }
  return current;
}
  public int getLastValue(){
    return last.value;
  }
}

class MyCode {
	public static void main (String[] args) {
		CircLinkedList l = new CircLinkedList();    
    l.append(1);
		l.append(2);
	  l.append(3);
	  l.append(4);
	  l.prepend(0);
	  l.insert(5,5);
	  l.insert(2,1);
	  l.deleteFirst(1);
	  l.append(2);
	  l.deleteFirst(2);
    l.insert(0,1);
    l.insert(6,1);
    l.insert(3,1);
    l.deleteAll(1);
    
    l.reverse();
    System.out.println(l.getList());
    l.setLast(l.CircRecursiveReverse(l.getLast().next, l.getLast(), l.getLast().next));

    ArrayList<Integer> rlist = l.getList();
    
    for(int i = 0; i < rlist.size(); i++){
      System.out.println(rlist.get(i));
    }
    
    System.out.println("Length = " + l.getLength());
    System.out.println("Last = " + l.getLastValue());
	}
}
