package practice;

import java.util.Arrays;
import java.util.LinkedList;

public class testIntersect {
    public static void main(String[] args) {
        int [] ans = new int[2];
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(3);
        list.add(4);
        list.add(6);
        list.add(7);
        list.add(8);
        int [] arr = {1, 2, 3, 5, 7, 9};
        int idx = 0;

        for (int i = 0; i < list.size(); i++){
            for (int j = 0; j < arr.length; j++){
                if (list.get(i) == arr[j]){
                    ans[idx++] = arr[j];
                }
            }
        }
        System.out.println(Arrays.toString(ans));

    }
    
}
