package solutions.pack3_ArrAndList;
import java.util.Arrays;

public class MyArrayBasic {
    protected int MAX_SIZE = 5;
    protected int data[] = new int [MAX_SIZE];
    protected int size = 0;

    public MyArrayBasic(int ... data){
        // if (MAX_SIZE < a.length){
        //     MAX_SIZE = a.length;
        //     data = new int[MAX_SIZE];
        //     // size = a.length;
        // }
        // for (int i = 0; i < a.length; i++){
        //     data[i] = a[i];
        // }

        if(data == null){
            return;
        }
        else{
            int length = Math.min(data.length, MAX_SIZE);
            for (int i = 0; i < length; i++) {
                this.data[i] = data[i];
            }
            this.size = length;
        }
    }

    public void add(int d){
        data[size++] = d;
    }

    public void insert(int d, int index){
        for (int j = size; j > index; j--){
            data[j] = data[j - 1];

        }
        data[index] = d;
        size++;
    }

    public int find(int d){
        for(int i = 0; i < size; i++){
            if (data[i] == d){
                return i;
            }
        }
        return -1;
    }
    
    public int binarySearch(int d){
        int left = 0, right = size -1;
        while (left <= right){
            int m = left + (right + left) / 2;
            if (data[m] == d){
                return m;
            } 
            if (d < data[m]) {
                right = m - 1;
            }
            else {
                left = m + 1;
            }
            
        }
        return -1;
    }

    public void delete(int i){
        for (int j = i; j < size; j++){
            data[i] = data[i + 1];
        }
        size--;
    }
    @Override
    public String toString() {
        StringBuilder n = new StringBuilder();
        n.append("[");
        for (int i = 0; i < size; i++){
            n.append(data[i]);
            if (i < size -1){
                n.append(",");
            }
        }
        n.append("]");
        return n.toString();
    }
    
    
    
}
