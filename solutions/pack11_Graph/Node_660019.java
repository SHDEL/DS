package solutions.pack11_Graph;
import java.util.ArrayList;

public class Node_660019 {
    private int id;
    private ArrayList<Edge_660019> edges;
    private ArrayList<EdgeWithBandwidth_660019> edgesWithBandwidth;

    public Node_660019(int id) {
        this.id = id;
        this.edges = new ArrayList<>();
        this.edgesWithBandwidth = new ArrayList<>();
    }

    public void addEdge(Edge_660019 edge) {
        edges.add(edge);
    }

    public void addEdgeWithBandwidth(EdgeWithBandwidth_660019 edge) {
        edgesWithBandwidth.add(edge);
    }

    public int getId() {
        return id;
    }

    public ArrayList<Edge_660019> getEdges() {
        return edges;
    }

    public ArrayList<EdgeWithBandwidth_660019> getEdgesWithBandwidth() {
        return edgesWithBandwidth;
    }

    public String toString() {
        return "Node " + id;
    }
}