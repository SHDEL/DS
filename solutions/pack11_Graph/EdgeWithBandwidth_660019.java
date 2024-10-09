package solutions.pack11_Graph;

public class EdgeWithBandwidth_660019 extends Edge_660019 {
    int bandwidth;

    public EdgeWithBandwidth_660019(int latency, int bandwidth, Node_660019 node1, Node_660019 node2) {
        super(latency, node1, node2);
        this.bandwidth = bandwidth;
    }

}
