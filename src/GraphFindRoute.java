import java.util.LinkedList;

/**
 * Find route between to nodes of graph
 */

public class GraphFindRoute {

    private static GraphNode<Integer> searchNode;

    public static void main(String[] args) {
        // Prepare graph
        GraphNode<Integer> node1 = new GraphNode<>(1);
        GraphNode<Integer> node2 = new GraphNode<>(2);
        GraphNode<Integer> node3 = new GraphNode<>(3);
        GraphNode<Integer> node4 = new GraphNode<>(4);
        GraphNode<Integer> node5 = new GraphNode<>(5);
        node1.addChild(node2);
        node2.addChild(node5);
        node5.addChild(node1);
        node1.addChild(node3);
        node3.addChild(node4);
        // Find out if path exists from node1 to node4
        searchNode = node4;
        System.out.println("Deep search...");
        deepSearch(node1);
        System.out.println("Wide search...");
        wideSearch(node1);
    }

    // Deep first search
    private static void deepSearch(GraphNode<Integer> node) {
        if (node.isVisited())
            return;
        node.setVisited(true);
        System.out.println(node);
        if (node == searchNode) {
            System.out.println("Path exists!");
            return;
        }
        for (GraphNode<Integer> child : node.getChildren()) {
            deepSearch(child);
        }
    }

    // Wide first search
    private static void wideSearch(GraphNode<Integer> node) {
        LinkedList<GraphNode<Integer>> wideList = new LinkedList<>();
        wideList.add(node);
        while(!wideList.isEmpty()) {
            GraphNode<Integer> currentNode = wideList.poll();
            System.out.println(currentNode);
            if (currentNode == searchNode) {
                System.out.println("Path exists!");
                System.exit(0);
            }
            wideList.addAll(currentNode.getChildren());
        }
    }

}
