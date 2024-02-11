import java.awt.*;
import java.util.List;
import javax.swing.*;

/**
 * This class represents a graphical panel for displaying a given graph.
 * It extends the Swing JPanel class and overrides its paintComponent method
 * to draw the nodes and edges of the graph using Java 2D graphics.
 * 
 * The panel randomly positions each node on the panel and draws it as a filled circle
 * with a given radius and the node's name as text. The edges of the graph are drawn
 * as straight lines connecting the centers of the corresponding nodes.
 * 
 * To use this class, create a new instance with a Graph object and the desired width
 * and height of the panel, and add it to a JFrame to display it.
 */
public class DrawGraph extends JPanel {
    private Graph graph;
    private int width;
    private int height;
    private int radius;

    /**
    * Constructs a DrawGraph object with the given graph, width, and height.
    * @param graph the graph to be drawn
    * @param width the width of the JPanel
    * @param height the height of the JPanel
    */
    public DrawGraph(Graph graph, int width, int height) {
        this.graph = graph;
        this.width = width;
        this.height = height;
        this.radius = 20;
    }

    /**
    * Overrides the paintComponent method to draw the graph on the JPanel.
    * @param g the Graphics object to draw on
    */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        List<Node> nodes = graph.getNodes();
        for (Node node : nodes) {
            int x = (int) (Math.random() * (width - 2 * radius) + radius);
            int y = (int) (Math.random() * (height - 2 * radius) + radius);
            node.setLocation(x, y);
            g2d.setColor(Color.BLUE);
            g2d.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
            g2d.setColor(Color.BLACK);
            g2d.drawString(node.getName(), x, y);
        }

        List<Edge> edges = graph.getEdges();
        for (Edge edge : edges) {
            int x1 = edge.getSource().getLocation().x;
            int y1 = edge.getSource().getLocation().y;
            int x2 = edge.getDestination().getLocation().x;
            int y2 = edge.getDestination().getLocation().y;
            g2d.drawLine(x1, y1, x2, y2);
        }
    }

    /**
    * The main method that creates and displays a JFrame with a DrawGraph panel on it.
    * @param args command-line arguments (not used)
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
        graph.addEdge(new Edge(nodeB, nodeD));
        graph.addEdge(new Edge(nodeC, nodeD));
        graph.addEdge(new Edge(nodeD, nodeE));

        DrawGraph panel = new DrawGraph(graph, 400, 400);
        JFrame frame = new JFrame("Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}