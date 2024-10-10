package solutions.pack12b_SSP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Task3_660019 {
    
    public int stateSpace(int[] beginState, int[] goalState){
        int minimumOperations = 0;
        InterfaceSwapAdjacentPairs_660019 swapPairs;       // lambda expression
        InterfaceSwapCorrespondingHalves_660019 swapHalves; // lambda expression
        swapPairs = (State_660019 s) -> {
            int[] arr = Arrays.copyOf(s.getArray(), s.getArray().length);
            for (int i = 0; i < arr.length - 1; i += 2) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
            return arr;
        };
        swapHalves = (State_660019 a) -> {
            int[] arr = Arrays.copyOf(a.getArray(), a.getArray().length);
            int mid = arr.length / 2;
            for (int i = 0; i < mid; i++) {
                int tmp = arr[i];
                arr[i] = arr[mid + i];
                arr[mid + i] = tmp;
            }
            return arr;
        };
        // test
        // int[] arr = { 5, 3, 7, 1, 8, 9 };
        // System.out.println(12);
        // System.out.println(Arrays.toString(swapPairs.swapAdjacentPairs(new
        // State_660019(arr))));
        // System.out.println(Arrays.toString(swapHalves.swapCorrespondingHalves(new
        // State_660019(arr))));

        // bfs create
        Queue<State_660019> Q = new LinkedList<>();
        State_660019 start = new State_660019(beginState, 0);
        HashSet<String> visited = new HashSet<>();// int [] has not contains becasue address
        visited.add(Arrays.toString(beginState));
        Q.add(start);// Start
        while (!Q.isEmpty()) {
            State_660019 cur = Q.poll();
            State_660019 curL = new State_660019(swapPairs.swapAdjacentPairs(cur), cur.getLevel() + 1);// level count of
                                                                                                       // op
            State_660019 curR = new State_660019(swapHalves.swapCorrespondingHalves(cur), cur.getLevel() + 1);
            minimumOperations = cur.getLevel();
            if (Arrays.equals(goalState, cur.getArray())) {
                return minimumOperations;
            }
            if (!visited.contains(Arrays.toString(curL.getArray()))) {
                cur.setLeft(curL);
                Q.add(cur.getLeft());
                visited.add(Arrays.toString(curL.getArray()));
            }

            if (!visited.contains(Arrays.toString(curR.getArray()))) {
                cur.setRigth(curR);
                Q.add(cur.getRight());
                visited.add(Arrays.toString(curR.getArray()));
            }
        }
        minimumOperations = -1;
        return minimumOperations;
    }

}
