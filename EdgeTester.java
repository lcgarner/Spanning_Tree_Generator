/**
 * This class tests the functionality of the Node and Edge classes.
 */
public class EdgeTester {
    public static void main(String[] args) {
        // create some nodes
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        
        // create some edges between the nodes
        Edge edge1 = new Edge(node1, node2);
        Edge edge2 = new Edge(node2, node3);
        Edge edge3 = new Edge(node3, node1);
        
        // add the edges to the nodes
        node1.addEdge(edge1);
        node1.addEdge(edge3);
        node2.addEdge(edge1);
        node2.addEdge(edge2);
        node3.addEdge(edge2);
        node3.addEdge(edge3);
        
        // test the getNodeName method of the Node class
        System.out.println("Node 1 name: " + node1.getName());
        System.out.println("Node 2 name: " + node2.getName());
        System.out.println("Node 3 name: " + node3.getName());
        
        // test the getEdges method of the Node class
        System.out.println("Node 1 edges: " + node1.getEdges());
        System.out.println("Node 2 edges: " + node2.getEdges());
        System.out.println("Node 3 edges: " + node3.getEdges());
        
        // test the isSelfLoop method of the Edge class
        System.out.println("Edge 1 is self-loop? " + edge1.isSelfLoop());
        System.out.println("Edge 2 is self-loop? " + edge2.isSelfLoop());
        System.out.println("Edge 3 is self-loop? " + edge3.isSelfLoop());
    }
}
