// package whatever; // don't place package name!

import java.io.*;

class TreeMapNode{
  TreeMapNode left;
  TreeMapNode right;
  int value;
  String key;
  public TreeMapNode(String key, int value){
    this.key = key;
    this.value = value;
  }
}

class TreeMap{
  TreeMapNode root;
  
  public void insert(TreeMapNode current, String key, int value){
    if(current == root){
      if(findLevel(root, key, 0) != -1){
        return;
      }
    }
    if(root == null){
      root = new TreeMapNode(key, value);
      return;
    }
    if(current == null){
      return;
    }
    
    if(key.compareTo(current.key)< 0){
      if(current.left == null){
        current.left = new TreeMapNode(key, value);
        return;
      }else{
        insert(current.left, key, value);
      }
    }else if(key.compareTo(current.key)>0){
      if(current.right == null){
        current.right = new TreeMapNode(key, value);
        return;
      }else{
        insert(current.right, key, value);
      }
    }
  }
  
  public void deleteNode(String key){
    root = delete(root, key);
  }
  
  public TreeMapNode delete (TreeMapNode current, String key){
    if(current == null){
      return current;
    }
    if(key.compareTo(current.key)< 0){
      current.left = delete(current.left, key);
    }
    else if(key.compareTo(current.key) > 0){
      current.right = delete(current.right, key);
    }else{
      if(current.right == null && current.left == null){
        current = null;
      }else if(current.right != null && current.left != null){
        TreeMapNode temp = findMin(current.right);
        current.key = temp.key;
        current.value = temp.value;
        current.right = delete(current.right, temp.key);
      }else{
        if(current.right != null){
          current = current.right;
        }else{
          current= current.left;
        }
      }
    }
    return current;
  }
  
  public TreeMapNode findMin(TreeMapNode current){
    if(current.left != null){
    return findMin(current.left);
    }
    return current;
  }
  
  public TreeMapNode findMax(TreeMapNode current){

    if(current.right != null){
    return findMin(current.right);
    }
    return current;
  }
  
  public int findLevel(TreeMapNode current, String key, int i){
    if(current == null || root == null){
      return -1;
    }else if(key.compareTo(current.key) == 0){
      return i;
    }else if(key.compareTo(current.key) > 0){
      return(findLevel(current.right, key, i+1));
    }else if(key.compareTo(current.key)< 0){
      return(findLevel(current.left, key, i+1));
    }else{
      return -1;
    } 
  }
  
  public int find(TreeMapNode current, String key){
    if(current == null || root == null){
      return -1;
    }else if(key.compareTo(current.key) == 0){
      return current.value;
    }else if(key.compareTo(current.key) > 0){
      return(find(current.right, key));
    }else if(key.compareTo(current.key)< 0){
      return(find(current.left, key));
    }else{
      return -1;
    } 
  }
  
  public void reverse(TreeMapNode current){
    if(current != null){
      TreeMapNode temp = current.left;
      current.left = current.right;
      current.right = temp;
      reverse(current.left);
      reverse(current.right);

    }
  }
  
  public void printInOrder(TreeMapNode current){
    if(current == null){
      return;
    }
    printInOrder(current.left);
    System.out.print("[" + current.key + " : " + Integer.toString(current.value) + "]");
    printInOrder(current.right);
    
  }
  
  public void printPreOrder(TreeMapNode current){
    if(current == root){
      System.out.print("{");
    }
    if(current == null){
      return;
    }
    System.out.print("[" + current.key + " : " + Integer.toString(current.value) + "]");
    printPreOrder(current.left);
    printPreOrder(current.right);
    
  }
  
  public int countLeaves(TreeMapNode current, int i){
    if(current == null){
      return i; 
    }
    if(current.left != null && current.right != null){
      
      i += countLeaves(current.left, i);
      i += countLeaves(current.right, i);
      return i;
    }else if(current.right == null && current.right == null){
      return 1;
    }else{
      if(current.left != null){
        return(countLeaves(current.left, i));
      }else{
        return(countLeaves(current.right, i));
      }
    }
  }
  
  public void printPostOrder(TreeMapNode current){
    if(current == null){
      return;
    }
    printPreOrder(current.left);
    printPreOrder(current.right);
    System.out.print("[" + current.key + " : " + Integer.toString(current.value) + "]");
  }
  
  public TreeMapNode getRoot(){
    return root;
  }
  
  public void print(){
    System.out.print("{");
    printInOrder(root);
    System.out.println("}");
  }
}


class MyCode {
	public static void main (String[] args) {
		TreeMap t = new TreeMap();
    /*t.insert(t.getRoot(), "chicken", 4);
    t.insert(t.getRoot(),"poggers", 7);
    t.insert(t.getRoot(), "hi", 1);
    t.insert(t.getRoot(), "ptrfamilysmurf2.0", 0);
    t.insert(t.getRoot(), "5", 4);
    t.insert(t.getRoot(),"a", 5);
    t.deleteNode("chicken");
    t.print();
    System.out.println();
    t.reverse(t.getRoot());
    t.printPreOrder(t.getRoot());
    System.out.println();
    t.printPostOrder(t.getRoot());
    System.out.println();
    System.out.println(t.countLeaves(t.getRoot(), 0));
    //System.out.println(t.getRoot().key);
    //System.out.println(t.findLevel(t.getRoot(), "ptrfamilysmurf2.0", 0));
    //System.out.println(t.find(t.getRoot(), "poggers"));
	*/
  t.insert(t.getRoot(), "5", 5);
  for(int i = 0; i < 10; i++){
    t.insert(t.getRoot(), String.valueOf(i) , i);
  }
  t.print();
  System.out.println(t.countLeaves(t.getRoot(), 0));
  }
  
  
}
