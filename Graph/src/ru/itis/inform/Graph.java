package ru.itis.inform;

public interface Graph {
    void addVertex();

    void addEdge(int vertexFrom, int vertexTo, int weightEdge);

    void showGraph();
}