// package whatever; // don't place package name!

import java.io.*;

class BinaryNode{
  BinaryNode left;
  BinaryNode right;
  int value;
  public BinaryNode(int value){
    left = null;
    right = null;
    this.value = value;
  }
}

class BinaryTree{
  BinaryNode root;
  
  public int insert(int value, BinaryNode current){
    if(find(value, root, 0) != -1){
      return 1;
    }
    if(root == null){
      root = new BinaryNode(value);
      return 1;
    }
    if(current.value < value){
      if(current.right == null){
        current.right = new BinaryNode(value);
        return 1;
      }
      return(insert(value, current.right));
    }else if(current.value > value){
      if(current.left == null){
        current.left = new BinaryNode(value);
        return 1;
      }
      return(insert(value, current.left));
    }else{
      return 1;
    }
  }
  
  public int find(int value, BinaryNode current, int counter){
    if(root == null){
      return -1;
    }
    if(current == null){
      return -1;
    }
    if(current.value == value){
      return counter;
    }
    if(current.value != value){
      if(current.value < value){
        counter++;
        return(find(value, current.right, counter));
      }else if(current.value > value){
        counter++;
        return(find(value, current.right, counter));
      }else{
        return -1;
      }
    }
    return -1;
  }
  

  public BinaryNode delete(int value, BinaryNode current){
    if(current == null){
      return current;
    }
    if(value > current.value){
      current.right = delete(value, current.right);
    }else if(value < current.value){
      current.left = delete(value, current.left);
    }else{
      //Case 1 (No Children)
      if(current.left == null && current.right == null){
        current = null;
      }else if(((current.right == null)||(current.left == null))){ // Case 2 (1 Child)
        if(current.right != null){
          current = current.right;
        }else{
          current = current.left;
        }
      }
      else{ //Case 3 (2 Children)
        BinaryNode temp = new BinaryNode(predecessor(current));
        current.value = temp.value;
        current.left = delete(temp.value, current.left);
      }
        
    }
    return current;
  }
  
  public int successor(BinaryNode base){
    base = base.right;
    while(base.left != null){
      base = base.left;
    }
    return base.value;
  }
  
  public int predecessor(BinaryNode base){
    base = base.left;
    while(base.right != null){
      base = base.right;
    }
    return base.value;
  }
  
  public void preorder(BinaryNode current){
    if(current == null){
      return;  
    }
    System.out.println(current.value);
    preorder(current.left);
    preorder(current.right);
  }
  public void postorder(BinaryNode current){
    if(current == null){
      return;  
    }
    
    postorder(current.left);
    postorder(current.right);
    System.out.println(current.value);
  }
  public void deleteNode(int value){
    root = delete(value, root);
  }
  public void printInOrder(BinaryNode current, String space){
    if(current == null){
      return;  
    }
    printInOrder(current.left, space);
    System.out.println(space + current.value);
    
    printInOrder(current.right, space);
  }
  
  public BinaryNode get_root(){
    return root;
  }
  
  public void reverse(BinaryNode current){
    if(current == null){
      return;
    }
    
    BinaryNode temp = current.left;
    reverse(current.left);
    current.left = current.right;
    reverse(current.left);
    current.right = temp;

  }
}


class MyCode {
	public static void main (String[] args){
		BinaryTree l = new BinaryTree();
    l.insert(5, l.get_root());
    l.insert(2, l.get_root());
    l.insert(3, l.get_root());
    l.insert(1, l.get_root());
    l.insert(7, l.get_root());
    l.insert(6, l.get_root());
    l.insert(8, l.get_root());
    l.deleteNode(5);
    l.reverse(l.get_root());
    /*
        3
      2  7
    1   6 8
    */
    
    
    //l.postorder(l.get_root());
    //l.preorder(l.get_root());
    l.printInOrder(l.get_root(), "");
    
    //System.out.println(l.find(1, l.get_root(), 0));
    
	}
}
