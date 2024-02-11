/**
 * SpanningTreeTester is a class that tests the SpanningTree class by creating a graph and generating its
 * corresponding spanning tree.
 */
public class SpanningTreeTester {

    /**
     * The main method creates a graph and adds several nodes and edges to it. Then, it generates the corresponding
     * spanning tree using the SpanningTree class and prints it to the console.
     *
     * @param args an array of command-line arguments for the application (not used)
     */
    public static void main(String[] args) {
        Graph graph = new Graph();
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.addEdge(new Edge(nodeA, nodeB));
        graph.addEdge(new Edge(nodeA, nodeC));
        graph.addEdge(new Edge(nodeB, nodeC));
        graph.addEdge(new Edge(nodeB, nodeD));
        graph.addEdge(new Edge(nodeB, nodeE));
        graph.addEdge(new Edge(nodeC, nodeE));
        graph.addEdge(new Edge(nodeD, nodeE));
        graph.addEdge(new Edge(nodeD, nodeF));
        graph.addEdge(new Edge(nodeE, nodeF));
        System.out.println("Graph:\n" + graph.toString());
        SpanningTree spanningTree = new SpanningTree(graph);
        System.out.println("Spanning Tree:");
        System.out.println(spanningTree.treeToString());
    }
}
