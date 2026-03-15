import java.util.*;
class Graph{
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    Graph(int v)
    {
           for(int i=0;i<v;i++)
           {
            adjList.add(new ArrayList<Integer>());

           }
    }
    public void addEdge(int u,int v)
    {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
}
public class GraphRepresenation {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(2,3);
        g.addEdge(1,4);
        g.addEdge(2,3);
        g.addEdge(0,4);
        g.prinAdjList();
        sc.close();
    }
}
