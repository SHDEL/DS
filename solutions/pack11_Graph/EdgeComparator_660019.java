package solutions.pack11_Graph;

import java.util.Comparator;

public class EdgeComparator_660019 implements Comparator<Edge_660019> {
        public EdgeComparator_660019() {
                
        }

        @Override
        public int compare(Edge_660019 o1, Edge_660019 o2) {
                return o1.getLatency() == o2.getLatency() ? 0 : o1.getLatency() < o2.getLatency() ? -1 : 1;
                // throw new UnsupportedOperationException("Unimplemented method 'compare'");
        }
}
