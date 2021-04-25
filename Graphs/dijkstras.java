import java.io.*;
import java.util.*;

class Edge implements Comparator<Edge>{
  int connection;
  int weight;
  
  public Edge(){
    
  }
  
  public Edge(int connection, int weight){
    this.connection = connection;
    this.weight = weight;
  }
  
  public void print(){
    System.out.println("Connection to: " + connection + " Weight: " + weight);
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
    edges[v].add(new Edge(x, w));
    //edges[x].add(new Edge(v, w));
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


class Dijkstra{
  PriorityQueue<Edge> pq;
  int[] edgeTo;
  int[] distTo;
  Set<Integer> marked;
  int s;
  int v;
  public Dijkstra(WeightedGraph g, int s){
    this.v = g.V;
    pq = new PriorityQueue<Edge>(v, new Edge());
    edgeTo = new int[v];
    distTo = new int[v];
    marked =  new HashSet<Integer>();
    this.s = s;
    distTo[s] = 0;
    pq.add(new Edge(s, 0));
    distTo[s] = 0;
    for(int i  = 0; i < v; i++){
      if(i != s){
        distTo[i] = Integer.MAX_VALUE;
      }
    }
    dijkstra(g, s);
  }
  
  public void dijkstra(WeightedGraph g, int s){
    while(!pq.isEmpty()){
      Edge n = pq.poll();
      marked.add(n.connection);
      for(Edge e : g.returnAdj(n.connection)){
        if(!marked.contains(e.connection)){
          if(distTo[n.connection] + e.weight < distTo[e.connection]){
            distTo[e.connection] = distTo[n.connection] + e.weight;
            edgeTo[e.connection] = n.connection;
          }
          pq.add(new Edge(e.connection, distTo[e.connection]));
        }
      }
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

class MyCode {
    public static void main(String[] args){
    WeightedGraph w = new WeightedGraph(9);
   /* w.addEdge(0, 1, 1);
    w.addEdge(2, 1, 2);
    w.addEdge(1, 4, 3);
    w.addEdge(5, 2, 4);
    w.addEdge(3, 4, 5);
    w.addEdge(4, 5, 6);
    w.addEdge(5, 6, 7);
    w.addEdge(5, 8, 8);
    w.addEdge(6, 7, 9);
    w.addEdge(1, 5, 7);
    w.addEdge(2, 4, 6);
    w.addEdge(0, 7, 23);
    */
    w.add
    //w.print();
    Dijkstra d = new Dijkstra(w, 3);
    for(int e : d.pathTo(1)){
      System.out.print(e + " ");
    }

  }
}
