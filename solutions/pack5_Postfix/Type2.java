package solutions.pack5_Postfix;
import java.util.Iterator;
import java.util.ArrayList;

public class Type2 <T> implements Iterable<T> {
    private ArrayList<T> items = new ArrayList<>();
    private int count;

    public void add(T item){
        items.add(item);
        count++;
    }
    public T get(int index){
        return items.get(index);
    }
    @Override
    public Iterator<T> iterator(){
        return new AnyItemsIterator(this);
    }
    private class AnyItemsIterator implements Iterator <T> {
        private Type2<T> lis;
        private int idx;
        public AnyItemsIterator(Type2<T> arg){
            this.lis = arg;
        }
        @Override
        public boolean hasNext(){
            return (idx < lis.count);
        }
        @Override
        public T next(){
            return lis.items.get(idx++);
        }
    }
    
}
