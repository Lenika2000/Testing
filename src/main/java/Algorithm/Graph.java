package Algorithm;
import java.util.*;

public class Graph {
    private LinkedList<Integer> adjLists[];
    private ArrayList<Integer> visitedVertices = new ArrayList<Integer>();
    private boolean visited[];

    public Graph(int vertices) {
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<Integer>();
    }

    public void addEdge(int src, int dest) {
        adjLists[src].add(dest);
    }

    public LinkedList<Integer> getEdges(int src) {
        return adjLists[src];
    }

    public ArrayList<Integer> getVisitedVertices() {
        return visitedVertices;
    }

    public void DFS(int vertex) {
        visited[vertex] = true;
        visitedVertices.add(vertex);
        System.out.print(vertex + " ");

        for (int next : adjLists[vertex]){
            if (!visited[next]){
                DFS(next);
            }
        }
    }
}
