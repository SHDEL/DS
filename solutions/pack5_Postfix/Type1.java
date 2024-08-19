package solutions.pack5_Postfix;

import java.util.ArrayList;

public class Type1 <T> {
    private ArrayList<T> items = new ArrayList<>();
    private int count;
    public void add(T item){
        items.add(item);
        count++;
    }
    public T get(int index){
        return items.get(index);
    }
}
