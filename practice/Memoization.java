package practice;

public class Memoization {
    public static void main(String[] args) {
        int [] mem = new int[10];
        System.out.println(fibmem(4, mem));
    }
    public static int fibmem(int n , int [] mem){
        if (n <= 1){
            return 1;
        }
        if (mem[n] != 0){
            System.out.println("case 2");
            return mem[n];
        }
        mem[n] = fibmem(n - 1, mem) + fibmem(n - 2, mem);
        return mem[n];
    }
    
}
