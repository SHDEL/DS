package solutions.pack4;

public class MyLinkedList_660019 {
    public class Node {
        int data;
        Node next;
        public Node(int d){
            data = d;
        }
    }
    Node head = null;

    public void add(int d){
        Node p = new Node(d);
        p.next = head;
        head = p;
    }
    public void add(int[] d){
        for (int i = d.length - 1; i >= 0; i--) {
           add(d[i]);
        }
     }
    public void insert(int d){
        Node q = new Node(d);
        if (head == null || head.data >= q.data) {
            q.next = head;
            head = q;
        } 
        else {
            Node p = head;
            while (p.next != null && p.next.data < q.data) {
                p = p.next;
            }
            q.next = p.next;
            p.next = q;
        }
    }
    public void insert(int []d){
        for (int i : d) {
            insert(i);
        }
    }
    public int find(int d){
        int idx = -1;
        Node p = head;
        int cnt = 0;
        while(p != null){
            if (p.data == d){
                return cnt;
            }
           cnt++;
           p = p.next;//skip
        }
        return idx;
    }
    public void delete(int d){
        Node t = new Node(0);
        t.next = head;
        Node p = t;
        while( (p.next != null) && (p.next.data != d) ) {
            p = p.next;
        }
        if(p.next != null) {
            p.next = p.next.next;
        }
        head = t.next;
    
    }
    public int size(){
        int cnt = 0;
        Node p = head;
        while (p.next != null){
            cnt++;
            p = p.next; 
        }
        return cnt++;
    }
    @Override 
    public String toString() {
        StringBuffer sb = new StringBuffer("head ");
        Node p = head;
        while(p!=null) {
            sb.append("--> [");
            sb.append(p.data);
            sb.append("] ");
            p = p.next;
        }
        sb.append("-> null");
        return new String(sb);
    }
    public static void main(String[] args) {
        demo1();
        demo2();

    }
    static void demo1(){
        System.out.println("----demo1----");
        MyLinkedList_660019 list = new MyLinkedList_660019();
        list.add(5);
        list.add(1);
        list.insert(4);
        list.insert(3);
        System.out.println(list);
        list.delete(2);
        System.out.println("5 is at " + list.find(5));
        System.out.println(list);
    }
    static void demo2() {
        System.out.println("----demo2----");
        int [] arr = {50, 40, 30, 20, 10};
        MyLinkedList_660019 mList = new MyLinkedList_660019();
        mList.insert(arr);
        System.out.println(mList);
    }
}
