package algorithmTest;

import algorithm.Graph;
import org.junit.Assert;
import org.junit.Test;

public class AlgorithmCommonTest extends Assert {
    @Test
    public void testAddEdgeToGraph() {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        boolean expected = graph.getEdges(0).contains(1);
        assertTrue(expected);
    }
}
