import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents a graph data structure.
 */
public class Graph {
    private Map<String, Node> nodes;
    private List<Edge> edges;

    /**
    * Creates a new empty graph.
    */
    public Graph() {
        this.nodes = new HashMap<String, Node>();
        this.edges = new ArrayList<Edge>();
    }

    /**
    * Adds the given node to the graph.
    * @param node the node to add
    */
    public void addNode(Node node) {
        this.nodes.put(node.getName(), node);
    }

    /**
    * Gets the node with the given name from the graph.
    * @param name the name of the node to get
    * @return the node with the given name, or null if it is not found
    */
    public Node getNode(String name) {
        return this.nodes.get(name);
    }

    /**
    * Gets a list of all nodes in the graph.
    * @return a list of all nodes in the graph
    */
    public List<Node> getNodes() {
        return new ArrayList<Node>(this.nodes.values());
    }

    /**
    * Gets a list of all edges in the graph.
    * @return a list of all edges in the graph
    */
    public List<Edge> getEdges() {
        return this.edges;
    }

    /**
    * Adds the given edge to the graph.
    * @param edge the edge to add
    */
    public void addEdge(Edge edge) {
        this.edges.add(edge);
        Node source = edge.getSource();
        Node destination = edge.getDestination();
        source.addEdge(destination);
        destination.addEdge(source);
    }

    /**
    * Creates a string representation of the graph by printing all the edge pairs.
    * @return a string representation of the graph
    */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Edge edge : edges) {
            sb.append(edge.getSource().getName()).append(" - ").append(edge.getDestination().getName()).append("\n");
        }
        return sb.toString();
    }
}
