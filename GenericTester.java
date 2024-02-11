import java.util.List;

/**
 * A generic tester class to test different types of objects.
 * This class fulfills the final project requirement: Contains at least one generic class
 * @param <T> the type of object to test.
 */
public class GenericTester<T> {
    private T object;

    /**
     * Constructs a new GenericTester object.
     * @param object the object to test.
     */
    public GenericTester(T object) {
        this.object = object;
    }

    /**
     * Tests the object by calling the appropriate test method based on its type.
     */
    public void test() {
        if (object instanceof Node) {
            testNode((Node) object);
        } else if (object instanceof Edge) {
            testEdge((Edge) object);
        } else if (object instanceof Graph) {
            testGraph((Graph) object);
        } else {
            System.out.println("Unsupported type: " + object.getClass().getName());
        }
    }

    /**
     * Tests a node object.
     * @param node the node to test.
     */
    private void testNode(Node node) {
        System.out.println("Testing Node: " + node.getName());

        // Test getName()
        String name = node.getName();
        if (name == null || name.isEmpty()) {
            System.out.println("ERROR: Invalid name");
        } else {
            System.out.println("Name: " + name);
        }

        // Test getEdges()
        List<Node> edges = node.getEdges();
        if (edges == null || edges.isEmpty()) {
            System.out.println("No edges");
        } else {
            System.out.println("Edges:");
            for (Node edge : edges) {
                System.out.println("- " + edge.getName());
            }
        }
    }

    /**
     * Tests an edge object.
     * @param edge the edge to test.
     */
    private void testEdge(Edge edge) {
        System.out.println("Testing Edge: " + edge.getSource().getName() + " -> " + edge.getDestination().getName());

        // Test getSource() and getDestination()
        Node source = edge.getSource();
        Node destination = edge.getDestination();
        if (source == null || destination == null) {
            System.out.println("ERROR: Invalid source or destination");
        } else {
            System.out.println("Source: " + source.getName());
            System.out.println("Destination: " + destination.getName());
        }

        // Test isSelfLoop()
        if (edge.isSelfLoop()) {
            System.out.println("Self-loop");
        } else {
            System.out.println("Not a self-loop");
        }
    }

    /**
     * Tests a graph object.
     * @param graph the graph to test.
     */
    private void testGraph(Graph graph) {
        System.out.println("Testing Graph");

        // Test getNodes()
        List<Node> nodes = graph.getNodes();
        if (nodes == null || nodes.isEmpty()) {
            System.out.println("No nodes");
        } else {
            System.out.println("Nodes:");
            for (Node node : nodes) {
                System.out.println("- " + node.getName());
            }
        }

        // Test getEdges()
        List<Edge> edges = graph.getEdges();
        if (edges == null || edges.isEmpty()) {
            System.out.println("No edges");
        } else {
            System.out.println("Edges:");
            for (Edge edge : edges) {
                System.out.println("- " + edge.getSource().getName() + " -> " + edge.getDestination().getName());
            }
        }
    }

    public static void main(String[] args) {
        // Create a new graph
        Graph graph = new Graph();
    
        // Create some nodes
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
    
        // Add the nodes to the graph
        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
    
        // Create some edges
        Edge ab = new Edge(a, b);
        Edge bc = new Edge(b, c);
        Edge cd = new Edge(c, d);
    
        // Add the edges to the graph
        graph.addEdge(ab);
        graph.addEdge(bc);
        graph.addEdge(cd);
    
        // Test the graph using the GenericTester class
        GenericTester<Graph> tester = new GenericTester<>(graph);
        tester.test();
    }
}
