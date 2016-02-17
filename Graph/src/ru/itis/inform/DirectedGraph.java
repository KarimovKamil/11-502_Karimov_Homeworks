package ru.itis.inform;

public interface DirectedGraph {
    void addVertex();

    void addDirectedEgde(int vertixFrom, int vertixTo, int weightEdge);

    void runFloyd();

    void showMatrix();

    void showReachabilityMatrix();
}
