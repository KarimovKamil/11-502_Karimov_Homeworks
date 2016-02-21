package ru.itis.inform;

public class Main {
    public static void main(String[] args) {
        Graph graph1 = new GraphMatrixImpl();

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

        graph1.showMatrix();
        graph1.runFloyd();
        graph1.showReachabilityMatrix();
    }
}