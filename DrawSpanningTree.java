import javax.swing.*;
import java.awt.*;

/**
 * A panel that can draw a graph and its corresponding spanning tree. The graph and the spanning tree
 * are provided in the constructor. The panel's dimensions are set to 500x500 by default, but can be
 * changed by calling the setPreferredSize() method.
 */
public class DrawSpanningTree extends JPanel {

    private Graph graph;
    private SpanningTree spanningTree;

    /**
    * Constructs a new DrawSpanningTree object.
    * @param graph the graph to be drawn
    * @param spanningTree the spanning tree of the graph to be drawn
    */
    public DrawSpanningTree(Graph graph, SpanningTree spanningTree) {
        this.graph = graph;
        this.spanningTree = spanningTree;
        setPreferredSize(new Dimension(500, 500));
    }

    /**
    * Paints the components of the panel.
    * @param g the Graphics object used for drawing
    */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Node node : graph.getNodes()) {
            Point location = node.getLocation();
            g.setColor(Color.BLACK);
            g.fillOval(location.x - 5, location.y - 5, 10, 10);
            g.drawString(node.getName(), location.x + 10, location.y + 5);
        }
        for (Edge edge : graph.getEdges()) {
            Point source = edge.getSource().getLocation();
            Point dest = edge.getDestination().getLocation();
            g.setColor(Color.BLACK);
            g.drawLine(source.x, source.y, dest.x, dest.y);
        }
        for (Edge edge : spanningTree.getTreeEdges()) {
            Point source = edge.getSource().getLocation();
            Point dest = edge.getDestination().getLocation();
            g.setColor(Color.RED);
            g.drawLine(source.x, source.y, dest.x, dest.y);
        }
    }

    /**
    * Creates a graph and its corresponding spanning tree and displays them in a JFrame.
    * @param args command-line arguments (not used)
    */
    public static void main(String[] args) {
        Graph graph = new Graph();

        Node nodeA = new Node("A", 50, 50);
        Node nodeB = new Node("B", 150, 150);
        Node nodeC = new Node("C", 300, 70);
        Node nodeD = new Node("D", 100, 300);
        Node nodeE = new Node("E", 200, 200);
        Node nodeF = new Node("F", 350, 350);
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

        SpanningTree spanningTree = new SpanningTree(graph);

        JFrame frame = new JFrame("Draw Spanning Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DrawSpanningTree(graph, spanningTree));
        frame.pack();
        frame.setVisible(true);
    }
}