package ru.itis.inform;

public class GraphMatrixImpl implements DirectedGraph, Graph {

    private static final int DEFAULT_SIZE = 50;
    private static final int INF = 500;

    private int matrix[][];
    private int dmatrix[][];
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

    public void addEdge(int vertexA, int vertexB, int weightEdge) {
        if (vertexA < verticesCount && vertexB < verticesCount && this.matrix[vertexA][vertexB] == 0) {
            this.matrix[vertexA][vertexB] = weightEdge;
            this.matrix[vertexB][vertexA] = weightEdge;
        } else throw new IllegalArgumentException();
    }

    public void addDirectedEgde(int vertixFrom, int vertixTo, int weightEdge) {
        if (vertixFrom < verticesCount && vertixTo < verticesCount && this.matrix[vertixFrom][vertixTo] == 0) {
            this.matrix[vertixFrom][vertixTo] = weightEdge;
        }
    }

    public void generateDMatrix() {
        this.dmatrix = new int[verticesCount][verticesCount];
        for (int i = 0; i < verticesCount; i++){
            for (int j = 0; j < verticesCount; j++){
                if (matrix[i][j] == 0 && i != j){
                    dmatrix[i][j] = INF;
                } else {
                    dmatrix[i][j] = matrix[i][j];
                }
            }
        }
    }

    public int[][] runFloyd(){
        generateDMatrix();
        for (int k = 0; k < verticesCount; k++){
            for (int i = 0; i < verticesCount; i++){
                for (int j = 0; j < verticesCount; j++){
                    dmatrix[i][j] = Math.min(dmatrix[i][j], dmatrix[i][k] + dmatrix[k][j]);
                }
            }
        }
        return dmatrix;
    }

    public void showMatrix() {
        System.out.println("Adjacency matrix:");
        for (int i = 0; i < verticesCount; i++) {
            for (int j = 0; j < verticesCount - 1; j++) {
                System.out.print(matrix[i][j] + ",  ");
            }
            System.out.println(matrix[i][verticesCount - 1]);
        }
    }

    public void showReachabilityMatrix() {
        System.out.println("Reachability matrix:");
        for (int i = 0; i < verticesCount; i++) {
            for (int j = 0; j < verticesCount - 1; j++) {
                System.out.print(dmatrix[i][j] + ",  ");
            }
            System.out.println(dmatrix[i][verticesCount - 1]);
        }
    }
}