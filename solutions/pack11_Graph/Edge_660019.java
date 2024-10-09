package solutions.pack11_Graph;

public class Edge_660019 {
    int latency;
    Node_660019 node1;
    Node_660019 node2;
    Edge_660019() {

    }
    public Edge_660019(int latency, Node_660019 Node1, Node_660019 Node2) {
        this.latency = latency;
        this.node1 = Node1;
        this.node2 = Node2;
    }
    public int getLatency() {
        return latency;
    }
    @Override
    public String toString() {
        return "Latency: " + latency + " n1: " + node1 + " n2: " + node2;
    }
}
