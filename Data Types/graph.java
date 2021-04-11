// package whatever; // don't place package name!
import java.io.*;
import java.util.*;

class Graph{
  int V;
  ArrayList<Integer>[] adj;
  
  public Graph(int V){
    this.V = V;
    adj = (ArrayList<Integer>[]) new ArrayList[V]; 
    for(int i = 0; i < V; i++){
      adj[i] = new ArrayList<Integer>();
    }
  }  
  
  public void addEdge(int v, int w){
    
    if(v > V || w > V){
      return;
    }
    
    for(int i : adj[v]){
      if(i == w){
        return;
      }
    }
    
    for(int i : adj[w]){
      if(i == v){
        System.out.println("Unbalanced Connections");
        return;
      }
    }
    
    adj[w].add(v);
    adj[v].add(w);
  }
  
  public void printGraph(){
    for(int i = 0; i < V; i++){
      System.out.print("Adj to " + i + ": ");
      for(int j : adj[i]){
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }
  
  public Iterable<Integer> returnAdj(int v){
    return adj[v];
  }
}

class DFS{
  boolean[] marked;
  int[] edgeTo;
  int s;
  
  public DFS(Graph graph, int start){
    this.s = start;
    this.marked = new boolean[graph.V];
    this.edgeTo = new int[graph.V];
    dfs(graph, start);
    //for(int i : edgeTo){
      //System.out.print(i + " ");
    //}
  }
  public void dfs(Graph graph, int v){
    marked[v] = true;
    for(int i: (Iterable<Integer>) graph.adj[v]){
      if(marked[i] != true){
        edgeTo[i] = v;
        dfs(graph, i);
      }
    }
  }

  public ArrayList<Integer> pathTo(int t){
    if(hasPathTo(t) == false){
      return null;
    }
    ArrayList<Integer> path = new ArrayList<Integer>();
    for(int i = t; i != s; i = edgeTo[i]){
      path.add(i);
      
    }
    path.add(s);
    Collections.reverse(path);
    return path;
  }
  
  public boolean hasPathTo(int t){
    return marked[t];
  }
}

class BFS{
   
   boolean[] marked;
   int[] edgeTo;
   int s;
   
   public BFS(Graph graph, int start){
     this.s = start;
     marked = new boolean[graph.V];
     edgeTo = new int[graph.V];
     bfs(graph, s);
   }
   
   public void bfs(Graph graph, int v){
     LinkedList<Integer> q = new LinkedList<Integer>();
     marked[v] = true;
     
     q.add(v);
     
     while(q.peek() != null){
      int n = q.poll();
      Iterable<Integer> adjList = graph.returnAdj(n);
      

       for(int i : adjList){
         if(marked[i] == false){
         marked[i] = true;
         q.add(i);
         edgeTo[i] = n;
         }
       }
     }
   }
   
    public ArrayList<Integer> pathTo(int t){
    if(hasPathTo(t) == false){
      return null;
    }
    ArrayList<Integer> path = new ArrayList<Integer>();
    for(int i = t; i != s; i = edgeTo[i]){
      path.add(i);
      
    }
    path.add(s);
    Collections.reverse(path);
    return path;
  }
  
  public boolean hasPathTo(int t){
    return marked[t];
  }
}


class MyCode {
	public static void main (String[] args) {
		Graph g = new Graph(9);
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(1, 4);
    g.addEdge(2, 5);
    g.addEdge(3, 4);
    g.addEdge(4, 5);
    g.addEdge(5, 6);
    g.addEdge(5, 8);
    g.addEdge(6, 7);
    g.printGraph();
    DFS d = new DFS(g, 2);
    BFS b = new BFS(g, 2);
    ArrayList<Integer> arr =  d.pathTo(7);
    ArrayList<Integer> arr2 = b.pathTo(7);
   //System.out.println(d.hasPathTo(2));
   System.out.println();
    System.out.print("DFS: ");
    for(int i : arr){
      System.out.print(i + " ");
    }
    System.out.println();
System.out.print("BFS: ");
    for(int i : arr2){
      System.out.print(i + " ");
    }
    //System.out.println("test");
  }
}
