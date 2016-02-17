package ru.itis.inform;

public interface Graph {
    void addVertex();

    void addEdge(int vertexA, int vertexB, int weightEdge);

    void runFloyd();

    void showMatrix();

    void showReachabilityMatrix();
}