package solutions.pack7_Recursion;
import java.util.Arrays;
public class EqualSubsets_660019 {
    public static boolean canPartition_Recur(int [] arr){
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return canPartition(arr, sum / 2, arr.length);
    }
    public static boolean canPartition(int[] arr, int sum, int n) {
        if (sum == 0){
            return true;
        } 
        if (n == 0 && sum != 0){
            return false;
        } 
        if (arr[n - 1] > sum){
            return canPartition(arr, sum, n - 1);
        }   
        return canPartition(arr, sum - arr[n - 1], n - 1) || canPartition(arr, sum, n - 1);
    }
    public static boolean canPartition_Memoiz(int [] arr){
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int arr2[][] = new int[arr.length + 1][sum + 1];
        for (int row[] : arr2) {
            Arrays.fill(row, -1);
        }
        // for (int[] i : arr2){
        //     System.out.println(Arrays.toString(i));
        // }
        
        return isSubsetSum(arr, arr.length, sum / 2, arr2);
    }
    public static boolean isSubsetSum(int arr[], int n, int sum, int[][] arr2){
        if (sum == 0){
            return true;
        }
        if (n == 0 && sum != 0){
            return false;
        }
 
        if (arr[n - 1] > sum)
            return isSubsetSum(arr, n - 1, sum, arr2);
        
        if (isSubsetSum(arr, n - 1, sum, arr2) != false || isSubsetSum(arr, n - 1, sum - arr[n - 1], arr2) != false){
            return true;
        }
        return false;
    }
    public static boolean canPartition_DP(int [] arr){
        int sum = 0;
        int i, j;
        int n = arr.length;
 
        for (i = 0; i < n; i++){
            sum += arr[i];
        }
        if (sum % 2 != 0){
            return false;
        }
        boolean part[][] = new boolean[sum / 2 + 1][n + 1];
 
        for (i = 0; i <= n; i++){
            part[0][i] = true;
        }   
        
        for (i = 1; i <= sum / 2; i++){
            part[i][0] = false;
        }
        
        for (i = 1; i <= sum / 2; i++) {
            for (j = 1; j <= n; j++) {
                part[i][j] = part[i][j - 1];
                if (i >= arr[j - 1]){
                    part[i][j] = part[i][j] || part[i - arr[j - 1]][j - 1];
                }
            }
        }
        return part[sum / 2][n];
        
    }
    
}
