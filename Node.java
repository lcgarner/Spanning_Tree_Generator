import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * A Node represents a point in a graph.
 */
public class Node {
    private String name;
    private Point location;
    private List<Node> edges;
    
    /**
     * Constructs a new Node with the specified name and location.
     *
     * @param name the name of the Node
     * @param x the x-coordinate of the Node's location
     * @param y the y-coordinate of the Node's location
     */
    public Node(String name, int x, int y) {
        this.name = name;
        this.location = new Point(x, y);
        edges = new ArrayList<>();
    }

    /**
     * Constructs a new Node with the specified name and a default location of (0,0).
     * @param name the name of the Node
     */
    public Node(String name){
        this.name = name;
        edges = new ArrayList<>();
        location = new Point();
    }
    
    /**
     * Returns the name of the Node.
     * @return the name of the Node
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the x-coordinate of the Node's location.
     *
     * @return the x-coordinate of the Node's location
     */
    public int getX() {
        return location.x;
    }
    
    /**
     * Returns the y-coordinate of the Node's location.
     *
     * @return the y-coordinate of the Node's location
     */
    public int getY() {
        return location.y;
    }
    
    /**
     * Returns the list of Nodes connected to this Node.
     *
     * @return the list of Nodes connected to this Node
     */
    public List<Node> getEdges() {
        return edges;
    }
    
    /**
     * Adds a Node to the list of Nodes connected to this Node.
     *
     * @param node the Node to add
     */
    public void addEdge(Node node) {
        edges.add(node);
    }

    /**
     * Adds an Edge to the list of Edges connected to this Node.
     *
     * @param edge the Edge to add
     */
    public void addEdge(Edge edge) {
        if (edge.getSource() == this) {
            edges.add(edge.getDestination());
        } else if (edge.getDestination() == this) {
            edges.add(edge.getSource());
        }
    }

    public void removeEdge(Node node) {
        edges.remove(node);
    }

    public List<Node> getNeighbors() {
        return edges;
    }

    /**
     * Sets the location of the Node to the specified coordinates.
     *
     * @param x the new x-coordinate of the Node's location
     * @param y the new y-coordinate of the Node's location
     */
    public void setLocation(int x, int y) {
        location.setLocation(x, y);
    }

    /**
     * Returns the location of the Node.
     *
     * @return the location of the Node
     */
    public Point getLocation() {
        return location;
    }
}
