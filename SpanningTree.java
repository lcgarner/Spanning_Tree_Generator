import java.util.ArrayList;
import java.util.List;

/**
 * Represents a spanning tree of a graph.
 */
public class SpanningTree {
    //private Graph graph;
    private List<Node> treeNodes;
    private List<Edge> treeEdges;

    /**
     * Constructs a spanning tree from the given graph.
     *
     * @param graph the graph to create a spanning tree from
     */
    public SpanningTree(Graph graph) {
        //this.graph = graph;
        treeNodes = new ArrayList<>();
        treeEdges = new ArrayList<>();
        depthFirstSearch(graph.getNodes().get(0), null, treeNodes, treeEdges);
    }

    // ...

    private static void depthFirstSearch(Node node, Node parent, List<Node> treeNodes, List<Edge> treeEdges) {
        treeNodes.add(node);
        if (parent != null) {
            treeEdges.add(new Edge(parent, node));
        }
        for (Node child : node.getEdges()) {
            if (!treeNodes.contains(child)) {
                depthFirstSearch(child, node, treeNodes, treeEdges);
            }
        }
    }

    // /**
    //  * Performs a depth-first search of the graph to create the spanning tree.
    //  *
    //  * @param node   the node to start the search from
    //  * @param parent the parent node of the current node, null if current node is root
    //  */
    // private void depthFirstSearch(Node node, Node parent) {
    //     treeNodes.add(node);
    //     if (parent != null) {
    //         treeEdges.add(new Edge(parent, node));
    //     }
    //     for (Node child : node.getEdges()) {
    //         if (!treeNodes.contains(child)) {
    //             depthFirstSearch(child, node);
    //         }
    //     }
    // }

    /**
     * Returns the nodes in the spanning tree.
     *
     * @return a list of nodes in the spanning tree
     */
    public List<Node> getTreeNodes() {
        return treeNodes;
    }

    /**
     * Returns the edges in the spanning tree.
     *
     * @return a list of edges in the spanning tree
     */
    public List<Edge> getTreeEdges() {
        return treeEdges;
    }

    /**
     * Returns a string representation of the spanning tree from edge pairs.
     *
     * @return a string representation of the spanning tree
     */
    public String treeToString() {
        StringBuilder sb = new StringBuilder();
        for (Edge edge : treeEdges) {
            sb.append(edge.getSource().getName())
              .append(" - ")
              .append(edge.getDestination().getName())
              .append("\n");
        }
        return sb.toString();
    }
}