package ru.itis.inform;

public class GraphMatrixImpl implements Graph {

    private static final int DEFAULT_SIZE = 50;
    private int matrix[][];
    private int verticesCount;
    private int maxSize;

    public GraphMatrixImpl() {
        initGraph(DEFAULT_SIZE);
    }

    public GraphMatrixImpl(int maxSize) {
        initGraph(maxSize);
    }

    private void initGraph(int maxSize) {
        this.maxSize = maxSize;
        this.verticesCount = 0;
        this.matrix = new int[maxSize][maxSize];
    }

    public void addVertex() {
        if (this.verticesCount < this.maxSize) {
            this.verticesCount++;
        } else throw new IllegalArgumentException();
    }

    public void addEdge(int vertexFrom, int vertexTo, int weightEdge) {
        if (vertexFrom < verticesCount && vertexTo < verticesCount && this.matrix[vertexFrom][vertexTo] == 0) {
            this.matrix[vertexFrom][vertexTo] = weightEdge;
        } else throw new IllegalArgumentException();
    }

    public void showGraph() {
        for (int i = 0; i < verticesCount; i++) {
            for (int j = 0; j < verticesCount - 1; j++) {
                System.out.print(matrix[i][j] + ",  ");
            }
            System.out.println(matrix[i][verticesCount - 1]);
        }
    }
}