// package whatever; // don't place package name!

import java.io.*;

import java.io.*;
import java.util.*;

class Edge implements Comparator<Edge>{
  int connection;
  int weight;
  int source;
  
  public Edge(){
    
  }
  
  public Edge(int source, int connection, int weight){
    this.connection = connection;
    this.weight = weight;
    this.source = source;
  }
  
  public void print(){
    System.out.println(source + " => " + connection + " Weight: " + weight);
  }
  @Override
  public int compare(Edge n1, Edge n2){
    if(n1.weight < n2.weight){
      return -1;
    }
    if(n1.weight > n2.weight){
      return 1;
    }else{
      return 0;
    }
  }
}

class WeightedGraph{
  ArrayList<Edge>[] edges;
  int V;
  
  public WeightedGraph(int v){
    this.V = v;
    this.edges = (ArrayList<Edge>[]) new ArrayList[V];
    for(int i  = 0; i < v; i++){
      edges[i] = new ArrayList<Edge>();
    }
  }
  
  public void addEdge(int v, int x, int w){
    edges[v].add(new Edge(v, x, w));
    edges[x].add(new Edge(x, v, w));
  }
  
  public void print(){
    for(int i = 0; i < V; i++){
      System.out.println(i + ": ");
      for(Edge j : edges[i]){
        j.print();
      }
      System.out.println("=======================");
    }
  }
    public Iterable<Edge> returnAdj(int v){
    return edges[v];
  }
}


  public boolean hasPathTo(int s){
    if(marked.contains(s)){
      return true;
    }else{
      return false;
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
}

class WeightedQuickUnion{
  int[] sets;
  public WeightedQuickUnion(int s){
    sets = new int[s];
    for(int i  = 0; i < s; i++){
      sets[i] = -1;
    }
  }
  
  public boolean isCon(int s, int t){
    return(find(s) == find(t));
  }
  
  public void con(int s, int t){
  sets[find(s)] = find(t);
  }
  
  public int find(int current){
    int i = current;
    while(sets[i] != -1){
      i = sets[i];  
    }
    return i;
  }
}

class Kruskal{
  PriorityQueue<Edge> pq;
  ArrayList<Edge> mst;
  public Kruskal(WeightedGraph g){
    pq = new PriorityQueue<Edge>(g.V, new Edge());
    for(int i = 0; i < g.V; i++){
      for(Edge j : g.returnAdj(i)){
        pq.add(j);
      }
    }
    kruskal(g);
  }
  public void kruskal(WeightedGraph g){
    mst = new ArrayList<Edge>();
    WeightedQuickUnion wqu = new WeightedQuickUnion(g.V);
    while(!pq.isEmpty()){
      Edge n = pq.poll();
      if(wqu.isCon(n.source, n.connection) == false){
        wqu.con(n.source, n.connection);
        mst.add(n);
        
      }
    }
  }
  public Iterable<Edge> getMST(){
    return mst;
  }
}

class MyCode {
    public static void main(String[] args){
    WeightedGraph w = new WeightedGraph(15);

    w.addEdge(0, 2, 1);
    w.addEdge(0, 1, 2);
    w.addEdge(1, 2, 5);
    w.addEdge(2, 4, 1);
    w.addEdge(1, 4, 3);
    w.addEdge(2, 5, 15);
    w.addEdge(1, 3, 11);
    w.addEdge(4, 5, 4);
    w.addEdge(3, 4, 3);
    w.addEdge(4, 6, 3);
    w.addEdge(5, 6, 1);
    w.addEdge(3, 6, 1);
    
      Kruskal k = new Kruskal(w);
      Iterable<Edge> edges = k.getMST();
      for(Edge i : edges){
        i.print();
      }
  }
}
