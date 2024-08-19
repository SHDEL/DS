package solutions.pack4;

import java.util.HashSet;
import java.util.Stack;

public class MyLinkedListTricky_660019 extends MyLinkedList_660019 {
    public void q1_rotate_counter_clockwise(int k){
        Node p = head;
        // System.out.println("p = head(10)");
        if (k > 0 && k <= size()){
            for (int i = 1; i < k; i++){
                p = p.next;
            }
            Node temp = p.next;
            p.next = null;
            Node q = temp;
            while (q.next != null) {
                q =q.next;
            }
            q.next = head;
            head = temp;
        }
        else{
            System.out.println("k must be positive integer and not larger than list size");
        }

    }
    public void q2_reverse(){
        Node p = head;
        Node q = null;
        Node tmp_next = null;
        while (p != null) {
            tmp_next = p.next;
            p.next = q;
            q = p;
            p = tmp_next;
        }     
        head = q;
    }
    public void q3_remove_dup(){
        if (head == null) {
            return;
        }
        Node p = head, q = null;
        HashSet<Integer> dup = new HashSet<>();
        while (p!=null) {
            if(dup.contains(p.data)){
                q.next=p.next;
            }
            else{
                dup.add(p.data);
                q = p;
            }
            p = p.next;
        }

    }
    public void q4_add_one(){
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;

        current = head;
        Node last = null;
        int carry = 1;

        while (current != null && carry > 0) {
            int sum = current.data + carry;
            carry = sum / 10;
            current.data = sum % 10;
            last = current;
            current = current.next;
        }

        if (carry > 0) {
            last.next = new Node(carry);
        }
        prev = null;
        current = head;
        next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;

    }
    public boolean q5_isPalindrome(){
        Stack<Integer> stack = new Stack<>();
        Node p= head, q = head;
        while (q != null && q.next != null) {
            stack.push(p.data);
            p = p.next;
            q = q.next.next;
        }

        if (q != null) {
            p = p.next;
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != p.data) {
                return false;
            }
            p = p.next;
        }
        return true;

    }
    
}
