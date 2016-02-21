package ru.itis.inform;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphMatrixImplTest {

    private GraphMatrixImpl graph1 = new GraphMatrixImpl();
    private GraphMatrixImpl graph2 = new GraphMatrixImpl();

    @org.junit.Before
    public void setUp() throws Exception {
        this.graph1 = new GraphMatrixImpl();
        this.graph2 = new GraphMatrixImpl();
    }

    @org.junit.Test
    public void testRunFloyd1() throws Exception {
        graph1.addVertex();
        graph1.addVertex();
        graph1.addVertex();
        graph1.addVertex();
        graph1.addVertex();

        graph1.addEdge(0, 1, 4);
        graph1.addEdge(2, 4, 5);
        graph1.addEdge(1, 2, 1);
        graph1.addEdge(3, 1, 7);
        graph1.addEdge(4, 3, 2);

        int[][] actual = graph1.runFloyd();

        int[][] expected = {{0,  4,  5,  11,  10}, {4,  0,  1,  7,  6}, {5,  1,  0,  7,  5},
                {11,  7,  7,  0,  2}, {10,  6,  5,  2,  0}};

        assertEquals("Error-NonDirectedGraph",expected, actual);
    }

    @org.junit.Test
    public void testRunFloyd2() throws Exception {
        graph2.addVertex();
        graph2.addVertex();
        graph2.addVertex();
        graph2.addVertex();
        graph2.addVertex();

        graph2.addDirectedEgde(0, 1, 4);
        graph2.addDirectedEgde(2, 4, 5);
        graph2.addDirectedEgde(1, 2, 1);
        graph2.addDirectedEgde(3, 1, 7);
        graph2.addDirectedEgde(4, 3, 2);

        int[][] actual = graph2.runFloyd();

        int[][] expected = {{0,  4,  5,  12,  10}, {500,  0,  1,  8,  6}, {500,  14,  0,  7,  5},
                {500,  7,  8,  0,  13}, {500,  9,  10,  2,  0}};

        assertEquals("Error-DirectedGraph",expected, actual);
    }

}