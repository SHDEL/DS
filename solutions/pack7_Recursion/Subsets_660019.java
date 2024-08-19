package solutions.pack7_Recursion;
import java.util.ArrayList;
import java.util.List;
public class Subsets_660019 {
    static List<Integer> ans;
    public static void printAllSubSets_Recurse(List<Integer> set){
        List<Integer> subset = new ArrayList<>();
        Subsets(set, subset, 0);
    }
    public static void Subsets(List<Integer> set, List<Integer> subset, int idx){
        if (idx == set.size()) {
            System.out.print(subset + " ");
            return ;
        }
        subset.add(set.get(idx));
        Subsets(set, subset, idx + 1);

        subset.remove(subset.size() - 1);
        Subsets(set, subset, idx + 1);

    }
    public static void printAllSubsets_DP(List<Integer> set){
        List<List<Integer>> allSubsets = new ArrayList<>();
        allSubsets.add(new ArrayList<>());

        for (int num : set) {
            int size = allSubsets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSubset = new ArrayList<>(allSubsets.get(i));
                newSubset.add(num);
                allSubsets.add(newSubset);
            }
        }
        for (List<Integer> subset : allSubsets) {
            System.out.print(subset + " ");
        }
    }
}
