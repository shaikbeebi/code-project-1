import java.util.*;
class Graph {
    private Map<Integer, List<Integer>> adjList;
    private boolean isDirected;
    public Graph() {
        this(false);
    }
    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
        adjList = new HashMap<>();
    }
    public void addEdge(int src, int dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());
        adjList.get(src).add(dest);
        if (!isDirected) {
            adjList.get(dest).add(src);
        }
    }
    public Map<Integer, List<Integer>> getAdjList() {
        return adjList;
    }
    public void printGraph() {
		for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}
}
public class GraphList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph graph = new Graph(false);
        System.out.println("Enter number of edges:");
        int edges = sc.nextInt();
        System.out.println("Enter edges (format: src dest):");
        for (int i = 0; i < edges; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            graph.addEdge(src, dest);
        }
        System.out.println("Graph:");
        graph.printGraph();
        sc.close();
    }
}
