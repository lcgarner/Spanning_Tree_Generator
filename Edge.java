/**
 * This class represents an edge between two nodes in a graph.
 */
public class Edge {
    private Node source;
    private Node destination;

    /**
     * Creates a new edge between the given source and destination nodes.
     * @param source      the source node of the edge
     * @param destination the destination node of the edge
     */
    public Edge(Node source, Node destination) {
    this.source = source; // the source node of the edge
    this.destination = destination; // the destination node of the edge
    }

    /**
     * Gets the source node of the edge.
     * @return the source node of the edge
     */
    public Node getSource() {
        return source;
    }

    /**
     * Gets the destination node of the edge.
     * @return the destination node of the edge
     */
    public Node getDestination() {
        return destination;
    }

    /**
     * Returns true if this edge is a self-loop (i.e., the source and destination nodes are the same).
     * @return true if this edge is a self-loop, false otherwise
     */
    public boolean isSelfLoop() {
        return source == destination;
    }
}
