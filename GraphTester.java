/**
 * This class is a tester for the Graph class.
 */
public class GraphTester {
    /**
     * Main method that creates a graph and adds nodes and edges to it. 
     * Then it prints the graph.
     * @param args command arguments (not used)
     */
    public static void main(String[] args) {
        Graph graph = new Graph();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);

        graph.addEdge(new Edge(nodeA, nodeB));
        graph.addEdge(new Edge(nodeA, nodeC));
        graph.addEdge(new Edge(nodeB, nodeC));
        graph.addEdge(new Edge(nodeB, nodeD));
        graph.addEdge(new Edge(nodeB, nodeE));
        graph.addEdge(new Edge(nodeC, nodeD));
        graph.addEdge(new Edge(nodeD, nodeE));

        System.out.println("Printing example graph: ");
        System.out.println(graph);
    }
}
