package ru.itis.inform;

public class Main {
    public static void main(String[] args) {
        DirectedGraph graph1 = new GraphMatrixImpl();

        graph1.addVertex();
        graph1.addVertex();
        graph1.addVertex();
        graph1.addVertex();
        graph1.addVertex();

        graph1.addDirectedEgde(0, 1, 4);
        graph1.addDirectedEgde(2, 4, 5);
        graph1.addDirectedEgde(1, 2, 1);
        graph1.addDirectedEgde(3, 1, 7);
        graph1.addDirectedEgde(4, 3, 2);

        graph1.showMatrix();
        graph1.runFloyd();
        graph1.showReachabilityMatrix();
    }
}