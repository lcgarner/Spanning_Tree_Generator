import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/**
 * Algorithms for traversal, shortest path, etc.
 * TO DO:
 * Add a function to determine whether or not a graph is bipartite.
 */
public class Algorithms {
    //private Graph graph;
    private List<Node> treeNodes;
    private List<Edge> treeEdges;

    /**
     * Recursively performs a depth-first search of the graph to discover the spanning tree.
     *
     * @param node   the node to start the search from
     * @param parent the parent node of the current node, null if current node is root
     */
    private void depthFirstSearch(Node node, Node parent){
        treeNodes.clear();
        treeEdges.clear();
        treeNodes.add(node);
        if (parent != null) {
            treeEdges.add(new Edge(parent, node));
        }
        for (Node child : node.getEdges()) {
            if (!treeNodes.contains(child)) {
                depthFirstSearch(child, node);
            }
        }
    }

    public static List<Node> bfsTraversal(Graph graph, Node startNode) {
        List<Node> traversalOrder = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            traversalOrder.add(currentNode);

            for (Node neighbor : currentNode.getNeighbors()) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return traversalOrder;
    }
    
    //write an algorithm to determine whether or not a graph is bipartite
    public boolean isBipartite(Graph graph) {
        return false; //placeholder   
    }   

    //write an algorithm to determine whether or not a graph is connected
    public boolean isConnected(Graph graph) {
        return false; //placeholder
    }

    //write an algorithm to determine whether or not a graph is a tree
    public boolean isTree(Graph graph) {
        return false; //placeholder
    }

    //write an algorithm to determine whether or not a graph is a forest
    public boolean isForest(Graph graph) {
        return false; //placeholder
    }

    //write an algorithm to determine whether or not a graph is a cycle
    public boolean isCycle(Graph graph) {
        return false; //placeholder
    }

}

