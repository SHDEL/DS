package solutions.pack9_Heap;

import java.util.Arrays;

public class MyPriorityQueue_660019 implements MyQueueInterface {
    MyMinHeap_660019 heap = new MyMinHeap_660019();
    public void enqueue(int d){
        if (isFull()){
            return ;
        }
        heap.insert(d);
    }
    @Override
    public int dequeue() {
        return heap.remove();
    }
    @Override
    public int front() {
        return heap.peek();
    }
    @Override
    public boolean isFull() {
        return heap.isFull();
    }
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }
    public String toString(){
        return heap.toString();
    }
}
