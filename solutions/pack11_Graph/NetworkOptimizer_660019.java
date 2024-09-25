package solutions.pack11_Graph;
import java.util.PriorityQueue;

public class NetworkOptimizer_660019 {

    public int optimizeNetwork(int N, int M, int[][] input) {

        int totalLatency = 0;

        Node_660019[] nodes = new Node_660019[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node_660019(i + 1);
        }

        for (int i = 0; i < input.length; i++) {
            int node1Id = input[i][0];
            int node2Id = input[i][1];
            int latency = input[i][2];
            Edge_660019 edge = new Edge_660019(latency, nodes[node1Id - 1], nodes[node2Id - 1]);
            nodes[node1Id - 1].addEdge(edge);
            nodes[node2Id - 1].addEdge(edge);
        }

        /*
         * TASK 2: Implement PRIM's algorithm to find the minimum spanning tree
         * by using latency as the weight
         * 
         * The algorithm should return the total latency of the minimum spanning tree
         */

        Node_660019 starNode = nodes[0];
        PriorityQueue<Edge_660019> pq = new PriorityQueue<>(new EdgeComparator_660019());

        // implement the algorithm here

        return totalLatency;

    }

    // Overload the optimizeNetwork method
    public int optimizeNetwork(int N, int M, int T, int[][] input) {
        int totalLatency = 0;

        Node_660019[] nodes = new Node_660019[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node_660019(i + 1);
        }

        for (int i = 0; i < input.length; i++) {
            int node1Id = input[i][0];
            int node2Id = input[i][1];
            int latency = input[i][2];
            int bandwidth = input[i][3];
            EdgeWithBandwidth_660019 edge = new EdgeWithBandwidth_660019(latency, bandwidth, nodes[node1Id - 1], nodes[node2Id - 1]);
            nodes[node1Id - 1].addEdgeWithBandwidth(edge);
            nodes[node2Id - 1].addEdgeWithBandwidth(edge);
        }

        /*
         * TASK 3: Implement PRIM's algorithm to find the minimum spanning tree
         * by using latency as the weight and
         * the edge that have bandwidth less than T should not be included in the
         * minimum spanning tree
         * 
         * The algorithm should return the total latency of the minimum spanning tree
         */
        Node_660019 starNode = nodes[0];
        PriorityQueue<EdgeWithBandwidth_660019> pq = new PriorityQueue<>(new EdgeComparator_660019());

        // implement the algorithm here


        return totalLatency;

    }

}
