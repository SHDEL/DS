package solutions.pack5_Postfix;
import java.util.LinkedList;

public class MyQueueListWrap_660019<T> extends LinkedList<T> {
    public void enqueue(T d) {
        this.add(d);
    }
    public T dequeue(){
        return this.poll();
    }
    public T top(){
        return this.peek();
    }
    public String dumpToString() {
        StringBuilder sb = new StringBuilder();
        for (T item : this) {
            sb.append(item.toString());
            sb.append(" "); 
        }
        return sb.toString();
    }
}


