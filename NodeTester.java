/**
 * This class is used to test the Node class.
 */
public class NodeTester {

    public static void main(String[] args) {
        Node nodeA = new Node("A", 0, 0);
        Node nodeB = new Node("B", 0, 10);
        Node nodeC = new Node("C", 10, 0);
        
        nodeA.addEdge(nodeB);
        nodeB.addEdge(nodeC);
        nodeC.addEdge(nodeA);
        
        System.out.println("Node A name: " + nodeA.getName());
        System.out.println("Node B location: (" + nodeB.getX() + ", " + nodeB.getY() + ")");
        System.out.println("Node C edges: " + nodeC.getEdges());
        
        nodeA.setLocation(5, 5);
        System.out.println("Node A new location: (" + nodeA.getX() + ", " + nodeA.getY() + ")");
    }
}
