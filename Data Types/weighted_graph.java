
import java.io.*;
import java.util.*;

class Edge{
  int connection;
  int weight;
  
  public Edge(int connection, int weight){
    this.connection = connection;
    this.weight = weight;
  }
  
  public void print(){
    System.out.println("Connection to: " + connection + " Weight: " + weight);
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
    edges[v].add(new Edge(x, w));
    edges[x].add(new Edge(v, w));
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
}

class MyCode {
    public static void main(String[] args){
    WeightedGraph w = new WeightedGraph(9);
    w.addEdge(0, 1, 1);
    w.addEdge(1, 2, 2);
    w.addEdge(1, 4, 3);
    w.addEdge(2, 5, 4);
    w.addEdge(3, 4, 5);
    w.addEdge(4, 5, 6);
    w.addEdge(5, 6, 7);
    w.addEdge(5, 8, 8);
    w.addEdge(6, 7, 9);
    w.print();

  }
}

