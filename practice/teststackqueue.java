package practice;

import java.util.Stack;
import solutions.pack5_Postfix.*;

import solutions.pack5_Postfix.MyQueueListWrap_660019;

public class teststackqueue {
    public static void main(String[] args) {
        int [] values = {1, 3, 5, 7 , 9 ,11};
        Stack s = new Stack<>();
        MyQueueListWrap_660019 q = new MyQueueListWrap_660019<>();
        for (int i = 0; i < values.length; i++){
            s.push(values[i]);
            q.enqueue(values[i] + 1);
        }
        System.out.println(s);
        System.out.println(q);

        int n = 0;
        while (!s.isEmpty()){
            q.enqueue((int)s.pop() + (int)q.dequeue());
        }
        System.out.println(s);
        System.out.println(q);

        s.push(0);
        while(!q.isEmpty()){
            s.push((int)s.pop() + (int)q.dequeue());
        }
        System.out.println(s);
        System.out.println(q);

    }
    
}
