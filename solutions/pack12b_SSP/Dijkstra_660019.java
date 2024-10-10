package solutions.pack12b_SSP;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Dijkstra_660019 {

    int[][] adjMatrix;
    int[] previous, distance;
    boolean[] visted;
    int source;

    public Dijkstra_660019(int[][] adjMatrix, int source) {
        this.adjMatrix = adjMatrix;
        this.source = source;
        previous = new int[adjMatrix.length];
        distance = new int[adjMatrix.length];
        visted = new boolean[adjMatrix.length];
    }
    
    //Task 1 imeplement the findSSP method using Dijkstra's algorithm
    public void findSSP() {
         PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(v -> distance[v]));
        for (int i = 0; i < adjMatrix.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            // previous[i]=0;
        }
        q.add(source);
        distance[source] = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            if (visted[u]){
                continue;
            }

            visted[u] = true;
            for (int neighbor = 0; neighbor < adjMatrix.length; neighbor++) {
                if (adjMatrix[u][neighbor] > 0 && !visted[neighbor]) {
                    int alt = distance[u] + adjMatrix[u][neighbor];
                    if (alt < distance[neighbor]) {
                        distance[neighbor] = alt;
                        previous[neighbor] = u;
                        q.add(neighbor);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        System.out.println(Arrays.toString(previous));

    }

    //Task 2 implement the printAllSSP method to print the shortest path 
    //from the source to all other nodes
    public void printAllSSP(){
        for (int i = 0; i < adjMatrix.length; i++) {
            Stack<Integer> Vertex = new Stack<>();
            int u = i;
            while (u != source) {
                Vertex.push(u);
                u = previous[u];
            }
            Vertex.push(source);
            StringBuilder path = new StringBuilder();
            int idx = 0;
            int maxSize = Vertex.size();
            while (!Vertex.isEmpty()) {
                path.append(Vertex.pop());
                if (idx < maxSize - 1) {
                    path.append(" -> ");
                }
                idx++;
            }
            System.out.println("Shortest path from " + source + " to " + i + " is " + path.toString());
            System.out.println("with distance of " + distance[i]);
        }

    }

}