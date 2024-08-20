package Labs;

import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayList;
import java.util.List;

import solutions.pack7_Recursion.EqualSubsets_660019;
import solutions.pack7_Recursion.GridPaths_660019;
import solutions.pack7_Recursion.Subsets_660019;

public class Lab7_Recursion_DP_Main {
    public static void main(String[] args) {
        // testEqualSubsets();
        // System.out.println("----");
        testSubSets();
        // testGridPaths();
    }
    static void testEqualSubsets() {
        int [] a = {1,5,11,5};
        int [] b = {1,5,3};
        System.out.println("-----Recurse-----");
        System.out.println(EqualSubsets_660019.canPartition_Recur(a));
        System.out.println(EqualSubsets_660019.canPartition_Recur(b));
        System.out.println("-----Memoiz-----");
        System.out.println(EqualSubsets_660019.canPartition_Memoiz(a));
        System.out.println(EqualSubsets_660019.canPartition_Memoiz(b));
        System.out.println("-----DP-----");
        System.out.println(EqualSubsets_660019.canPartition_DP(a));
        System.out.println(EqualSubsets_660019.canPartition_DP(b));     
    }
    static void testSubSets() { 
        System.out.println("--- Subsets ---");
        List<Integer> set = new ArrayList<>();
        set.add(1); set.add(2); set.add(3);
        System.out.println("using recursive method");
        Subsets_660019.printAllSubSets_Recurse(set);
        System.out.println("\nusing dynamic programming method");
        Subsets_660019.printAllSubsets_DP(set);
    }
    static void testGridPaths() {
        int [][] grid = { {0,0,0,0},
                          {0,1,0,0},  
                          {0,0,0,1},
                          {1,0,0,0}};
        System.out.println("--- grid paths ---");
        System.out.println("number of paths: " + GridPaths_660019.numberOfPaths(grid));
        
    }
}
