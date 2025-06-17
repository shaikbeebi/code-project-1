import java.util.*;
class Graph{
    private int[][] adjMatrix;
    private int numVertices;
    private boolean isDirected;
    public Graph(int numVertices, boolean isDirected) {
        this.numVertices = numVertices;
        this.isDirected = isDirected;
        adjMatrix = new int[numVertices][numVertices];
    }
    public void addEdge(int src, int dest) {
        if (src < 0 || src >= numVertices || dest < 0 || dest >= numVertices) {
            System.out.println("Invalid vertex number.");
            return;
        }
        adjMatrix[src][dest] = 1;
        if (!isDirected) {
            adjMatrix[dest][src] = 1;
        }
    }
    public void printGraph() {
        System.out.println("Adjacency Matrix:");
        System.out.print("   ");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
public class GraphMatrix{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices:");
        int vertices = sc.nextInt();
        Graph graph = new Graph(vertices, false);
        System.out.println("Enter number of edges:");
        int edges = sc.nextInt();
        System.out.println("Enter edges (format: src dest):");
        for (int i = 0; i < edges; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            graph.addEdge(src, dest);
        }
        graph.printGraph();
        sc.close();
    }
}
