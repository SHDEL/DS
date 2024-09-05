package solutions.pack9_Heap;

import java.util.Arrays;

public class MyHeapSort_660019{
    MyMinHeap_660019 heap = new MyMinHeap_660019();
    public MyHeapSort_660019(){

    }
    public void insert(int d){
        heap.insert(d);
    }
    public String sort(){
        StringBuilder sorted = new StringBuilder();
        sorted.append("[");
        while (!heap.isEmpty()) {
            sorted.append(heap.remove()).append(" ");
        }
        sorted.append("]");
        return sorted.toString();
    }
    public String toString(){
        return heap.toString();    
    }
    
}