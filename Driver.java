import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The Driver class is responsible for building a graph using user input and displaying the resulting
 * spanning tree in a separate window.
 */
public class Driver {
    private GraphBuilder graphBuilder;
    private Node selectedNode;
    private boolean finalized;

    /**
     * Constructs a new Driver object and initializes the graph builder and finalized flag.
     */
    public Driver() {
        graphBuilder = new GraphBuilder();
        finalized = false;

        JFrame frame = new JFrame("Build Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Draw nodes
                for (Node node : graphBuilder.getNodes()) {
                    g.setColor(Color.BLUE);
                    g.fillOval(node.getX() - 10, node.getY() - 10, 20, 20);
                    g.setColor(Color.BLACK);
                    g.drawString(node.getName(), node.getX() - 5, node.getY() + 5);
                }

                // Draw edges
                for (Edge edge : graphBuilder.getEdges()) {
                    if (finalized) {
                        g.setColor(Color.RED);
                    } else {
                        g.setColor(Color.BLACK);
                    }
                    g.drawLine(edge.getSource().getX(), edge.getSource().getY(), edge.getDestination().getX(), edge.getDestination().getY());
                }
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (Node node : graphBuilder.getNodes()) {
                    if (Math.sqrt(Math.pow(e.getX() - node.getX(), 2) + Math.pow(e.getY() - node.getY(), 2)) <= 10) {
                        selectedNode = node;
                        break;
                    }
                }

                if (selectedNode == null) {
                    Node node = new Node(Character.toString((char) ('A' + graphBuilder.getNodes().size())), e.getX(), e.getY());
                    graphBuilder.addNode(node);
                    selectedNode = node;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (!finalized) {
                    Node releasedNode = null;
                    for (Node node : graphBuilder.getNodes()) {
                        if (Math.sqrt(Math.pow(e.getX() - node.getX(), 2) + Math.pow(e.getY() - node.getY(), 2)) <= 10) {
                            releasedNode = node;
                            break;
                        }
                    }

                    if (releasedNode != null && releasedNode != selectedNode) {
                        graphBuilder.addEdge(selectedNode, releasedNode);
                    }

                    selectedNode = null;
                    panel.repaint();
                }
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.add(createFinishButton(), BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    /**
     * Draws the spanning tree for the current graph and displays it in a separate window.
     */
    public void drawSpanningTree() {
        Graph graph = graphBuilder.build();
        SpanningTree spanningTree = new SpanningTree(graph);
        JFrame frame = new JFrame("Spanning Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DrawSpanningTree(graph, spanningTree));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Creates a "Get Spanning Tree" button and attaches an action listener to it. When clicked,
     * the button will finalize the graph and draw its spanning tree.
     * @return JButton button to finish building graph.
     */
    private JButton createFinishButton() {
        JButton button = new JButton("Get Spanning Tree");
        button.addActionListener(e -> {
            finalized = true;
            drawSpanningTree();
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(button.getParent());
            frame.dispose();
        });
        return button;
    }

    public static void main(String[] args) {
        Driver buildGraph = new Driver();
        System.out.println(buildGraph);
    }
}