import java.util.*;
public class Graph
{
    private Map<Integer, List<Integer>> adjList;
    public Graph()
    {
        adjList = new HashMap<>();
    }  
    public void addEdge(int u,int v,boolean directed)
    {
        adjList.putIfAbsent(u,new ArrayList<>());
        adjList.putIfAbsent(v,new ArrayList<>());
        adjList.get(u).add(v);
        if(!directed)
        {
            adjList.get(v).add(u);
        }
    }
    public void printGraph()
    {
        System.out.println("Graph adjacency List: ");
        for(int vertex:adjList.keySet())
        {
            System.out.println(vertex +" -> "+adjList.get(vertex));
            
        }
    }
    public void DFS(int start)
    {
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS Traversal: "+start+" : ");
        DFSRecursive(start,visited);
        System.out.println();
    }
    public void DFSRecursive(int vertex, Set<Integer> visited)
    {
        visited.add(vertex);
        System.out.print(vertex+" ");
        for(int neighbor:adjList.getOrDefault(vertex, new ArrayList<>()))
        {
            if(!visited.contains(neighbor))
            {
                DFSRecursive(neighbor, visited);
            }
        }
    }
    public static void main(String args[])
    {
        Graph graph = new Graph();
        graph.addEdge(0,1,false);
        graph.addEdge(0,3,false);
        graph.addEdge(1,3,false);
        graph.addEdge(1,2,false);
        graph.addEdge(1,5,false);
        graph.addEdge(1,6,false);
        graph.addEdge(3,2,false);
        graph.addEdge(3,4,false);
        graph.addEdge(2,5,false);
        graph.addEdge(2,4,false);
        graph.addEdge(4,6,false);
        graph.printGraph();
        graph.DFS(0);


    }
}