package AlgorithmTest;

import Algorithm.Graph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ListIterator;

public class AlgorithmTest1 extends Assert {

    public int vertices = 8;
    public Graph graph = new Graph(vertices);

    @Before
    public void setUp() {
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 0);
        graph.addEdge(0, 3);
        graph.addEdge(3, 0);
        graph.addEdge(1, 2);
        graph.addEdge(2, 1);
        graph.addEdge(1, 3);
        graph.addEdge(3, 1);
        graph.addEdge(2, 5);
        graph.addEdge(5, 2);
        graph.addEdge(3, 7);
        graph.addEdge(7, 3);
        graph.addEdge(4, 7);
        graph.addEdge(7, 4);
        graph.addEdge(6, 7);
        graph.addEdge(7, 6);
    }

    public void checkArrays (int[] arrayTestValues) {
        boolean expected = true;
        ListIterator<Integer> ite = graph.getVisitedVertices().listIterator();
        while (ite.hasNext() && expected) {
            expected = (arrayTestValues[ite.nextIndex()] == ite.next());
        }
        assertTrue(expected);
    }

    @Test
    public void BackEdgeCheck() {
        boolean expected = true;
        for (int i = 0; i< vertices; i++) {
            ListIterator<Integer> ite = graph.getEdges(i).listIterator();
            while (ite.hasNext() && expected) {
                expected = graph.getEdges(ite.next()).contains(i);
            }
        }
        assertTrue(expected);
    }

    @Test
    public void testStartFromFirstVertex() {
        int[] arrayTestValues = { 0, 1, 2, 5, 3, 7, 4, 6 };
        graph.DFS(0);
        checkArrays(arrayTestValues);
    }

    @Test
    public void testStartFromSecondVertex() {
        int[] arrayTestValues = { 1, 0, 2, 5, 3, 7, 4, 6 };
        graph.DFS(1);
        checkArrays(arrayTestValues);
    }

    @Test
    public void testStartFromThirdVertex() {
        int[] arrayTestValues = { 2, 0, 1, 3, 7, 4, 6, 5 };
        graph.DFS(2);
        checkArrays(arrayTestValues);
    }

    @Test
    public void testStartFromFourthVertex() {
        int[] arrayTestValues = { 3, 0, 1, 2, 5, 7, 4, 6 };
        graph.DFS(3);
        checkArrays(arrayTestValues);
    }

    @Test
    public void testStartFromFifthVertex() {
        int[] arrayTestValues = { 4, 7, 3, 0, 1, 2, 5, 6 };
        graph.DFS(4);
        checkArrays(arrayTestValues);
    }

    @Test
    public void testStartFromSixthVertex() {
        int[] arrayTestValues = { 5, 2, 0, 1, 3, 7, 4, 6 };
        graph.DFS(5);
        checkArrays(arrayTestValues);
    }

    @Test
    public void testStartFromSeventhVertex() {
        int[] arrayTestValues = { 6, 7, 3, 0, 1, 2, 5, 4};
        graph.DFS(6);
        checkArrays(arrayTestValues);
    }

    @Test
    public void testStartFromEighthVertex() {
        int[] arrayTestValues = { 7, 3, 0, 1, 2, 5, 4, 6 };
        graph.DFS(7);
        checkArrays(arrayTestValues);
    }

}
