import java.util.ArrayList;
import java.util.List;

/**
 * A utility class for building graphs.
 * This class stores the user's graph as they create it in JPanel.
 */
public class GraphBuilder {
    private List<Node> nodes;
    private List<Edge> edges;

    /**
     * Constructs a new GraphBuilder.
     */
    public GraphBuilder() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    /**
     * Adds a node to the list of nodes.
     * @param node the node to add
     */
    public void addNode(Node node) {
        nodes.add(node);
    }

    /**
     * Adds an edge between the given source and destination nodes.
     * @param source the source node of the edge
     * @param destination the destination node of the edge
     */
    public void addEdge(Node source, Node destination) {
        edges.add(new Edge(source, destination));
    }

    /**
     * Returns the list of nodes that have been added to this builder.
     * @return the list of nodes
     */
    public List<Node> getNodes() {
        return nodes;
    }

    /**
     * Returns the list of edges that have been added to this builder.
     * @return the list of edges
     */
    public List<Edge> getEdges() {
        return edges;
    }

    /**
     * Constructs a new graph from the nodes and edges that have been added to this builder.
     * @return the constructed graph
     */
    public Graph build() {
        Graph graph = new Graph();
        for (Node node : nodes) {
            graph.addNode(node);
        }
        for (Edge edge : edges) {
            graph.addEdge(edge);
        }
        return graph;
    }
}
