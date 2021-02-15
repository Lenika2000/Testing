package algorithm;
import java.util.*;

public class Graph {
    private final ArrayList<LinkedList<Integer>> adjLists;
    private final ArrayList<Integer> visitedVertices = new ArrayList<>();
    private final boolean[] visited;

    public Graph(int vertices) {
        adjLists = new ArrayList<>();
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists.add(i, new LinkedList<Integer>());
    }

    public void addEdge(int src, int dest) {
        adjLists.get(src).add(dest);
    }

    public LinkedList<Integer> getEdges(int src) {
        return adjLists.get(src);
    }

    public ArrayList<Integer> getVisitedVertices() {
        return visitedVertices;
    }

    public void DFS(int vertex) {
        visited[vertex] = true;
        visitedVertices.add(vertex);
        System.out.print(vertex + " ");

        for (int next : adjLists.get(vertex)){
            if (!visited[next]){
                DFS(next);
            }
        }
    }
}
