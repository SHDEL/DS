package solutions.pack11_Graph;

import java.util.Arrays;
import java.util.Stack;

public class TheLake_660019 {

    public int findTotalMaxDepth(int[][] input) {
        int totalSumDepth = 0;
        int[][] input_copy = Arrays.copyOf(input, input.length);
        int rows = input_copy.length;
        int cols = input_copy[0].length;
        class SumDfs {
            private int sum;

            public void sumdfs(int[][] input, int r, int c) {
                if (r < 0 || c < 0 || r >= rows || c >= cols || input[r][c] == 0) {
                    return;
                }
                sum += input[r][c];
                input[r][c] = 0;// visited
                sumdfs(input, r - 1, c);// up
                sumdfs(input, r + 1, c);// down
                sumdfs(input, r, c - 1);// left
                sumdfs(input, r, c + 1);// rigth
            }

            public int getSum() {
                return sum;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                SumDfs dfs = new SumDfs();
                if (input[i][j] > 0) {
                    dfs.sumdfs(input_copy, i, j);
                    totalSumDepth = Math.max(totalSumDepth, dfs.getSum());
                }
            }
        }
        return totalSumDepth;
    }

}
