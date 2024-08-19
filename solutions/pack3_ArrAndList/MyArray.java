package solutions.pack3_ArrAndList;

public class MyArray extends MyArrayBasic {
    public MyArray(){
        this.MAX_SIZE = 100_000;
        this.data = new int[MAX_SIZE];
    }
    public MyArray(int max){
        this.MAX_SIZE = max;
        this.data = new int[MAX_SIZE];
    }
    public MyArray(int max, int... data) {
        this.MAX_SIZE = max;
        this.data = new int[MAX_SIZE];
        int length = Math.min(data.length, MAX_SIZE);
        for (int i = 0; i < length; i++) {
            this.data[i] = data[i];
        }
        this.size = length;
    }
    public boolean isFull(){
        return size >= MAX_SIZE;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void expandByK(int k){
        int newMaxSize = k * MAX_SIZE;
        int[] newData = new int[newMaxSize];
        System.arraycopy(data, 0, newData, 0, size);
        this.data = newData;
        this.MAX_SIZE = newMaxSize;
    }
    public void expand(){
        expandByK(2);
    }
    @Override
    public void add(int d) {
        if (isFull()) {
            expand();
        }
        data[size++] = d;
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    
}
