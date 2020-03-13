import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {
    private boolean visited;
    private T data;
    private List<GraphNode<T>> children = new ArrayList<>();

    public GraphNode(T data) {
        this.data = data;
    }

    public void addChild(GraphNode<T> child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public List<GraphNode<T>> getChildren() {
        return children;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
